package de.consistec.fit2013.tests;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Test;

import de.consistec.fit2013.Encoder;
import de.consistec.fit2013.FileReaderTool;
import de.consistec.fit2013.exceptions.FileReaderException;


public class EncoderTests {

	private FileReaderTool mFileReaderToolOutput = null;
	private FileReaderTool mFileReaderToolReference = null;
	
	@Test
	public void testEncoding()
	{
		this.input1Test(new String[] {"fit2013-master/input/input1.txt","fit2013-master/output/output1.txt"},"fit2013-master/output/output_input1.txt");
		this.input1Test(new String[] {"fit2013-master/input/input2.txt","fit2013-master/output/output2.txt"},"fit2013-master/output/output_input2.txt");
		this.input1Test(new String[] {"fit2013-master/input/input3.txt","fit2013-master/output/output3.txt"},"fit2013-master/output/output_input3.txt");
	}
	
	
	public void input1Test(String[] inArgs, String referencePath)
	{	
		
		boolean encodingIsCorrect = true;
		
		
			Encoder.main(inArgs);
				
		try
		{
			this.mFileReaderToolOutput = new FileReaderTool(inArgs[1]);
			this.mFileReaderToolReference = new FileReaderTool(referencePath);
		}
		catch(FileReaderException e)
		{
			fail("An error happened while initialising the readers for the comparision");
		}
		
		int i = -1;
		
		try
		{
			while((i = this.mFileReaderToolOutput.getNextCharacter()) != -1)
			{
				if(i != this.mFileReaderToolReference.getNextCharacter())
				{
					encodingIsCorrect = false;
					break;
				}
			}
		}
		catch(FileReaderException e)
		{
			fail("FailReaderException was trigerred while comparing the caracters");
		}
		finally
		{
			try
			{
				this.mFileReaderToolOutput.close();
				this.mFileReaderToolReference.close();
			}
			catch(FileReaderException e)
			{
				fail("An error happened while closing the readers for the comparision");
			}
		}
		
		
		assertTrue("The produced output is not correct!", encodingIsCorrect);		
		
	}
	


@After
public void cleanTestEnvironment()
{
	for(int i = 1; i < 4; i++)
	{
		File cFile = new File("fit2013-master/output/output"+i+".txt");
		
		if(cFile.exists())
		{
			cFile.delete();
		}
	}
	
}

}