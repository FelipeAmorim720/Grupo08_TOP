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
    ALERTA_PADRAO_PROCESSADOR("A m�quina %d localizada na esta��o %s atingiu %.1f% de processamento."),
    ALERTA_PADRAO_MEMORIA("A m�quina %d localizada na esta��o %s atingiu %.1f% de armazenamento interno."),
    ALERTA_PADRAO_RAM("A m�quina %d localizada na esta��o %s atingiu %.1f% de uso de M�moria RAM.");
    
    private String alertas;

    private Alertas(String alertas) {
        this.alertas = alertas;  
    }

    public String getAlertas() {
        return alertas;
    }
}

/*
A m�quina id_maquina localizada na esta��o nome_estacao ultrapassou o percentual de processamento atingindo  percent_use.
A m�quina id_maquina localizada na esta��o nome_estacao  ultrapassou o percentual de armazenamento interno atingindo  percent_use. 
A m�quina id_maquina localizada na esta��o nome_estacao ultrapassou o percentual de uso de M�moria RAM atingindo  percent_use.
*/