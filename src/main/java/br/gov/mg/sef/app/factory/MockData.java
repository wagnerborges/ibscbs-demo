/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gov.mg.sef.app.factory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wagner.borges
 */
public class MockData {
    
    private static List<String> dadosEstados = new ArrayList<>();

    public static List<String> getMockData() {
        
        dadosEstados.add("SP");
        dadosEstados.add("MG");        
        
        return dadosEstados;
    }  
    
    public void getProdutos() {
        
    }
}
