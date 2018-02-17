/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionDB;

/**
 *
 * @author joao
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class ConnectionFactory {

    private static Connection connection = null;

    private ConnectionFactory() {

    }

    private static void createConnection() throws ClassNotFoundException, SQLException {
        // Forço a instanciação da classe Driver da implementação fornecida pela MySQL
        // Carregar o Driver (ETAPA 2)
        Class.forName("com.mysql.jdbc.Driver");

        // Especifica uma URL com informações para acessar o Banco de Dados (ETAPA 3)
        String url = "jdbc:mysql://localhost:3306/db_cabaret"; // Nome da base de dados
        String user = "root"; // nome do usuário do MySQL
        String password = "123pimpim"; // senha do MySQL



        // Abre uma conexão com o Banco de Dados (ETAPA 4)
        connection = DriverManager.getConnection(url, user, password);


    }

    public static synchronized Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connection == null)
            createConnection();
        return connection;
    }

    public static synchronized void close() throws SQLException {
        if (connection != null)
            connection.close();
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}

