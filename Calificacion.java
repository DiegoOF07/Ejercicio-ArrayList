public class Calificacion {
    private Estudiante estudiante;
    private Examen examen;

    public Calificacion(Estudiante estudiante, Examen examen) {
        this.estudiante = estudiante;
        this.examen = examen;
    }

    public Calificacion() {
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    @Override
    public String toString() {
        return "Calificacion obtenida de " + estudiante.getNombre()+" "+estudiante.getApellido() + " en el examen de " + examen.getMateria() +" es "+examen.getNota();
    }

    
}
