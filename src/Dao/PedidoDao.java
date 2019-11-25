/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Models.PedidoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author marco
 */
public class PedidoDao {
    
    public boolean save(PedidoModel ped) {
        Connection conexao = FabricaConexao.GeraConexao();
        String sql = "INSERT INTO TBL_PEDIDO(ped_CLI_ID, ped_PRD_ID, ped_VEN_ID) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement pst = conexao.prepareStatement(sql);
            
            pst.setInt(1, ped.getClienteId());
            pst.setInt(2, ped.getProdutoId());
            pst.setInt(3, ped.getVendedorId());
            return pst.execute();
        } catch (Exception e) {
            System.out.println("Erro ao salvar o Registro" + e.getMessage());
            return false;
        }
    }
}
