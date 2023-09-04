import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Estudiante {

    private String nombre, apellido, email;
    private int codigoEstudiantil;
    private Date fechaNacimiento;

    public Estudiante(String nombre, String apellido, String email, int codigoEstudiantil) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.codigoEstudiantil = codigoEstudiantil;
    }

    public Estudiante(){}

    public boolean validarFecha(String fecha){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        if(fecha.length()==10){
            try{
                this.fechaNacimiento = format.parse(fecha);
                return true;
            }catch(ParseException pE){
                System.out.println("El formato ingresado no es valido");
                System.out.println("Utiliza el formato dd/MM/yyyy");
                return false;
            }
        }else{
            System.out.println("El formato ingresado no es valido");
            System.out.println("Utiliza el formato dd/MM/yyyy");
            return false;
        }
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCodigoEstudiantil() {
        return codigoEstudiantil;
    }

    public void setCodigoEstudiantil(int codigoEstudiantil) {
        this.codigoEstudiantil = codigoEstudiantil;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return nombre+" "+apellido+ " | Fecha de nacimiento:" + fechaNacimiento
                + " | Email: " + email + " | Codigo estudiantil: " + codigoEstudiantil;
    }

    
}