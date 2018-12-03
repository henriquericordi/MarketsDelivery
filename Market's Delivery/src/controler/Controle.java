/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import dao.DAOControle;
import dao.ProdutoDAO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Carrinho;
import model.Produto;

/**
 *
 * @author Henrique Ricordi
 */
public class Controle {

    //<editor-fold defaultstate="collapsed" desc="SINGLETON">
    private static Controle instance;

    public static Controle getInstance() {
        if (instance == null) {
            instance = new Controle();
        }
        return instance;
    }
    //</editor-fold> 

    private ArrayList<Produto> listaResultado;
    private Carrinho carrinho = new Carrinho();
    private String caminho;

    public boolean alterarProdutos(String caminho) {
        try {
            FileReader arq = new FileReader(caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();
            while (linha != null) {
                String dadosProduto[] = linha.split(";");
                linha = lerArq.readLine();
            }
            arq.close();
            return true;
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
            return false;
        }
}

public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public ArrayList<Produto> buscarProduto(String textoBusca) {
        DAOControle c = new DAOControle();
        return c.buscarProduto(textoBusca);
    }

    public ArrayList<Produto> getListaResultado() {
        return listaResultado;
    }

    public void setListaResultado(ArrayList<Produto> listaResultado) {
        this.listaResultado = listaResultado;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }
}
