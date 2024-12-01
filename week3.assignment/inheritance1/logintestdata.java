package week3.assignment;

public class Logintestdata extends TestData{
	public void enterUsername() {
		System.out.println("Enter username");
	}
	public void enterPassword() {
		System.out.println("Enter password");
	}

	public static void main(String[] args) {
		Logintestdata ld = new Logintestdata();
		ld.enterPassword();
		ld.enterUsername();
		ld.navigatetohomepage();
		ld.entercredentials();

	}

}
