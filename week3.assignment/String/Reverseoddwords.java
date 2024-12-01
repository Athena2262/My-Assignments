package week3.assignment;

public class ReverseOddwords {

    public static void main(String[] args) {
        // Input string
        String test = "I am a software tester";

        // Split the string into an array of words
        String words[] = test.split(" ");

        // Traverse through each word
        for (int i = 0; i < words.length; i++) {
            // Check if the position is odd 
            if (i % 2 == 1) {
                // Convert to character array and reverse the word
                char[] rev = words[i].toCharArray();
                for (int j = rev.length - 1; j >= 0; j--) {
                    System.out.print(rev[j]);
                }
                System.out.print(" ");
            } else {
            	System.out.print(words[i]+" ");
            }
        }

    }
}
