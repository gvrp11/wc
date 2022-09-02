

import java.util.HashMap;
import java.util.Map;

public class WordCount {

	public static void main(String[] args) {
		
		if(args.length > 0) {
			wordCount(args[0]);
		}else {
			System.out.println("Please pass a string as input");
		}

	}

	static void wordCount(String str) {
		
		if(str == null || str.trim().length() == 0) {
			System.out.println("Null or Empty Srting is passed");
			return;
		}
		
		String[] words = str.split(" ");
		Map<String, Integer> wordCount = new HashMap<>();

		for (String word : words) {
			word = word.toLowerCase();
			Integer counter = wordCount.get(word);
			if (counter == null) {
				wordCount.put(word, 1);
			} else {
				wordCount.put(word, counter + 1);
			}
		}
		
		for(String w : wordCount.keySet()) {
			System.out.println(wordCount.get(w) + " " + w);
		}

	}
}
