package edu.curso.observer;

public class MundoReal {
    public static void main(String[] agrs) {
        Jornal estadao = new Jornal("Estatadão");
        Jornal globo = new Jornal("O Globo");


        Economista joao = new Economista("João");
        Economista maria = new Economista("Maria");
        Assinante alfredo = new Economista("Alfredo");
        Aposentado irineu = new Aposentado();


        estadao.adicionar(joao);
        globo.adicionar(maria);
        estadao.adicionar(alfredo);
        globo.adicionar(alfredo);
        globo.remover(alfredo);
        estadao.adicionar(irineu);

        estadao.publicarNoticia("Projetos sugeridos pela CPI da Covid estao parados ha ate 3 anos no Congresso");
        globo.publicarNoticia("Bolsonaro chega ao Ministério da Economia para reunião com Guedes, em meio a desgaste com teto de gastos");
    }
}
