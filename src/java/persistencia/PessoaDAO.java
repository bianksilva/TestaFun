package persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.Pessoa;

/**
 *
 * @author Bianca Silva
 */
public class PessoaDAO {

    
    
    private Connection conexao;
  
    
    public PessoaDAO() {
        try {

            conexao = Conexao.criaConexao();
        } catch (Exception e) {
            System.out.println("Erro PessoaDAO");
            System.out.println(e);
        }
    }

    public boolean inserir_Pessoa(Pessoa pessoa) {

        try {
            
            String sql;
            if (pessoa.getCod() == 0) {
                //realizar uma inclusão
                sql = "INSERT INTO pessoa (cpf, nome, nascimento ) VALUES (?,?,?)";
            } else {
                //realizar alteração
                sql = "UPDATE pessoa SET cpf=?, nome=?, nascimento=?  WHERE cod=?";

            }
            PreparedStatement ps = conexao.prepareStatement(sql);

            ps.setString(1, pessoa.getCpf());
            ps.setString(2, pessoa.getNome());
            ps.setDate(3, new Date(pessoa.getNascimento().getTime()));

            if (pessoa.getCod() > 0) {
                ps.setInt(4, pessoa.getCod());
            }

            ps.execute();

            return true;

        } catch (SQLException e) {
            System.out.println("Erro de SQL" + e.getMessage());
            return false;
        }
    }

    public ArrayList<Pessoa> getListar_Pessoa() {
        Calendar hoje = Calendar.getInstance();
        
        ArrayList<Pessoa> resultado = new ArrayList<>();
        try {

            Statement stmt = conexao.createStatement();

            ResultSet rs = stmt.executeQuery("select * from pessoa"); //buscar no banco, na tabela pessoa
            while (rs.next()) {
                Pessoa e = new Pessoa();
                e.setCod(rs.getInt("cod"));
                e.setCpf(rs.getString("cpf"));
                e.setNome(rs.getString("nome"));
                e.setNascimento(rs.getDate("nascimento"));

                resultado.add(e); //salva os dados na variável e
            }
        } catch (Exception e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return resultado;
    }

    public boolean excluir(int cod) {
        try {
            String sql = "DELETE FROM pessoa WHERE cod=?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, cod);

            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro de SQL");
            return false;
        }

    }

    public Pessoa getPessoaPorCodigo(int cod) {
        Pessoa pessoa = new Pessoa();
        try {
            String sql = "SELECT * FROM pessoa WHERE cod=?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, cod);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pessoa.setCod(rs.getInt("cod"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setNascimento(rs.getDate("nascimento"));

            }

        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return pessoa;
    }

    
}
