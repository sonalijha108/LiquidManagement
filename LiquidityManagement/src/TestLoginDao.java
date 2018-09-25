

import java.util.ArrayList;
import java.util.List;

import com.beans.AccountData;
import com.beans.User;
import com.daos.Dao;
import com.daos.DaoImpl;

public class TestLoginDao {

	public static void main(String[] args) {
		Dao dao=new DaoImpl();
		AccountData accountdata=new AccountData(500, 400, 300, "relind", "reliance", "relind123", "relind@gmail.com", 8888888888L);
		dao.addUser(accountdata);

		System.out.println("User and account data"+accountdata);
		
		//List<User> users=new ArrayList<>();
		//User user=new User("xyz","XYZ","xyz123","xyz@citi.com",666666666);
		//users.add(user);
		//user=dao.LoginDao("relind", "relind123");
		//int rowsAdded=dao.addUser(user);
		//System.out.println("Rows added: "+rowsAdded);
	}

}
