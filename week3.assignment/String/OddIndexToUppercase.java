package week3.assignment;

public class OddIndexToUppercase {

	public static void main(String[] args) {
		// Input string
        String test = "changeme";

        // Convert the string to a character array
        char[] odd = test.toCharArray();

        // Iterate through the characters from end to start
        for (int i = 0; i < odd.length; i++) {
            // Check if the index is odd
            if (i % 2 != 0) {
                // Change the character at the odd index to uppercase
                odd[i] = Character.toUpperCase(odd[i]);
            }
        }
        String result = new String(odd);
        System.out.println(result);

	}

}

