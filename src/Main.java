import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Número de Fibonacci a calcular: ");
        int n = sc.nextInt();

        if (n < 0 || n > Fibonacci.MAX_TERMINO) {
            System.out.println("El número debe estar entre 0 y " + Fibonacci.MAX_TERMINO + ".");
            return;
        }

        Fibonacci fib = new Fibonacci(n);

        // Una hebra por término, del 2 al N (los términos 0 y 1 son casos especiales)
        HebraFibonacci[] hebras = new HebraFibonacci[Math.max(n - 1, 0)];
        for (int i = 0; i < hebras.length; i++) {
            hebras[i] = new HebraFibonacci(fib, i + 2);
        }

        for (HebraFibonacci h : hebras) {
            h.start();
        }

        // El main espera a que todas las hebras terminen
        for (HebraFibonacci h : hebras) {
            h.join();
        }

        System.out.println("**************");
        System.out.println("FIBONACCI " + n + ": " + fib.getValor(n));
    }
}