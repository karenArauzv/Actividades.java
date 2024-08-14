public class Producto {
    private String nombre;
    private int cantidadInicial;
    private int cantidadDisponible;
    private double precio;

    public Producto(String nombre, int cantidadInicial, double precio) {
        this.nombre = nombre;
        this.cantidadInicial = cantidadInicial;
        this.cantidadDisponible = cantidadInicial;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadInicial() {
        return cantidadInicial;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public double getPrecio() {
        return precio;
    }
}
