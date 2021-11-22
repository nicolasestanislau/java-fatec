package edu.curso.javafx.bce.tradicional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TesteConexao {
    private static final String DBURL = "jdbc:mysql://localhost/petdb";
    private static final String DBUSER = "root";
    private static final String DBPASS = "";


    public static void main(String[] args) throws Exception{
        System.out.println("teste de conexão data base");
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("classe de conexão carregada");
        Connection con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        System.out.println("conectado no banco de dados");

//        String sql = "INSERT INTO pet (id, nome, raca, peso, nascimento)" +
//                "VALUES (1, 'Toto', 'ViraLata', 10.76, '2021-11-09')";
//
//        PreparedStatement stmt = con.prepareStatement(sql);
//        stmt.executeUpdate();

        String sql = "SELECT * FROM pet";

        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        System.out.println(rs.getInt("id"));
        System.out.println(rs.getString("nome"));
        System.out.println(rs.getString("raca"));
        System.out.println(rs.getDouble("peso"));
        System.out.println(rs.getDate("nascimento"));

        while(rs.next()) {
            System.out.println(rs.getInt("id"));
            System.out.println(rs.getString("nome"));
            System.out.println(rs.getString("raca"));
            System.out.println(rs.getDouble("peso"));
            System.out.println(rs.getDate("nascimento"));
        };

        con.close();
    }
}
