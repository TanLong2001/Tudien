package com.example.newVersion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.Line;

public class History {

	
	public static List<String> history(String url) {
		BufferedReader br = null;
		List<String> strings = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(new File(url)));
			String lineString = "";
			try {
				lineString = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while(lineString != null) {
				strings.add(lineString);
				try {
					lineString = br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return strings;
	}
}
