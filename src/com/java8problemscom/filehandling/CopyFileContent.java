package com.java8problemscom.filehandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFileContent {

	public static void main(String[] args) {
		
		try {
			FileReader reader=new FileReader("C:\\Users\\ASUS\\Documents\\Arthif\\source.txt");
//			FileWriter writer=new FileWriter("C:\\Users\\ASUS\\Documents\\Arthif\\destination.txt");
//			
//			int character;
//			while((character=reader.read()) !=-1){
//				writer.write(character);			
//			}
			
			BufferedReader bReader=new BufferedReader(reader);
			String line;
			while((line=bReader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
