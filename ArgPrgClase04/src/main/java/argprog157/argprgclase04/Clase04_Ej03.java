package argprog157.argprgclase04;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Clase04_Ej03 {

    public static void main(String[] args) { //throws FileNotFoundException {
        try {
            String operacion = args[0];
            String desplazamiento = args[1];
            String archivoOrigen = args[2];
            String archivoDestino = args[3];
            String cadenaOrigen = "";
            String cadenaResultante = "";

            Scanner aO = new Scanner(new File(archivoOrigen));

            while (aO.hasNextLine()) {
                cadenaOrigen += aO.nextLine() + "\n";
            }
            aO.close();

            Codigo miCodigo = new Codigo();
            miCodigo.setFrase(cadenaOrigen);
            miCodigo.setDesplazamiento(Integer.parseInt(desplazamiento));

            if (operacion.equals("C")) {
                cadenaResultante = miCodigo.codificar();
            } else if (operacion.equals("D")) {
                cadenaResultante = miCodigo.decodificar();
            } else {
                System.out.println("Arguemnto para codificar/decodificar incorrecto");
            }

            try {
                FileWriter fw = new FileWriter(new File(archivoDestino), true);
                fw.write("");
                fw.write(cadenaResultante);
                fw.close();
                System.out.println("Codificación / Decodificación exitosa");

            } catch (IOException ex) {
                Logger.getLogger(Clase04_Ej03.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        }
    }

    static class Codigo {

        private String frase;
        private int desplazamiento;

        public String getFrase() {
            return frase;
        }

        public void setFrase(String frase) {
            this.frase = frase;
        }

        public int getDesplazamiento() {
            return desplazamiento;
        }

        public void setDesplazamiento(int desplazamiento) {
            this.desplazamiento = desplazamiento;
        }

        public String codificar() {
            String resultado = "";
            for (int i = 0; i < frase.length(); i++) {
                int aux = frase.charAt(i);
                aux += this.desplazamiento;
                resultado = resultado + (char) aux;
            }
            return resultado;
        }

        public String decodificar() {
            String resultado = "";
            for (int i = 0; i < frase.length(); i++) {
                int aux = frase.charAt(i);
                aux -= this.desplazamiento;
                resultado = resultado + (char) aux;
            }
            return resultado;
        }
    }

}
