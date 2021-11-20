package controller;

import Models.DataBaseModel;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

public class ViewController {

    private final DataBaseModel db = new DataBaseModel();
    private final LoocaController looca = new LoocaController();
    private final SlackController s = new SlackController();

    public Boolean verifyUserAndMachine(String login, String senha, String fkMaquina) throws IOException {
        String query = String.format("select email,senha,fk_estacao from [dbo].[usuario] where email ='%s' and senha = '%s';", login, senha);
        Map map = db.makeSelectQuery(query);
        Integer fkmaquinaInt = 0;
        try {
            fkmaquinaInt = Integer.valueOf(fkMaquina);
            s.setFkMaquina(fkmaquinaInt);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Insira apenas n�meros no id da maquina");
        }
        if (map.isEmpty()) {
            return false;
        } else {
            Boolean checked = checkFkMaquina(fkmaquinaInt);
            if (checked) {
                letterToPython(String.format("%d", fkmaquinaInt)); 
                return true;
            } else {
                return false;
            }

        }
    }

    public Boolean checkFkMaquina(int fkMaquina) {
        String query = String.format("select * from maquina where id_maquina = %d", fkMaquina);
        Map map = db.makeSelectQuery(query);
        if (map.isEmpty()) {
            return false;
        } else {
            return true;
        }

    }

    public void letterToPython(String id)
            throws IOException {
        FileWriter file = new FileWriter("../SCREEN-READER-LINUX/dist/machine.ini");
        PrintWriter writer = new PrintWriter(file);
        writer.print("[machine_config]");
        writer.println("");
        writer.printf("machine_id = %s", id);
        writer.close();
    }
    
    public void openPython () throws IOException{
        String[] args = new String[] {"/bin/bash", "-c", "your_command"};
        Process proc = new ProcessBuilder(args).start();
    }

    public void start() {
        looca.setSlack(s);
        looca.insertInSeconds(5);
        looca.alertInMinutes();

    }

    public void init() {
        db.initializer();
    }

    public boolean calibratePc(Boolean requested, String fkMaquina) {
        Integer fkInt = 0;
        fkInt = Integer.valueOf(fkMaquina);
        looca.setFkMaquina(fkInt);

        if (!requested) {
            System.out.println("verificando se o pc j� foi checado alguma vez");

            String response = db.makeCalibrateSelect(fkMaquina);
            if (response.equals("0") || response.equals("1")) {
                looca.setStaticPcInfo();
                return true;
            } else if (response.equals("")) {
                return false;

            } else {
                looca.setStaticPcInfo();
                return true;
            }
        }
        return false;

    }

}
