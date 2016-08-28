package modelo;

import persistencia.dao.LogInDAO;

public class LogIn {

private LogInDAO logIn; 
	
	public LogIn()
	{
		this.setLogIn(new LogInDAO());
	}

	public LogInDAO getLogIn() {
		return logIn;
	}

	public void setLogIn(LogInDAO logIn) {
		this.logIn = logIn;
	}
}
