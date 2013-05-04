-Assuming you use windows and your jdk is configured and your environment variables are set: 
(you don't need java7 I just realized the restriction and so removed the diamond operator ;-) )
	
	-just double-click on the compile.bat to build the sources.
	-Then from the root-folder (fit2013) you can run the program with the following command:
	 (you can copy paste it from here)

	java de.consistec.fit2013.Encoder hereComesYourInput.txt hereComesYourOutput.txt






I added some junit test classes inside the project in the package de.consistec.fit2013.tests they are not compiled by the script.
They also contain hardcoded relative file paths pointing to files in the fit2013-master folder at root level. 


Best Regards,
Eric Falk

erfalk@gmail.com