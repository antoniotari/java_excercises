package com.antoniotari.facebook;

import java.util.Collection;
import java.util.Iterator;

public class L {
	public static void log(Object... objs){
		if(objs==null){
			System.out.println("__NULL__");
			return;
		}
				
		StringBuilder sb = new StringBuilder();
		log(sb,objs);
		System.out.println(sb.toString());
	}
	
	private static void log(StringBuilder sb,Object... objs){
		for(Object obj:objs){
			if(obj instanceof Iterable){
				sb.append("[");
				
				Iterator<Object> flavoursIter = ((Iterable)obj).iterator();
				if (flavoursIter.hasNext())log(sb,flavoursIter.next());
			    while (flavoursIter.hasNext()){
					sb.append(", ");
					log(sb,flavoursIter.next());
			    }
				sb.append("]");
			}else if(obj==null)
				sb.append("__NULL__");
			else if(obj.toString().isEmpty())
				sb.append("__EMPTY_STRING__");
			else
				sb.append(obj.toString());
			
			//add separator
			if(!obj.equals(objs[objs.length-1]))
				sb.append(" **** ");
		}
	}
	
	public static void nl(){
		log("\n");
	}
}
