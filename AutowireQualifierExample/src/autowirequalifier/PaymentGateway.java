package autowirequalifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class PaymentGateway {
 
    @Autowired
    @Qualifier("oracleOrderBean")
    private Order order;
     
    @Override
    public String toString(){
        return "ordering "+this.order.getItem()+" | price: "+this.order.getPrice();
    }
}