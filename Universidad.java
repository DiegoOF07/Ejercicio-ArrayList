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

public class Universidad {
    private String nombre;
    private ArrayList<Sede> sedes;
    
    public Universidad() {
        this.nombre = "UVG";
        sedes = new ArrayList<Sede>();
        sedes.add(new Sede(1, "Central"));
    }

    
    /** 
     * @param idSede
     * @param nombre
     */
    public void agregarSedes(int idSede, String nombre){
        if(buscarSede(idSede)==null){
            sedes.add(new Sede(idSede, nombre));
        }else{
            System.out.println("La sede con ese id ya existe");
        }
    }

    
    /** 
     * @param id
     * @return Sede
     */
    public Sede buscarSede(int id){
        Sede miSede = null;
        for (Sede sede : sedes) {
            if(sede.getId() == id){
                miSede = sede;
            }
        }
        return miSede;
    }

    public void mostrarSedes(){
        for (Sede sede : sedes) {
            System.out.println(sede);
        }
    }

    
}
