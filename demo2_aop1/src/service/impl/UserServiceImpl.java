package service.impl;

import org.springframework.stereotype.Service;
import service.UserService;

@Service("service")
public class UserServiceImpl implements UserService{
    @Override
    public String login(String name, String pass) {
        System.out.println("login登录...");
        int a = 1/0;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "登录成功";
    }

    @Override
    public void logout() {
        System.out.println("拜拜");
    }
}
