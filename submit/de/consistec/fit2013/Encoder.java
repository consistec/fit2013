package de.consistec.fit2013;


import java.util.Scanner;

import de.consistec.fit2013.exceptions.FileReaderException;
import de.consistec.fit2013.exceptions.FileWriterException;


public class Encoder {

	//TODO: Test if the encoding still works
	//TODO: test cases for all the shit.
	
	public Encoder()
	{
	
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		ArgValidator cArgValidator = new ArgValidator();
		
		boolean areArgsOK = false;
		
		String userMessage = "";
		
		Scanner cScanner = new Scanner(System.in);
		
		do 
		{
			areArgsOK = cArgValidator.areArgsOK(args);	
			

			
			switch(cArgValidator.getArgRejectionReason())
			{
			case WrongArgNumber:				
				userMessage = "You forgot to specify all arguments your input should have the form: \n\r" +
							  "input.txt output.txt \n\r" + 
						      "Please re-enter the input and output file seperated by a space: 'input.txt output.txt' \n\r";
				break;
			
			case CannotFindInputFile:
				userMessage = "the input file you specified does not exist: \n\r" + 
					          "Please re-enter the input and output file seperated by a space: 'input.txt output.txt";
				break;
			
			case OutputFileAlreadyExists:
				
				userMessage = "the output file you specified already exists: \n\r" + 
				          "Do you want to overwrite it? (Y/n)";
				
				System.out.println(userMessage);
				
				boolean respondOK = false;
				
				do
				{
					String respond = cScanner.nextLine();
				
					if( respond.equals("") || respond.equals("Y") || respond.equals("y") )
					{
						respondOK = true;
						
						//this is the last tested rejection cause. If the user gets promted for this the other args are ok.
						//Here we can proceed if the user wants to overwrite
						areArgsOK = true;
						
					}
					else if( respond.equals("n") || respond.equals("N") )
					{
						respondOK = true;
						userMessage = "Please re-enter the input and output file seperated by a space: 'input.txt output.txt";
					}
					else
					{
						userMessage = "Your respond could not be interpreted: do you want to overwrite the output file? (Y/n)";
						System.out.println(userMessage);
					}
				
				}while(!respondOK);
				
				break;
				
			case None:
				
				break;
			}
			
					
			if(!areArgsOK)
			{
				System.out.println(userMessage);
				args =  cScanner.nextLine().split(" ");
			}
					
		}while(!areArgsOK);
		
		cArgValidator = null;
		cScanner = null;
		
		
		try 
		{
			new Encoder().run(args[0], args[1]);
		}
		catch (FileReaderException e)
		{
			System.out.println("Sorry something went terribly wrong please check your input file settings!");
		}
		catch (FileWriterException e)
		{
			System.out.println("Sorry something went terribly wrong please check your output file settings!");
		}
		
		System.out.println("GOOD NEWS: Your file has been encoded!!");

	}

	private void run(String inputFilePath, String outputFilePath) throws FileReaderException, FileWriterException
	{
		FileReaderTool cFileReadTool = new FileReaderTool(inputFilePath);
		FileWriterTool cFileWriterTool = new FileWriterTool(outputFilePath);
		
		int i;
		
		while((i = cFileReadTool.getNextCharacter()) != -1)
		{
			int toWrite = EncodingTools.getMapping(i);
			
			if(toWrite != -1)
			{
				cFileWriterTool.writeNextCharacter(toWrite);
			}
		}
		
		cFileReadTool.close();
		cFileWriterTool.close();
	}
	
}