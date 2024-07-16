/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gov.mg.sef.app.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author wagner.borges
 */
public class Produto {

    private int codigo;
    private String descricao;
    private double valor;
    private boolean diferido;
    private boolean reducaoAliquota;
    private boolean cestaBasica;

    private static List<Produto> listaProduto = new ArrayList<>();

    public Produto(int codigo, String descricao, double valor) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor = valor;
    }

    public static Produto getProduto(int codigo) {
        
        carregaProdutos();

        for (Produto produto : getListaProduto()) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }

    private static void carregaProdutos() {
        getListaProduto().add(new Produto(1001, "Camisa do Flamengo", 450));
        getListaProduto().add(new Produto(1002, "Tênis do Flamengo", 550));
        getListaProduto().add(new Produto(1003, "Bone do Flamengo", 750));
        getListaProduto().add(new Produto(1004, "Relógio do Flamengo", 250));
        getListaProduto().add(new Produto(1005, "Calça do Flamengo", 450));
        getListaProduto().add(new Produto(1005, "Toalha do Flamengo", 650));
        getListaProduto().add(new Produto(1006, "Mesa do Flamengo", 450));
        getListaProduto().add(new Produto(1007, "Teclado do Flamengo", 550));
        getListaProduto().add(new Produto(1008, "Cerveja do Flamengo", 250));
        getListaProduto().add(new Produto(1009, "Gasolina do Flamengo", 750));
        
        getListaProduto().add(new Produto(1010, "Bola do Flamengo", 350));
        getListaProduto().add(new Produto(1011, "Bola do Flamengo", 650));
        
        getListaProduto().add(new Produto(2001, "Bola de Futebol", 300));
        getListaProduto().add(new Produto(2002, "Bola de Futebol", 500));
        
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the diferido
     */
    public boolean isDiferido() {
        return diferido;
    }

    /**
     * @param diferido the diferido to set
     */
    public void setDiferido(boolean diferido) {
        this.diferido = diferido;
    }

    /**
     * @return the reducaoAliquota
     */
    public boolean isReducaoAliquota() {
        return reducaoAliquota;
    }

    /**
     * @param reducaoAliquota the reducaoAliquota to set
     */
    public void setReducaoAliquota(boolean reducaoAliquota) {
        this.reducaoAliquota = reducaoAliquota;
    }

    /**
     * @return the cestaBasica
     */
    public boolean isCestaBasica() {
        return cestaBasica;
    }

    /**
     * @param cestaBasica the cestaBasica to set
     */
    public void setCestaBasica(boolean cestaBasica) {
        this.cestaBasica = cestaBasica;
    }

    /**
     * @return the listaProduto
     */
    public static List<Produto> getListaProduto() {
        return listaProduto;
    }

    /**
     * @param aListaProduto the listaProduto to set
     */
    public static void setListaProduto(List<Produto> aListaProduto) {
        listaProduto = aListaProduto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.codigo;
        hash = 67 * hash + Objects.hashCode(this.descricao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return Objects.equals(this.descricao, other.descricao);
    }

    @Override
    public String toString() {
        return descricao;
    }

    
    
}
