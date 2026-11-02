public class Fibonacci {
    public static final int MAX_TERMINO = 92; // el término 93 desborda un long

    private final long[] valores;
    private final boolean[] calculado;

    public Fibonacci(int n) {
        int tamanoArray = Math.max(n + 1, 2); //lo defino así para el caso especial de n=0
        valores = new long[tamanoArray];
        calculado = new boolean[tamanoArray];

        // Casos especiales: los términos 0 y 1 ya están calculados
        valores[0] = 0;
        valores[1] = 1;
        calculado[0] = true;
        calculado[1] = true; //el resto se inicializan en false
    }

    public synchronized boolean estaCalculado(int i) {
        return calculado[i];
    }

    public synchronized long getValor(int i) {
        return valores[i];
    }

    public synchronized void publicar(int i, long valor) {
        valores[i] = valor;
        calculado[i] = true;
    }
}
