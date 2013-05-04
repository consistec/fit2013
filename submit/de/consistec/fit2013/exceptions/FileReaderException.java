package de.consistec.fit2013.exceptions;

public class FileReaderException extends Exception {
	
	public FileReaderException()
	{
		this("ReaderException");
	}
	
	public FileReaderException(String inMessage)
	{
		super(inMessage);
	}

}
