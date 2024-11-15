package com.map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class WordCounter {

	public static void main(String[] args) {
		Map<String,Integer > map=new HashMap<>();
		try {
			File file=new File("C:\\Users\\ASUS\\Desktop\\new.txt");
			FileReader freader;
			freader = new FileReader(file);
			BufferedReader breader=new BufferedReader(freader);
			String line;
			while((line=breader.readLine())!=null)
			{
				String words[]=line.split("\\W+");
				
			for(String word:words) {
				if(!word.isEmpty()) {
					if(map.get(word)==null) {
						map.put(word, 1);
					}
					else {
						int count=map.get(word);
						map.put(word, count+=1);
					}
				}
			}
			}
			for(Map.Entry<String, Integer> mapentry:map.entrySet()) {
				System.out.println(mapentry.getKey()+" = "+mapentry.getValue());
			}
			
			//System.out.println(map);
			breader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
