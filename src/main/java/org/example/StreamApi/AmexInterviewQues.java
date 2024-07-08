package org.example.StreamApi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class AmexInterviewQues {

    public static void main(String ... args){
//        I/P- {"abc","efghi","xyz","retd","pqrst"}
//                O/P-{ihgfe, dter, tsrqp}
        List<String> ip = Arrays.asList("abc","efghi","xyz","retd","pqrst");
        List<String> op = ip.stream().filter(a->a.length()>3).map(a->new StringBuilder(a).reverse().toString()).toList();
        System.out.println(op);

//        I/P- { "ABC","123ABC","DEG",34H"}
//                O/P-{ "CBA", "GED"}
        List<String> ip1 = Arrays.asList("ABC","123ABC","DEG","34H", " A");
        List<String> op1 = ip1.stream().filter(a->!a.chars().anyMatch(Character::isDigit) || !a.chars().anyMatch(Character::isSpaceChar))
                .map(a->new StringBuilder(a).reverse().toString()).toList();
        System.out.println(op1);

//    	3. Use JAVA 8 to code the following :
//    I/P- { "ABC","123ABC","DEG",34H"} O/P- { "CBA" , "321CBA, "GED", 43H"}]
        List<String> ip2 = Arrays.asList("ABC","123ABC","DEG","34H");
        List<String> op2 = ip2.stream().map(a->
                {
                    StringBuilder letters = new StringBuilder();
                    StringBuilder numerics = new StringBuilder();
                    a.chars().forEach(c->{
                        if(Character.isDigit(c)){
                            numerics.append((char) c);
                        } else if (Character.isAlphabetic(c)) {
                            letters.append( (char) c);
                        }
                    });

                    return numerics.reverse().append(letters.reverse()).toString();
                }
        ).toList();
        System.out.println(op2);

        //        one program to split the string based on :| and further on
//        : to store in order in map (TreeMap) String str ="1010:Amit : | 2010 : Java : | 3030:Interview : | 4010: "
        String str = "1010:Amit : | 2010 : Java : | 3030:Interview : | 4010: ";
//        Map<Integer, String> m = Arrays.stream(str.split(" : \\| ")).map(p->p.split(":")).collect(Collectors.toMap(p->Integer.parseInt(p[0].trim()), p-> p[1].trim(), new TreeMap<>()));


//      4Q  input {2,3,4,5,6} and output {360, 240} using stream api
//        int[] input = {2, 3, 4, 5, 6};
//        int product = Arrays.stream(input).reduce(1,(a,b)-> a*b);
//        int [] output = Arrays.stream(input).map(m->product/m).toArray();
//        System.out.println(Arrays.toString(output));





//        Given `int[] input = {2,3,4,5,6};`, produce the output `{360, 240, 180, 144, 120}
                int[] input = {2, 3, 4, 5, 6};
                int productres = 1;
                int[] outputres = new int[input.length];
                for(int i : input){
                    productres *= i;
                }
                for (int i = 0; i < input.length; i++) {
                    outputres[i] = productres/input[i];
                }
                System.out.println(Arrays.toString(outputres));
    }
}
