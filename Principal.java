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
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    private static Universidad universidad = new Universidad();
    private static Scanner sc = new Scanner(System.in);
    private static boolean continuar = true;
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        while (continuar) {
            menuUniversidad();
        }        

    }

    public static void menuUniversidad(){
        continuar = true;
        System.out.println("\nCONTROL DE NOTAS\n");
        System.out.println("1. Agregar una nueva sede");
        System.out.println("2. Ingresar a una sede");
        System.out.println("3. Salir");
        String opcion = sc.nextLine();
        switch (opcion) {
            case "1":
                try {
                    System.out.println("\nAgrega una sede");
                    System.out.print("Ingresa el id de la sede: ");
                    int idSede = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingresa el nombre de la sede: ");
                    String nombreSede = sc.nextLine();
                    universidad.agregarSedes(idSede, nombreSede);
                } catch (InputMismatchException e) {
                    System.out.println("El id de la sede debe ser un numero");
                    sc.nextLine();
                }
                break;
            
            case "2":
                try {
                    System.out.println("\nListado de sedes");
                    universidad.mostrarSedes();
                    System.out.print("Elige una de las sedes: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    menuSede(universidad.buscarSede(id));
                } catch (InputMismatchException e) {
                    System.out.println("Solo puedes ingresar numeros, vuelve a intentarlo");
                    sc.nextLine();
                }
                break;
            
            case "3":
                continuar = false;
                break;
        
            default:
                System.out.println("Opcion invalida");
                break;
        }
    }

    
    /** 
     * @param sede
     */
    public static void menuSede(Sede sede){
        boolean seguir = true;
        while(seguir){
            try {
                System.out.println("\nBienvenido a la sede "+sede.getNombre()+"\n");
                System.out.println("1. Agregar estudiantes");
                System.out.println("2. Ver todos los estudiantes");
                System.out.println("3. Asignar un examen a un estudiante");
                System.out.println("4. Ver todas las calificaciones");
                System.out.println("5. Mostrar datos estadisticos");
                System.out.println("6. Regresar");
                System.out.print("Selecciona la opcion que desees: ");
                String opcion = sc.nextLine();
                switch (opcion) {
                    case "1":
                        try{
                            System.out.println("\nAgrega un estudiante");
                            System.out.print("Ingresa el id del estudiante: ");
                            int idEstudiante = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Ingresa el nombre del estudiante: ");
                            String nombreEstudiante = sc.nextLine();
                            System.out.print("Ingresa el apellido del estudiante: ");
                            String apellidoEstudiante = sc.nextLine();
                            System.out.print("Ingresa el email del estudiante: ");
                            String emailEstudiante = sc.nextLine();
                            System.out.println("Ingresa la fehca de nacimiento del estudiante");
                            System.out.print("Nota: Utiliza el formato dd/MM/yyyy: ");
                            String fechaNacimiento = sc.nextLine();
                            sede.agregarEstudiante(nombreEstudiante, apellidoEstudiante, emailEstudiante, idEstudiante, fechaNacimiento);
                        }catch(InputMismatchException e){
                            System.out.println("El id debe ser un dato numerico");
                            sc.nextLine();
                        }
                        break;

                    case "2":
                        System.out.println("\nListado de estudiantes de la sede "+sede.getNombre());
                        sede.mostrarEstudiantes();
                        break;

                    case "3":
                        System.out.println("\nAsignacion de notas");
                        sede.asignarNotas();
                        break;

                    case "4":
                        System.out.println("\nListado de calificaciones de la sede "+sede.getNombre());
                        sede.mostrarCalificaciones();
                        break;

                    case "5":
                        System.out.println("\nDatos estadisiticos de la sede "+sede.getNombre());
                        sede.mostrarMaterias();
                        System.out.print("Selecciona la materia de la que quieres ver los datos:");
                        int op = sc.nextInt();
                        sc.nextLine();
                        if(sede.identificarMateria(op)!=null){
                            if(sede.datosSuficientes(sede.identificarMateria(op))){
                                System.out.println("Media: "+sede.media(sede.identificarMateria(op)));
                                System.out.println("Mediana: "+sede.mediana(sede.identificarMateria(op)));
                                System.out.println("Moda: "+sede.moda(sede.identificarMateria(op)));
                                System.out.println("Desviacion Estandar: "+sede.desvEstandar(sede.identificarMateria(op)));
                                System.out.println("Nota mas alta: "+sede.notaMasAlta(sede.identificarMateria(op)));
                                System.out.println("Nota mas baja: "+sede.notaMasBaja(sede.identificarMateria(op)));
                            }else{
                                System.out.println("Datos insuficientes\nSe requieren al menos 2 datos");
                            }
                        }else{
                            System.out.println("No has seleccionado una materia valida");
                        }
                        break;

                    case "6":
                        seguir = false;
                        break;
                
                    default:
                        System.out.println("Opcion invalida");
                        break;
                }
            } catch (NullPointerException e) {
                System.out.println("El id de la sede que solicitaste no es valida");
                seguir = false;
            } 
        }
    }
}
