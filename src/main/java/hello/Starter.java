package hello;

import org.springframework.context.support.GenericGroovyApplicationContext;

/**
 * @author ymolodkov
 * @date 20/12/14.
 * @since 0.1
 */
public class Starter {

    public static void main(String[] args) {
        GenericGroovyApplicationContext ctx = new GenericGroovyApplicationContext("classpath:context.groovy");
        Greeter greeter = ctx.getBean(Greeter.class);
        System.out.println(greeter.sayHello());
    }
}
