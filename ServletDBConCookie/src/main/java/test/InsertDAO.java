package test;
import java.sql.*;

public class InsertDAO {
	public int k=0;
	public int insert(EmployeeBean eb) {
		try {
		Connection con=DBConnection.getCon();
		PreparedStatement ps=con.prepareStatement
				("insert into employee49 values(?,?,?,?,?,?,?)");
		ps.setString(1,eb.getId());
		ps.setString(2, eb.getName());
		ps.setString(3, eb.getDesg());
		ps.setInt(4, eb.getBsal());
		ps.setString(5, eb.getMailId());
		ps.setLong(6, eb.getPhone());
		ps.setFloat(7, eb.gettotSal());
		
		k=ps.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
	return k;	
	}

}
