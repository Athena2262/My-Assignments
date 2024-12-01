package week3.assignment;

public class LoginPage extends BasePage{

	@Override
	public void performcommontasks() {
		// TODO Auto-generated method stub
		super.performcommontasks();
	}

	public static void main(String[] args) {
		LoginPage lp = new LoginPage();
		lp.performcommontasks();
		lp.findelement();
		lp.clickElement();
		lp.entertext();
	}

}
