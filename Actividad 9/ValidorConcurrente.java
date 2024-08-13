import java.util.Scanner;

public class ValidorConcurrente {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la contraseña a validar: ");
        String contraseña = scanner.nextLine();

        // Crear hilos para validar cada criterio
        Thread longitudMinima = new Thread(new ValidorCon(contraseña, "longitud mínima de 8 caracteres", ".{8,}"));
        Thread caracteresEspeciales = new Thread(new ValidorCon(contraseña, "presencia de caracteres especiales", "[^a-zA-Z0-9]"));
        Thread dosMayusculas = new Thread(new ValidorCon(contraseña, "al menos dos letras mayúsculas", "(.*[A-Z].*[A-Z])"));
        Thread tresMinusculas = new Thread(new ValidorCon(contraseña, "al menos tres letras minúsculas", "(.*[a-z].*[a-z].*[a-z])"));
        Thread unNumero = new Thread(new ValidorCon(contraseña, "al menos un número", ".*\\d.*"));

        
        longitudMinima.start();
        caracteresEspeciales.start();
        dosMayusculas.start();
        tresMinusculas.start();
        unNumero.start();

       
        try {
            longitudMinima.join();
            caracteresEspeciales.join();
            dosMayusculas.join();
            tresMinusculas.join();
            unNumero.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Validación de contraseña completada.");
    }
}
