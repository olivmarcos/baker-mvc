/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Models.VendedorModel;
import Models.VendedorModel;
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
public class VendedorDao {
     public boolean insert(VendedorModel vend) {
        
        String sql = "INSERT INTO TBL_VENDEDOR(ven_name, ven_empresa, ven_cpf) VALUES (?, ?, ?)"; 
        
        try {
            Connection con = Dao.FabricaConexao.GeraConexao();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, vend.getName());
            pst.setString(2, vend.getEmpresa());
            pst.setInt(3, vend.getCpf());
            
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao salvar o registro " + e.getMessage());
        }
        
        return false;
    }
    
    public VendedorModel recover(int id) {
        
        String sql = "SELECT ven_id, ven_name, ven_empresa, ven_cpf FROM TBL_VENDEDOR WHERE ven_id = ?";
        
        try {
            Connection con = Dao.FabricaConexao.GeraConexao();
            PreparedStatement stp = con.prepareStatement(sql);
            stp.setInt(1, id);
            ResultSet result = stp.executeQuery();
            result.next();
            
            VendedorModel vend = new VendedorModel();
            vend.setId(Integer.parseInt(result.getString("ven_id")));
            vend.setName(result.getString("ven_name"));
            vend.setEmpresa(result.getString("ven_empresa"));
            vend.setCpf(result.getInt("ven_cpf"));
            
            return vend;
        } catch (SQLException e) {
             Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    public void update(VendedorModel vend) {
        String sql = "UPDATE TBL_VENDEDOR SET ven_name = ?, ven_empresa = ?, ven_cpf = ? WHERE ven_id = ?";
        
        try {
            Connection con = Dao.FabricaConexao.GeraConexao();
            PreparedStatement stp = con.prepareStatement(sql);

            stp.setString(1, vend.getName());
            stp.setString(2, vend.getEmpresa());
            stp.setInt(3, vend.getCpf());
            stp.setInt(4, vend.getId());

            stp.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public boolean delete(int id) {
        String sql = "DELETE FROM TBL_VENDEDOR WHERE ven_id = ?";
        
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
    
    public ArrayList<VendedorModel> recoverAll() {
        String sql = "SELECT * FROM TBL_VENDEDOR";
        ArrayList<VendedorModel> vendedores = new ArrayList<VendedorModel>();
        
        try {
            Connection con = Dao.FabricaConexao.GeraConexao();
            PreparedStatement stp = con.prepareStatement(sql);

            ResultSet result = stp.executeQuery();
           
            while (result.next())
            {
                VendedorModel vend = new VendedorModel();

                vend.setId(result.getInt("ven_id"));
                vend.setName(result.getString("ven_name"));
                vend.setEmpresa(result.getString("ven_empresa"));
                vend.setCpf(result.getInt("ven_cpf"));
        
                vendedores.add(vend);
            }
            return vendedores;

        } catch (SQLException ex) {

            System.err.println(ex.getMessage());
        }
        return null;
    }
}
