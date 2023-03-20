package argprog157.argprgclase04;


import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;




public class Clase04_Ej01 {

    public static void main(String[] args) {
        
        switch (args.length) {
            case 4 ->  {
               Clase04_Ej01.ordenarArreglo(args);
            }
            case 3 ->  {       
                String[] argumentoCompleto = new String[4];
                argumentoCompleto = Arrays.copyOfRange(args, 0, 4);     
                argumentoCompleto[3] = Clase04_Ej01.obtenerOrden();
                Clase04_Ej01.ordenarArreglo(argumentoCompleto);
            }
            case 1 ->  {
                String [] argumentoCompleto = new String[4];
                argumentoCompleto = Clase04_Ej01.obtenerNumeros(argumentoCompleto);
                argumentoCompleto[argumentoCompleto.length-1] = args[0];
                Clase04_Ej01.ordenarArreglo(argumentoCompleto);
            }
            case 0 ->  {
                String [] argumentoCompleto = new String[4];
                argumentoCompleto = Clase04_Ej01.obtenerNumeros(argumentoCompleto);
                argumentoCompleto[3] = Clase04_Ej01.obtenerOrden();
                Clase04_Ej01.ordenarArreglo(argumentoCompleto);
            }

            
        }
        //Case 4: por parametros del main vienen todos los argumentos
        //Case 3: por parámetros del main sólo vienen 3 argumentos, que asumimos son los numeros a ordenar
        //Case 1: por parametro del main viene un solo argumento, que asumimos que es el orden deseado
        //Case 0: no se pasan parámetros por el main
    }
    
    //  *** F U N C I O N E S  ***
    
    static String[] obtenerNumeros (String arreglo[]) {
        for (int i = 0; i < arreglo.length-1; i++) {
            System.out.println("Ingresar el numero " + (i+1));
            Scanner sc = new Scanner(System.in);
            arreglo[i] = String.valueOf(sc.nextInt());
        }
        return arreglo;
    }
    
    static String obtenerOrden() {
        String orden = "";
        Scanner sc = new Scanner(System.in);
                
        while (!orden.equals("A") && !orden.equals("D") ) {
            System.out.println("Ingrese el orden preferido, (A)scendente o (D)escendente");
            orden = sc.nextLine();
        }
        return orden;
    }
    
    
    static boolean verificarOrden(String orden) {
        if(orden.equals("A") || orden.equals("D")) {
            return(true);
        } else {
            return(false);
        }
    }
    
    static void ordenarArreglo (String[] arreglo) {
        
        //Verificamos si el último argumento es una (A)scendente o una (D)escendente
        if (!verificarOrden(arreglo[arreglo.length-1])) {
            System.out.println("El cuarto argumento debe ser A o D");
            System.exit(0);
        }
        
        
        String orden;
        if(arreglo[arreglo.length-1].equals("A")){
            orden = "Ascendente";
        } else {
            orden = "Descendente";
        }
        
        
        //Mostramos los datos originales
        System.out.println("Los datos originales son los siguientes:");
        System.out.println("---------------------------------------------");
        for (int i = 0; i < arreglo.length-1; i++) {
            System.out.println("Número " + (i+1) + ": " + arreglo[i] + "");
        }
        System.out.println("\nOrden solicitado: " + orden);
                
        System.out.println("---------------------------------------------\n");
        
        
        //Creamos un arreglo de numeros enteros de tamaño (menos 1) al del parámetro (sacamos el orden)
        int arregloInt[] = new int[arreglo.length-1];
        
        //Asignamos a cada posición del arreglo de enteros el valor que viene por parámetro 
        for (int i = 0; i < arregloInt.length; i++) {
            arregloInt[i] = Integer.parseInt(arreglo[i]);
        }
        
        if(orden.equals("Ascendente")) {
            Arrays.sort(arregloInt);
        } else {
            //Creamos un arreglo de objetos Integer, para poder ordenarlos
            Integer[] arregloInteger = Arrays.stream(arregloInt).boxed().toArray(Integer[]::new);
            
            //Ordenamos el nuevo arreglod e Integer de forma descendente
            Arrays.sort(arregloInteger, Collections.reverseOrder());
            
            //Pasamos el arreglo de Integer ordenados en forma descendente al arreglo de datos primitivos int
            
            arregloInt = Arrays.stream(arregloInteger).mapToInt(Integer::intValue).toArray();
        }
                        
        for (int i = 0; i < arregloInt.length; i++) {
            System.out.println("Dato " + (i+1) + ": " + arregloInt[i]);
        }
    }
}

