

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

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
		
		Map<String, Integer> wordCount = new TreeMap<String, Integer>();

		for (String word : words) {
			word = word.toLowerCase();
			Integer counter = wordCount.get(word);
			if (counter == null) {
				wordCount.put(word, 1);
			} else {
				wordCount.put(word, counter + 1);
			}
		}
		
		//This prints key-values sorted by key's natural order
		/*for(String w : wordCount.keySet()) {
			System.out.println(wordCount.get(w) + " " + w);
		} */
		
		Map<String, Integer> wcm = new TreeMap<String, Integer>(new ValueComparator(wordCount));
		
		wcm.putAll(wordCount);
		
		//This prints key-values in the descending order of values. If values are same, then key ascending order will be used
		for(String w : wcm.keySet()) {
			System.out.println(wcm.get(w) + " " + w);
		}

	}
	
	static class ValueComparator implements Comparator<String>{
		
		private Map<String, Integer> map;
		
		ValueComparator(Map<String, Integer> map){
			this.map = map;
		}

		@Override
		public int compare(String o1, String o2) {
			Integer i1 = map.get(o1);
			Integer i2 = map.get(o2);
			
			int valueComp = i2.compareTo(i1);
			int keyComp = o1.compareTo(o2);
			
			if(valueComp != 0) {
				return valueComp;
			}else {
				return keyComp;
			}
		}
		
	}
	 
}
