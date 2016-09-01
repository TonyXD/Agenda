package dto;

public class LogInDTO {

	private String puerto;
	private String user;
	private String pass;
	
	public LogInDTO(String user, String pass)
	{
		this.setUser(user);
		this.setPass(pass);
	}

	public LogInDTO() {
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPuerto() {
		return puerto;
	}

	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}
	
}
