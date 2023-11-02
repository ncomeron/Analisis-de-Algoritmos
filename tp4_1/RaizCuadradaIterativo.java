package tp4_1;

public class RaizCuadradaIterativo {
    
    public static void main(String[] args) {
        System.out.println(parteEnteraRaizCuadrada(92312));
    }
    
    public static int parteEnteraRaizCuadrada(double numero) {
        long tiempoInicial = System.nanoTime();
        double auxiliar;
        double raizCuadrada = numero / 2;
        
        do {
            auxiliar = raizCuadrada;
            raizCuadrada = (auxiliar + (numero / auxiliar)) / 2;
        }
        while ((auxiliar - raizCuadrada) != 0);
        
        long tiempoFinal = System.nanoTime() - tiempoInicial;
        System.out.println("Tiempo empirico: "+(tiempoFinal)+" nanosegundos");
        
        return (int)raizCuadrada;
    }
}
