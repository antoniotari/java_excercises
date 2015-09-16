package com.antoniotari.excercises.files;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;


public class MainFiles {

	public static void main(String... args){

		ArrayList<String> list=new ArrayList<String>( Arrays.asList("first"));
		writeToFile(list,"test");
		ArrayList<String> list2=readObjectFile("test",ArrayList.class);

		for(String s:list2){
			System.out.println(s);
		}

		writeTextFile("string","test2");
		System.out.println(readTextFile("test2"));
	}

	public static void writeTextFile(String string,String filename){
		try(OutputStream file = new FileOutputStream(filename)){
			file.write(string.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String readTextFile(String filename){
		String result=null;
		try(
				InputStream is=new FileInputStream(filename);
				InputStreamReader buf=new InputStreamReader(is,"UTF-8");
				BufferedReader reader=new BufferedReader(buf);
				){
            StringBuffer sb = new StringBuffer();
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			result = sb.toString();
		}catch(IOException e){}
		return result;
	}

	public static void writeToFile(Serializable obj,String filename){
		try (
				OutputStream file = new FileOutputStream(filename);
				OutputStream buffer = new BufferedOutputStream(file);
				ObjectOutput output = new ObjectOutputStream(buffer);
				){
			output.writeObject(obj);
		}  
		catch(IOException ex){
		}
	}

	public static <T> T readObjectFile(String filename,Class<T> classOfT){
		T list=null;
		try(
				InputStream file = new FileInputStream(filename);
				InputStream buffer = new BufferedInputStream(file);
				ObjectInput input = new ObjectInputStream (buffer);
				){
			list = (classOfT.cast(input.readObject()));
		} catch(ClassNotFoundException|IOException ex){
			return null;
		}
		return list;
	}
}
