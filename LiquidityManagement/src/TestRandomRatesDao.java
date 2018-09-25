
import com.backgroundprocesses.ShortPeriodRun;
import com.utilities.RandRateGenerator;

public class TestRandomRatesDao {

	public static void main(String[] args) 
	{
		System.out.println("Here");
		Thread t = new ShortPeriodRun();
		t.start();
		System.out.println("There");
		
		while(true)
		{	
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}

}
