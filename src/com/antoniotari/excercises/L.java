package com.antoniotari.excercises;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;

public class L {
	
	public static void log(Object... objs){
		if(objs==null){
			System.out.println(readString("null"));
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
				sb.append(readString("null"));
			else if(obj.toString().isEmpty())
				sb.append(readString("empty"));
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
	
	private static String readString(String what){
		String defStr=readDefaults().replaceAll("\\s", "");
		String[] tokens = defStr.split(";");
		for(String token:tokens){
			String[] tokens2 = token.split("=");
			if(tokens2.length==2 && tokens2[0].equals(what)){
				return tokens2[1];
			}
		}
		return "??";
	}
	
	private static String readDefaults(){
		StringBuilder sb = new StringBuilder();
		try
		(	InputStream os=new FileInputStream("default_strings");
			InputStreamReader isr=new InputStreamReader(os);
			BufferedReader br= new BufferedReader(isr);){
			String temp;
			while((temp = br.readLine())!=null){
				sb.append(temp);
			}
		}catch(IOException e){}
		return sb.toString();
	}
}
