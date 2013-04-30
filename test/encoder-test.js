/*************************************************************
   Filename: 		    encoder-test.js
   Version: 		    0.0.0.1
   Create date:     	30.04.2013
   Last modified:   	30.04.2013
   Description: 	  	Unittests for encode-handler.js
 *************************************************************/


 var assert  = require('node-assertthat');
 var eh 	 = require('../src/encode-handler');

 suite('Encoder-Test', function(){

 	test('Check result from first input file', function(done){
 		eh.transform('bcd', function(actual){
 			assert.that(actual, is.equalTo('ABC'));
 			done();
 		});
 	});

 	test('Check result from second input file', function(done){
 		eh.transform('abcwxy', function(actual){
 			assert.that(actual, is.equalTo('NABXYZ'));
 			done();
 		});
 	});

 	test('Check result from third input file', function(done){
 		eh.transform('Wir wollen Euch testen und sind sehr gespannt auf die Antworten. Hoffentlich sind es mehr als 2.', function(actual){
 			assert.that(actual, is.equalTo('yHS XPKKDM cVBG UDTUDM VMC THMC TDGS FDTQNMMU NVE CHD mMUXPSUDM. fPEEDMUKHBG THMC DT LDGS NKT 2.'));
 			done();
 		});
 	});

 });
