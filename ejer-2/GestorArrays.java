import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * - La clase GestorArrays carga un array desde un fichero de texto, duplica sus
 * valores y lo vuelca en un fichero de salida. Crea aparte, un fichero de texto
 * con un número por
 * línea.
 *
 * 
 * @author (Sarah Soares)
 * @version (21-05-2024)
 */
public class GestorArrays {

    int[] numeros;
    int elem;
    String nombre;

    /**
     * Constructor del método GestorArrays. El constructor recibe como parámetros el
     * nombre del fichero de entrada
     * y el tamaño máximo del array. El constructor lanza la excepción propia
     * (que derivará de RuntimeException) ArgumentoIncorrectoExcepcion.
     */
    public GestorArrays(String nombre, int max) {

        this.nombre = nombre;
        try {
            numeros = new int[max];
        } catch (ArgumentoIncorrectoExcepcion e) {

        }

    }

    /**
     * carga el array desde el fichero (previamente se
     * habrá abierto el fichero). El método avisa de las posibles
     * excepciones (no las captura) y cierra el fichero
     */
    public void cargarArray() {
        // falta método
    }

    /**
     * Duplica los valores del array, es decir, cada valor almacenado en el array
     * lo cambia por su doble
     */
    public void duplicarArray() {
        // falta método
    }

    /**
     * Guarda los nuevos valores del array en un fichero de salida con el mismo
     * nombre que el fichero de entrada (con lo cual los datos iniciales se
     * destruirán).
     * 
     */
    public void volcarArray() {
        // falta método

    }

    public static void main(String[] args) {

        GestorArrays gestor = new GestorArrays(-5);
    }
}