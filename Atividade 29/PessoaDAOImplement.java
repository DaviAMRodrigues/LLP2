import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAOImplement implements PessoaDAO {

    @Override
    public List<Pessoa> getListaPessoas() throws SQLException {
        String sql = "SELECT id, nome, email FROM pessoal";
        List<Pessoa> lista = new ArrayList<>();
        try (Connection con = ConexaoMaisSimples.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Pessoa p = new Pessoa();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setEmail(rs.getString("email"));
                lista.add(p);
            }
        }
        return lista;
    }

    @Override
    public void adicionarPessoa(Pessoa pessoa) throws SQLException {
        String sql = "INSERT INTO pessoal(nome, email) VALUES (?, ?)";
        try (Connection con = ConexaoMaisSimples.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getEmail());
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    pessoa.setId(keys.getInt(1));
                }
            }
        }
    }

    @Override
    public Pessoa buscarPessoaPorId(int id) throws SQLException {
        String sql = "SELECT id, nome, email FROM pessoal WHERE id = ?";
        try (Connection con = ConexaoMaisSimples.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Pessoa(rs.getInt("id"), rs.getString("nome"), rs.getString("email"));
                }
            }
        }
        return null;
    }

    @Override
    public void atualizarPessoa(Pessoa pessoa) throws SQLException {
        String sql = "UPDATE pessoal SET nome = ?, email = ? WHERE id = ?";
        try (Connection con = ConexaoMaisSimples.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getEmail());
            ps.setInt(3, pessoa.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public void deletarPessoa(int id) throws SQLException {
        String sql = "DELETE FROM pessoal WHERE id = ?";
        try (Connection con = ConexaoMaisSimples.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
    
}
