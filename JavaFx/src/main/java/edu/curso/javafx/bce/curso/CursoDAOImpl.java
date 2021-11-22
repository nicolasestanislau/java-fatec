package edu.curso.javafx.bce.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CursoDAOImpl implements CursoDAO {

    private static final String DBURL = "jdbc:mysql://localhost/cursosdb";
    private static final String DBUSER = "root";
    private static final String DBPASS = "";

    public CursoDAOImpl() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void adicionar(Curso c) {

        try {
            Connection con =  DriverManager.getConnection(DBURL, DBUSER, DBPASS);

            String sql = "insert into cursos (id, codCurso, nome, coordenador, qntAlunos) " +
                    "VALUES (?, ? ,?, ?, ?)";

            System.out.println(sql);
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, c.getId());
            stmt.setLong(2, c.getCodCurso());
            stmt.setString(3, c.getNome());
            stmt.setString(4, c.getCoordenador());
            stmt.setLong(5, c.getQntAlunos());
            stmt.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Curso> pesquisarPorNome(String nome) {
        List<Curso> encontrados = new ArrayList<>();
        try {
            Connection con =  DriverManager.getConnection(DBURL, DBUSER, DBPASS);

            String sql = "SELECT * FROM cursos WHERE nome like '%" + nome + "%'";
            System.out.println(sql);

            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                Curso c = new Curso();
                c.setId( rs.getLong("id"));
                c.setCodCurso( rs.getLong("codCurso"));
                c.setNome(rs.getString("nome"));
                c.setCoordenador( rs.getString("coordenador"));
                c.setQntAlunos( rs.getLong("qntAlunos"));

                encontrados.add(c);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encontrados;
    }

    @Override
    public void atualizar(long id, Curso c) {

    }

    @Override
    public void remover(long id) {
        try {
            Connection con =  DriverManager.getConnection(DBURL, DBUSER, DBPASS);

            String sql = "DELETE FROM cursos WHERE id = ?";
            System.out.println(sql);
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
