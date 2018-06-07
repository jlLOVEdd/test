package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class JavaJC {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  /*  System.out.println(set);
		    Set sortedSet = new TreeSet(set);
		    System.out.println(sortedSet);*/
		    DOg d = new DOg();
		    DOg d1 = new DOg();
		    DOg d2 = new DOg();
		    DOg d3 = new DOg();
		    d.setName("1");
		    d1.setName("2");
		    d2.setName("3");
		    d3.setName("4");
		    Set sortedSet = new TreeSet();
		    sortedSet.add(d3);
		    sortedSet.add(d);
		    sortedSet.add(d1);
		    sortedSet.add(d2);
		    Iterator it  =sortedSet.iterator();
		    while(it.hasNext()){
		    	 System.out.println(((DOg)it.next()).getName());
		    }
		    System.out.println(sortedSet);
		     Map m = Collections.synchronizedMap(new HashMap());
		     
	}
}
	class DOg {
		
		public DOg() {
			super();
			// TODO Auto-generated constructor stub
		}

		private String name ;
		
		

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
	}

