package tp4_1;

public class Fibonacci {
    
    public static long fib(long n) {
        long res;
        // Caso base
        if (n <= 1)
            res = n;
        else
            // Sino, paso recursivo
            res = fib(n - 1) + fib(n - 2);
        return res;
    }
    
    public static void main(String args[]) {
        final long N = 11;
        
        System.out.println(fib(N));  
    }
}
