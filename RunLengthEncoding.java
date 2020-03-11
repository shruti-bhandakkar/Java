/**
Run-length encoding is a fast and simple method of encoding strings.
The basic idea is to represent repeated successive characters as a single count and character.
For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".

Implement run-length encoding and decoding.
You can assume the string to be encoded have no digits and consists solely of alphabetic characters.
You can assume the string to be decoded is valid.
**/

import java.util.*;

public class RunLengthEncoding {

    public static void main(String[] args) {
        String encodeThisString = "AAAABBBCCDAA";
        StringBuffer encodedString = runLengthEncode(encodeThisString);
        System.out.println(encodedString);
        String decodeThisString = "4A3B2C1D2A";
        StringBuffer decodedString = runLengthDecode(decodeThisString);
        System.out.println(decodedString);
    }

    private static StringBuffer runLengthEncode(String s) {
        StringBuffer str = new StringBuffer();
        int count = 1;
        for(int i = 0; i < s.length()-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                count++;
            } else {
                str.append(count);
                str.append(s.charAt(i));
                count = 1;
            }
        }
        str.append(count);
        str.append(s.charAt(s.length()-1));
        return str;
    }

    private static StringBuffer runLengthDecode(String s) {
        StringBuffer str = new StringBuffer();
        for(int i = 0; i < s.length()-1; i=i+2) {
            for(int j = Character.getNumericValue(s.charAt(i)); j > 0; j--)
                str.append(s.charAt(i+1));
        }
        return str;
    }
}
