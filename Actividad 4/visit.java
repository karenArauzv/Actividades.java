import java.util.Scanner;

public class visit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del visitante: ");
        String nombre = scanner.nextLine();
    
        int totalVisitas = 0;
        int tiempoTotalEstadía = 0;

        
        for (int dia = 1; dia <= 7; dia++) {
            System.out.println("\nDía " + dia);

            int visitasDia = 0;
            while (true) {
                System.out.print("Hora de ingreso (0 para terminar): ");
                int horaIngreso = scanner.nextInt();
                if (horaIngreso == 0) {
                    break;
                }

                System.out.print("Hora de salida: ");
                int horaSalida = scanner.nextInt();

                while (horaSalida <= horaIngreso) {
                    System.out.println("Hora de salida debe ser mayor a hora de ingreso.");
                    System.out.print("Ingrese nuevamente la hora de salida: ");
                    horaSalida = scanner.nextInt();
                }

                visitasDia++;
                totalVisitas++;
                tiempoTotalEstadía += horaSalida - horaIngreso;
            }

            System.out.println("Visitas en el día " + dia + ": " + visitasDia);
        }

        double tiempoPromedio = (double) tiempoTotalEstadía / totalVisitas;
        System.out.println("\nResumen del visitante " + nombre);
        System.out.println("Total de visitas: " + totalVisitas);
        System.out.println("Tiempo promedio de estadía: " + tiempoPromedio + " horas");
        System.out.println("Es mayor de edad: " + (edad >= 18));
    }
}
