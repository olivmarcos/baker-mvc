/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baker;

import Controller.ProductController;
import Dao.FabricaConexao;
import java.sql.Connection;

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
        
        dados[0] = "0";
        dados[1] = "Pão";
        dados[2] = "0.40";
        dados[3] = "und";
        
        ProductController controll = new ProductController();
        
        controll.save(dados);

    }
    
}
