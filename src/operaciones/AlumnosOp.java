package operaciones;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author 
 */
public class AlumnosOp {

    private final Conexion conectar;
    private final String strObtAlumnos = "SELECT * FROM alumnos";
    private final String strObtAlumno = "SELECT * FROM alumnos WHERE id = ?";
    private final String strInsertAlumno = "INSERT INTO alumnos(numero_control,nombre,apellido) VALUES(?,?,?)";
    private final String strAcualizarAlumno = "UPDATE alumnos SET numero_control = ?, nombre = ?, apellido = ? WHERE id = ?";
    private final String strEliminarALumno = "DELETE FROM alumnos WHERE id = ?";

    public AlumnosOp() {
        conectar = new Conexion();
    }

    public ArrayList<Alumno> obtenerAlumnos() {

        ArrayList<Alumno> alumnos = new ArrayList<>();

        try {
            PreparedStatement ps = conectar.getConexion().prepareStatement(strObtAlumnos);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Alumno alumno = new Alumno();

                alumno.setId(rs.getInt("id"));
                alumno.setNumControl(rs.getString("numero_control"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido(rs.getString("apellido"));

                alumnos.add(alumno);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error:" + e);
        }

        return alumnos;
    }

    public Alumno obtenerAlumno(int id) {

        Alumno alumno = new Alumno();

        try {
            PreparedStatement ps = conectar.getConexion().prepareStatement(strObtAlumno);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                alumno.setId(rs.getInt("id"));
                alumno.setNumControl(rs.getString("numero_control"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido(rs.getString("apellido"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error:" + e);
        }

        return alumno;
    }

    public ArrayList<Alumno> obtenerAlumnosSubfijo(String busqueda, String dato) {
        String sentencia = "SELECT * FROM alumnos WHERE " + busqueda + " LIKE '" + dato + "%'";
        ArrayList<Alumno> alumnos = new ArrayList<>();

        try {
            PreparedStatement ps = conectar.getConexion().prepareStatement(sentencia);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                 Alumno alumno = new Alumno();
                 alumno.setId(rs.getInt("id"));
                alumno.setNumControl(rs.getString("numero_control"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido(rs.getString("apellido"));
                
                alumnos.add(alumno);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error:" + e);
        }

        return alumnos;
    }

    public void insertarAlumno(Alumno alumno) {
        try {
            PreparedStatement ps = conectar.getConexion().prepareStatement(strInsertAlumno);
            ps.setString(1, alumno.getNumControl());
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getApellido());

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Inserción exitosa. Filas afectadas: " + filasAfectadas);
            } else {
                System.out.println("La inserción no tuvo éxito.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error:" + e);
        }

    }

    public void actualizarAlumno(int id, Alumno alumno) {
        try {
            PreparedStatement ps = conectar.getConexion().prepareStatement(strAcualizarAlumno);
            ps.setString(1, alumno.getNumControl());
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getApellido());
            ps.setInt(4, id);
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Actualizacion exitosa. Filas afectadas: " + filasAfectadas);
            } else {
                System.out.println("La Actualizacion no tuvo éxito.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error:" + e);
        }

    }

    public void eliminarAlumno(int id) {

        try {
            PreparedStatement ps = conectar.getConexion().prepareStatement(strEliminarALumno);
            ps.setInt(1, id);

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Eliminacion exitosa. Filas afectadas: " + filasAfectadas);
            } else {
                System.out.println("La Eliminacion no tuvo éxito.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error:" + e);
        }

    }
}
