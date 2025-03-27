package main.java.set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {
    private Set<Produto> produtoSet;

    public CadastroProdutos() {
        this.produtoSet = new HashSet<>();
    }

    public void adicionarProduto(long codigo, String nome, double preco, int quantidade){
        this.produtoSet.add(new Produto(nome, codigo, preco, quantidade));
    }

    public Set<Produto> exibirProdutosPorNome(){
        Set<Produto> produtosPorNome = new TreeSet<>(produtoSet);
        if (!produtoSet.isEmpty()){
        return produtosPorNome;
        }else{
            throw new RuntimeException("A lista está vazia.");
        }
    }

    public Set<Produto> exibirProdutosPorPreco(){
        Set<Produto> produtosPorPreco = new TreeSet<>( new ComparatorPorPreco());
        if(!produtoSet.isEmpty()){
        produtosPorPreco.addAll(produtoSet);
        return produtosPorPreco;
        }else{
            throw new RuntimeException("A lista está vazia.");
        }
    }

    public void removerProduto(String nome){
        Produto produtoRemover = null;
        if(!produtoSet.isEmpty()){
            for (Produto p : produtoSet){
                if(p.getNome().equalsIgnoreCase(nome)){
                    produtoRemover = p;
                    break;
                }
            }
            produtoSet.remove(produtoRemover);
        } else{
            throw new RuntimeException("A lista está vazia.");
        }
    }

    public static void main(String[] args) {
        CadastroProdutos cadastroProdutos = new CadastroProdutos();

        cadastroProdutos.adicionarProduto(1L, "Computador", 1500d, 10);
        cadastroProdutos.adicionarProduto(2L, "WebCam", 25.99d, 30);
        cadastroProdutos.adicionarProduto(4L, "Mouse", 30d, 100);
        cadastroProdutos.adicionarProduto(1L, "Teclado", 60d, 30);

        //Exibir todos os produtos no cadastro
        System.out.println(cadastroProdutos.produtoSet);

        //Exibir produtos ordenados por nome
        System.out.println(cadastroProdutos.exibirProdutosPorNome());

        //Exibir produtos por preco
        System.out.println(cadastroProdutos.exibirProdutosPorPreco());

        //Removendo um produto
        cadastroProdutos.removerProduto("Mouse");
        System.out.println(cadastroProdutos.produtoSet);
    }
}
