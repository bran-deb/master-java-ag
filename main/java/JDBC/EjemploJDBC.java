package JDBC;

import java.sql.*;

public class EjemploJDBC {
    public static void main(String[] args) {

//        String url = "jdbc:mysql://localhost:3306/java-jdbc-ag?zeroDateTimeBehavior=convertToNull&serverTimezone=America/La_Paz";
        String url = "jdbc:postgresql://localhost:5432/java-jdbc-ag";
        String username = "root";
        String password = "diosdeb";

        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                Statement statement = connection.createStatement();
                ResultSet resultado = statement.executeQuery("SELECT * FROM productos");
        ) {
            while (resultado.next()) {
                System.out.print(" | " + resultado.getInt("id"));//campo o columna
                System.out.print(" | " + resultado.getString("nombre"));
                System.out.print(" | " + resultado.getInt("precio"));
                System.out.println(" | " + resultado.getDate("fecharegistro") + " | ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
