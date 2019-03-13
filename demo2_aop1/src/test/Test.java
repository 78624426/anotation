package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:u.xml");
        UserService service = (UserService)ac.getBean("service");
        try{
            service.login("tome","123");

        }catch (Exception e){
            service.logout();
        }
    }
}
