package org.example;

public class WordCount {

    public static int removeWords(String s){
        StringBuilder s1 = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'Y') {
                s1.append(s.charAt(i));
            }
        }
        System.out.println(s1);
        return s1.length();
    }
    public static void main(String[] args) {

        int count = 0;
        String s = "Y\tY\tY\tY\tY\tY\tY\tY\tY\tY\tY\tY\tY\tY\tY\tY\tY\tY\tY\tY\tY\tY\tY\tY";


        for(int i = 0; i<s.length(); i++){
            if( s.charAt(i) == 'Y') count++;
        }
        System.out.println(count);
        System.out.println(WordCount.removeWords(s));
    }
}
