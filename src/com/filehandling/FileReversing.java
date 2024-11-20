package com.filehandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReversing {

	public static void main(String[] args) {
		try {
			BufferedReader bReader=new BufferedReader(new FileReader("C:\\Users\\ASUS\\Documents\\Arthif\\source.txt"));
			BufferedWriter bWriter=new BufferedWriter(new FileWriter("C:\\Users\\ASUS\\Documents\\Arthif\\reversed.txt"));
			
			String line=bReader.readLine();
			StringBuilder content=new StringBuilder();
			while(line!=null) {
				content.append(line).append(System.lineSeparator());
				line=bReader.readLine();
			}
			bWriter.write(content.reverse().toString());
			System.out.println("File Reversed successfully");
			
			bReader.close();
			bWriter.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
