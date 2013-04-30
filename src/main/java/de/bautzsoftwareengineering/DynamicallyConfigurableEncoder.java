package de.bautzsoftwareengineering;

import java.util.HashMap;

/**
 * Tim Bautz Softwareengineering
 * tim@bautz-softwareengineering.de
 * Date: 30.04.13
 * Time: 19:12
 */
public class DynamicallyConfigurableEncoder {

    private HashMap<Character, Character> encoding = new HashMap<Character, Character>();

    public void addEncoding(String input, String output) throws IllegalArgumentException {
        if (input.length() != output.length())
            throw new IllegalArgumentException("Input length != Output length");

        char[] inputChars = input.toCharArray();
        char[] outputChars = output.toCharArray();
        for (int i = 0; i < inputChars.length; i++) {
            if (encoding.containsKey(inputChars[i]) && encoding.get(inputChars[i]) != outputChars[i])
                throw new IllegalArgumentException("Double match for encoding of Input: " + inputChars[i] + " -->" + outputChars[i] + "!=" + encoding.get(inputChars[i]));
            encoding.put(inputChars[i], outputChars[i]);
        }
    }

    public String encode(String input) throws IllegalArgumentException {
        StringBuffer outputBuffer = new StringBuffer();
        char[] inputChars = input.toCharArray();
        for (int i = 0; i < input.length(); i++) {
            if (encoding.containsKey(inputChars[i]))
                outputBuffer.append(encoding.get(inputChars[i]));
            else
                outputBuffer.append(inputChars[i]);
        }
        return outputBuffer.toString();
    }

    public void reset(){
        encoding = new HashMap<Character, Character>();
    }


}
