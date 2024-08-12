
import java.util.Scanner;
public class Visitante{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Capturando datos del visitante
        System.out.print("Ingrese el nombre del visitante: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el apellido del visitante: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese la edad del visitante: ");
        int edad = scanner.nextInt();

        System.out.print("Ingrese el número de documento del visitante: ");
        long numeroDocumento = scanner.nextLong();

        System.out.print("Hora de ingreso del visitante: ");
        int hora = scanner.nextInt();


        
        System.out.println("\nDatos del visitante:");
        System.out.println("Nombre completo: " + nombre + " " + apellido);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Número de documento: " + numeroDocumento);
        System.out.println("Hora de ingreso: " + hora); 
       
    }
}
