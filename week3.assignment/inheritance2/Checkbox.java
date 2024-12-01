package week3.assignment;

public class CheckBox extends Button{
	public void checkbutton() {
		System.out.println("checking");
	}
	public static void main(String[] args) {
		CheckBox cb = new CheckBox();
		cb.checkbutton();
		cb.click();
		cb.setText();
		cb.submit();
	}

}
