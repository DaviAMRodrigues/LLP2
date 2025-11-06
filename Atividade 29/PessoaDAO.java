import java.sql.SQLException;
import java.util.List;

public interface PessoaDAO {
    List<Pessoa> getListaPessoas() throws SQLException;
    void adicionarPessoa(Pessoa pessoa) throws SQLException;
    Pessoa buscarPessoaPorId(int id) throws SQLException;
    void atualizarPessoa(Pessoa pessoa) throws SQLException;
    void deletarPessoa(int id) throws SQLException;
}
