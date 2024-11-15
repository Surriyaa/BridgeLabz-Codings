package com.map;

import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {
	
	private TreeMap<String, String> contact;
	
	PhoneBook(){
		contact=new TreeMap<String, String>();
	}
	
	private void addContact(String name, String num) {
		contact.put(name, num);
		
	}
	
	private void removeContact(String name) {
		if(contact.containsKey(name)) {
			contact.remove(name);
		}
	}
	
	private void searchContact(String name) {
		if(contact.containsKey(name)) {
			System.out.println("Number of "+name+"="+  contact.get(name));
		}
	}
	
	private void allContacts() {
		for(Map.Entry<String, String> m:contact.entrySet()) {
			System.out.println(m.getKey()+" : "+m.getValue());
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PhoneBook pb=new PhoneBook();
		pb.addContact("Surriyaa","6758675849");
		pb.addContact("gobika","7879786869");
		pb.addContact("raja","96879700978");
		pb.addContact("ramya","978787879");
		pb.addContact("kumar","87970698790");
		
		pb.allContacts(); // display all the contact
		
		pb.searchContact("gobika");
		
		pb.removeContact("raja"); // remove the key value pair of raja 
		
		pb.allContacts();
		
	}



	

}
