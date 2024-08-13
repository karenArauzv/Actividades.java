public class Potencia implements OperacionMatematica {
    private double base;
    private int exponente;

    public Potencia(double base, int exponente) {
        this.base = base;
        this.exponente = exponente;
    }

    @Override
    public double ejecutarOperacion() {
        return Math.pow(base, exponente);
    }
}
