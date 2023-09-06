package test;
import java.sql.*;
import java.util.*;

public class RetrieveDAO {
	ArrayList<EmployeeBean> al=new ArrayList<EmployeeBean>();
	public ArrayList<EmployeeBean> retrieve(){
		try {
		Connection con=DBConnection.getCon();
		PreparedStatement ps=con.prepareStatement
				("select * from employee49");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			EmployeeBean eb=new EmployeeBean();
			eb.setId(rs.getString(1));
			eb.setName(rs.getString(2));
			eb.setDesg(rs.getString(3));
			eb.setBsal(rs.getInt(4));
			eb.setMailId(rs.getString(5));
			eb.setPhone(rs.getLong(6));
			eb.settotSal(rs.getFloat(7));
			al.add(eb);
		}
		}catch(Exception e) {e.printStackTrace();}
		return al;
	}

}
