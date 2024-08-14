
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.function.Consumer;

public class ValidorConcurrente {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la contraseña a validar: ");
        String contraseña = scanner.nextLine();

    
        String archivoRegistro = "registro_validaciones.txt";

        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoRegistro, true))) {
            Consumer<String> resultadoLogger = resultado -> {
                try {
                    writer.write(resultado);
                    writer.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            };

            Thread longitudMinima = new Thread(new ValidorCon(contraseña, "longitud mínima de 8 caracteres", ".{8,}", resultadoLogger));
            Thread caracteresEspeciales = new Thread(new ValidorCon(contraseña, "presencia de caracteres especiales", "[^a-zA-Z0-9]", resultadoLogger));
            Thread dosMayusculas = new Thread(new ValidorCon(contraseña, "al menos dos letras mayúsculas", "(.*[A-Z].*[A-Z])", resultadoLogger));
            Thread tresMinusculas = new Thread(new ValidorCon(contraseña, "al menos tres letras minúsculas", "(.*[a-z].*[a-z].*[a-z])", resultadoLogger));
            Thread unNumero = new Thread(new ValidorCon(contraseña, "al menos un número", ".*\\d.*", resultadoLogger));

           
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

            System.out.println("Validación de contraseña completada. Resultados guardados en " + archivoRegistro);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
