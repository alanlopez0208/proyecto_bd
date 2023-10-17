package operaciones;

public class Alumno {

    private int id;
    private String nombre;
    private String apellido;
    private String numControl;

    public Alumno() {
    }

    public Alumno(String nombre, String apellido, String numControl) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numControl = numControl;
    }

    public Alumno(int id, String nombre, String apellido, String numControl) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numControl = numControl;
    }

    public Alumno(Object[] alumnoObjecto) {
        if (alumnoObjecto.length != 4) {
            throw new IllegalArgumentException("El arreglo debe tener 4 elementos.");
        }
        this.id = (int) alumnoObjecto[0];
        this.numControl = (String) alumnoObjecto[1];
        this.nombre = (String) alumnoObjecto[2];
        this.apellido = (String) alumnoObjecto[3];
    }

    @Override
    public String toString() {
        return this.getNombre() + " " + this.getApellido() + " " + this.getNumControl();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumControl() {
        return numControl;
    }

    public void setNumControl(String numControl) {
        this.numControl = numControl;
    }

    public Object[] toObject() {
        return new Object[]{
            this.getId(), this.getNumControl(), this.getNombre(), this.getApellido()
        };
    }

}
