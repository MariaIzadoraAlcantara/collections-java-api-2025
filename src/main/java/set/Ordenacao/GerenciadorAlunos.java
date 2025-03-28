package main.java.set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Aluno> alunoSet;

    public GerenciadorAlunos() {
        this.alunoSet = new HashSet<>();
    }

    public void adicionarAluno(String nome, long matricula, double media){
        this.alunoSet.add(new Aluno(nome, matricula, media));
    }

    public String removerAluno(long matricula) {
        if(alunoSet.isEmpty()){
            throw new RuntimeException("A lista está vazia.");
        }
        Aluno alunoParaRemover = null;
        for(Aluno a : alunoSet){
            if(a.getMatricula() == matricula){
                alunoParaRemover = a;
                break;
            }
        }
        if(alunoParaRemover == null){
            throw new RuntimeException("Matrícula " + matricula + " não encontrada.");
        }
        alunoSet.remove(alunoParaRemover);
        return alunoParaRemover.getNome();
    }

    public void exibirAlunosPorNome(){
        Set<Aluno> alunosPorNome = new TreeSet<>(alunoSet);
        if(!alunoSet.isEmpty()){
            System.out.println(alunosPorNome);
        }else{
            throw new RuntimeException("A lista está vazia.");
        }
    }

    public void exibirAlunosPorNota(){
        Set<Aluno> alunosPorNota = new TreeSet<>(new ComparatorPorNotas());
        if(!alunoSet.isEmpty()){
            alunosPorNota.addAll(alunoSet);
            System.out.println(alunosPorNota);
        } else {
            throw new RuntimeException("A lista está vazia.");
        }
    }

    public void exibirAlunos(){
        if(!alunoSet.isEmpty()){
            System.out.println(alunoSet);
        } else {
            System.out.println("A lista está vazia.");
        }
    }

    public static void main(String[] args) {
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        gerenciadorAlunos.exibirAlunos();

        gerenciadorAlunos.adicionarAluno("Iza", 12345L, 10);
        gerenciadorAlunos.adicionarAluno("Madalena", 12346L, 8.5);
        gerenciadorAlunos.adicionarAluno("Liv", 12347L, 7);
        gerenciadorAlunos.adicionarAluno("Joaquim", 12349L, 5);
        gerenciadorAlunos.adicionarAluno("Jó", 12348L, 9.5);

        gerenciadorAlunos.exibirAlunos();

        //Exibir alunos por nome
        gerenciadorAlunos.exibirAlunosPorNome();

        //Exibir alunos por nota
        gerenciadorAlunos.exibirAlunosPorNota();

        //Removendo aluno
        String aluno = gerenciadorAlunos.removerAluno(12349L);
        System.out.println("Aluno removido " + aluno);
        gerenciadorAlunos.exibirAlunos();
    }
}
