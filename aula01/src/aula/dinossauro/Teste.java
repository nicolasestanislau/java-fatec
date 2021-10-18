package aula.dinossauro;

import javax.swing.*;
import java.util.Scanner;

public class Teste {
    public static void main(String [] args){
        Dinossauro skeep = new Dinossauro();

        skeep.energia = 100;
        skeep.velocidade = 100;
        skeep.temperatura = 100;
        skeep.humor = 100;


        char letra = 'q';

        do{
            System.out.println("---------------------- \nstatus do Skeep\n" +
                    "energia: " + skeep.energia + "\n" +
                    "velocidade: "+ skeep.velocidade + "\n" +
                    "temperatura: " + skeep.temperatura + "\n" +
                    "humor: " +  skeep.humor);
            Scanner scan= new Scanner(System.in);
            System.out.println("-----------Skeep----------- \nP -Pular- "
                    + "\nC -Correr- \nM -Comer- \nA -Cantar- \nS -Tomar sol-  \nO -Ficar na sombra- \n "
                    + "\nE -Sair");

            String textoMaiusculo = scan.nextLine().toUpperCase();
            letra = textoMaiusculo.charAt(0);
            if ('P' == letra) {
                skeep.pular();
            } else if ('C' == letra) {
                skeep.correr();
            } else if ('M' == letra) {
                skeep.comer();
            } else if ('A'== letra) {
                skeep.cantar();
            } else if ('S' == letra) {
                skeep.tomarSol();
            } else if ('O' == letra) {
                skeep.ficarNaSombra();
            } else if ('E'== letra) {
                JOptionPane.showMessageDialog(null, "-----Saindo-----");
            } else {
                JOptionPane.showMessageDialog(null, "opção inválida");
            }
        }while(letra !='E');
    }
}
