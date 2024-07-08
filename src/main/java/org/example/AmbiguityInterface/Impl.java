package org.example.AmbiguityInterface;

public class Impl implements InterfaceA, InterfaceB{


//    @Override
//    public void runthis() {
//        InterfaceA.super.runthis();
//    }

    @Override
    public void runthis(){
        InterfaceB.super.runthis();
    }

    public static void main(String[] args) {
        Impl i = new Impl();
        i.runthis();

//        char [] c = {'h', 'g', 's', 'l'};
//        String s = String.valueOf(c);
//        System.out.println(s);

        String s = "10";
        int i1 = Integer.parseInt(s);
        System.out.println(i1);
        String s1 = Integer.toString(i1);

    }
}

//class Solution {
//    public static TreeMap<Integer, Integer> createList(int num){
//        TreeMap<Integer, Integer> result = new TreeMap<>();
//        int counter = 0;
//        for(int i=0; num>0; i++){
//            int n = num%10;
//            // int finalnum = n;
//            // int j = i;
//            // while(j>0){
//            //     finalnum = finalnum * 10;
//            //     j--;
//            // }
//            result.put(counter++, n);
//            num = num/10;
//        }
//        return result;
//    }
//
//    // public String returnTheString(int n){
//    //     Switch(n){
//    //         case 1 : return "I";
//    //         case 5 : return "V";
//    //         case 10 : return "X";
//    //         case 50 : return "L";
//    //         case 100 : return "C";
//    //         case 500 : return "D";
//    //         case 1000 : return "M";
//    //     }
//    // }
//
//    public String intToRoman(int num) {
//        TreeMap<Integer, Integer> nums = createList(num);
//        System.out.println(nums);
//        StringBuilder sb = new StringBuilder();
//        NavigableMap<Integer, Integer> reverseMap = nums.descendingMap();
//
//        for(Map.Entry<Integer, Integer> n : reverseMap.entrySet()){
//            Integer key = (int) n.getKey();
//            Integer value = (int) n.getValue();
//            if(value == 9){
//                if(key== 0){
//                    sb.append("IX");
//                } else if(key == 1){
//                    sb.append("XC");
//                } else if(key == 2){
//                    sb.append("CM");
//                }
//            } else if( value == 4){
//                if(key== 0){
//                    sb.append("IV");
//                } else if(key == 1){
//                    sb.append("XL");
//                } else if(key == 2){
//                    sb.append("CD");
//                }
//            }
//            else{
//                if(value > 5 && value < 10){
//                    int leftvalue = 9 - value;
//                }
//            }
//
//        }
//        return sb.toString();
//    }
//}