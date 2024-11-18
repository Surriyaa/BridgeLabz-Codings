package com.java8;

import java.util.ArrayList;
import java.util.List;

public class MapReduce {

	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		list.add(4);
		list.add(5);list.add(1);list.add(3);
		list.add(2);
		
		int sumOfSquaresOfEven =list.stream().filter(l->l%2==0)
				.map(l->l*l).reduce(0, (c,e)-> c+e);
		
		System.out.println(sumOfSquaresOfEven);
	}

}
