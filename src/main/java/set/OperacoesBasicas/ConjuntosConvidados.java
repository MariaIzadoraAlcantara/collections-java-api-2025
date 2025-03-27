package main.java.set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntosConvidados {

    private Set<Convidado> convidadoSet;

    public ConjuntosConvidados() {
        this.convidadoSet = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoConvite){
        this.convidadoSet.add(new Convidado(nome, codigoConvite));
    }

    public void removerConvidadoPorCodigoCovite(int codigoCovite){
        Convidado convidadoParaRemover = null;
        if(!convidadoSet.isEmpty()){
            for (Convidado c : convidadoSet){
                if(c.getCodigoConvite() == codigoCovite){
                    convidadoParaRemover = c;
                    break;
                }
            }
            convidadoSet.remove(convidadoParaRemover);
        } else {
            throw new RuntimeException("O conjuto está vazio.");
        }
    }

    public int contarConvidados(){
        return convidadoSet.size();
    }

    public void exibirConvidados(){
        if(!convidadoSet.isEmpty()){
            System.out.println(convidadoSet);
        } else {
            throw new RuntimeException("o conjuto está vazio.");
        }
    }

    public static void main(String[] args) {
        ConjuntosConvidados conjuntoConvidados = new ConjuntosConvidados();

        // Exibindo o número de convidados no conjunto (deve ser zero)
        System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidado(s) dentro do Set de Convidados");

        conjuntoConvidados.adicionarConvidado("Izadora", 1234);
        conjuntoConvidados.adicionarConvidado("Joaquim", 1235);
        conjuntoConvidados.adicionarConvidado("João", 1235);
        conjuntoConvidados.adicionarConvidado("Alice", 1236);

        // Exibindo o número de convidados no conjunto (deve ser zero)
        System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidado(s) dentro do Set de Convidados");

        System.out.println("Convidados no conjunto: ");
        conjuntoConvidados.exibirConvidados();

        conjuntoConvidados.removerConvidadoPorCodigoCovite(1234);
        // Exibindo o número de convidados no conjunto (deve ser zero)
        System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidado(s) dentro do Set de Convidados");

        System.out.println("Convidados no conjunto após remoção: ");
        conjuntoConvidados.exibirConvidados();

    }
}
