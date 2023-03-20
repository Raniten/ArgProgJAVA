/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package argprog157.argprgclase04;

import java.io.*;
import java.util.Scanner;



public class Clase04_Ej02 {
    public static void main(String[] args) throws FileNotFoundException {
        long resultado = 0;
        String operacion = args[1];
        
        String cadenaCompleta;
        String [] arregloNumeros;
        
        Scanner sc = new Scanner(new File(args[0]));
        
        cadenaCompleta = sc.nextLine();
        arregloNumeros = cadenaCompleta.split(" ");
        sc.close();
        
        if(operacion.equals("suma")) {
            for (int i = 0; i < arregloNumeros.length; i++) {
                resultado += Long.parseLong(arregloNumeros[i]);
            }
            System.out.println("La suma de todos los numeros del archivo es: " + resultado);
        } else if(operacion.equals("producto")) {
            resultado = 1;
            for (int i = 0; i < arregloNumeros.length; i++) {
                resultado *= Long.parseLong(arregloNumeros[i]);
            }
            System.out.println("El producto de todos los numeros del archivo es: " + resultado);
        }
        System.out.println("FIN");
        
        
    }
    
}
