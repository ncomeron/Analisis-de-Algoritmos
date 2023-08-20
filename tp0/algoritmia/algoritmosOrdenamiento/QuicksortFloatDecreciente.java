package tp0.algoritmia.algoritmosOrdenamiento;

public class QuicksortFloatDecreciente {
    
    public static void intercambiar (float[] arreglo, int i, int j) {
        float temp = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = temp;
    }
 
    public static int particion(float[] a, int inicio, int fin) {
        //Elemento más a la derecha como pivote
        float pivote = a[fin];
 
        //Los elementos menores que el pivote serán empujados a la izquierda de indicePivote
        //Los elementos mayores que el pivote serán empujados a la derecha de indicePivote
        int indicePivote = inicio;
 
        //Cuando encontramos un elemento mayor o igual que el pivote, indicePivote se incrementa, y ese elemento se colocaría
        //despues del pivote.
        for (int i = inicio; i < fin; i++) {
            if (a[i] >= pivote) {
                intercambiar(a, i, indicePivote);
                indicePivote++;
            }
        }
 
        // Intercambiar indicePivote con pivote
        intercambiar(a, fin, indicePivote);
 
        //Retorna indicePivote (índice del elemento pivote)
        return indicePivote;
    }
 
    public static void quicksort(float[] a, int inicio, int fin) {
        if (inicio >= fin) 
            return;
        
        //Ordenar los elementos a través del pivote
        int pivote = particion(a, inicio, fin);
 
        //Llamada recursiva que contiene un subrreglo con elementos menores que el pivote
        quicksort(a, inicio, pivote - 1);
 
        //Llamada recursiva que contiene un subrreglo con elementos mayores que el pivote
        quicksort(a, pivote + 1, fin);
    }
}
