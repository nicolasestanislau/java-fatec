package aula.alunos;

import javax.swing.*;
import java.util.Scanner;

public class GestaoAlunos {
    int indice = 0;

    Aluno[] alunos = new Aluno[50];

    public void criar(Aluno a) {
        if (indice < 50) {
            this.alunos[indice].nome = a.nome;
            this.alunos[indice].id = a.id;
            this.alunos[indice].nascimento = a.nascimento;
            this.alunos[indice].ra = a.ra;
            indice ++;
        }
    }

    public void atualizar() {

    }

    public void excluir() {

    }

    public void exibir(){

    }

    public static void main(String[] args) {
        GestaoAlunos gestaoAlunos = new GestaoAlunos();
        char letra = 'q';

        do{
            Scanner scan= new Scanner(System.in);
            System.out.println("-----------Menu----------- \nC -Criar- "
                    + "\nE -Exibir- \nR -Remover- \nA -Atualizar- \nS -Sair-  \n" );

            String textoMaiusculo = scan.nextLine().toUpperCase();
            letra = textoMaiusculo.charAt(0);
            if ('C' == letra) {
                Aluno a = new Aluno();
                Scanner myObj = new Scanner(System.in);  // Create a Scanner object
                System.out.println("Enter username");
                a.nome = myObj.nextLine();

                Scanner myObj1 = new Scanner(System.in);  // Create a Scanner object
                System.out.println("Enter id");
                a.id = Long.parseLong(myObj1.nextLine());

                Scanner myObj2 = new Scanner(System.in);  // Create a Scanner object
                System.out.println("Enter data de nascimento");
                a.nascimento = myObj2.nextLine();

                Scanner myObj3 = new Scanner(System.in);  // Create a Scanner object
                System.out.println("Enter ra");
                a.ra = myObj3.nextLine();

                gestaoAlunos.criar(a);
            } else if ('E' == letra) {
                gestaoAlunos.exibir();
            } else if ('R' == letra) {
                gestaoAlunos.excluir();
            } else if ('A'== letra) {
                gestaoAlunos.atualizar();
            } else if ('S'== letra) {
                JOptionPane.showMessageDialog(null, "-----Saindo-----");
            } else {
                JOptionPane.showMessageDialog(null, "opção inválida");
            }
        }while(letra !='S');
    }

}
