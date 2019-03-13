package test1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

//@Component//默认id为a
@Component("hello")//id为hello
@Scope("prototype")//有两个值，prototype:非单例，singleton:单例
public class A {
    @Autowired//默认按类型从容器中找bean对象
    @Qualifier("b1")
    //@Resource(name="b")
    B b;

    @PostConstruct
    public void init(){
        System.out.println("初始化方法，在注入完成后调用，方法名任意");
    }

    @Override
    public String toString() {
        return "A{" +
                "b=" + b +
                '}';
    }
}
