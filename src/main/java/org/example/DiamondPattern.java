package org.example;

public class DiamondPattern {
    public static void main(String[] args) {

//          *
//         ***
//        *****
//         ***
//          *
//

//         *
//        ***
//         *


//         *
//        ***

        int inlines = 5;
        int maxStars = 5;
        int [] stars = {1, 3, 5};

        int firsthalfnumlines = inlines/2 + 1;
        int secondhalfnumlines = inlines/2;

        // To print the above half
        //   *
        //  ***
        // *****
        for(int i =0; i< firsthalfnumlines; i++){
            int numspaces = maxStars + 2 - stars[i];
            for(int k = 0; k < numspaces/2;k++){
                System.out.print(" ");
            }
            for(int j=0; j< stars[i];j++){
                System.out.print("*");
            }
            for(int k = 0; k < numspaces/2;k++){
                System.out.print(" ");
            }
            System.out.println();
        }

        // TO print the later half
        // ***
        //  *
        for(int i = secondhalfnumlines-1; i>=0; i--){
            int numspaces = maxStars + 2 - stars[i];
            for(int k=0; k<numspaces/2; k++){
                System.out.print(" ");
            }
            for(int j = 0; j<stars[i]; j++){
                System.out.print("*");
            }
            for(int k=0; k<numspaces/2; k++){
                System.out.print(" ");
            }
            System.out.println();
        }

    }
}
