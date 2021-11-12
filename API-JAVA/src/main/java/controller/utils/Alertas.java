/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.utils;

/**
 *
 * @author Gabriel_Prisco
 */
public enum Alertas {
    ALERTA_PROCESSADOR("A m�quina %d localizada na esta��o %s atingiu %.1f% de processamento."),
    ALERTA_MEMORIA("A m�quina %d localizada na esta��o %s atingiu %.1f% de armazenamento interno."),
    ALERTA_RAM("A m�quina %d localizada na esta��o %s atingiu %.1f% de uso de M�moria RAM.");
    
    private String alertas;

    private Alertas(String alertas) {
        this.alertas = alertas;  
    }

    public String getAlertas() {
        return alertas;
    }
}