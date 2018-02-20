/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import ConnectionDB.ConnectionFactory;
import
/**
 *
 * @author joao
 */
import java.sql.ResultSet;
public class DAOFuncionarios {
    private Connection c;
    
     public DAOFuncionarios() throws ClassNotFoundException,SQLException{
        c = ConnectionFactory.getConnection();
            }
    public void adicionar(Funcionarios funcionario){
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement("INSERT INTO Funcionarios(Nome, DataNasc, Genero, Salario, DataAdmiss, Funcao, Cpf_Func) VALUES(?,?,?,?,?,?,?);");
            ps.setString(1, funcionario.nome);
            ps.setString(2, funcionario.datanasc);
            ps.setString(3, funcionario.genero);
            ps.setInt(4, funcionario.salario);
            ps.setString(5,funcionario.dataAdmiss);
            ps.setString(6, funcionario.funcao);
            ps.setString(7, funcionario.cpf);
            ps.executeUpdate();
            ps.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
        public ResultSet select (){
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement("SELECT * FROM Funcionarios;");
                        ResultSet resultado = ps.executeQuery();
                                    ps.close();

                                return resultado;


    
            //ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
           
    
}