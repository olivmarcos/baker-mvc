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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author marco
 */
public class ProductDao {
    
    public boolean insert(ProductModel prod) {
        
        String sql = "INSERT INTO TBL_PRODUCT(prd_name, prd_price, prd_unity) VALUES (?, ?, ?)"; 
        
        try {
            Connection con = Dao.FabricaConexao.GeraConexao();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, prod.getName());
            pst.setDouble(2, prod.getPrice());
            pst.setString(3, prod.getUnity());
            
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao salvar o registro " + e.getMessage());
        }
        
        return false;
    }
    
    public ProductModel recover(int id) {
        
        String sql = "SELECT prd_id, prd_name, prd_price, prd_unity FROM TBL_PRODUCT WHERE prd_id = ?";
        
        try {
            Connection con = Dao.FabricaConexao.GeraConexao();
            PreparedStatement stp = con.prepareStatement(sql);
            stp.setInt(1, id);
            ResultSet result = stp.executeQuery();
            result.next();
            
            ProductModel prod = new ProductModel();
            prod.setId(Integer.parseInt(result.getString("prd_id")));
            prod.setName(result.getString("prd_name"));
            prod.setPrice(result.getDouble("prd_price"));
            prod.setUnity(result.getString("prd_unity"));
            
            return prod;
        } catch (SQLException e) {
             Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    public ProductModel recoverByName(String name) {
        
        String sql = "SELECT prd_id, prd_name, prd_price, prd_unity FROM TBL_PRODUCT WHERE prd_name = ?";
        
        try {
            Connection con = Dao.FabricaConexao.GeraConexao();
            PreparedStatement stp = con.prepareStatement(sql);
            stp.setString(1, name);
            ResultSet result = stp.executeQuery();
            result.next();
            
            ProductModel prod = new ProductModel();
            prod.setId(Integer.parseInt(result.getString("prd_id")));
            prod.setName(result.getString("prd_name"));
            prod.setPrice(result.getDouble("prd_price"));
            prod.setUnity(result.getString("prd_unity"));
            
            return prod;
        } catch (SQLException e) {
             Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
 
    public ProductModel recoverByPrice(Double price) {
        
        String sql = "SELECT prd_id, prd_name, prd_price, prd_unity FROM TBL_PRODUCT WHERE prd_price = ?";
        
        try {
            Connection con = Dao.FabricaConexao.GeraConexao();
            PreparedStatement stp = con.prepareStatement(sql);
            stp.setDouble(1, price);
            ResultSet result = stp.executeQuery();
            result.next();
            
            ProductModel prod = new ProductModel();
            prod.setId(Integer.parseInt(result.getString("prd_id")));
            prod.setName(result.getString("prd_name"));
            prod.setPrice(result.getDouble("prd_price"));
            prod.setUnity(result.getString("prd_unity"));
            
            return prod;
        } catch (SQLException e) {
             Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    public ProductModel recoverByUni(String uni) {
        
        String sql = "SELECT prd_id, prd_name, prd_price, prd_unity FROM TBL_PRODUCT WHERE prd_unity = ?";
        
        try {
            Connection con = Dao.FabricaConexao.GeraConexao();
            PreparedStatement stp = con.prepareStatement(sql);
            stp.setString(1, uni);
            ResultSet result = stp.executeQuery();
            result.next();
            
            ProductModel prod = new ProductModel();
            prod.setId(Integer.parseInt(result.getString("prd_id")));
            prod.setName(result.getString("prd_name"));
            prod.setPrice(result.getDouble("prd_price"));
            prod.setUnity(result.getString("prd_unity"));
            
            return prod;
        } catch (SQLException e) {
             Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    public void update(ProductModel prod) {
        String sql = "UPDATE TBL_PRODUCT SET prd_name = ?, prd_price = ?, prd_unity = ? WHERE prd_id = ?";
        
        try {
            Connection con = Dao.FabricaConexao.GeraConexao();
            PreparedStatement stp = con.prepareStatement(sql);
            stp.setString(1, prod.getName());
            stp.setDouble(2, prod.getPrice());
            stp.setString(3, prod.getUnity());
            stp.setInt(4, prod.getId());


            stp.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public boolean delete(int id) {
        String sql = "DELETE FROM TBL_PRODUCT WHERE prd_id = ?";
        
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
    
    public ArrayList<ProductModel> recoverAll(String uni) {
        String sql = "SELECT prd_id, prd_name, prd_price, prd_unity FROM TBL_PRODUCT WHERE prd_unity = ?";
        ArrayList<ProductModel> products = new ArrayList<ProductModel>();
        
        try {
            Connection con = Dao.FabricaConexao.GeraConexao();
            PreparedStatement stp = con.prepareStatement(sql);
            
            stp.setString(1, uni);

            ResultSet result = stp.executeQuery();
           
            while (result.next())
            {
                ProductModel prod = new ProductModel();

                prod.setId(result.getInt("prd_id"));
                prod.setName(result.getString("prd_name"));
                prod.setPrice(result.getDouble("prd_price"));
                prod.setUnity(result.getString("prd_unity"));
        
                products.add(prod);
            }
            return products;

        } catch (SQLException ex) {

            System.err.println(ex.getMessage());
        }
        return null;
    }
    
    public ProductModel recoverLast()
    {      
        String sql = "SELECT MAX(prd_id) AS 'prd_id', prd_name, prd_price, prd_unity FROM TBL_PRODUCT;";
        
        try {
            Connection con = Dao.FabricaConexao.GeraConexao();
            PreparedStatement stp = con.prepareStatement(sql);
            ResultSet result = stp.executeQuery();
            result.next();
            
            ProductModel prod = new ProductModel();
            prod.setId(Integer.parseInt(result.getString("prd_id")));
            prod.setName(result.getString("prd_name"));
            prod.setPrice(result.getDouble("prd_price"));
            prod.setUnity(result.getString("prd_unity"));
            
            return prod;
        } catch (SQLException e) {
             Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    public ProductModel recoverFirst()
    {      
        String sql = "SELECT MIN(prd_id) AS 'prd_id', prd_name, prd_price, prd_unity FROM TBL_PRODUCT;";
        
        try {
            Connection con = Dao.FabricaConexao.GeraConexao();
            PreparedStatement stp = con.prepareStatement(sql);
            ResultSet result = stp.executeQuery();
            result.next();
            
            ProductModel prod = new ProductModel();
            prod.setId(Integer.parseInt(result.getString("prd_id")));
            prod.setName(result.getString("prd_name"));
            prod.setPrice(result.getDouble("prd_price"));
            prod.setUnity(result.getString("prd_unity"));
            
            return prod;
        } catch (SQLException e) {
             Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    public ProductModel recoverNext(int id)
    {      
        String sql = "SELECT MIN(prd_id) AS 'prd_id', prd_name, prd_price, prd_unity FROM TBL_PRODUCT WHERE prd_id > ?";
        
        try {
            Connection con = Dao.FabricaConexao.GeraConexao();
            PreparedStatement stp = con.prepareStatement(sql);
            stp.setInt(1, id);

            ResultSet result = stp.executeQuery();
            result.next();
            
            ProductModel prod = new ProductModel();
            prod.setId(Integer.parseInt(result.getString("prd_id")));
            prod.setName(result.getString("prd_name"));
            prod.setPrice(result.getDouble("prd_price"));
            prod.setUnity(result.getString("prd_unity"));
            
            return prod;
        } catch (SQLException e) {
             Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
        public ProductModel recoverPrevious(int id)
    {      
        String sql = "SELECT MAX(prd_id) AS 'prd_id', prd_name, prd_price, prd_unity FROM TBL_PRODUCT WHERE prd_id < ?";
        
        try {
            Connection con = Dao.FabricaConexao.GeraConexao();
            PreparedStatement stp = con.prepareStatement(sql);
            stp.setInt(1, id);

            ResultSet result = stp.executeQuery();
            result.next();
            
            ProductModel prod = new ProductModel();
            prod.setId(Integer.parseInt(result.getString("prd_id")));
            prod.setName(result.getString("prd_name"));
            prod.setPrice(result.getDouble("prd_price"));
            prod.setUnity(result.getString("prd_unity"));
            
            return prod;
        } catch (SQLException e) {
             Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
}
    