/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baker;

import Controller.ClienteController;
import Controller.ProductController;
import Controller.VendedorController;
import Dao.ClienteDao;
import Dao.FabricaConexao;
import Dao.ProductDao;
import Dao.VendedorDao;
import Models.ClienteModel;
import Models.ProductModel;
import Models.VendedorModel;
import Views.ClienteView;
import Views.Home;
import Views.ProductTableView;
import Views.ProductView;
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
//         String dados[] = new String[4];
//        
//        dados[0] = "0";
//        dados[1] = "Teste22342";
//        dados[2] = "Rua Teste";
//        dados[3] = "122544";
//  
//        
       // VendedorController controll = new VendedorController();
//
//        controll.save(dados);
       /*  String[][] products = controll.recoverAll();
        for (int i = 0; i < products.length; i++) {
            System.out.println("" + products[i][0]);
        }*/
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
//        ProductView tela = new ProductView();
//        tela.setVisible(true);
//        VendedorDao teste = new VendedorDao();
//        VendedorModel me = new VendedorModel();
//        
//        me.setName("marcos");
//        me.setEmpresa("empresa");
//        me.setCpf(1235478);
//        
//        if(teste.insert(me))
//        {
//            System.out.println("ok");
//        }
//        else
//            System.out.println("Not ok");
//        VendedorController controll = new VendedorController();
//        
//        if(controll.delete(1))
//        {
//            System.out.println("ok");
//        }
//        else
//            System.out.println("not ok");
//        
//        ClienteDao teste = new ClienteDao();
//        ClienteModel me = new ClienteModel();
//        
//        me.setName("marcos");
//        me.setEndereco("Rua Coronel Galdino Andrade, n 225, Bairro Avelino Cardoso");
//        me.setCpf(1235478);
//        
//        if(teste.insert(me))
//        {
//            System.out.println("ok");
//        }
//        else
//            System.out.println("Not ok");
//    }
//        ClienteController controll = new ClienteController();
//
//        if (controll.delete(1)) {
//            System.out.println("ok");
//        } else {
//            System.out.println("not ok");
//        }
//
//        ClienteView tela = new ClienteView();
//        ProductView tela2 = new ProductView();
        
////        
//        Home home = new Home();
//        home.setVisible(true);
//       
      /* ProductController teste = new ProductController();
       teste.recoverNext(2);*/
        
        ProductTableView tela = new ProductTableView();
        tela.setVisible(true);
        
//        ProductDao teste = new ProductDao();
//        teste.recoverByName("Teste09");

    }
}
