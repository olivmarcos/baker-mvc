/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baker;

import Controller.ProductController;
import Dao.FabricaConexao;
import Dao.ProductDao;
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
        dados[1] = "Teste2";
        dados[2] = "0.02";
        dados[3] = "testando";
        
        ProductController controll = new ProductController();
        
//        controll.save(dados);

        controll.update(dados);
    
        dados = controll.recover(4);
        controll.delete(5);
        
        System.out.println("Retorno do recuperar " +  dados[0] + ": Nome: " + dados[1] + ", Preço: " + dados[2] + ", Unidade: " + dados[3]);
        System.out.println("Fim");
        
    }
    
}
