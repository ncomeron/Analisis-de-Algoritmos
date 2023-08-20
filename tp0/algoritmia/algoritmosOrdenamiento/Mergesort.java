package tp0.algoritmia.algoritmosOrdenamiento;

public class Mergesort {

    public static void mergesort(int a[], int izq, int der){
        if (izq < der){
            int m = (izq + der) / 2;
            mergesort(a, izq, m);
            mergesort(a, m + 1, der);                                                                                
            merge(a, izq, m, der);                                                                                 
        }
    }
    
    public static void merge(int a[], int izq, int m, int der){
        int i, j, k;
        int [] aux = new int[a.length]; //Areglo auxiliar.
        for (i = izq; i <= der; i++) {      //Copia ambas mitades en el arreglo auxiliar.                                       
            aux[i] = a[i];
        }

        i = izq; 
        j = m + 1; 
        k = izq;
     
        while ((i <= m) && (j <= der)) {    //Copia el siguiente elemento más grande.                                      
            if (aux[i] <= aux[j])
                a[k++] = aux[i++];
            else
                a[k++] = aux[j++];
        }
        
        while (i <= m) {            //Copia los elementos que quedan de la primera mitad (si los hay).
            a[k++] = aux[i++];
        }
    }
}