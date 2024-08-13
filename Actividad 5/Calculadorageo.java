import java.util.Scanner;
public class Calculadorageo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecciona la figura geométrica:");
        System.out.println("1. Círculo");
        System.out.println("2. Cuadrado");
        System.out.println("3. Triángulo");
        System.out.println("4. Rectángulo");
        System.out.println("5. Pentágono");
        System.out.print("Ingrese el número de la figura: ");
        int figura = scanner.nextInt();

        System.out.println("Selecciona la operación:");
        System.out.println("1. Área");
        System.out.println("2. Perímetro");
        System.out.print("Ingrese el número de la operación: ");
        int operacion = scanner.nextInt();

        double resultado = 0;

        switch (figura) {
            case 1 -> { 
                if (operacion == 1) {
                    System.out.print("Ingrese el radio del círculo: ");
                    double radio = scanner.nextDouble();
                    resultado = Math.PI * radio * radio;
                } else if (operacion == 2) {
                    System.out.print("Ingrese el radio del círculo: ");
                    double radio = scanner.nextDouble();
                    resultado = 2 * Math.PI * radio;
                } else {
                    System.out.println("Operación no válida.");
                }
            }

            case 2 -> { 
                if (operacion == 1) {
                    System.out.print("Ingrese el lado del cuadrado: ");
                    double lado = scanner.nextDouble();
                    resultado = lado * lado;
                } else if (operacion == 2) {
                    System.out.print("Ingrese el lado del cuadrado: ");
                    double lado = scanner.nextDouble();
                    resultado = 4 * lado;
                } else {
                    System.out.println("Operación no válida.");
                }
            }

            case 3 -> { 
                if (operacion == 1) {
                    System.out.print("Ingrese la base del triángulo: ");
                    double base = scanner.nextDouble();
                    System.out.print("Ingrese la altura del triángulo: ");
                    double altura = scanner.nextDouble();
                    resultado = 0.5 * base * altura;
                } else if (operacion == 2) {
                    System.out.print("Ingrese el primer lado del triángulo: ");
                    double lado1 = scanner.nextDouble();
                    System.out.print("Ingrese el segundo lado del triángulo: ");
                    double lado2 = scanner.nextDouble();
                    System.out.print("Ingrese el tercer lado del triángulo: ");
                    double lado3 = scanner.nextDouble();
                    resultado = lado1 + lado2 + lado3;
                } else {
                    System.out.println("Operación no válida.");
                }
            }

            case 4 -> { 
                if (operacion == 1) {
                    System.out.print("Ingrese la base del rectángulo: ");
                    double base = scanner.nextDouble();
                    System.out.print("Ingrese la altura del rectángulo: ");
                    double altura = scanner.nextDouble();
                    resultado = base * altura;
                } else if (operacion == 2) {
                    System.out.print("Ingrese la base del rectángulo: ");
                    double base = scanner.nextDouble();
                    System.out.print("Ingrese la altura del rectángulo: ");
                    double altura = scanner.nextDouble();
                    resultado = 2 * (base + altura);
                } else {
                    System.out.println("Operación no válida.");
                }
            }

            case 5 -> { 
                if (operacion == 1) {
                    System.out.print("Ingrese el apotema del pentágono: ");
                    double apotema = scanner.nextDouble();
                    System.out.print("Ingrese el perímetro del pentágono: ");
                    double perimetro = scanner.nextDouble();
                    resultado = (perimetro * apotema) / 2;
                } else if (operacion == 2) {
                    System.out.print("Ingrese el lado del pentágono: ");
                    double lado = scanner.nextDouble();
                    resultado = 5 * lado;
                } else {
                    System.out.println("Operación no válida.");
                }
            }

            default -> System.out.println("Figura no válida.");
        }

        if (resultado != 0) {
            System.out.println("El resultado es: " + resultado);
        }

        scanner.close();
    }
}
