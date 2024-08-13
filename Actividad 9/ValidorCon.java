import java.util.regex.Pattern;

public class ValidorCon implements Runnable {
    private String contraseña;
    private String criterio;
    private Pattern patron;

    public ValidorCon(String contraseña, String criterio, String regex) {
        this.contraseña = contraseña;
        this.criterio = criterio;
        this.patron = Pattern.compile(regex);
    }

    @Override
    public void run() {
        if (patron.matcher(contraseña).find()) {
            System.out.println("La contraseña cumple con el criterio de " + criterio);
        } else {
            System.out.println("La contraseña NO cumple con el criterio de " + criterio);
        }
    }
}
