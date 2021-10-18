package aula.curso;

import sun.awt.X11.XSystemTrayPeer;

public class Equals {
    public static void main(String[] args){
        String a = "JOAO";
        String b = "JOAO";
        a = a + "";
        b = b + "";
        if(a.equals(b)) {
            System.out.println("São iguais");
        }else{
            System.out.println("São diferentes");
        }

        System.out.println( a.hashCode() );
        System.out.println( b.hashCode() );
        System.out.println();
    }

}
