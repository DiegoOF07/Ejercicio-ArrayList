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
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
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

    
    /** 
     * @param nombre
     * @param apellido
     * @param email
     * @param codigoEstudiantil
     * @param fechaNacimiento
     */
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

    
    /** 
     * @param codigo
     * @return Estudiante
     */
    public Estudiante buscarEstudiante(int codigo){
        Estudiante miEstudiante = null;
        for (Estudiante estudiante : estudiantes) {
            if(estudiante.getCodigoEstudiantil()==codigo){
                miEstudiante = estudiante;
            }
        }
        return miEstudiante;
    }

    
    /** 
     * @param estudiante
     * @param examen
     */
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

    public void mostrarCalificaciones(){
        if(calificaciones.size()>0){
            for (Calificacion calificacion : calificaciones) {
                System.out.println(calificacion);
            }
        }else{
            System.out.println("No hay calificaciones todavia");
        }
    }

    public void mostrarMaterias(){
        for(int i = 0;i<materias.length;i++){
            System.out.println(String.valueOf(i+1)+". "+materias[i]);
        }
    }

    
    /** 
     * @param codigo
     * @param materia
     * @return Calificacion
     */
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
        try{
            System.out.println("Se muestran todos los estudiantes disponibles");
            mostrarEstudiantes();
            System.out.print("Ingresa el codigo de estudiante: ");
            int codigo = sc.nextInt();
            sc.nextLine();
            System.out.println("Se muestran los diferentes examenes para asignar");
            mostrarMaterias();
            System.out.println("Selecciona el examen para asignar: ");
            int op = sc.nextInt();
            sc.nextLine();
            System.out.println("Que nota obtuvo para este examen: ");
            double nota = sc.nextDouble();
            sc.nextLine();
            if(buscarEstudiante(codigo) != null){
                if(identificarMateria(op) != null){
                    if(validarCalificacion(codigo, identificarMateria(op))==null){
                        agregarCalificacion(buscarEstudiante(codigo), examen = new Examen(identificarMateria(op), nota));
                    }else{
                        System.out.println("Este estudiante ya posee ese examen asignado");
                    }
                }else{
                    System.out.println("La materia que has seleccionado no existe");
                }
            }else{
                System.out.println("El estudiante que ha ingresado no existe");
            }
        }catch(InputMismatchException e){
            System.out.println("Has ingresado mal los datos");
            sc.nextLine();
        }
    }

    
    /** 
     * @param materia
     * @return boolean
     */
    public boolean datosSuficientes(String materia){
        ArrayList<Double> notas = new ArrayList<Double>();
        for (Calificacion calificacion : calificaciones) {
            if(calificacion.getExamen().getMateria().equals(materia)){
                notas.add(calificacion.getExamen().getNota());
            }
        }
        if(notas.size()>1){
            return true;
        }else{
            return false;
        }
    }

    
    /** 
     * @param op
     * @return String
     */
    public String identificarMateria(int op){
        try{
            return materias[op-1];
        }catch(IndexOutOfBoundsException e){
            return null;
        }catch (InputMismatchException e){
            return null;
        }
    }

    
    /** 
     * @param materia
     * @return double
     */
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

    
    /** 
     * @param materia
     * @return double
     */
    public double mediana(String materia){
        try {
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
        } catch (Exception e) {
            return 0;
        }
        
    }

    
    /** 
     * @param materia
     * @return double
     */
    public double moda(String materia){
        int frecuencia = 0;
        int frecuenciaAnt = 0;
        double moda = 0;
        ArrayList<Double> notas = new ArrayList<Double>();
        for (Calificacion calificacion : calificaciones) {
            if(calificacion.getExamen().getMateria().equals(materia)){
                notas.add(calificacion.getExamen().getNota());
            }
        }
        for(int i = 0; i<notas.size(); i++){
           frecuencia = Collections.frequency(notas, notas.get(i));
           if(frecuencia>frecuenciaAnt){
                moda = notas.get(i);
                frecuenciaAnt = frecuencia;
           }
        }
        return moda;
    }

    
    /** 
     * @param materia
     * @return double
     */
    public double desvEstandar(String materia){
        double total = 0;
        ArrayList<Double> notas = new ArrayList<Double>();
        for (Calificacion calificacion : calificaciones) {
            if(calificacion.getExamen().getMateria().equals(materia)){
                notas.add(calificacion.getExamen().getNota());
            }
        }

        for (Double nota : notas) {
            total = total + Math.pow((nota-media(materia)), 2);            
        }
        return Math.sqrt(total/(notas.size()-1));
    }

    public double notaMasAlta(String materia){
        ArrayList<Double> notas = new ArrayList<Double>();
        for (Calificacion calificacion : calificaciones) {
            if(calificacion.getExamen().getMateria().equals(materia)){
                notas.add(calificacion.getExamen().getNota());
            }
        }
        Collections.sort(notas, Collections.reverseOrder());
        return notas.get(0);
    }

    public double notaMasBaja(String materia){
        ArrayList<Double> notas = new ArrayList<Double>();
        for (Calificacion calificacion : calificaciones) {
            if(calificacion.getExamen().getMateria().equals(materia)){
                notas.add(calificacion.getExamen().getNota());
            }
        }
        Collections.sort(notas);
        return notas.get(0);
    }

    
    /** 
     * @return int
     */
    public int getId(){
        return idSede;
    }

    
    /** 
     * @return String
     */
    public String getNombre(){
        return this.nombreSede;
    }
    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Sede: | " + idSede + " | " + nombreSede;
    }
    
    
    

}
