package Task6;

import Task5.MainTask5;
import java.util.Random;
import java.util.Scanner;

public class MainTask6 {
    //Task2
    public static int findSymbolOccurance(String ToFind, char Symbol){
        System.out.println(ToFind.replace(String.valueOf(Symbol),"").length());
        return  ToFind.length();
    }
    //Task3
    public static int findWordPosition(String source, String target) {
        int index = source.indexOf(target);
        if (index != -1) {
            return index;
        } else {
            return -1;
        }
    }
    //Task4
    public static String stringReverse(String str) {
        String reversedStr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversedStr += str.charAt(i);
        }
        return reversedStr;
    }
    //Task5

    public static boolean isPalindrome(String str) {
        String reversedStr = stringReverse(str);
        return str.equals(reversedStr);
    }


    public static void main(String[] args) {

    }

}
