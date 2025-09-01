
import dao.MusicaDAO;
import modelo.Musica;
import java.util.List;
import dao.MusicaDB;

public class Main {
  public static void main(String[] args) {
    MusicaDAO musicaDAO = new MusicaDB();
    List<Musica> musicas = musicaDAO.getAllMusicas();
    for (Musica musica : musicas) {
      musica.imprimeCodMusArt();
    }

    EscreverArquivo.writeLineInFile("musica.txt", "codMus, titulo, artista", false);
    for (Musica musica : musicas) {
      EscreverArquivo.writeLineInFile("musica.txt", musica.toString(), true);
    }
  }
}