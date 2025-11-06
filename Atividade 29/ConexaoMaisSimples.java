import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMaisSimples {
	// Fornece uma conexão para o banco bd_pessoal
	private static final String URL = "jdbc:mysql://localhost:3306/bd_pessoal?useSSL=false&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASS = "root";

	private ConexaoMaisSimples() {
		// prevent instantiation
	}

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// opcional: rethrow como RuntimeException para indicar configuração incorreta
			throw new SQLException("Driver JDBC não encontrado", e);
		}
		return DriverManager.getConnection(URL, USER, PASS);
	}
}
