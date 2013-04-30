/*************************************************************
   Filename: 		    encoder-handler.js
   Version: 		    0.0.0.1
   Create date:     	30.04.2013
   Last modified:   	30.04.2013
   Description: 	  	Transform input.
 *************************************************************/


exports.transform = function(input, callback){
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

		    if(input.charCodeAt(i) >= 98 && input.charCodeAt(i) <= 110){
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

	   callback(output);
}