package de.consistec.fit2013.exceptions;

public class FileWriterException extends Exception {
	
	public FileWriterException()
	{
		this("FileWriterException");
	}
	
	public FileWriterException(String inMessage)
	{
		super(inMessage);
	}

}
