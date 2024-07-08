//package org.example;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//public class NonRepeatingCharacterInAString {
//
//    static Character NonRepeatingCharacterInString(String s){
//        Character c = ' ';
//        for(int i=0; i<s.length()-1; i++){
//            c = s.charAt(i);
//            boolean flag = false;
//            for(int j = i+1; j<s.length(); j++){
//                if(c == s.charAt(j)) flag = true;
//            }
//            if(flag != true) break;
//        }
//        return c;
//    }
//    public static void main(String ... args){
////        String s = "leelcode";
////
////
////        List<String> s1 = Arrays.asList("abc", "abc112", "cef", "123mc");
////        List<String> res = s1.stream().filter(a-> !a.chars().anyMatch(Character::isDigit)).map(a-> new StringBuilder(a).reverse().toString()).toList();
////
////        String str = "1010:Amit|2010:Java|3030:Interview|4010:Sachin";
//////        output  => [1010, Amit|2010, Java|3030, Interview|4010, Sachin]
////
////        System.out.println(res);
////        List<String > s2 =  Arrays.asList("abc","efghi","xyz","retd","pqrst");
////        List<String> res1 = s2.stream().filter(a->a.length()>3).map(a->new StringBuilder(a).reverse().toString()).toList();
////        System.out.println(res1);
//
//
//        List<String> lques = Arrays.asList("AA", "BB", "BB", "AA", "CC");
//
//        Map<String, Integer> res = new HashMap<>();
//        lques.stream().forEach(a-> res.put(a, res.getOrDefault(a,0)+1));
//        lques.stream().collect(Collectors.toMap());
//        System.out.println(res);
//
//    }
//}
