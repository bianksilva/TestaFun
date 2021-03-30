
import java.util.ArrayList;
import persistencia.PessoaDAO;
import model.Pessoa;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bianca Silva
 */
public class TestaDAO {

    public static void main(String[] args) {

        PessoaDAO dao = new PessoaDAO();
        ArrayList<Pessoa> lista = dao.getListar_Pessoa();
        for (Pessoa e : lista) { //cada objeto encontrado é armazenado na variável e
            System.out.println("Código: " + e.getCod());
            System.out.println("CPF: " + e.getCpf());
            System.out.println("Nome: " + e.getNome());
            System.out.println("Data de Nascimento: " + e.getNascimento());
            System.out.println("---------------------------------------");

        }

    }

}
