/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Models.ProductModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author marco
 */
public class ProductDao {
    
    public void insert(ProductModel prod) {
        
        String sql = "INSERT INTO TBL_PRODUCT(prd_name, prd_price, prd_unity) VALUES (?, ?, ?)"; 
        
        try {
            Connection con = Dao.FabricaConexao.GeraConexao();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, prod.getName());
            pst.setDouble(2, prod.getPrice());
            pst.setString(3, prod.getUnity());
            
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar o r egistro " + e.getMessage());
        }
    }
    
    public ProductModel recover(int id) {
        Connection con = Dao.FabricaConexao.GeraConexao();
        
        String sql = "SELECT prd_id, prd_name, prd_price, prd_unity FROM TBL_PRODUCT WHERE prd_id = ?";
        
        try {
            PreparedStatement stp = con.prepareStatement(sql);
            stp.setInt(1, id);
            ResultSet result = stp.executeQuery();
            result.next();
            
            ProductModel prod = new ProductModel();
            prod.setId(Integer.parseInt(result.getString("prd_id")));
            prod.setName(result.getString("prd_name"));
            prod.setPrice(result.getDouble("prd_price"));
            prod.setUnity(result.getString("prd_unity"));
        } catch (SQLException e) {
             Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    public void update(ProductModel prod) {
        
    }
    
    public void delete(int id) {
        
    }
    
    public List<ProductModel> recoverAll() {
        return null;
    }
}
