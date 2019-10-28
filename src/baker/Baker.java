/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baker;

import Controller.ProductController;
import Dao.FabricaConexao;
import Dao.ProductDao;
import Models.ProductModel;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author marco
 */
public class Baker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String dados[] = new String[4];
        
        dados[0] = "4";
        dados[1] = "Teste22342";
        dados[2] = "0.02";
        dados[3] = "testando";
  
        
        ProductController controll = new ProductController();
        
        //controll.save(dados);
        

        String[][] products = controll.recoverAll();
        for (int i = 0; i < products.length; i++) {
            System.out.println("" + products[i][0]);
        }
//        controll.update(dados);
//    
//        dados = controll.recover(4);  
//        controll.delete(5);
//        
       /* ProductDao teste = new ProductDao();
        
        teste.recoverAll();
        
        for (ProductModel pr : teste.recoverAll()){
            System.out.println("Teste" + pr.getName());
        }*/
        
    }
    
}
