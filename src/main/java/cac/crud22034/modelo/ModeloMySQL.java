/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cac.crud22034.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eze23
 */
public class ModeloMySQL implements Modelo {

    private static final String GET_ALL_QUERY = "SELECT * FROM jugadores";

    @Override
    public List<Alumno> getAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        try ( Connection con = Conexion.getConnection();  PreparedStatement ps = con.prepareStatement(GET_ALL_QUERY);  ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                alumnos.add(rsToAlumno(rs));
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error al leer los jugadores de la BD", ex);
        }
        return alumnos;
    }

    @Override
    public Alumno getAlumno(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int addAlumno(Alumno alumno) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int updateAlumno(Alumno alumno) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int removeAlumno(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Alumno rsToAlumno(ResultSet rs) throws SQLException {
        int id = rs.getInt("id_player");
        String nombre = rs.getString("nombre");
        String apellido = rs.getString("apellido");
        int edad = rs.getInt("edad");
        double altura = rs.getDouble("altura");
        String posicion = rs.getString("posicion");
        String equipoActual = rs.getString("equipoActual");
        String foto = rs.getString("fotoBase64");
        return new Alumno(id, nombre, apellido, edad, altura, posicion, equipoActual, foto);
    }
}
