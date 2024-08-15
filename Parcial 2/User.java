import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

class Usuario {
    private String nombre;
    private String correo;
    private String contraseña;

    public Usuario(String nombre, String correo, String contraseña) {
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}

class ValidadorDeUsuario {
    public static boolean validarNombre(String nombre) {
        return Pattern.matches("[a-zA-Z\\s]{3,50}", nombre);
    }

    public static boolean validarCorreo(String correo) {
        return Pattern.matches("^[\\w-.]+@[\\w-]+\\.[a-z]{2,6}$", correo);
    }

    public static boolean validarContraseña(String contraseña) {
        return Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$", contraseña);
    }
}

class RegistroDeUsuarios {
    private List<Usuario> usuarios;

    public RegistroDeUsuarios() {
        usuarios = new ArrayList<>();
    }

    public boolean registrarUsuario(String nombre, String correo, String contraseña) {
        if (ValidadorDeUsuario.validarNombre(nombre) &&
            ValidadorDeUsuario.validarCorreo(correo) &&
            ValidadorDeUsuario.validarContraseña(contraseña)) {
            
            Usuario usuario = new Usuario(nombre, correo, contraseña);
            usuarios.add(usuario);
            System.out.println("Usuario registrado exitosamente: " + usuario);
            return true;
        } else {
            System.out.println("Error en la validación. Usuario no registrado.");
            return false;
        }
    }

    public void mostrarUsuarios() {
        System.out.println("Usuarios registrados:");
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }
}

public class User {  
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RegistroDeUsuarios registro = new RegistroDeUsuarios();
        
        while (true) {
            System.out.println("Ingrese el nombre del usuario:");
            String nombre = scanner.nextLine();
            
            System.out.println("Ingrese el correo electrónico:");
            String correo = scanner.nextLine();
            
            System.out.println("Ingrese la contraseña:");
            String contraseña = scanner.nextLine();
            
            registro.registrarUsuario(nombre, correo, contraseña);
            
            System.out.println("¿Desea registrar otro usuario? (si/no):");
            String continuar = scanner.nextLine();
            if (!continuar.equalsIgnoreCase("si")) {
                break;
            }
        }
        
        registro.mostrarUsuarios();
        scanner.close();
    }
}
