/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Models.ClienteModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marco
 */
public class ClienteDao {
        
    public boolean insert(ClienteModel cli) {
        
        String sql = "INSERT INTO TBL_CLIENTE(cli_name, cli_endereco, cli_cpf) VALUES (?, ?, ?)"; 
        
        try {
            Connection con = Dao.FabricaConexao.GeraConexao();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cli.getName());
            pst.setString(2, cli.getEndereco());
            pst.setInt(3, cli.getCpf());
            
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao salvar o registro " + e.getMessage());
        }
        
        return false;
    }
    
    public ClienteModel recover(int id) {
        
        String sql = "SELECT cli_id, cli_name, cli_endereco, cli_cpf FROM TBL_CLIENTE WHERE cli_id = ?";
        
        try {
            Connection con = Dao.FabricaConexao.GeraConexao();
            PreparedStatement stp = con.prepareStatement(sql);
            stp.setInt(1, id);
            ResultSet result = stp.executeQuery();
            result.next();
            
            ClienteModel cli = new ClienteModel();
            cli.setId(Integer.parseInt(result.getString("cli_id")));
            cli.setName(result.getString("cli_name"));
            cli.setEndereco(result.getString("cli_endereco"));
            cli.setCpf(result.getInt("cli_cpf"));
            
            return cli;
        } catch (SQLException e) {
             Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    public void update(ClienteModel cli) {
        String sql = "UPDATE TBL_CLIENTE SET cli_name = ?, cli_endereco = ?, cli_cpf = ? WHERE cli_id = ?";
        
        try {
            Connection con = Dao.FabricaConexao.GeraConexao();
            PreparedStatement stp = con.prepareStatement(sql);

            stp.setString(1, cli.getName());
            stp.setString(2, cli.getEndereco());
            stp.setInt(3, cli.getCpf());
            stp.setInt(4, cli.getId());

            stp.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public boolean delete(int id) {
        String sql = "DELETE FROM TBL_CLIENTE WHERE cli_id = ?";
        
        try {
            Connection con = Dao.FabricaConexao.GeraConexao();
            PreparedStatement stp = con.prepareStatement(sql);
            
            stp.setInt(1, id);
            stp.execute();
            
            return true;
        } catch (Exception e) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
    public ArrayList<ClienteModel> recoverAll() {
        String sql = "SELECT * FROM TBL_CLIENTE";
        ArrayList<ClienteModel> products = new ArrayList<ClienteModel>();
        
        try {
            Connection con = Dao.FabricaConexao.GeraConexao();
            PreparedStatement stp = con.prepareStatement(sql);

            ResultSet result = stp.executeQuery();
           
            while (result.next())
            {
                ClienteModel cli = new ClienteModel();

                cli.setId(result.getInt("cli_id"));
                cli.setName(result.getString("cli_name"));
                cli.setEndereco(result.getString("cli_endereco"));
                cli.setCpf(result.getInt("cli_cpf"));
        
                products.add(cli);
            }
            return products;

        } catch (SQLException ex) {

            System.err.println(ex.getMessage());
        }
        return null;
    }
}
