package de.consistec.fit2013;

import java.io.File;

public class ArgValidator {
	
	private ArgRejectionReason mArgRejectReason;

	
public boolean areArgsOK(String[] inArgs)
{
	boolean toReturn = true;
	
	if(!this.isCorrectArgumentNumber(inArgs))
	{
		toReturn = false;
		this.mArgRejectReason = ArgRejectionReason.WrongArgNumber;
	}
	else if(!this.inputFileExists(inArgs[0]))
	{
		toReturn = false;
		this.mArgRejectReason = ArgRejectionReason.CannotFindInputFile;
	}
	else if(!this.outputFileNameIsAvailable(inArgs[1]))
	{
		toReturn = false;
		this.mArgRejectReason = ArgRejectionReason.OutputFileAlreadyExists;
	}
	else
	{
		this.mArgRejectReason = ArgRejectionReason.None;
	}
	
	return toReturn;
	
}

private boolean isCorrectArgumentNumber(String[] args)
{
	boolean toReturn = false;
	
	if(args.length == 2)
	{
		toReturn = true;
	}
		
	return toReturn;
}

private boolean inputFileExists(String inputFilePath)
{
	boolean toReturn = false;
	
	File cFile = new File(inputFilePath);
	
	if(cFile.exists())
	{
		toReturn = true;
	}
	
	return toReturn;
}

private boolean outputFileNameIsAvailable(String outputFilePath)
{
	boolean toReturn = false;
	
	File cFile = new File(outputFilePath);
	
	if(!cFile.exists())
	{
		toReturn = true;
	}
	
	return toReturn;
}

public ArgRejectionReason getArgRejectionReason()
{
	return this.mArgRejectReason;
}

}
