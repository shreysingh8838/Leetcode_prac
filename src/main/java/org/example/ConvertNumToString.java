package org.example;

public class ConvertNumToString {

    private static String ifNumIsOnes(int i){
        switch(i){
            case 0 : return "Zero";
            case 1 : return "One";
            case 2 : return "Two";
            case 3 : return "Three";
            case 4 : return "Four";
            case 5 : return "Five";
            case 6 : return "Six";
            case 7 : return "Seven";
            case 8 : return "Eight";
            case 9 : return "Nine";
        }
        return "";
    }

    private static String ifNumIsSmallerThanTwenty(int i){
        switch (i){
            case 10 : return "Ten";
            case 11 : return "Eleven";
            case 12 : return "Twelve";
            case 13 : return "Thirteen";
            case 14 : return "Fourteen";
            case 15 : return "Fifteen";
            case 16 : return "Sixteen";
            case 17 : return "Seventeen";
            case 18 : return "Eighteen";
            case 19 : return "Ninteen";
            case 20 : return "Twenty";
        }
        return "";
    }
    private static String ifNumsIsTens(int i){
        switch (i){
            case 2: return "Twenty";
            case 3: return "Thirty";
            case 4: return "Forty";
            case 5: return "Fifty";
            case 6: return "Sixty";
            case 7: return "Seventy";
            case 8: return "Eighty";
            case 9: return "Ninty";
        }
        return "";
    }
    private static String convertNumToString(int i){
        if(i < 10) return ifNumIsOnes(i);
        else if(i < 20) return ifNumIsSmallerThanTwenty(i);
        else{
            int ones = i%10;
            int tens = i/10;
            return ( ifNumsIsTens(tens)+"-"+ ifNumIsOnes(ones));
        }
    }
    public static void main(String[] args) {
        int num = 1;
        System.out.println("Given Number is : " + num);
        String s = convertNumToString(num);
        System.out.println("Converted String is : " + s);
    }
}
