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
public class Examen {
    private String materia;
    private double nota;

    public Examen(String materia, double nota) {
        this.materia = materia;
        this.nota = nota;
    }

    public Examen(){}

    
    /** 
     * @return String
     */
    public String getMateria() {
        return materia;
    }

    
    /** 
     * @param materia
     */
    public void setMateria(String materia) {
        this.materia = materia;
    }

    
    /** 
     * @return double
     */
    public double getNota() {
        return nota;
    }

    
    /** 
     * @param nota
     */
    public void setNota(double nota) {
        this.nota = nota;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Examen de " + materia + " | nota: " + nota;
    }

    

    
}
