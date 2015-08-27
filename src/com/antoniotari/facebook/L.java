package com.antoniotari.facebook;

public class L {
	public static void log(Object... objs){
		if(objs==null){
			System.out.println("__NULL__");
			return;
		}
		StringBuilder sb = new StringBuilder();
		for(Object obj:objs){
			if(obj==null)
				sb.append("__NULL__");
			else if(obj.toString().isEmpty())
				sb.append("__EMPTY_STRING__");
			else
				sb.append(obj.toString());
			
			//add separator
			if(!obj.equals(objs[objs.length-1]))
				sb.append(" **** ");
		}
		System.out.println(sb.toString());
	}
}
