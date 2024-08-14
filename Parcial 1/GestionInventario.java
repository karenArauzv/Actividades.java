import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GestionInventario {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, Producto> inventario = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Ingresar nuevo producto");
            System.out.println("2. Vender producto");
            System.out.println("3. Duplicar inventario si está agotado");
            System.out.println("4. Mostrar información del inventario");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    ingresarProducto();
                    break;
                case "2":
                    venderProducto();
                    break;
                case "3":
                    duplicarInventario();
                    break;
                case "4":
                    mostrarInventario();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
            System.out.println();
        }
    }

    private static void ingresarProducto() {
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Cantidad inicial: ");
        int cantidadInicial = Integer.parseInt(scanner.nextLine());
        System.out.print("Precio: ");
        double precio = Double.parseDouble(scanner.nextLine());

        Producto producto = new Producto(nombre, cantidadInicial, precio);
        inventario.put(nombre, producto);
    }

    private static void venderProducto() {
        System.out.print("Nombre del producto a vender: ");
        String nombre = scanner.nextLine();
        System.out.print("Cantidad a vender: ");
        int cantidadVendida = Integer.parseInt(scanner.nextLine());

        Producto producto = inventario.get(nombre);
        if (producto != null) {
            if (producto.getCantidadDisponible() >= cantidadVendida) {
                producto.setCantidadDisponible(producto.getCantidadDisponible() - cantidadVendida);
                System.out.println("Venta realizada. Cantidad disponible ahora: " + producto.getCantidadDisponible());
            } else {
                System.out.println("No hay suficiente stock de " + nombre + ".");
            }
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void duplicarInventario() {
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();

        Producto producto = inventario.get(nombre);
        if (producto != null) {
            if (producto.getCantidadDisponible() == 0) {
                producto.setCantidadDisponible(producto.getCantidadInicial() * 2);
                System.out.println("Inventario duplicado para " + nombre + ".");
            } else {
                System.out.println("El producto " + nombre + " aún tiene stock disponible.");
            }
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void mostrarInventario() {
        for (Producto producto : inventario.values()) {
            System.out.println("Producto: " + producto.getNombre());
            System.out.println("Cantidad Inicial: " + producto.getCantidadInicial());
            System.out.println("Cantidad Disponible: " + producto.getCantidadDisponible());
            System.out.println("Precio: $" + producto.getPrecio());
            System.out.println();
        }
    }
}
