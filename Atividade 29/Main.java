import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PessoaDAO dao = new PessoaDAOImplement();
        try {
            List<Pessoa> pessoas = dao.getListaPessoas();
            System.out.println("REGISTRO;Nome;Email");
            int idx = 1;
            for (Pessoa p : pessoas) {
                System.out.println(idx + ";" + p.getNome() + ";" + p.getEmail());
                idx++;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao recuperar lista de pessoas: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
