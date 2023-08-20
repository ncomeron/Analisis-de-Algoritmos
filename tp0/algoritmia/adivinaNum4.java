package tp0.algoritmia;

import java.util.Random;
import java.util.Scanner;

// Este metodo genera un numero entero en forma aleatoria dentro de un rango, y luego trata de adivinar el numero 
// de forma aleatoria tambien, indicandole si es mayor o menor hasta poder adivinarlo
public class adivinaNum4 {
 public static void main(String [ ] args){
     int min,max;
     Scanner s=new Scanner(System.in);
     System.out.println("Ingresar limite inferior");
     min= s.nextInt();
     System.out.println("Ingresar limite superior");
     max=s.nextInt();
     Random r=new Random();
     adivinaNum(r,min,max);
 }   
  private static int generaNumRandom(Random r, int min, int max) {
        return  r.nextInt(max - min + 1) + min ;
    }
  private static void adivinaNum(Random r,int min,int max){
      int num=generaNumRandom(r,min,max),otro;
      boolean exito=false;
      while(!exito){
          otro= generaNumRandom(r,min,max);
          if(otro>num){
              System.out.println("Es mayor");
          }else{
              if(otro<num){
                  System.out.println("Es menor");
              }else{
                
                  System.out.println("Adivino el numero!!!");
                  exito=true;
              }
          }
             
      }