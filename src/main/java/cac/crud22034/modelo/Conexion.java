/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cac.crud22034.modelo;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author eze23
 */
public class Conexion {

    private static Connection conx;
    private static BasicDataSource dataSource;

    private Conexion() {
    }

    // SINGLETON
    // POOL DE CONEXIONES
    public static DataSource getDataSource() {
        if (dataSource == null) {
            try {
                String URL = "jdbc:mysql://root:pinguino11@localhost:3306/cac_crud_java_2022?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
                dataSource = new BasicDataSource();
                dataSource.setUrl(URL);
                dataSource.setInitialSize(50);
            } catch (Exception ex){
                throw new RuntimeException("Error al conectar con la BD");
            }
        }
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

}
