package main.java.set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    private Set<Contato> contatoSet;

    public AgendaContatos() {
        this.contatoSet = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero){
        this.contatoSet.add(new Contato(nome, numero));
    }

    public void exibirContatos(){
        if(!contatoSet.isEmpty()){
            System.out.println(contatoSet);
        } else{
            System.out.println("A agenda está vazia.");
        }
    }

    public Set<Contato> pesquisarPorNome(String nome){
        Set<Contato> contatoPorNome = new HashSet<>();
        if(!contatoSet.isEmpty()){
            for(Contato c : contatoSet){
                if(c.getNome().startsWith(nome)){
                    contatoPorNome.add(c);
                }
            } return contatoPorNome;
        } else {
            throw new RuntimeException("A agenda está vazia.");
        }
    }

    public Contato atualizarNumero(String nome, int numero){
        Contato contatoAtualizado = null;
        if(!contatoSet.isEmpty()){
            for (Contato c : contatoSet){
                if(c.getNome().equalsIgnoreCase(nome)){
                    c.setNumero(numero);
                    contatoAtualizado = c;
                    break;
                }
            }
            return contatoAtualizado;
        } else{
            throw new RuntimeException("A agenda está vazia.");
        }
    }

    public void removerContato(String nome){
        Contato contatoRemover = null;
        if(!contatoSet.isEmpty()){
            for(Contato c : contatoSet){
                if(c.getNome().equalsIgnoreCase(nome)){
                    contatoRemover = c;
                    break;
                }
            }
            contatoSet.remove(contatoRemover);
        } else{
            throw new RuntimeException("A agenda está vazia.");
        }
    }


    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.exibirContatos();

        agendaContatos.adicionarContato("Izadora", 1234);
        agendaContatos.adicionarContato("Izadora 2", 5555);
        agendaContatos.adicionarContato("João", 1111);
        agendaContatos.adicionarContato("Fernanda", 2222);
        agendaContatos.adicionarContato("Joaquim", 2222);

        agendaContatos.exibirContatos();

        //Pesquisar por Nome
        System.out.println(agendaContatos.pesquisarPorNome("Izadora"));

        //Atualizar numero
        Contato contatoAtualizado = agendaContatos.atualizarNumero("Joaquim", 3333);
        System.out.println("Contato atualizado: " + contatoAtualizado);

        System.out.println("Agenda após a atualização");
        agendaContatos.exibirContatos();

        //Remover contato
        agendaContatos.removerContato("Izadora");
        System.out.println("Após remover contato");
        agendaContatos.exibirContatos();





    }
}
