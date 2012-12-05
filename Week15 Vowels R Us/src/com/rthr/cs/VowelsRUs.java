/**
 * Author:  Arthur Lockman
 * Date:    Dec 5, 2012
 * School:  Gorham High School
 * 
 * Project: Week15 Vowels R Us
 * Package: com.rthr.cs
 */
package com.rthr.cs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Week14 VowelsRUs Class.
 * @author arthurlockman
 *
 */
public class VowelsRUs
{
	private static FileInputStream fInStream;
	private static InputStreamReader iStreamReader;
	private static BufferedReader reader;
	private String[] data;
	
	/**
	 * Performs the Vowels R Us processing.
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		VowelsRUs vowelWorker = new VowelsRUs();
		vowelWorker.run();
	}
	
	/**
	 * Runs the Vowels R Us application.
	 * @throws IOException
	 */
	private void run() throws IOException
	{
		this.openFile();
		data = this.getData();
		
		for (int i = 0; i < data.length; i++)
			this.processWord(data[i]);
		
		return;
	}
	
	/**
	 * Opens the data file.
	 */
	private void openFile()
	{
	    try
		{
			fInStream = new FileInputStream ("/Users/arthurlockman/Dropbox/School/AP CS/Work/Data Files/vowels.txt/");
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	    
	    iStreamReader = new InputStreamReader(fInStream);
	    reader = new BufferedReader(iStreamReader);
	}
	
	/**
	 * Gets the data out of the data file, and stores it in a string 
	 * array.
	 * @return An array of strings containing the data.
	 * @throws IOException
	 */
	private String[] getData() throws IOException
	{
		String[] tmpData = new String[4];
		String line = reader.readLine();
		int counter = 0;
		
		while (line != null)
		{
			tmpData[counter] = line;
			counter++;
			line = reader.readLine();
		}
		
		reader.close();
		return tmpData;
	}
	
	/**
	 * Perform the processing on each word.
	 * @param line The line to be processed.
	 */
	private void processWord(String line)
	{
		String[] tmpLine = line.split(" ");
		String word = tmpLine[0];
		String suffix = tmpLine[1];
		String pluralWord = new String();
		String suffixWord = new String();
		char[] wordArray = word.toCharArray();
		char[] suffixArray = suffix.toCharArray();
		
		//If ends in double vowels or double consonants.
		if ((!isVowel(wordArray[wordArray.length-1]) && !isVowel(wordArray[wordArray.length-2]))
				|| (isVowel(wordArray[wordArray.length-1]) && isVowel(wordArray[wordArray.length-2])))
		{
			pluralWord = word + wordArray[wordArray.length-1] + "H";
			
			//If suffix starts with consonant.
			if (!isVowel(suffixArray[0]))
				suffixWord = word.substring(0, word.length()-2) + wordArray[wordArray.length-1] + suffix;
			//If suffix starts with a vowel.
			else if (isVowel(suffixArray[0]))
				suffixWord = word + suffixArray[0] + suffix;
		}
		//If ends in a single consonant
		else if (!isVowel(wordArray[wordArray.length-1]))
		{
			pluralWord = word + "GH";
			
			//Create the suffix.
			suffixWord = word + suffix;
		}
		//If ends in a single vowel
		else if (isVowel(wordArray[wordArray.length-1]))
		{
			pluralWord = word.substring(0, word.length()-1) + "G";
			
			//If suffix starts with consonant.
			if (!isVowel(suffixArray[0]))
				suffixWord = word + suffixArray[0] + suffix;
			//If suffix starts with a vowel.
			else if (isVowel(suffixArray[0]))
				suffixWord = word + suffix.substring(1, suffix.length());
		}
		
		System.out.println("Original string: "+line);
		System.out.println(" Plural of "+word+": "+pluralWord);
		System.out.println("    With suffix: "+suffixWord+"\n");
	}
	
	/**
	 * Determines whether or not a given character is a vowel.
	 * @param ch The character to check.
	 * @return A boolean, whether or not the character is a vowel.
	 */
	private boolean isVowel(char ch)
	{
		if (ch == 'A' || ch == 'S' || ch == 'C' || ch == 'L'
				|| ch == 'a' || ch == 's' || ch == 'c' || ch == 'l')
			return true;
		else
			return false;
	}

}
