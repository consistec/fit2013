package de.bautzsoftwareengineering;

/**
 * Tim Bautz Softwareengineering
 * tim@bautz-softwareengineering.de
 * Date: 24.04.13
 * Time: 19:16
 */
public class Encoder {


    public String encode(String input) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char currChar = chars[i];
            if (currChar >= 'o' && currChar <= 'z')
                chars[i] = (char) (chars[i] - 31);
            if (currChar > 'a' && currChar < 'o')
                chars[i] = (char) (chars[i] - 33);
            if (currChar == 'a')
                chars[i] = 'N';
            if(currChar >= 'W' && currChar <='Z')
                chars[i] = (char)(chars[i]+34);
            if(currChar >= 'A' && currChar <'E')
                chars[i] = (char)(chars[i] +44);
            if(currChar >= 'E' && currChar < 'W')
                chars[i] = (char) (chars[i]+ 30);
        }
        return new String(chars);
    }


}
