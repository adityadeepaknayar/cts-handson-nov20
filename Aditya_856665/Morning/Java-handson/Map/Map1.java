package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Map1 {
	public static void main(String[]args) {
		Map<String, ArrayList<String>> map1=new HashMap<String, ArrayList<String>>();
		map1.put("CS",new ArrayList<String>());
		map1.put("EC",new ArrayList<String>());
		map1.get("CS").add("Student1");
		map1.get("EC").add("Student2");
		map1.get("CS").add("Student3");
		map1.get("EC").add("Student4");
		
		System.out.println("CS : "+map1.get("CS"));
		System.out.println("EC : "+map1.get("EC"));


	}

}
