/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.ClienteDao;
import Models.ClienteModel;
import java.util.ArrayList;

/**
 *
 * @author marco
 */
public class ClienteController {
     public boolean save(String[] dados) {
        ClienteModel cli = new ClienteModel();
        cli.vetorTo(dados);
        
        ClienteDao Dao  = new ClienteDao();
        
        if (cli.getId() == 0) {
            Dao.insert(cli);
            return true;
        } else {
            Dao.update(cli);
            return false;
        }
    }
    
    public String[] recover(int id) {
        ClienteDao Dao = new ClienteDao();
        
        ClienteModel cli = Dao.recover(id);
        
        return cli.toVetor();
    }
    
    public void update(String[] dados) {
        ClienteModel cli = new ClienteModel();
        cli.vetorTo(dados);
        
        ClienteDao Dao  = new ClienteDao();
        
        if (cli.getId() == 0) {
            Dao.insert(cli);
        } else {
            Dao.update(cli);
        }
    }
    
    public boolean delete(int id) {
        ClienteDao Dao = new ClienteDao();
        if (Dao.delete(id)){
            return true;
        }
        return false;
   
    }
    
    public String[][] recoverAll() {
        ClienteDao Dao = new ClienteDao();
        
        ArrayList<ClienteModel> listProduct = Dao.recoverAll();
        
        String[][] matrizReturn = new String[listProduct.size()][4];
        for (int i = 0; i < listProduct.size(); i++) {
            matrizReturn[i] = listProduct.get(i).toVetor();
        }
        return matrizReturn;
    }
}
