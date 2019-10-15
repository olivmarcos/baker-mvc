/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.ProductDao;
import Models.ProductModel;

/**
 *
 * @author marco
 */
public class ProductController {
    
    public void save(String[] dados) {
        ProductModel prod = new ProductModel();
        prod.vetorTo(dados);
        
        ProductDao Dao  = new ProductDao();
        
        if (prod.getId() == 0) {
            Dao.insert(prod);
        } else {
            Dao.update(prod);
        }
    }
    
    public String[] recover(int id) {
        ProductDao Dao = new ProductDao();
        
        ProductModel prod = Dao.recover(id);
        
        return prod.toVetor();
    }
}
