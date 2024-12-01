package week3.assignment;

public class TextField extends WebElement{
	public void getText() {
		System.out.println("get the value");
	}
	public static void main(String[] args) {
		TextField tf = new TextField();
		tf.getText();
		tf.click();
		tf.setText();
	}

}
