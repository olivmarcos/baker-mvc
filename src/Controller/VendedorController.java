/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.VendedorDao;
import Models.VendedorModel;
import java.util.ArrayList;

/**
 *
 * @author marco
 */
public class VendedorController {
        
    public boolean save(String[] dados) {
        VendedorModel vend = new VendedorModel();
        vend.vetorTo(dados);
        
        VendedorDao Dao  = new VendedorDao();
        
        if (vend.getId() == 0) {
            Dao.insert(vend);
            return true;
        } else {
            Dao.update(vend);
            return false;
        }
    }
    
    public String[] recover(int id) {
        VendedorDao Dao = new VendedorDao();
        
        VendedorModel vend = Dao.recover(id);
        
        return vend.toVetor();
    }
    
    public void update(String[] dados) {
        VendedorModel vend = new VendedorModel();
        vend.vetorTo(dados);
        
        VendedorDao Dao  = new VendedorDao();
        
        if (vend.getId() == 0) {
            Dao.insert(vend);
        } else {
            Dao.update(vend);
        }
    }
    
    public boolean delete(int id) {
        VendedorDao Dao = new VendedorDao();
        if (Dao.delete(id)){
            return true;
        }
        return false;
   
    }
    
    public String[][] recoverAll() {
        VendedorDao Dao = new VendedorDao();
        
        ArrayList<VendedorModel> listProduct = Dao.recoverAll();
        
        String[][] matrizReturn = new String[listProduct.size()][4];
        for (int i = 0; i < listProduct.size(); i++) {
            matrizReturn[i] = listProduct.get(i).toVetor();
        }
        return matrizReturn;
    }
}
