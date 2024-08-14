import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.function.Consumer;

public class ValidorCon implements Runnable {
    private String contraseña;
    private String criterio;
    private Pattern patron;
    private Consumer<String> resultadoLogger;

    public ValidorCon(String contraseña, String criterio, String regex, Consumer<String> resultadoLogger) {
        this.contraseña = contraseña;
        this.criterio = criterio;
        this.patron = Pattern.compile(regex);
        this.resultadoLogger = resultadoLogger;
    }

    @Override
    public void run() {
        String resultado = patron.matcher(contraseña).find() 
            ? "Cumple" 
            : "No cumple";
        String mensaje = "La contraseña " + resultado + " con el criterio de " + criterio;
        System.out.println(mensaje);

        
        resultadoLogger.accept("Contraseña: " + contraseña + " | " + mensaje);
    }
}
