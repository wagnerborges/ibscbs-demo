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
    private boolean semSplit;
    private boolean splitSimplificado;
    private boolean splitInteligente;
    private boolean isento;
    private boolean isentoComIsencao;
    private boolean diferido;
    private boolean presumido;
    private double aliquotaSplitSimplificado;
    private double valorIbsRetidoPorSplitSimplificado;

    public double getValorIbsRetidoPorSplitSimplificado() {
        return valorIbsRetidoPorSplitSimplificado;
    }

    public void setValorIbsRetidoPorSplitSimplificado(double valorIbsRetidoPorSplitSimplificado) {
        this.valorIbsRetidoPorSplitSimplificado = valorIbsRetidoPorSplitSimplificado;
    }

    public double getAliquotaSplitSimplificado() {
        return aliquotaSplitSimplificado;
    }

    public void setAliquotaSplitSimplificado(double aliquotaSplitSimplificado) {
        this.aliquotaSplitSimplificado = aliquotaSplitSimplificado;
    }

    public boolean isSemSplit() {
        return semSplit;
    }

    public void setSemSplit(boolean semSplit) {
        this.semSplit = semSplit;
    }

    public boolean isSplitSimplificado() {
        return splitSimplificado;
    }

    public void setSplitSimplificado(boolean splitSimplificado) {
        this.splitSimplificado = splitSimplificado;
    }

    public boolean isSplitInteligente() {
        return splitInteligente;
    }

    public void setSplitInteligente(boolean splitInteligente) {
        this.splitInteligente = splitInteligente;
    }

    public boolean isIsento() {
        return isento;
    }

    public void setIsento(boolean isento) {
        this.isento = isento;
    }

    public boolean isIsentoComIsencao() {
        return isentoComIsencao;
    }

    public void setIsentoComIsencao(boolean isentoComIsencao) {
        this.isentoComIsencao = isentoComIsencao;
    }

    public boolean isDiferido() {
        return diferido;
    }

    public void setDiferido(boolean diferido) {
        this.diferido = diferido;
    }

    public boolean isPresumido() {
        return presumido;
    }

    public void setPresumido(boolean presumido) {
        this.presumido = presumido;
    }

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
