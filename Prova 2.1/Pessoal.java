package src;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Pessoal {
    private int matricula;
    private String nome;
    private String email;
    private String senha;
    private String cargo;
    private String turma;
    private String setor;


    public Pessoal(int matricula, String nome, String email, String senha, String cargo, String turma, String setor) {
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cargo = cargo;
        this.turma = turma;
        this.setor = setor;
    }


    @Override
    public String toString() {
        return  matricula + ";" + nome + ";" + email + ";" + senha
                + ";" + cargo + ";" + turma + ";" + setor ;
    }


    public int getMatricula() {
        return matricula;
    }


    public String getNome() {
        return nome;
    }


    public String getEmail() {
        return email;
    }


    public String getSenha() {
        return senha;
    }


    public String getCargo() {
        return cargo;
    }


    public String getTurma() {
        return turma;
    }


    public String getSetor() {
        return setor;
    }

    
    
}
