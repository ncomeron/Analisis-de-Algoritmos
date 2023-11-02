package tp4_1;
     
public class RaizCuadradaRecursivo {
    
    private static int parteEnteraRaizCuadrada(int izq, int der, int N) {
        int resultado = 0;
        
        // Realiza el calculo basándose en búsqueda binaria, mientras el rango sea válido
        if (izq <= der) {
            int medio = (int)(izq + der) / 2;
            
            // Caso base
            if ((medio * medio <= N) && ((medio + 1) * (medio + 1) > N)) 
                resultado = medio;
            // Sino, caso recursivo
            else {
                if (medio * medio < N) 
                    resultado = parteEnteraRaizCuadrada(medio + 1, der, N);
                else 
                    resultado = parteEnteraRaizCuadrada(izq, medio - 1, N);
            }
        }
        return resultado;
    }
    
    public static void main (String[] args) {
        int N = 92312;
        
        long tiempoInicial = System.nanoTime();
            parteEnteraRaizCuadrada(0, N, N);
        long tiempoFinal = System.nanoTime() - tiempoInicial;
        
        System.out.println(parteEnteraRaizCuadrada(0, N, N));
        System.out.println("Tiempo empirico: "+tiempoFinal+" nanosegundos");   
    }
}