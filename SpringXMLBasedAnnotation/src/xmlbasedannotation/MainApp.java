package xmlbasedannotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

		HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorld");
		helloWorld.getMessage();
	}
}
