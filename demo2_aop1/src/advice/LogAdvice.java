package advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Component//放入容器中
@Aspect//表示是一个切面
public class LogAdvice {
    //定义切点
    @Pointcut("execution(* service.impl.*.*(..))")
    public void pc1(){}

    @Pointcut("execution(* service.impl.*Impl.*(..))")
    public void pc2(){}

    //@Before("pc1()")
    @Before("execution(* service.impl.*.*(..))")
    public void log1(JoinPoint jp){
        Signature sg = jp.getSignature();
        MethodSignature ms = (MethodSignature)sg;
        String name = ms.getName();
        Method m = ms.getMethod();
        Object[]args = jp.getArgs();//方法参数
        Object target = jp.getTarget();
        System.out.println("LogAdvice.log中方法名:"+name+",参数："+ Arrays.toString(args)+",target:"+target);

    }

    @AfterReturning(value="pc2()",returning = "rv")//后置通知
    public void log2(JoinPoint jp,Object rv){
        System.out.println("后置通知log2中，方法返回值："+rv);

    }
    @AfterThrowing(value = "pc2()",throwing = "e")
    public void log3(JoinPoint jp,Exception e){
        System.out.println("异常通知log3中的异常："+e.getMessage());

    }

    @Around("pc1()")//环绕
    Object around(ProceedingJoinPoint jp)throws Throwable{
        System.out.println("开启事务");
        Object o = null;
        try{
            o = jp.proceed();
            System.out.println("提交事务");
        }catch (Throwable e){
            System.out.println("事务回滚");
            throw e;
        }
        return o;
    }

    //最终通知
    @After("pc1()")
    void finallyMethod(){
        System.out.println("相当于finally,死活都要作");
    }

}
