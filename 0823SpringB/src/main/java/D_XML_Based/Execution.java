package D_XML_Based;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Execution {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Laptop laptop = context.getBean(Laptop.class);
        Software software = laptop.getSoftware();'


    }
}
}
