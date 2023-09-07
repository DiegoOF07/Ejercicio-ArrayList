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
public class Calificacion {
    private Estudiante estudiante;
    private Examen examen;

    public Calificacion(Estudiante estudiante, Examen examen) {
        this.estudiante = estudiante;
        this.examen = examen;
    }

    public Calificacion() {
    }

    
    /** 
     * @return Estudiante
     */
    public Estudiante getEstudiante() {
        return estudiante;
    }

    
    /** 
     * @param estudiante
     */
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    
    /** 
     * @return Examen
     */
    public Examen getExamen() {
        return examen;
    }

    
    /** 
     * @param examen
     */
    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Calificacion obtenida de " + estudiante.getNombre()+" "+estudiante.getApellido() + " en el examen de " + examen.getMateria() +" es "+examen.getNota();
    }

    
}
