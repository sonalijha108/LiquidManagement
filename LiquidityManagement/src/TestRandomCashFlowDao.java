
import java.util.Iterator;
import java.util.List;
import com.services.*;
import com.utilities.RandGenerator;
import com.beans.*;

public class TestRandomCashFlowDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RandGenerator r = new RandGenerator(30, 100, 1000);
		List<CashFlow> cashflow = r.GenerateRandomCashFlow();
		
		Iterator ir=cashflow.iterator();
		while (ir.hasNext()) 
			System.out.println(ir.next());
		
		Service service=new ServiceImpl();
		service.addRandomCashflow(cashflow);
		
		
//		Random r = new Random();
//		double min = -1.00;
//		double max = 1.00;
//		
//		for(int i=0;i<15;i++) {
//		double rate = min + (max - min) * r.nextDouble();
//		rate = Math.round(rate * 100.0) / 100.0;
//		System.out.println(rate);
	
		}
}

