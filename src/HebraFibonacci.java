public class HebraFibonacci extends Thread {
    private final Fibonacci fib;
    private final int termino;

    public HebraFibonacci(Fibonacci fib, int termino) {
        super("Hebra-" + termino);
        this.fib = fib;
        this.termino = termino;
    }

    // Espera activa: repite la comprobación hasta que el término esté calculado
    private void esperarTermino(int i) {
        while (!fib.estaCalculado(i)) {
            Thread.yield();
        }
    }

    @Override
    public void run() {
        esperarTermino(termino - 1);
        esperarTermino(termino - 2);

        long valor = fib.getValor(termino - 1) + fib.getValor(termino - 2);
        System.out.println("Fibonacci " + termino + ": " + valor);
        fib.publicar(termino, valor); // se publica después de imprimir para mantener el orden
    }
}
