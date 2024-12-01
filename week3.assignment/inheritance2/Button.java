package week3.assignment;

public class Button extends WebElement{
	public void submit() {
		System.out.println("yes/no");
	}
	public static void main(String[] args) {
		Button bt = new Button();
		bt.submit();
		bt.click();
		bt.setText();
	}

}
