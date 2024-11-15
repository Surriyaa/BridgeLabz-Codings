package com.map;

import java.util.HashMap;
import java.util.Map;

public class FrequencyCounter {

	public static void main(String[] args) {
		Map<Character,Integer> words=new HashMap();
		String str="Sssurriya";
		for(int i=0;i<str.length();i++) {
			if(words.get(str.charAt(i)) == null) {
				words.put(str.charAt(i), 1);
			}
			else {
				int count=words.get(str.charAt(i));
				words.put(str.charAt(i), count+=1);
			}
		}
		System.out.println(words);
	}

}
