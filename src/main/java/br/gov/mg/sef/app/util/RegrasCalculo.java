/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gov.mg.sef.app.util;

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

    public RegrasCalculo(String aliquotaIbs, String aliquotaCbs, String aliquotaIva, String subTotal) {
        this.aliquotaIbs = Double.parseDouble(aliquotaIbs) / 100;
        this.aliquotaCbs = Double.parseDouble(aliquotaCbs) / 100;
        this.aliquotaIva = Double.parseDouble(aliquotaIva) / 100;
        this.subTotal = Double.parseDouble(subTotal);
    }

    public RegrasCalculo calculaImpostoSemReducao() {

        this.valorIbs = aliquotaIbs * subTotal;
        this.valorCbs = aliquotaCbs * subTotal;
        this.valorIva = aliquotaIva * subTotal;

        this.valorTotal = (1 + aliquotaIva) * subTotal;

        return this;
    }
    
    public RegrasCalculo calculaImpostoComReducao(String valorReducao) {

        this.valorIbs = aliquotaIbs * subTotal;
        this.valorCbs = aliquotaCbs * subTotal;
        this.valorIva = aliquotaIva * subTotal;

        this.valorTotal = (1 + aliquotaIva) * subTotal;

        return this;
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
