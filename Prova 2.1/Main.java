package src;
import java.util.*;

import javax.swing.JFrame;

import com.mysql.cj.result.StringConverter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {


    
    public static ArrayList<Pessoal> buscaDadosBD() {

        ArrayList<Pessoal> elementosPessoa = new ArrayList<>();

        String nomeJDBC = "jdbc:mysql://localhost/bd_pessoal";
		String configTimeZone = "?useTimezone=true&serverTimezone=UTC";
		String nomeUser = "root";
		String password = "";

		try {
		
		//Class.forName("com.mysql.jdbc.Driver");
		Class.forName("com.mysql.cj.jdbc.Driver"); 

		Connection con = 
			DriverManager.getConnection(nomeJDBC+configTimeZone, nomeUser, password);

		// Acessa um banco de dados específico.
		Statement st = con.createStatement();
		st.executeUpdate("USE " + "bd_pessoal");

		// Faz a consulta SQL
		String pedido = "Select * From pessoal;";
		
		ResultSet rs = st.executeQuery(pedido);

		// Mostra os resultados da consulta

		while (rs.next()) {
            

            int matricula = rs.getInt("matricula");
            String nome = rs.getString("nome");
            String email = rs.getString("email");
            String senha = rs.getString("senha");
            String cargo = rs.getString("cargo");
            String turma = rs.getString("turma");
            String setor = rs.getString("setor");


            Pessoal pessoaAdicionada = new Pessoal(matricula, nome, email, senha, cargo, turma, setor);
            System.out.println(pessoaAdicionada.toString());
            
			elementosPessoa.add(pessoaAdicionada);
		}
		
		st.close();
		con.close();
		} catch (ClassNotFoundException | SQLException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
		}

        return elementosPessoa;
    }

 



    public static void main(String[] args) {
        //questao 2
        ArrayList<Pessoal> pessoas = new ArrayList<>();
        pessoas = buscaDadosBD();

        //questao 3

        //Nao consegui implementar o botao anteior e proximo, por isso me confundi na hora de criar o desenhar tela
        DesenharTela tela = new DesenharTela();

        Pessoal pessoa = new Pessoal(0, "nome teste", "email teste", "senha teste", "cargo teste", "turma teste", "setor teste");
        tela.desenharTela(StringConverter(pessoa.getMatricula()),pessoa.getNome(),pessoa.getEmail(),pessoa.getSenha(),pessoa.getCargo(),pessoa.getTurma(),pessoa.getSetor());
        //for (Pessoal pessoa : pessoas){
        //  tela.desenharTela(StringConverter(pessoa.getMatricula()),pessoa.getNome(),pessoa.getEmail(),pessoa.getSenha(),pessoa.getCargo(),pessoa.getTurma(),pessoa.getSetor());
        //}

        //questao 4
        LerCSV lerCSV = new LerCSV();
        lerCSV.escreverCSV(pessoas);


    }

    private static String StringConverter(int matricula) {
        return null;
    }



}
