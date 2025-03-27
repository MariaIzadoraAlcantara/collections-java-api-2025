package main.java.set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> tarefaSet;

    public ListaTarefas() {
        this.tarefaSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao){
        this.tarefaSet.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        Tarefa tarefaRemover = null;
        if (!tarefaSet.isEmpty()) {
            for (Tarefa t : tarefaSet) {
                if (t.getDescricao().equalsIgnoreCase(descricao)) {
                    tarefaRemover = t;
                    break;
                }
            }
            tarefaSet.remove(tarefaRemover);
        } else {
            throw new RuntimeException("A lista está vazia.");
        }
    }

    public void exibirTarefas(){
        if(!tarefaSet.isEmpty()){
            System.out.println(tarefaSet);
        } else{
            System.out.println("A lista está vazia.");
        }
    }

    public int contarTarefas(){
        if(!tarefaSet.isEmpty()){
           return tarefaSet.size();
        }else{
            throw new RuntimeException("A lista está vazia.");
        }
    }

    public Set<Tarefa> obterTarefasConcluidas(){
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        if(!tarefaSet.isEmpty()){
            for(Tarefa t : tarefaSet){
                if(t.isConcluida()){
                    tarefasConcluidas.add(t);
                }
            }
            return tarefasConcluidas;
        } else {
            throw new RuntimeException("A lista está vazia.");
        }
    }

    public Set<Tarefa> obterTarefasPendentes(){
        Set<Tarefa> tarefasPendentes = new HashSet<>();
        if(!tarefaSet.isEmpty()){
            for(Tarefa t : tarefaSet){
                if(!t.isConcluida()){
                    tarefasPendentes.add(t);
                }
            }
            return tarefasPendentes;
        } else {
            throw new RuntimeException("A lista está vazia.");
        }
    }

    public void marcarTarefaConcluida(String descricao){
            for(Tarefa t :tarefaSet){
                if(t.getDescricao().equalsIgnoreCase(descricao)){
                    t.setConcluida(true);
                }
            }
    }

    public void marcarTarefaPendente(String descricao){
        Tarefa tarefaPendente = null;
        for(Tarefa t : tarefaSet){
            if(t.getDescricao().equalsIgnoreCase(descricao)){
                tarefaPendente = t;
                break;
            }
        }

        if(tarefaPendente != null){
            if(tarefaPendente.isConcluida()){
                tarefaPendente.setConcluida(false);
            }
        } else {
            System.out.println("Tarefa não encontrada.");
        }
    }

    public void limparListaTarefas(){
        if(tarefaSet.isEmpty()){
            System.out.println("A lista já está vazia.");
        } else{
            tarefaSet.clear();
        }
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();

        listaTarefas.exibirTarefas();

        listaTarefas.adicionarTarefa("Estudar Java");
        listaTarefas.adicionarTarefa("Fazer exercícios");
        listaTarefas.adicionarTarefa("Tomar café");
        listaTarefas.adicionarTarefa("Ler livro");
        listaTarefas.adicionarTarefa("Dormir");

        listaTarefas.exibirTarefas();

        //Quantidade de tarefas na lista
        System.out.println("Total de tarefas na lista " + listaTarefas.contarTarefas());

        //Remover uma tarefa
        listaTarefas.removerTarefa("Ler livro");
        listaTarefas.exibirTarefas();

        //Quantidade de tarefas na lista
        System.out.println("Total de tarefas na lista " + listaTarefas.contarTarefas());

        //Obtendo tarefas pendentes
        System.out.println(listaTarefas.obterTarefasPendentes());

        //Marcando tarefas concluídas
        listaTarefas.marcarTarefaConcluida("Tomar café");
        listaTarefas.marcarTarefaConcluida("Estudar Java");

        //Obtendo tarefas concluídas
        System.out.println("Tarefas concluídas" + listaTarefas.obterTarefasConcluidas());

        //Marcando tarefas como pendente
        listaTarefas.marcarTarefaPendente("Estudar Java");
        listaTarefas.exibirTarefas();

        //Limpando lista de tarefas
        listaTarefas.limparListaTarefas();
        listaTarefas.exibirTarefas();



    }


}
