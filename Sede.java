import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Sede {
    private int idSede;
    private String nombreSede;
    private String[] materias = {"Matemática", "Lenguaje", "Química", "Física", "Comprensión Lectora", "Estadística"}; 
    private ArrayList<Calificacion> calificaciones;
    private ArrayList<Estudiante> estudiantes;
    private Scanner sc = new Scanner(System.in);

    public Sede(int idSede, String nombreSede){
        this.idSede = idSede;
        this.nombreSede = nombreSede;
        this.calificaciones = new ArrayList<Calificacion>();
        this.estudiantes = new ArrayList<Estudiante>();
    }

    public void agregarEstudiante(String nombre, String apellido, String email, int codigoEstudiantil, String fechaNacimiento){
        Estudiante miEstudiante = null;
        if(buscarEstudiante(codigoEstudiantil)==null){
            if(!nombre.isEmpty() && !apellido.isEmpty() && !email.isEmpty() && !fechaNacimiento.isEmpty()){
                miEstudiante = new Estudiante(nombre, apellido, email, codigoEstudiantil);
                if(miEstudiante.validarFecha(fechaNacimiento)){
                    estudiantes.add(miEstudiante);
                }else{
                    System.out.println("Prueba con otra fecha de nacimiento");
                }
            }else{
                System.out.println("No todos los datos estan completos");
            }
        }else{
            System.out.println("El codigo de estudiante ingresaso ya existe");
        }
    }

    public Estudiante buscarEstudiante(int codigo){
        Estudiante miEstudiante = null;
        for (Estudiante estudiante : estudiantes) {
            if(estudiante.getCodigoEstudiantil()==codigo){
                miEstudiante = estudiante;
            }
        }
        return miEstudiante;
    }

    public void agregarCalificacion(Estudiante estudiante, Examen examen){
        Calificacion calificacion = new Calificacion(estudiante, examen);
        calificaciones.add(calificacion);
    }

    public void mostrarEstudiantes(){
        if(estudiantes.size()>0){
            for (Estudiante estudiante : estudiantes) {
                System.out.println(estudiante);
            }
        }else{
            System.out.println("No hay estudiantes todavia");
        }
    }

    public void mostrarMaterias(){
        for(int i = 0;i<materias.length;i++){
            System.out.println(String.valueOf(i+1)+". "+materias[i]);
        }
    }

    public Calificacion validarCalificacion(int codigo, String materia){
        Calificacion cal = null;
        for (Calificacion calificacion : calificaciones) {
            if(calificacion.getEstudiante().getCodigoEstudiantil()==codigo){
                if(calificacion.getExamen().getMateria().equals(materia)){
                    cal = calificacion;
                }
            }
        }
        return cal;
    }

    public void asignarNotas(){
        Examen examen = null;
        System.out.println("Se muestran todos los estudiantes disponibles");
        mostrarEstudiantes();
        System.out.print("Ingresa el codigo de estudiante: ");
        int codigo = sc.nextInt();
        sc.nextLine();
        System.out.println("Se muestran los diferentes examenes para asignar");
        mostrarMaterias();
        System.out.println("Selecciona el examen para asignar: ");
        String op = sc.nextLine();
        System.out.println("Que nota obtuvo para este examen: ");
        double nota = sc.nextDouble();
        sc.nextLine();
        if(buscarEstudiante(codigo) != null){
            if(validarCalificacion(codigo, op)==null){
                agregarCalificacion(buscarEstudiante(codigo), examen = new Examen(op, nota));
            }else{
                System.out.println("Este estudiante ya posee ese examen asignado");
            }
        }else{
            System.out.println("El estudiante que ha ingresado no existe");
        }
    }

    public double media(String materia){
        int contador = 0;
        double suma = 0;
        for (Calificacion calificacion : calificaciones) {
            if(calificacion.getExamen().getMateria().equals(materia)){
                suma=suma+calificacion.getExamen().getNota();
                contador++;
            }
        }
        if(contador != 0){
            return suma/contador;
        }else{
            return suma/1;
        }
    }

    public double mediana(String materia){
        ArrayList<Double> notas = new ArrayList<Double>();
        for (Calificacion calificacion : calificaciones) {
            if(calificacion.getExamen().getMateria().equals(materia)){
                notas.add(calificacion.getExamen().getNota());
            }
        }
        Collections.sort(notas);
        if(notas.size()%2 == 0){
            return (notas.get(notas.size()/2-1)+notas.get(notas.size()/2))/2;
        }else{
            return notas.get(notas.size()/2);
        }
    }

    

}
