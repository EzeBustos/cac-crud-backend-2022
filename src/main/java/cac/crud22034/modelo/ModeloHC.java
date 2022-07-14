package cac.crud22034.modelo;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author Charly Cimino Aprendé más Java en mi canal:
 * https://www.youtube.com/c/CharlyCimino Encontrá más código en mi repo de
 * GitHub: https://github.com/CharlyCimino
 */

// Modelo HC (Hard Codeado): Los datos se guardan en la RAM. Solo sirve para testear la app.
public class ModeloHC implements Modelo {

    private List<Alumno> alumnosGuardados;

    public ModeloHC() {
        this.alumnosGuardados = new ArrayList<>();
        crearAlumnosFake();
    }

    @Override
    public List<Alumno> getAlumnos() {
        return new ArrayList(this.alumnosGuardados); // Copia de la lista original
    }

    @Override
    public Alumno getAlumno(int id) {
        int i = 0;
        Alumno encontrado = null;
        while (i < this.alumnosGuardados.size() && encontrado == null) {
            Alumno a = this.alumnosGuardados.get(i);
            if (a.getId() == id) {
                encontrado = a;
            } else {
                i++;
            }
        }
        if (encontrado == null) {
            throw new RuntimeException("No se encontró alumno con ID " + id);
        }
        return encontrado;
    }

    @Override
    public int addAlumno(Alumno alumno) {
        this.alumnosGuardados.add(alumno);
        return 0;
    }

    @Override
    public int updateAlumno(Alumno a) {
        Alumno target = getAlumno(a.getId());
        int idx = this.alumnosGuardados.indexOf(target);
        this.alumnosGuardados.set(idx, a);
        return 0;
    }

    @Override
    public int removeAlumno(int id) {
        Alumno target = getAlumno(id);
        this.alumnosGuardados.remove(target);
        return 0;
    }

    private void crearAlumnosFake() {
        try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("carasFake.properties")) {
            Properties props = new Properties();
            props.load(is);
            this.alumnosGuardados.add(new Alumno(1, "Kouza", "Ibrahim (HC)", 25, 1.92, "Arquero", "PSG", (String) props.get("HOMBRE_1")));
            this.alumnosGuardados.add(new Alumno(2, "Polo", "Irma", 25, 1.92, "Arquero", "PSG"));
            this.alumnosGuardados.add(new Alumno(3, "López", "María", 25, 1.92, "Arquero", "PSG", (String) props.get("MUJER_1")));
            this.alumnosGuardados.add(new Alumno(4, "García", "Luis", 25, 1.92, "Arquero", "PSG", (String) props.get("HOMBRE_3")));
            this.alumnosGuardados.add(new Alumno(5, "Gómez", "Sara", 25, 1.92, "Arquero", "PSG", (String) props.get("MUJER_3")));
            this.alumnosGuardados.add(new Alumno(6, "Ruiz", "Pedro", 25, 1.92, "Arquero", "PSG", (String) props.get("HOMBRE_2")));
            this.alumnosGuardados.add(new Alumno(7, "Pérez", "Lía", 25, 1.92, "Arquero", "PSG", (String) props.get("MUJER_2")));
            this.alumnosGuardados.add(new Alumno(8, "Suárez", "Ana", 25, 1.92, "Arquero", "PSG", (String) props.get("MUJER_4")));
            this.alumnosGuardados.add(new Alumno(9, "Mohamed", "Samuel", 25, 1.92, "Arquero", "PSG", (String) props.get("HOMBRE_4")));
        } catch (IOException ex) {
            throw new RuntimeException("No se pudieron cargar las caras fake");
        }
    }
}
