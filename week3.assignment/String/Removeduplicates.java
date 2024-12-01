package week3.assignment;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// Input string
        String text = "We learn Java basics as part of java sessions in java week1";
        //Split
        String[] words = text.split(" ");
        //variable to track duplicates
        int count=0;
        //outer loop to iterate
        for (int i = 0; i < words.length; i++) {
        	for(int j = i+1;j<words.length; j++) {
        		if (words[i].equalsIgnoreCase(words[j])) {
                    words[j] = ""; // Replace the duplicate word with an empty string
                    count++;       // Increment the duplicate count
                }
        	}
        }
        //if count greater than 1
        if (count>1) {
        	System.out.println("The modified :");
        	for (String word : words) {
                if (!word.equals("")) { // Skip empty words
                    System.out.print(word + " ");
                }
            }
        }

	}

}
