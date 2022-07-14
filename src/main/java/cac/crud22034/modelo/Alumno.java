package cac.crud22034.modelo;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */
public class Alumno {

    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private double altura;
    private String posicion;
    private String equipoActual;
    private String foto;

    public Alumno() {
    }

    public Alumno(int id) {
        setId(id);
    }

    public Alumno(String nombre, String apellido, int edad, double altura, String posicion, String equipoActual) {
        this(0, nombre, apellido, edad, altura, posicion, equipoActual, "");
    }

    public Alumno(int id, String nombre, String apellido, int edad, double altura, String posicion, String equipoActual) {
        this(id, nombre, apellido, edad, altura, posicion, equipoActual, "");
    }

    public Alumno(int id, String nombre, String apellido, int edad, double altura, String posicion, String equipoActual, String foto) {
        setId(id);
        setApellido(apellido);
        setNombre(nombre);
        setEdad(edad);
        setAltura(altura);
        setPosicion(posicion);
        setEquipoActual(equipoActual);
        setFoto(foto);
    }

    public void setId(int id) {
        if (id < 0) {
            throw new RuntimeException("Valor para ID inconsistente");
        }
        this.id = id;
    }

    public void setApellido(String apellido) {
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new RuntimeException("No se ha provisto un apellido");
        }
        this.apellido = apellido.trim();
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new RuntimeException("No se ha provisto un nombre");
        }
        this.nombre = nombre.trim();
    }
    
    public void setEdad(int edad){
        if (edad >= 18){
            this.edad = edad;
        }
    }

    public void setAltura(double altura) {
        if (altura > 0){
            this.altura = altura;
        }
    }
    
    public void setPosicion(String posicion) {
        if (posicion == null || posicion.trim().isEmpty()) {
            throw new RuntimeException("No se ha provisto una posición");
        }
        this.posicion = posicion.trim();    
    }
    
    public void setEquipoActual(String equipoActual) {
        if (equipoActual == null || equipoActual.trim().isEmpty()) {
            throw new RuntimeException("No se ha provisto un equipo");
        }
        this.equipoActual = equipoActual.trim();
    }
    

    public void setFoto(String foto) {
        if (foto == null || foto.trim().isEmpty()) {
            foto = "assets/sin-foto.jpg";
        }
        if (!foto.contains("sin-foto") || this.foto == null || this.foto.contains("sin-foto")) {
            this.foto = foto.trim();
        }
    }

    public int getId() {
        return id;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public double getAltura() {
        return altura;
    }

    public String getPosicion() {
        return posicion;
    }

    public String getEquipoActual() {
        return equipoActual;
    }

    
    public int getEdad() {
        return edad;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }


    public String getFoto() {
        return foto;
    }

    @Override
    public String toString() {
        return "Alumno{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", altura=" + altura + ", posicion=" + posicion + ", equipoActual=" + equipoActual + ", foto=" + foto + '}';
    }

    
    
}
