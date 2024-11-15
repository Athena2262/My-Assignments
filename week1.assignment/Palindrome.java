package week1.day2.assign;

public class Palindrome {

	public static void main(String[] args) {
		int input = 343;
		int r,sum = 0,temp;
		  temp = input;    
		  while(input>0){    
		   r= input %10;  //getting remainder  
		   sum=(sum*10)+r;    
		   input=input/10;    
		  }    
		  if(temp==sum)    
		   System.out.println("palindrome number ");    
		  else    
		   System.out.println("not palindrome");      


	}

}
