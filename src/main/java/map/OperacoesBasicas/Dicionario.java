package main.java.map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private Map<String,String> dicionarioMap;

    public Dicionario() {
        this.dicionarioMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao){
        dicionarioMap.put(palavra, definicao);
    }

    public void removerPalavra(String palavra){
        if(!dicionarioMap.isEmpty()){
            if(dicionarioMap.get(palavra) != null){
                dicionarioMap.remove(palavra);
            } else{
                System.out.println("A palavra não está no dicionário.");
            }
        } else{
            System.out.println("Dicionário vazio.");
        }
    }

    public void exibirPalavras(){
        if(!dicionarioMap.isEmpty()){
            System.out.println(dicionarioMap);
        } else{
            System.out.println("Dicionário vazio.");
        }
    }

    public String pesquisaPorPalavra(String palavra){
        String definicao = dicionarioMap.get(palavra);
        if(definicao != null){
            return definicao;
        }
        return "Palavra não encontrada";
    }

    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();

        dicionario.adicionarPalavra("java", "Linguagem de programação orientada a objetos.");
        dicionario.adicionarPalavra("typescript", "Superset da linguagem JavaScript que adiciona tipagem estática.");
        dicionario.adicionarPalavra("kotlin", "Linguagem moderna de programação para a JVM.");

        dicionario.exibirPalavras();

        //Removendo palavra
        dicionario.removerPalavra("Python");
        dicionario.removerPalavra("kotlin");

        dicionario.exibirPalavras();

        //Pesquisa a palavra e retorna sua definição
        System.out.println("Java: " + dicionario.pesquisaPorPalavra("java"));
    }
}
