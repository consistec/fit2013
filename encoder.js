if(!process.argv[2] || !process.argv[3]){
	console.log('Usage: node encoder.js input output');
}
else{
	fs = require('fs');
	fs.readFile(process.argv[2], 'utf8', function (err,input) {
	  if (err) {
	    return console.log(process.argv[2] + " - No such file or directory");
	  }
	   var output ='';
	   for(var i = 0; i<input.length; i++){

		   	if(input.charCodeAt(i) == 97){
		   		output += String.fromCharCode(input.charCodeAt(i) -19);
		   		continue;
		   	}

		   	if(input.charCodeAt(i) == 122){
		   		output += String.fromCharCode(input.charCodeAt(i) -43);
		   		continue;
		   	}

		    if(input.charCodeAt(i) > 98 && input.charCodeAt(i) <= 110){
		   		output += String.fromCharCode(input.charCodeAt(i) -33);
		   		continue;
		   	}

		   	if(input.charCodeAt(i) >= 111 && input.charCodeAt(i) < 122){
		   		output += String.fromCharCode(input.charCodeAt(i) -31);
		   		continue;
		   	}

			if(input.charCodeAt(i) == 65 || input.charCodeAt(i) == 66){
		   		output += String.fromCharCode(input.charCodeAt(i) + 44);
		   		continue;
		   	}

		   	if(input.charCodeAt(i) == 89 || input.charCodeAt(i) == 90){
		   		output += String.fromCharCode(input.charCodeAt(i) + 22);
		   		continue;
		   	}


		   	if(input.charCodeAt(i) > 66 && input.charCodeAt(i) <= 78){
		   		output += String.fromCharCode(input.charCodeAt(i) +30);
		   		continue;
		   	}

		   	if(input.charCodeAt(i) >= 79 && input.charCodeAt(i) <= 88){
		   		output += String.fromCharCode(input.charCodeAt(i) +34);
		   		continue;
		   	}

		   	output += String.fromCharCode(input.charCodeAt(i));
	   }

	   fs.writeFile(process.argv[3], output, function(err) {
		    if(err) {
		        console.log("Could not write to file " - process.argv[3]);
		    } else {
		        console.log("Encoding complete");
		    }
		}); 
	});
}