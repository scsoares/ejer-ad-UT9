package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * - La clase GestorArrays carga un array desde un fichero de texto, duplica sus
 * valores y lo vuelca en un fichero de salida. Crea aparte, un fichero de texto
 * con un número por
 * línea.
 *
 * 
 * @author (Sarah Soares)
 * @version (23-05-2024)
 */
public class GestorArrays {

    int[] numeros;
    int elem;
    String nombre;
    BufferedReader fichero;
    PrintWriter ficheroSalida;

    /**
     * Constructor del método GestorArrays. El constructor recibe como parámetros el
     * nombre del fichero de entrada
     * y el tamaño máximo del array. El constructor lanza la excepción propia
     * (que derivará de RuntimeException) ArgumentoIncorrectoExcepcion.
     */
    public GestorArrays(String nombre, int max) throws ArgumentoIncorrectoExcepcion {

        this.nombre = nombre;
        if (max <= 0) {
            throw new ArgumentoIncorrectoExcepcion(Integer.toString(max));
        } else {
            numeros = new int[max];
        }

    }

    /**
     * carga el array desde el fichero (previamente se
     * habrá abierto el fichero). El método avisa de las posibles
     * excepciones (no las captura) y cierra el fichero
     */
    public void cargarArray() throws FileNotFoundException, IOException {
        fichero = new BufferedReader(new FileReader(nombre + ".txt"));

        try {
            String num;
            int i = 0;

            while ((num = fichero.readLine()) != null) {
                int numParsed = Integer.parseInt(num);
                numeros[i] = numParsed;
                i++;
            }
        } finally {
            fichero.close();
        }
    }

    /**
     * Duplica los valores del array, es decir, cada valor almacenado en el array
     * lo cambia por su doble
     */
    public void duplicarArray() {

        elem = numeros.length;

        for (int i = 0; i < elem; i++) {
            numeros[i] = numeros[i] * 2;
        }
    }

    /**
     * Guarda los nuevos valores del array en un fichero de salida con el mismo
     * nombre que el fichero de entrada (con lo cual los datos iniciales se
     * destruirán).
     * 
     */
    public void volcarArray() throws IOException {

        ficheroSalida = new PrintWriter(new BufferedWriter(new FileWriter("fichero.txt")));

        for (int i = 0; i < elem; i++) {
            String numStr = Integer.toString(numeros[i]);
            ficheroSalida.print(numStr + "\n");
        }

        ficheroSalida.close();

    }

    // Me falta definir el mensaje de cada excepción, la puse como general
    public static void main(String[] args) {

        GestorArrays gestor = new GestorArrays("ficheroEntrada", 10);

        try {
            gestor.cargarArray();
            gestor.duplicarArray();
            gestor.volcarArray();
        } catch (Exception e) {
            System.out.println("Algun error ocurrió.");
        }

    }
}