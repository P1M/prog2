package Clientes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joao
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import ConnectionDB.ConnectionFactory;

public class DAOCadastroClientes {
    private Connection c;

    public DAOCadastroClientes() throws ClassNotFoundException,SQLException{
        c = ConnectionFactory.getConnection();
    }

    public void adicionar(Clientes clientes1) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = null;
        try{

            ps = c.prepareStatement("INSERT INTO CadastroClientes(Nome, DataNasc, Cpf, Telefone, Endereco, Cidade, Estado, Cep) VALUES (?,?,?,?,?,?,?,?);");
           ps.setString(1,clientes1.nome);
            ps.setString(2,clientes1.datanasc);
            ps.setString(3,clientes1.cpf);
            ps.setString(4,clientes1.telefone);
            ps.setString(5,clientes1.endereco);
            ps.setString(6,clientes1.cidade);
            ps.setString(7,clientes1.estado);
            ps.setString(8,clientes1.cep);







            ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
            e.printStackTrace();
        }



    }
}

