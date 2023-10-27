package tp2_2;

public class Ejercicio3_2 {
    
    public static void main(String[] args) {
        System.out.println(parteEnteraRaizCuadrada(100));
    }
    
    public static int parteEnteraRaizCuadrada(double numero){
        double auxiliar;
        double raizCuadrada = numero / 2;
        
        do {
            auxiliar = raizCuadrada;
            raizCuadrada = (auxiliar + (numero / auxiliar)) / 2;
        }
        while ((auxiliar - raizCuadrada) != 0);
        
        return (int)raizCuadrada;
    }
}
