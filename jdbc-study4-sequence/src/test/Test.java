package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Test {
	public static void main(String args[]) {
		ArrayList list = new ArrayList();
		list.add("A");
		list.add("B");
		list.add("A");
		System.out.println(list.size());
		HashSet set = new HashSet();
		set.add("A");
		set.add("B");		
		set.add("A");
		System.out.println(set.size());
		HashMap map=new HashMap();
		map.put("A", "A");
		map.put("B", "B");
		map.put("A", "A");
		System.out.println(map.size());
	}
} 
