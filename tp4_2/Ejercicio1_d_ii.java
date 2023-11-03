package tp4_2;

public class Ejercicio1_d_ii {
    
    public static void main(String[] args) {
        final int cantSemanas = 3; 
        System.out.println(calcularMulta(cantSemanas));
    }
    
    private static double calcularMulta (int cantSemanas) {
        double valorMulta;
        
        if (cantSemanas < 1) 
            valorMulta = 4000;
        else
            valorMulta = calcularMulta(cantSemanas - 1) * 1.05;
    
        return valorMulta;
    }  
}
