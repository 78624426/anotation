package test1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("b1")
public class B {
    //@Value("1")
    @Value("${id111}")
    int id;
    @Value("${name}")
    String name;

    @Override
    public String toString() {
        return "B{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
