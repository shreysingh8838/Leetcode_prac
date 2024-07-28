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
