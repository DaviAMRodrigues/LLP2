package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mysql.AcessoMySQL;
import modelo.Musica;

public class MusicaDB implements MusicaDAO {
  private Connection connection;

  public MusicaDB() {
    try {
      connection = AcessoMySQL.getConection();
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
  }

  @Override
  public List<Musica> getAllMusicas() {
    List<Musica> musicas = new ArrayList<Musica>();

    try {
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(
          "SELECT m.Titulo, a.Nome AS Artista, m.CodMus " +
          "FROM gravadora g " +
          "JOIN disco d ON g.CodGrav = d.CodGrav " +
          "JOIN faixa f ON d.CodDisco = f.CodDisco " +
          "JOIN musica m ON f.CodMus = m.CodMus " +
          "JOIN artista a ON d.CodArt = a.CodArt"
      );

      while (resultSet.next()) {
          Musica musica = new Musica();
          musica.setCodigo(resultSet.getInt("CodMus"));
          musica.setTitulo(resultSet.getString("Titulo"));
          musica.setArtista(resultSet.getString("Artista")); 
          musicas.add(musica);
      }
    } catch (SQLException exception) {
      exception.printStackTrace();
    }

    return musicas;
  }
}
