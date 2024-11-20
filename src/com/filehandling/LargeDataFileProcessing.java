package com.filehandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class LargeDataFileProcessing {

	public static void main(String[] args) {
		try {
			BufferedReader bReader=new BufferedReader(new FileReader("C:\\Users\\ASUS\\Documents\\Arthif\\File\\transactions.txt"));
			BufferedWriter bWriter=new BufferedWriter(new FileWriter("C:\\Users\\ASUS\\Documents\\Arthif\\File\\filtered_transactions.txt"));
			
			String line=bReader.readLine();
			double  threshold=1500;
			
			while(line!=null) {
				String transactions[]=line.split("[,]");
				if(transactions.length==4) {
					double transactionAmount=Double.parseDouble(transactions[2].trim());
					if(transactionAmount>threshold) {
						bWriter.write(line);
						bWriter.newLine();
						
					}
				}
				
				else {
					System.out.println("The line format is invalid");
				}
				line=bReader.readLine();
			}
			System.out.println("Filtered Successfully");
		bReader.close();
		bWriter.close();
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
