package de.bautzsoftwareengineering;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Tim Bautz Softwareengineering
 * tim@bautz-softwareengineering.de
 * Date: 30.04.13
 * Time: 20:00
 */
public class DynamicallyConfigurableEncoderRuntime {


    public static void main(String[] argv) {
        System.out.println("FIT2013 Encoder - Dynamically Configurable Edition");
        if (argv.length != 4) {
            System.out.println("Usage: encoder <inputConfigFileDir> <outputConfigFileDir> <inputfileToEncode> <encodedOutputfile");
            System.exit(-1);
        }

        // Phase 1: Collect input/output configuration tuples,
        File encodingSpecInputFileDir = new File(argv[0]);
        if (!encodingSpecInputFileDir.isDirectory()) {
            System.out.println(argv[0] + " is not a Directory!");
            System.exit(-1);
        }
        File encodingSpecOutputFileDir = new File(argv[1]);
        if (!encodingSpecOutputFileDir.isDirectory()) {
            System.out.println(argv[1] + "is not a Directory!");
            System.exit(-1);
        }

        ArrayList<File> encodingInputFiles = new ArrayList<File>(Arrays.asList(encodingSpecInputFileDir.listFiles()));
        ArrayList<File> encodingOutputFiles = new ArrayList<File>(Arrays.asList(encodingSpecOutputFileDir.listFiles()));

        // Phase 2: Configure encoder !
        DynamicallyConfigurableEncoder encoder = new DynamicallyConfigurableEncoder();
        for (File inputFile : encodingInputFiles) {
            String matchingOutPutFileName = "output_" + inputFile.getName();
            File matchingEncodingOutPutFile = findFileByName(encodingOutputFiles, matchingOutPutFileName);
            if (matchingEncodingOutPutFile != null) {
                String encodingInput = readFile(inputFile);
                String encodingOutput = readFile(matchingEncodingOutPutFile);
                System.out.println("Adding Configuration: In->" + inputFile.getName() + " Out->" + matchingOutPutFileName);
                encoder.addEncoding(encodingInput, encodingOutput);
            }

        }

        // Phase 3: Read Input to encode and encode it !
        String encodingInput = readFile(argv[2]);

        if (encodingInput == null || encodingInput.isEmpty()) {
            System.out.println("No input provided - exiting now");
            System.exit(-1);
        }
        System.out.println("Encoding input read from: "+ argv[2]);

        // Phase 4: Write output
        String encodingOutput = encoder.encode(encodingInput);
        writeFile(argv[3], encodingOutput);
    }

    private static String readFile(File file) {
        if (!file.canRead())
            System.out.println("Can't read file");
        StringBuffer fileBuffer = new StringBuffer();

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader bufferedReaderIn = new BufferedReader(new InputStreamReader(fileInputStream));
            int c = bufferedReaderIn.read();
            while (c != -1) {
                fileBuffer.append((char) c);
                c = bufferedReaderIn.read();
            }
            fileInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileBuffer.toString();
    }

    private static String readFile(String fileName) {
        return readFile(new File(fileName));
    }

    private static void writeFile(String fileName, String content) {
        try {
            File outputFile = new File(fileName);
            FileWriter outFileWriter = new FileWriter(outputFile);
            BufferedWriter bufferedWriterOut = new BufferedWriter(outFileWriter);
            bufferedWriterOut.write(content);
            bufferedWriterOut.flush();
            bufferedWriterOut.close();
            System.out.println("Output written to: " + fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static File findFileByName(ArrayList<File> files, String fileName) {
        for (File file : files) {
            if (file.getName().equals(fileName)) {
                return file;
            }
        }
        return null;
    }

}
