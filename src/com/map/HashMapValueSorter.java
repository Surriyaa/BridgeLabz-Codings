package com.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HashMapValueSorter {

	public static void main(String[] args) {
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("apple", 3);
        map.put("banana", 1);
        map.put("cherry", 2);
        map.put("date", 5);
        map.put("elderberry", 4);
        
        Map<String, Integer> smap=sortByValues(map);
        
        System.out.println("Sorted by valyes :");
        for(Map.Entry<String, Integer> s:smap.entrySet()) {
        	System.out.println(s.getKey()+" : "+s.getValue());
        }
	}

	private static Map<String, Integer> sortByValues(Map<String, Integer> map) {
		
		List<Map.Entry<String, Integer>> list=new ArrayList<>(map.entrySet());
		
		list.sort(Map.Entry.comparingByValue());
		
		Map<String, Integer> sortedmap=new LinkedHashMap<String, Integer>();
		for(Map.Entry<String, Integer> s:list) {
			sortedmap.put(s.getKey(), s.getValue());
		}
		
		
		
		return sortedmap;
	}

}
