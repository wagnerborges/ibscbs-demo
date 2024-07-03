/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gov.mg.sef.app.model;

/**
 *
 * @author wagner.borges
 */
public class Operacao {

    private double ibs;
    private double cbs;
    private double iva;
    private double aliquotaReducao;
    private double aliquotaCreditoPresumido;
    private String origem;
    private String destino;
    private String chave;
    private String dataOperacao;

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getDataOperacao() {
        return dataOperacao;
    }

    public void setDataOperacao(String dataOperacao) {
        this.dataOperacao = dataOperacao;
    }

    public double getIbs() {
        return ibs;
    }

    public void setIbs(double ibs) {
        this.ibs = ibs;
    }

    public double getCbs() {
        return cbs;
    }

    public void setCbs(double cbs) {
        this.cbs = cbs;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getAliquotaReducao() {
        return aliquotaReducao;
    }

    public void setAliquotaReducao(double aliquotaReducao) {
        this.aliquotaReducao = aliquotaReducao;
    }

    public double getAliquotaCreditoPresumido() {
        return aliquotaCreditoPresumido;
    }

    public void setAliquotaCreditoPresumido(double aliquotaCreditoPresumido) {
        this.aliquotaCreditoPresumido = aliquotaCreditoPresumido;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

}
