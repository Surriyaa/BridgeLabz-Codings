package com.filehandling;

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
			int wordCount=0;
			int sentenceCount=0;
			int characterCount=0;
			String line;
			while((line=bReader.readLine()) != null) {
				String words[]=line.split("[ ]");
				String sentence[]=line.split("[.]");
				char character[]=line.toCharArray();
				
				wordCount+=words.length;
				sentenceCount+=sentence.length;
				characterCount+=character.length;
				//System.out.println(line);
			}
			System.out.println("Words count "+wordCount);
			System.out.println("Sentence Count "+sentenceCount);
			System.out.println("Character count "+characterCount);
			bReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
