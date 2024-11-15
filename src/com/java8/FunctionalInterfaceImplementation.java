package com.java8;

@FunctionalInterface
interface Adding{
	void add(int a,int b);
}
public class FunctionalInterfaceImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Adding a=(s,y)-> System.out.println(s+y);
			a.add(10, 20);
		}
	}


