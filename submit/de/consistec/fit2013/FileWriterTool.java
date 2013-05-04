package de.consistec.fit2013;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import de.consistec.fit2013.exceptions.FileWriterException;

public class FileWriterTool {

	private BufferedWriter mBufferedWriter = null;
	
	
	public FileWriterTool(String inFilePath) throws FileWriterException
	{	
		try
		{
			this.mBufferedWriter = new BufferedWriter(new FileWriter(inFilePath));
		}
		catch(IOException e)
		{
			this.close();
			throw new FileWriterException("@ initializing the writer");
		}
	}
	
	public void writeNextCharacter(int inChar) throws FileWriterException
	{
		try
		{
			this.mBufferedWriter.write(inChar);
		}
		catch(IOException e)
		{
			this.close();
			throw new FileWriterException("@ writing character");
		}
		
	}
	
	public void close() throws FileWriterException
	{
		try
		{
			this.mBufferedWriter.flush();
			this.mBufferedWriter.close();
		}
		catch(IOException e)
		{
			throw new FileWriterException("@ closing the writer");
		}
		finally
		{
			this.mBufferedWriter = null;
		}
	}
	
}
