import java.util.ArrayList;

public interface DAO {
    public ArrayList<Aluno> getAlunos();
    public Aluno getAluno(int id);
    public void deletarAluno(int id);
    public void atualizarAluno(Aluno aluno, int id);
}
