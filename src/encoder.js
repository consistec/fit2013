/*************************************************************
   Filename: 		    encoder.js
   Version: 		    0.0.0.1
   Create date:     	30.04.2013
   Last modified:   	30.04.2013
   Description: 	  	Read input files from command line
   						and transform input by encode-handler.
   						Usage: node encoder.js input output
 *************************************************************/

var eh = require('./encode-handler');

if(!process.argv[2] || !process.argv[3]){
	console.log('Usage: node encoder.js input output');
}
else{
	fs = require('fs');
	fs.readFile(process.argv[2], 'utf8', function (err,input) {
	  if (err) {
	    return console.log(process.argv[2] + " - No such file or directory");
	  }
	   
	   eh.transform(input, function(output){
	   		fs.writeFile(process.argv[3], output, function(err) {
		    if(err) {
		        console.log("Could not write to file " - process.argv[3]);
		    } else {
		        console.log("Encoding complete");
		    }
		}); 
	   });
	});
}