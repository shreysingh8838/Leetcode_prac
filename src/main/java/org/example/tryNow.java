package org.example;

import java.util.*;
import java.util.stream.Collectors;

//
//You have been given a list of names: "Aastha", "Deepanshu", "Javed", and "Ajit".
// Your task is to write a Java program using Java 8 features to create a mapping of each name to its length and print the result in the format [Name = Length].
//Example Output: For the given list [Aastha, Deepanshu, Javed, Ajit], the expected output is:
//        [Aastha = 6, Deepanshu = 9, Javed = 5, Ajit = 4]
public class tryNow {
    //        List<String> s = Arrays.asList("Aastha", "Deepanshu", "Javed", "Ajit");
//        s.stream().forEach(a-> System.out.println(a + " = " + a.length()));

    public static void main(String[] args) {
        String s="india is my country";
//        O/P : Si AiDnI yRtNuOc Ym

        StringBuilder s1 = new StringBuilder(s);
        s1.append(" ");

        StringBuilder sb = new StringBuilder();
        List<String> ns = new ArrayList<>();

        int counter = 0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i)==' ') counter++;
            if(counter > 1){
                ns.add(sb.toString());
                sb.delete(0, sb.length());
                counter = 0;
            }
            sb.append(s1.charAt(i));
        }
        sb.delete(0,sb.length());
        for(int i=0; i<ns.size(); i++){
            StringBuilder temp = new StringBuilder(ns.get(i));
            temp.reverse();
            temp.append(" ");
            sb.append(temp);
        }
        counter = 0;
        for(int i=0; i<sb.length(); i++){
            if(sb.charAt(i)==' ') counter = 0;
            if(counter == 0)  {
                System.out.print(Character.toUpperCase(sb.charAt(i)));
                counter++;
            }
            else{
                System.out.print(sb.charAt(i));
                counter = 0;
            }
        }
    }
}
