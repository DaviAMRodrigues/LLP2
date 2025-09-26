import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class ConexaoMaisSimples{

	public ConexaoMaisSimples() {
		
		// Conexão com o driver JDBC
		String nomeJDBC = "jdbc:mysql://localhost/discdb";
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
		st.executeUpdate("USE " + "discdb");

		// Faz a consulta SQL
		String pedido = "Select * From musica;";
		
		ResultSet rs = st.executeQuery(pedido);

		// Mostra os resultados da consulta
		int numeroLinhas = 1;

		while (rs.next()) {
			System.out.println("REGISTRO: " + numeroLinhas );

			System.out.print("CodMus: ");
			System.out.println(rs.getString("CodMus"));
			
			System.out.print("Titulo: ");
			System.out.println(rs.getString("Titulo"));			

			numeroLinhas++;
		}
		
		/*	
		String sql = "Insert INTO Pensamentos(Texto, Autor) "
				+ "VALUES ('Penso, logo sei isso!', 'Eu');";		
		
		int linhasAlteradas = st.executeUpdate(sql);

		System.out.println(linhasAlteradas);
	 	*/
		st.close();
		con.close();
		} catch (ClassNotFoundException | SQLException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
		}

	}

	public static void main(String[] args) {
		new ConexaoMaisSimples();
	}

}
