package tp4_1;

public class Ejercicio2_1_b {
    
    private static long fibonacci(int n) {
        long resultado;
        // Caso base. Menor-Igual a 2 dado que el enunciado del problema comienza con los términos 1 y 2
        if (n <= 2)
            resultado = n;
        else
            // Sino, paso recursivo
            resultado = fibonacci(n - 1) + fibonacci(n - 2);
        return resultado;
    }
    
    public static long sumaTerminosParesFibonacci(long n) {
        long suma = 0;
        long valorTermino;
        
        for (int i = 1; i < n; i++) {
            valorTermino = fibonacci(i);
            if ((valorTermino % 2) == 0)
                suma += valorTermino;
        }
        return suma;
    }
    
    public static void main(String args[]) {
        /* Secuencia Fibonacci para los primeros diez términos (con 1 y 2 como casos base según indica el enunciado)
           1, 2, 3, 5, 8, 13, 21, 34, 55, 89 */
        
        final int N = 50;
        System.out.println(sumaTerminosParesFibonacci(N));  
        System.out.println(fibonacci(N));  
    }
}
