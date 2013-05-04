package de.consistec.fit2013;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import de.consistec.fit2013.exceptions.FileReaderException;

public class FileReaderTool {
	
	private BufferedReader mBufferedReader = null;
	
	public FileReaderTool(String inFilePath) throws FileReaderException
	{
		try
		{
			this.mBufferedReader = new BufferedReader(new FileReader(inFilePath));
		}
		catch(FileNotFoundException e)
		{
			this.close();
			throw new FileReaderException("@ initialising the reader");
		}
	}
	
	public int getNextCharacter() throws FileReaderException 
	{
		int toReturn = -1;
		
		try
		{
			toReturn = this.mBufferedReader.read();
		}
		catch(IOException e)
		{
			this.close();
			throw new FileReaderException("@ reading a character");
		}
		 
		return toReturn;
	}
	
	public void close() throws FileReaderException
	{
		try 
		{
			if(this.mBufferedReader != null)
			{
				this.mBufferedReader.close();
			}
		}
		catch (IOException e) 
		{
			throw new FileReaderException("@ closing the reader");
		}
		finally
		{
			this.mBufferedReader = null;
		}
	}

}
