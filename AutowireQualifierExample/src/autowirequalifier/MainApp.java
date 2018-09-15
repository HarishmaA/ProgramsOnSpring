package autowirequalifier;

	import org.springframework.context.ConfigurableApplicationContext;
	import org.springframework.context.support.ClassPathXmlApplicationContext;
	 
	
	 
	public class MainApp {
	 
	    public static void main(String a[]){
	        String confFile = "applicationContext.xml";
	        ConfigurableApplicationContext context 
	                        = new ClassPathXmlApplicationContext(confFile);
	        PaymentGateway paymentGateway = (PaymentGateway) context.getBean("paymentGateway");
	        System.out.println(paymentGateway.toString());
	    }
	}
