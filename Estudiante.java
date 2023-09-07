/**
 * @autor: Diego Oswaldo Flores Rivas - 23714
 * @version: 06/09/23b
 * 
 * Este programa tiene como objetivo llevar el control de las notas de universidad
 * que tiene la capacidad de crear sedes cada una independiente de la otra, contando con sus
 * propios alumnos y sus propias calificaciones.
 * 
 * Todas las sedes tienen las mismas materias de examenes que pueden ser asignadas
 * a los alumnos
 * 
 */
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

    
    /** 
     * @param fecha
     * @return boolean
     */
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

    
    /** 
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    
    /** 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    /** 
     * @return String
     */
    public String getApellido() {
        return apellido;
    }

    
    /** 
     * @param apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    
    /** 
     * @return String
     */
    public String getEmail() {
        return email;
    }

    
    /** 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    
    /** 
     * @return int
     */
    public int getCodigoEstudiantil() {
        return codigoEstudiantil;
    }

    
    /** 
     * @param codigoEstudiantil
     */
    public void setCodigoEstudiantil(int codigoEstudiantil) {
        this.codigoEstudiantil = codigoEstudiantil;
    }

    
    /** 
     * @return Date
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    
    /** 
     * @param fechaNacimiento
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return nombre+" "+apellido+ " | Fecha de nacimiento: " + fechaNacimiento
                + " | Email: " + email + " | Codigo estudiantil: " + codigoEstudiantil;
    }

    
}