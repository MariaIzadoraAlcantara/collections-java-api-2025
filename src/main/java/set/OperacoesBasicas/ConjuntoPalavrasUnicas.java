package main.java.set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> palavraUnicaSet;

    public ConjuntoPalavrasUnicas() {
        this.palavraUnicaSet = new HashSet<>();
    }

    public void adicionarPalavra(String palavra){
        this.palavraUnicaSet.add(palavra);
    }

    public void removerPalavra(String palavra){
        if(!palavraUnicaSet.isEmpty()){
            if(palavraUnicaSet.contains(palavra)){
                palavraUnicaSet.remove(palavra);
            }else{
                System.out.println("Palavra não encontrada no conjunto.");
            }
        } else{
            throw new RuntimeException("O conjunto está vazio.");
        }
    }

    public boolean verificarPalavra(String palavra){
        return palavraUnicaSet.contains(palavra);
    }

    public void exibirPalavrasUnicas(){
        if(!palavraUnicaSet.isEmpty()){
            System.out.println(palavraUnicaSet);
        } else{
            throw new RuntimeException("O conjuntos está vazio.");
        }
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas conjuntoLinguagens = new ConjuntoPalavrasUnicas();

        conjuntoLinguagens.adicionarPalavra("Java");
        conjuntoLinguagens.adicionarPalavra("JavaScript");
        conjuntoLinguagens.adicionarPalavra("Python");
        conjuntoLinguagens.adicionarPalavra("C++");
        conjuntoLinguagens.adicionarPalavra("Python");

        conjuntoLinguagens.exibirPalavrasUnicas();

        //Removendo uma linguagem
        conjuntoLinguagens.removerPalavra("Python");
        conjuntoLinguagens.exibirPalavrasUnicas();

        //Removendo uma linguagem inexistente
        conjuntoLinguagens.removerPalavra("Go");

        // Verificando se uma linguagem está no conjunto
        System.out.println("A linguagem 'Java' está no conjunto? " + conjuntoLinguagens.verificarPalavra("Java"));
        System.out.println("A linguagem 'Python' está no conjunto? " + conjuntoLinguagens.verificarPalavra("Python"));
    }

}
