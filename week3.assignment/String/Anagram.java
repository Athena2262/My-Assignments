package week3.assignment;
import java.util.Arrays;
public class Anagram {

	public static void main(String[] args) {
		//Input strings
		String text1 = "stops";
        String text2 = "potss";

        // Check if lengths are equal
        if (text1.length() != text2.length()) {
            System.out.println("Lengths mismatch, therefore the strings are not an Anagram.");
            return; // Exit the program
        }

        // Convert both strings to character arrays
        char[] char1 = text1.toCharArray();
        char[] char2 = text2.toCharArray();

        //Sort both character arrays
        Arrays.sort(char1);
        Arrays.sort(char2);
        if (Arrays.equals(char1, char2)) {
            System.out.println("The given strings are Anagram.");
        } else {
            System.out.println("The given strings are not an Anagram.");
        }
    }
}
