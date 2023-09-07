package tp2_1;

public class Ejercicio2_3 {
    
    private static final int N = 10000;
    
    public static void main(String[] args) {
        long[] a = new long[N];
        long sum = 0;
        
        long tiempoInicial = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += j;    
            }
            a[i] = sum;
            System.out.println("a["+i+"]: "+a[i]);
        }
        long tiempoFinal = System.currentTimeMillis() - tiempoInicial;
        
        System.out.println("sum: "+sum);
        System.out.println("Tiempo empirico: "+(tiempoFinal/1000.0)+" segundos");
    }
}
