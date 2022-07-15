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
    private static final String GET_BY_ID_QUERY = "SELECT * FROM jugadores WHERE id = ?";
    private static final String ADD_QUERY = "INSERT INTO jugadores VALUES (null, ?, ?, ?, ?, ?, ?, ?) ";
    private static final String UPDATE_QUERY = "UPDATE jugadores SET nombre = ?, apellido = ?, edad = ?, altura = ?, posicion = ?, equipoActual = ?, fotoBase64 = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM jugadores WHERE id = ?";

    @Override
    public List<Alumno> getAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        try ( Connection con = Conexion.getConnection();  PreparedStatement ps = con.prepareStatement(GET_ALL_QUERY);  ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                alumnos.add(rsToAlumno(rs));
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error de SQL", ex);
        } catch (Exception ex) {
            throw new RuntimeException("Error al leer jugadores", ex);
        }
        return alumnos;
    }

    @Override
    public Alumno getAlumno(int id) {
        Alumno alu = null;
        try ( Connection con = Conexion.getConnection();  PreparedStatement ps = con.prepareStatement(GET_BY_ID_QUERY);) {
            ps.setInt(1, id);
            try ( ResultSet rs = ps.executeQuery();) {
                rs.next();
                alu = rsToAlumno(rs);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error al obtener jugador con el id" + id + " de la BD", ex);
        } catch (Exception ex) {
            throw new RuntimeException("Error al leer jugadores" + id, ex);
        }
        return alu;
    }

    @Override
    public int addAlumno(Alumno alumno) {
        int regsAgregados = 0;
        try ( Connection con = Conexion.getConnection();  PreparedStatement ps = con.prepareStatement(ADD_QUERY);) {
            fillPreparedStatement(ps, alumno);
            regsAgregados = ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Error de SQL", ex);
        } catch (Exception ex) {
            throw new RuntimeException("Error al agregar jugador" + alumno.getNombreCompleto(), ex);
        }
        return regsAgregados;
    }

    @Override
    public int updateAlumno(Alumno alumno) {
        int regsActualizar = 0;
        try ( Connection con = Conexion.getConnection();  PreparedStatement ps = con.prepareStatement(UPDATE_QUERY);) {
            fillPreparedStatement(ps, alumno);
            ps.setInt(8, alumno.getId());
            regsActualizar = ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Error de SQL", ex);
        } catch (Exception ex) {
            throw new RuntimeException("Error al editar jugador" + alumno.getNombreCompleto(), ex);
        }
        return regsActualizar;
    }

    @Override
    public int removeAlumno(int id) {
        int regsBorrados = 0;
        try ( Connection con = Conexion.getConnection();  PreparedStatement ps = con.prepareStatement(DELETE_QUERY);) {
            ps.setInt(1, id);
            regsBorrados = ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Error de SQL", ex);
        } catch (Exception ex) {
            throw new RuntimeException("Error al borrar jugador con ID" + id, ex);
        }
        return regsBorrados;
    }

    private Alumno rsToAlumno(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String nombre = rs.getString("nombre");
        String apellido = rs.getString("apellido");
        int edad = rs.getInt("edad");
        double altura = rs.getDouble("altura");
        String posicion = rs.getString("posicion");
        String equipoActual = rs.getString("equipoActual");
        String foto = rs.getString("fotoBase64");
        return new Alumno(id, nombre, apellido, edad, altura, posicion, equipoActual, foto);
    }

    private void fillPreparedStatement(PreparedStatement ps, Alumno alumno) throws SQLException {
        ps.setString(1, alumno.getNombre());
        ps.setString(2, alumno.getApellido());
        ps.setInt(3, alumno.getEdad());
        ps.setDouble(4, alumno.getAltura());
        ps.setString(5, alumno.getPosicion());
        ps.setString(6, alumno.getEquipoActual());
        ps.setString(7, alumno.getFoto());
    }
}
