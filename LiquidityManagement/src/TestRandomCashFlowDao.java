
import java.util.Iterator;
import java.util.List;
import com.services.*;
import com.utilities.RandCashFlowGenerator;
import com.beans.*;
import com.daos.Dao;
import com.daos.DaoImpl;

public class TestRandomCashFlowDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RandCashFlowGenerator r = new RandCashFlowGenerator(30, 100, 1000);
		List<CashFlow> cashflow = r.GenerateRandomCashFlow();
		
		Iterator ir=cashflow.iterator();
		while (ir.hasNext()) 
			System.out.println(ir.next());
		
		//Service service=new ServiceImpl();
		Dao dao=new DaoImpl();
		int x=dao.addCashflowDao();
		System.out.println(x);

		}
}

