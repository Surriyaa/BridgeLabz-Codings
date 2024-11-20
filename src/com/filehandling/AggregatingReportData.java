package com.filehandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AggregatingReportData {

	public static void main(String[] args) {
		Map< String, Integer> logMap=new HashMap<>();

		try (
			BufferedReader bReader = new BufferedReader(new FileReader("C:\\Users\\ASUS\\Documents\\Arthif\\File\\logs.txt"))) {
			
			String line;
			while((line=bReader.readLine())!=null) {
				String logParts[]=line.split("[,]",3);
				if(logParts.length==3) {
				String logLevel=logParts[1].trim();
				logMap.put(logLevel, logMap.getOrDefault(logLevel, 0)+1);
				}
				
				else {
					System.out.println("invalid file format");
				}
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			BufferedWriter bWriter=new BufferedWriter(new FileWriter("C:\\Users\\ASUS\\Documents\\Arthif\\File\\log_summary.txt"));

			bWriter.write("Log Level Summary Report\n");
            bWriter.write("=========================\n");
            for(Map.Entry<String, Integer> entry :logMap.entrySet()) {
            	bWriter.write(entry.getKey()+" : "+entry.getValue());
            	bWriter.newLine();
            }
            
            System.out.println("Logs filtered Successfully");
            bWriter.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}

}
