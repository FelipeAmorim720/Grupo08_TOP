/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.utils;

/*
A m�quina id_maquina localizada na esta��o nome_estacao ultrapassou o percentual de processamento atingindo  percent_use.
A m�quina id_maquina localizada na esta��o nome_estacao  ultrapassou o percentual de armazenamento interno atingindo  percent_use. 
A m�quina id_maquina localizada na esta��o nome_estacao ultrapassou o percentual de uso de M�moria RAM atingindo  percent_use.
*/

/**
 *
 * @author Gabriel_Prisco
 */
public enum Alertas {
    ALERTA_PADRAO_MEMORIA(":disk: A m�quina %s localizada na esta��o %s atingiu %.1f%% de armazenamento interno."),
    ALERTA_CRITICO_MEMORIA(":disk: A m�quina %s localizada na esta��o %s ultrapassou o percentual de armazenamento interno, atingindo %.1f%%"),
    ALERTA_PADRAO_RAM(":memory: A m�quina %s localizada na esta��o %s atingiu %.1f%% de uso de Mem�ria RAM."),
    ALERTA_CRITICO_RAM(":memory: A m�quina %s localizada na esta��o %s ultrapassou o percentual de uso de Mem�ria RAM, atingindo %.1f%%"),
    ALERTA_PADRAO_PROCESSADOR(":cpu: A m�quina %s localizada na esta��o %s atingiu %.1f%% de processamento."),
    ALERTA_CRITICO_PROCESSADOR(":cpu: A m�quina %s localizada na esta��o %s ultrapassou o percentual de processamento, atingindo %.1f%%"),
    ALERTA_FALTA_PAPEL(":no-paper: O estoque de papel da m�quina %s localizada na esta��o %s chegou ao fim");

    private String alertas;

    private Alertas(String alertas) {
        this.alertas = alertas;  
    }

    public String getAlertas() {
        return alertas;
    }
}
