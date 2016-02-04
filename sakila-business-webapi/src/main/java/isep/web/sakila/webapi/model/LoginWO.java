package isep.web.sakila.webapi.model;

public class LoginWO extends WebObject {

	private static final long serialVersionUID = -1377067679473844279L;

	protected String email;
	protected String password;

	public LoginWO() {
		super();
	}

	public LoginWO(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String passeword) {
		this.password = passeword;
	}

}
