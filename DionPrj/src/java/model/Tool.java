package model;

import java.util.Random;

public class Tool {

    public static void main(String[] args) {

    }

    public static String createString(int n) {
        String letters = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(letters.length());
            char randomChar = letters.charAt(index);
            sb.append(randomChar);
        }
        String s = sb.toString();
        return s;
    }
    
    
    public static int createNumber(int n) {
        String letters = "0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int index = random.nextInt(letters.length());
            char randomChar = letters.charAt(index);
            sb.append(randomChar);
        }
        String s = sb.toString();
        int number = Integer.parseInt(s);
        return number;
    }
    
}

