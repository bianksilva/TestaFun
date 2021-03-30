package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/testafun";
    private static final String USUARIO = "root";
    private static final String SENHA = "";
    private static Connection cn = null;

    public static Connection criaConexao() throws SQLException { //retorna conexão com o banco 
        if (cn == null) {                                        //conexão não criada
            try {
                Class.forName(DRIVER);                               //carregar driver de conexão com o banco na memória 
                System.out.println("Driver foi carregado!");
                cn = DriverManager.getConnection(URL, USUARIO, SENHA);
                System.out.println("Conexão realizada com sucesso!");
            } catch (ClassNotFoundException e) {
                System.out.println("Driver não localizao!");
            }
        }
        return cn;
    }

}
