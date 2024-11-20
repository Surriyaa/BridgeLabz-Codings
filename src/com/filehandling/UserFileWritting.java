package com.filehandling;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserFileWritting {

	public static void main(String[] args) {
		
		try {
			Scanner sc=new Scanner(System.in);
			FileWriter fwriter=new FileWriter("C:\\Users\\ASUS\\Documents\\Arthif\\user_input.txt");
			System.out.println("write the line to upload");
			while(true) {
				String input=sc.nextLine();
			if(input.equalsIgnoreCase("exit")) {
				break;
			}
				fwriter.write(input+System.lineSeparator());
			}
			System.out.println("Written Sucessfully");
			sc.close();
			fwriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}

}

