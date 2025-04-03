package MVC.Vista;

import MVC.Modelo.MisionNinja;
import MVC.Modelo.Ninja;
import java.util.List;
import java.util.Scanner;

public class Vista {
    Scanner sc = new Scanner(System.in);
    
    public void mostrarNinjas(List<Ninja> ninja){
        System.out.println("Lista de Ninjas:");
        for (Ninja n : ninja){
            System.out.println(n);
        }
    }
    
    public MisionNinja agregarMision(){
        System.out.println("Para agg una mision al ninja digite lo sgte:");
        System.out.println("Id del ninja: ");
        int id_ninja = sc.nextInt();
        System.out.println("Ide de la mision: ");
        int id_mision = sc.nextInt();
        System.out.println("Recompensa de la: ");
        String fechaInicio = sc.nextLine();
        System.out.println("Recompensa de la: ");
        String fechaFin = sc.nextLine();
        return new MisionNinja(id_ninja, id_mision, fechaInicio, fechaFin);
    }
}
