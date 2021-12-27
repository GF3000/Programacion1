import java.util.Arrays; //Usado para los comprobadores automáticos

//Soluciones del Examen de Programacion 1
//Fecha: 16/12/2021
//Autor: Guillermo Franco Gimeno
//USO: ExamenP1_misSoluciones ex = new ExamenP1_misSoluciones()

class ExamenP1_misSoluciones{
  
  
  //Funcion dada
  public static boolean esVocal(char cas){
    return cas == 'a' || cas == 'e' || cas == 'i' || cas == 'o' || cas == 'u'; 
  }
  
  //Ejercicio 1
  public static boolean todasVocal(char [] col){
    Boolean bTodasVocal = true;
    for( int i =0; i< col.length && bTodasVocal; i++){
      bTodasVocal = esVocal (col[i]);
    }
    return bTodasVocal;
  
  }
  
  //Ejercicio 2
  public static int[] elementosPosImpar (int [] col){
    int longitud = col.length/2;
    int[] arrImpar = new int [longitud];
    for (int i = 0; i<longitud; i++){
      arrImpar[i] = col[2*i +1];
    }
    return arrImpar;
  }
  
  //Ejercicio 3: Con bucles
  public static boolean hayTresVocales (char [] col){
    int contadorVocales = 0;
    Boolean bTresVocales = false;
    for (int i = 0; i< col.length && !bTresVocales;i++){
      if (esVocal(col[i])){
        contadorVocales++;
        bTresVocales = contadorVocales >= 3;
  
      }
    }
    return bTresVocales;
  }

  //Ejercicio 4: Con recursividad. Requiere funcion auxiliar
  public static boolean hayTresVocalesRec (char [] col){
  
    return (contarVocalPos(col, 0) >= 3);
  }
  
  public static int contarVocalPos(char[] col, int pos){
    if (pos >= col.length){ return 0;}
    else{
      if(esVocal(col[pos])){
        return 1 + contarVocalPos(col, pos +1);
      }else{
        return contarVocalPos (col, pos +1);
      }
    }
  }
  
  public static void main (String[] args){

    //Comprobadores Ejercicio 1
    
    char[] arr1_1 = {'e', 't', '5'};
    char[] arr1_2 = {'e', 'i'};
    char[] arr1_3 = {};

    Boolean prueba1_1 = !todasVocal (arr1_1);
    Boolean  prueba1_2 = todasVocal (arr1_2);
    Boolean  prueba1_3 = todasVocal (arr1_3);

    //Comprobadores Ejercicio 2

    int[] arr2_1 = {2,6,5,4};
    int[] arr2_2 = {2,6,5};

    Boolean prueba2_1 = Arrays.toString(elementosPosImpar(arr2_1)).equals("[6, 4]");
    Boolean prueba2_2 = Arrays.toString(elementosPosImpar(arr2_2)).equals("[6]");

    //Comprobadores Ejercicio 3

    char[] arr3_1 = {'a', 'b','c','e','i','k','o'};
    char[] arr3_2 = {'a', 'b','c','e','h','k','w'};
    char[] arr3_3 = {};

    Boolean prueba3_1 = hayTresVocales(arr3_1);
    Boolean prueba3_2 = !hayTresVocales(arr3_2);
    Boolean prueba3_3 = !hayTresVocales(arr3_3);

    //Comprobadores Ejercicio 4

    char[] arr4_1 = {'a', 'b','c','e','i','k','o'};
    char[] arr4_2 = {'a', 'b','c','e','h','k','w'};
    char[] arr4_3 = {};

    Boolean prueba4_1 = hayTresVocalesRec(arr4_1);
    Boolean prueba4_2 = !hayTresVocalesRec(arr4_2);
    Boolean prueba4_3 = !hayTresVocalesRec(arr4_3);

    //Imprimir resultados de las pruebas

    System.out.println("Ejercicio 1:");
    System.out.println(prueba1_1 && prueba1_2 &&  prueba1_3);
    System.out.println("Ejercicio 2:");
    System.out.println(prueba2_1 && prueba2_2);
    System.out.println("Ejercicio 3:");
    System.out.println(prueba3_1 && prueba3_2 &&  prueba3_3);
    System.out.println("Ejercicio 4:");
    System.out.println(prueba4_1 && prueba4_2 &&  prueba4_3);




  }

  
}