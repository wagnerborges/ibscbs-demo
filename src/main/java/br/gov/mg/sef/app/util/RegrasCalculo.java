/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gov.mg.sef.app.util;

import br.gov.mg.sef.app.model.Operacao;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wagner.borges
 */
public class RegrasCalculo {

    private double aliquotaIbs;
    private double aliquotaCbs;
    private double aliquotaIva;
    private double subTotal;
    private double valorIbs;
    private double valorCbs;
    private double valorIva;
    private double valorTotal;
    private double valorRetidoPorSplitSimplificado;
    private List<Vector> listaOperacoesContribuinteA = new ArrayList();
    private List<Vector> listaOperacoesContribuinteB = new ArrayList();

    private List apuracoes = new ArrayList();

    public RegrasCalculo(String aliquotaIbs, String aliquotaCbs, String aliquotaIva, String subTotal) {
        this.aliquotaIbs = Double.parseDouble(aliquotaIbs) / 100;
        this.aliquotaCbs = Double.parseDouble(aliquotaCbs) / 100;
        this.aliquotaIva = Double.parseDouble(aliquotaIva) / 100;
        this.subTotal = Double.parseDouble(subTotal);
    }

    public RegrasCalculo calcularImpostoSemReducao() {

        this.valorIbs = aliquotaIbs * subTotal;
        this.valorCbs = aliquotaCbs * subTotal;
        this.valorIva = aliquotaIva * subTotal;

        this.valorTotal = (1 + aliquotaIva) * subTotal;

        return this;
    }

    public RegrasCalculo calcularImpostoComReducao(double valorReducao) {

        this.aliquotaIbs = this.aliquotaIbs * (1 - (valorReducao / 100));
        this.aliquotaCbs = this.aliquotaCbs * (1 - (valorReducao / 100));
        this.aliquotaIva = this.aliquotaIva * (1 - (valorReducao / 100));

        this.valorIbs = this.aliquotaIbs * subTotal;
        this.valorCbs = this.aliquotaCbs * subTotal;
        this.valorIva = this.aliquotaIva * subTotal;

        this.valorTotal = (1 + aliquotaIva) * subTotal;

        return this;
    }

    public void realizarApuracao(List<Operacao> listaOperacoes) {

        for (Operacao operacao : listaOperacoes) {

            /**
             * Apuração Contribuinte A *
             */
            if (operacao.getOrigem().equals("Contribuinte A") || operacao.getDestino().equals("Contribuinte A")) {
                if (operacao.getOrigem().equals("Contribuinte A") && operacao.getDestino().equals("Contribuinte B")) {
                    Vector linha = new Vector();
                    linha.add(operacao.getDataOperacao());
                    linha.add("-");
                    linha.add(operacao.getIbs());

                    listaOperacoesContribuinteA.add(linha);

                    if (operacao.isSplitInteligente()) {
                        Vector linha2 = new Vector();
                        linha2.add(operacao.getDataOperacao());
                        linha2.add(operacao.getIbs());
                        linha2.add("-");

                        listaOperacoesContribuinteA.add(linha2);
                        listaOperacoesContribuinteB.add(linha2);
                    }
                }

                if (operacao.getDestino().equals("Contribuinte A") && operacao.isSplitInteligente()) {
                    Vector linha = new Vector();
                    linha.add(operacao.getDataOperacao());
                    linha.add(operacao.getIbs());
                    linha.add("-");

                    listaOperacoesContribuinteA.add(linha);

                    Vector linhaB = new Vector();
                    linhaB.add(operacao.getDataOperacao());
                    linhaB.add("-");
                    linhaB.add(operacao.getIbs());
                    listaOperacoesContribuinteB.add(linhaB);

                } else if (operacao.getDestino().equals("Contribuinte A") && !operacao.isSplitInteligente()) {
                    Vector linhaB = new Vector();
                    linhaB.add(operacao.getDataOperacao());
                    linhaB.add("-");
                    linhaB.add(operacao.getIbs());
                    listaOperacoesContribuinteB.add(linhaB);
                }
            }

            if (operacao.getOrigem().equals("Contribuinte B") && operacao.getDestino().equals("Consumidor Final")) {

                if (operacao.isSplitInteligente() || operacao.isSplitSimplificado()) {
                    Vector linhaDebito = new Vector();
                    linhaDebito.add(operacao.getDataOperacao());
                    linhaDebito.add("-");
                    linhaDebito.add(operacao.getIbs());
                    listaOperacoesContribuinteB.add(linhaDebito);

                    Vector linhaCredito = new Vector();
                    linhaCredito.add(operacao.getDataOperacao());
                    linhaCredito.add(operacao.isSplitSimplificado() ? operacao.getValorIbsRetidoPorSplitSimplificado() : operacao.getIbs());
                    linhaCredito.add("-");
                    listaOperacoesContribuinteB.add(linhaCredito);

                } else {
                    Vector linhaDebito = new Vector();
                    linhaDebito.add(operacao.getDataOperacao());
                    linhaDebito.add("-");
                    linhaDebito.add(operacao.getIbs());
                    listaOperacoesContribuinteB.add(linhaDebito);
                }
            }
        }
    }

