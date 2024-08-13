import java.util.Scanner;

public class CalculadoraGeometrica {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int MAX_OPERACIONES = 100;
        double[] resultados = new double[MAX_OPERACIONES];
        int operacionCount = 0;

        while (true) {
            mostrarMenuPrincipal();
            int figura = obtenerEntradaEntero(scanner);

            if (figura == 7) {
                break;
            }

            if (figura == 6) {
                mostrarResultados(resultados, operacionCount);
                continue;
            }

            if (figura == 8) {
                System.out.print("Ingrese la base: ");
                double base = obtenerEntradaDouble(scanner);
                System.out.print("Ingrese el exponente: ");
                int exponente = obtenerEntradaEntero(scanner);
                double resultado = calcularPotencia(base, exponente);
                if (operacionCount < MAX_OPERACIONES) {
                    resultados[operacionCount++] = resultado;
                    System.out.println("El resultado de la potencia es: " + resultado);
                } else {
                    System.out.println("Capacidad de almacenamiento de resultados alcanzada.");
                }
                continue;
            }

            if (figura < 1 || figura > 5) {
                System.out.println("Figura no válida.");
                continue;
            }

            mostrarMenuOperacion();
            int operacion = obtenerEntradaEntero(scanner);

            if (operacion < 1 || operacion > 3) {
                System.out.println("Operación no válida.");
                continue;
            }

            double resultado = 0;

            switch (figura) {
                case 1: 
                    resultado = calcularCirculo(scanner, operacion);
                    break;
                case 2: 
                    resultado = calcularCuadrado(scanner, operacion);
                    break;
                case 3: 
                    resultado = calcularTriangulo(scanner, operacion);
                    break;
                case 4: 
                    resultado = calcularRectangulo(scanner, operacion);
                    break;
                case 5: 
                    resultado = calcularPentagono(scanner, operacion);
                    break;
            }

            if (operacionCount < MAX_OPERACIONES) {
                resultados[operacionCount++] = resultado;
                System.out.println("El resultado es: " + resultado);
            } else {
                System.out.println("Capacidad de almacenamiento de resultados alcanzada.");
            }
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
        System.out.println("8. Potencia");
        
        System.out.print("Ingrese el número de la figura: ");
    }

    private static void mostrarMenuOperacion() {
        System.out.println("Selecciona la operación:");
        System.out.println("1. Área");
        System.out.println("2. Perímetro");
        System.out.println("3. Potencia");
        System.out.print("Ingrese el número de la operación: ");
    }

    private static int obtenerEntradaEntero(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada no válida. Por favor ingrese un número entero.");
            scanner.next(); 
        }
        return scanner.nextInt();
    }

    private static double obtenerEntradaDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.println("Entrada no válida. Por favor ingrese un número.");
            scanner.next(); 
        }
        return scanner.nextDouble();
    }

    private static double calcularCirculo(Scanner scanner, int operacion) {
        System.out.print("Ingrese el radio del círculo: ");
        double radio = obtenerEntradaDouble(scanner);

        if (operacion == 1) {
            return Math.PI * radio * radio;
        } else { 
            return 2 * Math.PI * radio;
        }
    }

    private static double calcularCuadrado(Scanner scanner, int operacion) {
        System.out.print("Ingrese el lado del cuadrado: ");
        double lado = obtenerEntradaDouble(scanner);

        if (operacion == 1) {
            return lado * lado;
        } else { 
            return 4 * lado;
        }
    }

    private static double calcularTriangulo(Scanner scanner, int operacion) {
        if (operacion == 1) {
            System.out.print("Ingrese la base del triángulo: ");
            double base = obtenerEntradaDouble(scanner);
            System.out.print("Ingrese la altura del triángulo: ");
            double altura = obtenerEntradaDouble(scanner);
            return 0.5 * base * altura;
        } else { 
            System.out.print("Ingrese el primer lado del triángulo: ");
            double lado1 = obtenerEntradaDouble(scanner);
            System.out.print("Ingrese el segundo lado del triángulo: ");
            double lado2 = obtenerEntradaDouble(scanner);
            System.out.print("Ingrese el tercer lado del triángulo: ");
            double lado3 = obtenerEntradaDouble(scanner);
            return lado1 + lado2 + lado3;
        }
    }

    private static double calcularRectangulo(Scanner scanner, int operacion) {
        System.out.print("Ingrese la base del rectángulo: ");
        double base = obtenerEntradaDouble(scanner);
        System.out.print("Ingrese la altura del rectángulo: ");
        double altura = obtenerEntradaDouble(scanner);

        if (operacion == 1) {
            return base * altura;
        } else { 
            return 2 * (base + altura);
        }
    }

    private static double calcularPentagono(Scanner scanner, int operacion) {
        if (operacion == 1) {
            System.out.print("Ingrese el apotema del pentágono: ");
            double apotema = obtenerEntradaDouble(scanner);
            System.out.print("Ingrese el perímetro del pentágono: ");
            double perimetro = obtenerEntradaDouble(scanner);
            return (perimetro * apotema) / 2;
        } else { 
            System.out.print("Ingrese el lado del pentágono: ");
            double lado = obtenerEntradaDouble(scanner);
            return 5 * lado;
        }
    }

    private static double calcularPotencia(double base, int exponente) {
        if (exponente == 0) {
            return 1; 
        }
        if (exponente < 0) {
            return 1 / calcularPotencia(base, -exponente); 
        }
        return base * calcularPotencia(base, exponente - 1);
    }

    private static void mostrarResultados(double[] resultados, int count) {
        if (count == 0) {
            System.out.println("No hay resultados para mostrar.");
            return;
        }

        System.out.println("Resultados almacenados:");
        for (int i = 0; i < count; i++) {
            System.out.println("Resultado " + (i + 1) + ": " + resultados[i]);
        }
    }
}
