package week3.assignment;

public class BasePage {
	public void findelement() {
		System.out.println("Elements");
	}
	public void clickElement() {
		System.out.println("selected");
	}
	public void entertext() {
		System.out.println("TextEntered");
	}
	public void performcommontasks() {
		System.out.println("Yes");
	}
	public static void main(String[] args) {
		BasePage bp = new BasePage();
		bp.clickElement();
		bp.entertext();
		bp.findelement();
		bp.performcommontasks();
	}

}
