public class Examen {
    private String materia;
    private double nota;

    public Examen(String materia, double nota) {
        this.materia = materia;
        this.nota = nota;
    }

    public Examen(){}

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Examen de " + materia + " | nota: " + nota;
    }

    

    
}
