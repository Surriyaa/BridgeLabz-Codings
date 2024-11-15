package com.map;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FirstNonRepeatedCharacter {

	public static void main(String[] args) {
		
		String str="surrisyaau";
		char ch=firstNonRepChar(str);
		
		if(ch!=0)
			System.out.println("First no rep ch is "+ch);
		else
			System.out.println("No non rep ch");
		
	}

	private static char firstNonRepChar(String str) {

		Map<Character, Integer> map=new LinkedHashMap<>();
		for(char ch:str.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0)+1);
		}
		
		for(Entry<Character, Integer> m:map.entrySet()) {
			if(m.getValue()==1)
				return m.getKey();
		}
		
		
		return 0;
	}

}
