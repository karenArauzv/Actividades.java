import java.util.Scanner;

public class CalGeoPOO {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FiguraGeometrica figura = null;

        while (true) {
            mostrarMenuPrincipal();
            int opcion = scanner.nextInt();

            if (opcion == 7) {
                break;
            }

            switch (opcion) {
                case 1: 
                    System.out.print("Ingrese el radio del círculo: ");
                    double radio = scanner.nextDouble();
                    figura = new Circulo(radio);
                    break;
                case 2: 
                    System.out.print("Ingrese el lado del cuadrado: ");
                    double lado = scanner.nextDouble();
                    figura = new Cuadrado(lado);
                    break;
              
            }

            mostrarMenuOperacion();
            int operacion = scanner.nextInt();
            
            double resultado = 0;

            if (operacion == 1) {
                resultado = figura.calcularArea();
            } else if (operacion == 2) {
                resultado = figura.calcularPerimetro();
            }

            System.out.println("El resultado es: " + resultado);
        }

        scanner.close();
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\nSelecciona la figura geométrica:");
        System.out.println("1. Círculo");
        System.out.println("2. Cuadrado");
        System.out.println("3. Triángulo");
        System.out.println("4. Rectángulo");
        System.out.println("5. Pentágono");
        System.out.println("6. Mostrar resultados");
        System.out.println("7. Salir");
        System.out.print("Ingrese el número de la figura: ");
    }

    private static void mostrarMenuOperacion() {
        System.out.println("Selecciona la operación:");
        System.out.println("1. Área");
        System.out.println("2. Perímetro");
        System.out.print("Ingrese el número de la operación: ");
    }
}
