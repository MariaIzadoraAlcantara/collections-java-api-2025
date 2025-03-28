package main.java.map.OperacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private Map<String, Integer> agendaContatosMap;

    public AgendaContatos() {
        this.agendaContatosMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone){
        this.agendaContatosMap.put(nome,telefone);
    }

    public void removerContato(String nome){
        if(!agendaContatosMap.isEmpty()){
            agendaContatosMap.remove(nome);
        }else{
            System.out.println("A agenda está vazia.");
        }
    }

    public void exibirContatos(){
        if(!agendaContatosMap.isEmpty()){
            System.out.println(agendaContatosMap);
        }else{
            System.out.println("A agenda está vazia.");
        }
    }

    public Integer pesquisarPorNome(String nome){
        Integer numeroPorNome= null;
        if(!agendaContatosMap.isEmpty()){
            numeroPorNome = agendaContatosMap.get(nome);
            if (numeroPorNome == null){
                System.out.println("Este contato não existe.");
            }
        } else{
            System.out.println("A agenda está vazia");
        }
        return numeroPorNome;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.adicionarContato("Iza", 123456);
        agendaContatos.adicionarContato("Madalena", 123455);
        agendaContatos.adicionarContato("Liv", 123123);
        agendaContatos.adicionarContato("Joaquim", 111111);
        agendaContatos.adicionarContato("Jó", 999999);
        agendaContatos.adicionarContato("Iza", 555555); // O map atualiza a key para o ultimo value inserido

        agendaContatos.exibirContatos();

        //Pesquisar por nome
        System.out.println("O número é: " + agendaContatos.pesquisarPorNome("Madalena"));

        //Remover Contato
        agendaContatos.removerContato("Liv");
        agendaContatos.exibirContatos();

        agendaContatos.adicionarContato("Iza", 123);
        agendaContatos.exibirContatos();
    }
}