    public double calcularSaldoPeriodo(DefaultTableModel model) {

        double somaCredito = 0;
        double somaDebito = 0;

        for (int i = 0; i < model.getRowCount() - 1; i++) {
            String strCredito = (String) model.getValueAt(i, 1).toString();
            String strDebito = (String) model.getValueAt(i, 2).toString();

            double credito = strCredito.equals("-") ? 0 : Double.parseDouble(strCredito);
            double debito = strDebito.equals("-") ? 0 : Double.parseDouble(strDebito);

            somaCredito = somaCredito + credito;
            somaDebito = somaDebito + debito;
        }
        return somaDebito - somaCredito;
    }

    public double calcularRetencaoComSplitSimplificado(double aliquotaSplitSimplificado) {

        this.valorRetidoPorSplitSimplificado = (aliquotaSplitSimplificado / 100) * this.valorIbs;

        return this.valorRetidoPorSplitSimplificado;
    }

    public List<Vector> getListaOperacoesContribuinteA() {
        return listaOperacoesContribuinteA;
    }

    public void setListaOperacoesContribuinteA(List listaOperacoesContribuinteA) {
        this.listaOperacoesContribuinteA = listaOperacoesContribuinteA;
    }

    public List<Vector> getListaOperacoesContribuinteB() {
        return listaOperacoesContribuinteB;
    }

    public void setListaOperacoesContribuinteB(List listaOperacoesContribuinteB) {
        this.listaOperacoesContribuinteB = listaOperacoesContribuinteB;
    }

    public List getApuracoes() {
        return apuracoes;
    }

    public void setApuracoes(List apuracoes) {
        this.apuracoes = apuracoes;
    }

    public double getValorRetidoPorSplitSimplificado() {
        return valorRetidoPorSplitSimplificado;
    }

    public void setValorRetidoPorSplitSimplificado(double valorRetidoPorSplitSimplificado) {
        this.valorRetidoPorSplitSimplificado = valorRetidoPorSplitSimplificado;
    }

    public double getAliquotaIbs() {
        return aliquotaIbs;
    }

    public void setAliquotaIbs(double aliquotaIbs) {
        this.aliquotaIbs = aliquotaIbs;
    }

    public double getAliquotaCbs() {
        return aliquotaCbs;
    }

    public void setAliquotaCbs(double aliquotaCbs) {
        this.aliquotaCbs = aliquotaCbs;
    }

    public double getAliquotaIva() {
        return aliquotaIva;
    }

    public void setAliquotaIva(double aliquotaIva) {
        this.aliquotaIva = aliquotaIva;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getValorIbs() {
        return valorIbs;
    }

    public void setValorIbs(double valorIbs) {
        this.valorIbs = valorIbs;
    }

    public double getValorCbs() {
        return valorCbs;
    }

    public void setValorCbs(double valorCbs) {
        this.valorCbs = valorCbs;
    }

    public double getValorIva() {
        return valorIva;
    }

    public void setValorIva(double valorIva) {
        this.valorIva = valorIva;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

}
