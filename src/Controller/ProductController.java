/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.ProductDao;
import Models.ProductModel;
import java.util.ArrayList;

/**
 *
 * @author marco
 */
public class ProductController {
    
    public boolean save(String[] dados) {
        ProductModel prod = new ProductModel();
        prod.vetorTo(dados);
        
        ProductDao Dao  = new ProductDao();
        
        if (prod.getId() == 0) {
            Dao.insert(prod);
            return true;
        } else {
            Dao.update(prod);
            return false;
        }
    }
    
    public String[] recover(int id) {
        ProductDao Dao = new ProductDao();
        
        ProductModel prod = Dao.recover(id);
        
        return prod.toVetor();
    }
    
    public void update(String[] dados) {
        ProductModel prod = new ProductModel();
        prod.vetorTo(dados);
        
        ProductDao Dao  = new ProductDao();
        
        if (prod.getId() == 0) {
            Dao.insert(prod);
        } else {
            Dao.update(prod);
        }
    }
    
    public boolean delete(int id) {
        ProductDao Dao = new ProductDao();
        if (Dao.delete(id)){
            return true;
        }
        return false;
   
    }
    
    public String[][] recoverAll() {
        ProductDao Dao = new ProductDao();
        
        ArrayList<ProductModel> listProduct = Dao.recoverAll();
        
        String[][] matrizReturn = new String[listProduct.size()][4];
        for (int i = 0; i < listProduct.size(); i++) {
            matrizReturn[i] = listProduct.get(i).toVetor();
        }
        return matrizReturn;
    }
}
