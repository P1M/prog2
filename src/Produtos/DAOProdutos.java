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

            ps = c.prepareStatement("INSERT INTO Produtos(idProdutos, Bebidas, Camisinha, Cigarros, Preco, Quantidade) VALUES (?,?,?,?,?,?)");
            ps.setInt(1,produtos.idProdutos);
            ps.setString(2,produtos.bebidas);
            ps.setString(3,produtos.camisinha);
            ps.setString(4,produtos.cigarros);
            ps.setInt(5,produtos.preco);
            ps.setInt(6,produtos.quantidade);
            ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }



    }
    
}
