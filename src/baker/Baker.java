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
        dados[1] = "Teste";
        dados[2] = "0.00";
        dados[3] = "tst";
        
        ProductController controll = new ProductController();
        
//        controll.save(dados);

        dados = controll.recover(3);
        System.out.println("Retorno do recuperar " +  dados[0]);
        System.out.println("Fim");
    }
    
}
