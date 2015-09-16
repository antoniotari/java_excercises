package com.antoniotari.excercises;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMain {
	public static void main(String[] args) {
		try(//InputStream is = new FileInputStream("json_file.json");
				BufferedReader reader = new BufferedReader(new FileReader("json_file.json"));) {
			String line = null;
		    StringBuilder  stringBuilder = new StringBuilder();
		    while( ( line = reader.readLine() ) != null ) {
		        stringBuilder.append( line );
		        stringBuilder.append(System.getProperty("line.separator"));
		    }
		    String json = stringBuilder.toString();
		    L.log("json",json);
		    Pattern pattern = Pattern.compile("head");
            Matcher m = pattern.matcher(json);
            String videoStr = m.group(0);
            L.log(json,videoStr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
