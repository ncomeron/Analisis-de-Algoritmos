package tp4_1;

public class Ejercicio2_1_f {
    
    public static long sumaNumerosPrimos(int n) {
        long suma = 0;
        int raiz; // Obtenemos la raiz del numero evaluado para recortar la busqueda
        
        // Desde [2 a N] comprobamos que sea primo, y en caso positivo, se acumula i. Caso contrario suma un cero  
        for (int i = 2; i <= n; i++) {
            raiz = (int) Math.sqrt(i);
            suma += esPrimo(i, raiz);
        }
        return suma;
    }
    
    // Metodo recursivo que devuelve el valor de x (si es primo), 0 en caso contrario
    private static int esPrimo(int x, int r) {
        int resultado;
        
        if (r == 1) // Si alcanza a 1 como divisor, quiere decir que x es primo
            resultado = x; 
        else {
            if (x % r == 0) // Si x es divisible por cualq n > 1, entonces x no es primo
                resultado = 0;
            else 
                resultado = esPrimo(x, r - 1); // Llamada recursiva reduciendo el limite
        }  
        return resultado;
    }
    
    public static void main(String[] args) {
        final int N = 10;
        System.out.println(sumaNumerosPrimos(N));
    }
}
