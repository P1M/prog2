/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import ConnectionDB.ConnectionFactory;
import java.sql.ResultSet;


/**
 *
 * @author joao
 */
public class DAOProdutos {
    private Connection c;

    public DAOProdutos() throws ClassNotFoundException,SQLException{
        c = ConnectionFactory.getConnection();
    }

    public void adicionar(Produtos produtos){
        PreparedStatement ps = null;
        try{

            ps = c.prepareStatement("INSERT INTO Produtos(Nome, Preco, Quantidade) VALUES (?,?,?);");
            ps.setString(1,produtos.nome);
            ps.setInt(2,produtos.preco);
            ps.setInt(3,produtos.quantidade);
            ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }



    }
    public ResultSet select() throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement("SELECT * FROM Produtos;");

            // ps.close();
            //ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet resultado = ps.executeQuery();
        return resultado;
//ps.close();



    }
    
    
    public void deletarProduto(int id){
        
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement("DELETE FROM Produtos WHERE idProdutos = ?;");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            // ps.close();
            //ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }   
        
    }
}
