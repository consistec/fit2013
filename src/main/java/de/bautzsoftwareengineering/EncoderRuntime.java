package de.bautzsoftwareengineering;

import java.io.*;

/**
 * Tim Bautz Softwareengineering
 * tim@bautz-softwareengineering.de
 * Date: 25.04.13
 * Time: 06:49
 */
public class EncoderRuntime {


    public static void main(String[] argv) {
        System.out.println("FIT2013 Encoder");
        if (argv.length != 2) {
            System.out.println("Usage: encoder <inputfile> <outputfile");
            System.exit(-1);
        }


        String encodingInput = null;

        try {
            FileInputStream fileInputStream = new FileInputStream(argv[0]);
            BufferedReader bufferedReaderIn = new BufferedReader(new InputStreamReader(fileInputStream));
            String currLine = bufferedReaderIn.readLine();
            encodingInput = currLine;
            while (currLine != null) {
                currLine = bufferedReaderIn.readLine();
                encodingInput += currLine;
            }
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (encodingInput == null) {
            System.out.println("No input provided - exting now");
            System.exit(-1);
        }

        String encodingOutput = new Encoder().encode(encodingInput);

        try {
            File outputFile = new File(argv[1]);
            FileWriter outFileWriter = new FileWriter(outputFile);
            BufferedWriter bufferedWriterOut = new BufferedWriter(outFileWriter);
            bufferedWriterOut.write(encodingOutput);
            bufferedWriterOut.flush();
            bufferedWriterOut.close();
            System.out.println("File "+argv[0] + " sucessfully encoded. Output written to: "+ argv[1]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
