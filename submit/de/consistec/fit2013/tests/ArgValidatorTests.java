package de.consistec.fit2013.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.consistec.fit2013.ArgRejectionReason;
import de.consistec.fit2013.ArgValidator;

public class ArgValidatorTests {

	private ArgValidator mArgValidator;
	
	
	
	@Before
	public void prepareTestEnvironment()
	{
		this.mArgValidator = new ArgValidator();
	}
	
	
	
	
	@Test
	public void tooFewArgsTest() 
	{
		String[] args = {"input.txt"};
		
		boolean result = this.mArgValidator.areArgsOK(args);
		
		assertTrue("The Args should have been rejected", result == false   );
	}
	
	@Test
	public void tooFewArgsrejectionReasonTest() 
	{
		String[] args = {"input.txt"};
		
		boolean result = this.mArgValidator.areArgsOK(args);
		
		if(result)
		{
			fail("The Args should have been rejected");
		}
		
		assertTrue("The reason for the rejection is arguments i not correct",
				this.mArgValidator.getArgRejectionReason() == ArgRejectionReason.WrongArgNumber);	
	}
		
	@Test
	public void tooManyArgsTest() 
	{
		String[] args = {"input.txt","output.txt","buffer.txt"};
		
		boolean result = this.mArgValidator.areArgsOK(args);
		
		assertTrue("The Args should have been rejected", result == false   );
	}
	
	@Test
	public void tooManyArgsRejectionReasonTest() 
	{
		String[] args = {"input.txt","output.txt","buffer.txt"};
		
		boolean result = this.mArgValidator.areArgsOK(args);
		
		if(result)
		{
			fail("The Args should have been rejected");
		}
		
		assertTrue("The reason for the rejection is arguments i not correct",
				this.mArgValidator.getArgRejectionReason() == ArgRejectionReason.WrongArgNumber);	
	}
	
	@Test
	public void inputFileNotFoundTest()
	{
		String[] args = {"fit2013-master/input/inputTestNotFound.txt","fit2013-master/input/outputTest.txt"};
		
		boolean result = this.mArgValidator.areArgsOK(args);
		
		assertTrue("The Args should have been rejected", result == false   );
	}
	
	@Test
	public void inputFileNotFoundRejectionReasonTest()
	{
		String[] args = {"fit2013-master/input/inputTestNotFound.txt","fit2013-master/input/outputTest.txt"};
		
		boolean result = this.mArgValidator.areArgsOK(args);
		
		if(result)
		{
			fail("The Args should have been rejected");
		}
		
		assertTrue("The reason for the rejection is arguments i not correct",
				this.mArgValidator.getArgRejectionReason() == ArgRejectionReason.CannotFindInputFile);	
	}
	
	@Test
	public void OutputFileExistsTest()
	{
		String[] args = {"fit2013-master/input/inputTests.txt","fit2013-master/output/outputExistsTest.txt"};
		
		boolean result = this.mArgValidator.areArgsOK(args);
		
		assertTrue("The Args should have been rejected", result == false   );
	}
	
	@Test
	public void OutputFileExistsRejectionReasonTest()
	{
		String[] args = {"fit2013-master/input/inputTests.txt","fit2013-master/output/outputExistsTest.txt"};
		
		boolean result = this.mArgValidator.areArgsOK(args);
		
		if(result)
		{
			fail("The Args should have been rejected");
		}
		
		assertTrue("The reason for the rejection is arguments i not correct",
				this.mArgValidator.getArgRejectionReason() == ArgRejectionReason.OutputFileAlreadyExists);	
	}
	
	@Test
	public void ArgsAcceptedTest()
	{
		String[] args = {"fit2013-master/input/inputTests.txt","fit2013-master/output/outputDoesntExistsTest.txt"};
		
		boolean result = this.mArgValidator.areArgsOK(args);
		
		assertTrue("The Args should have been rejected", result == true   );
	}


	
	@After
	public void cleanTestEnvironment()
	{
		this.mArgValidator = null;
	}
	
	
	

}
