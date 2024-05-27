import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

/**
 * Clase que visualiza los enteros del fichero cuyo nombre se pasa como
 * parámetro en la pantalla en líneas
 * de 10 en 10 (el fichero tiene un número por línea).
 * Si algún valor contenido en el fichero no es un número entero se visualizará
 * en pantalla *** pero el
 * programa no parará en este caso.
 *
 * @author (Sarah Soares)
 * @version (20-05-2024)
 */

public class VisualizadorEnteros {

    /**
     * Constructor vacío.
     */
    public VisualizadorEnteros() {
    }

    public void mostrarEnteros(String nombre) {
        try {
            BufferedReader lector = new BufferedReader(new FileReader(nombre + ".txt"));
            try {
                String num;
                int i = 0;
                while ((num = lector.readLine()) != null) {
                    try {
                        int numParsed = Integer.parseInt(num);
                        System.out.print(numParsed + " ");
                    } catch (NumberFormatException nfe) {
                        System.out.print("*** ");
                    }
                    i++;

                    if (i % 10 == 0) {
                        System.out.println("");
                    }
                }

            } finally {
                lector.close();
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("El archivo no fue encontrado");
        } catch (IOException fnfe) {
            System.out.println("Error al leer el archivo");
        } catch (NullPointerException npe) {
            System.out.println("El nombre no puede ser nulo.");
        }

    }

    public static void main(String[] args) {

        VisualizadorEnteros visualizador = new VisualizadorEnteros();
        visualizador.mostrarEnteros("fichero");
    }

}