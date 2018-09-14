

import com.beans.User;
import com.daos.Dao;
import com.daos.DaoImpl;

public class TestLoginDao {

	public static void main(String[] args) {
		Dao dao=new DaoImpl();
		User user=new User();
		user=dao.LoginDao("admin", "admin123");
		System.out.println(user);
	}

}
