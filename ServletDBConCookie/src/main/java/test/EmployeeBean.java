package test;
import java.io.*;

@SuppressWarnings("serial")
public class EmployeeBean implements Serializable {
	private String Id,Name,Desg,MailId;
	private int Bsal;
	private long Phone;
	private float totSal;
	
	public EmployeeBean() {}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDesg() {
		return Desg;
	}

	public void setDesg(String desg) {
		Desg = desg;
	}

	public String getMailId() {
		return MailId;
	}

	public void setMailId(String mailId) {
		MailId = mailId;
	}

	public int getBsal() {
		return Bsal;
	}

	public void setBsal(int bsal) {
		Bsal = bsal;
	}

	public long getPhone() {
		return Phone;
	}

	public void setPhone(long phone) {
		Phone = phone;
	}

	public float gettotSal() {
		return totSal;
	}

	public void settotSal(float totsal) {
		this.totSal = totsal;
	}	

}
