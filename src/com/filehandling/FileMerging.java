package com.filehandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileMerging {

	public static void main(String[] args) {
		try {
			BufferedReader file1=new BufferedReader(new FileReader("C:\\Users\\ASUS\\Documents\\Arthif\\source.txt"));
			BufferedReader file2 = new BufferedReader(new FileReader("C:\\Users\\ASUS\\Documents\\Arthif\\File\\logs.txt"));
			BufferedReader file3=new BufferedReader(new FileReader("C:\\Users\\ASUS\\Documents\\Arthif\\File\\transactions.txt"));
			
			BufferedWriter file4=new BufferedWriter(new FileWriter("C:\\Users\\ASUS\\Documents\\Arthif\\File\\mergedFile.txt"));
			BufferedReader inputFiles[]= {file1,file2,file3};
			for(BufferedReader input: inputFiles) {
				String line;
				while((line=input.readLine())!=null) {
					file4.write(line);
					file4.newLine();
				}
				file4.newLine();
			}
			System.out.println("Files merged Successfully");
			file4.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
