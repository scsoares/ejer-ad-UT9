import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Calcula y devuelve el valor máximo de una serie de números
 * enteros leídos del fichero de texto “numeros.txt”. No contiene atributos.
 *
 * @author (Sarah Soares)
 * @version (20-05-2024)
 */
public class Maximo {
    /**
     * Constructor vacío.
     */
    public Maximo() {
    }

    /**
     * Este método puede lanzar excepciones del tipo IOException
     * y de conversión de formato. Dentro del método no se capturarán, sino que se
     * propagan
     * 
     * @return el mayor número en el archivo numeros.txt
     */
    public int maximoSinExcepciones() throws IOException, NumberFormatException {
        BufferedReader txt = new BufferedReader(new FileReader("numeros.txt"));

        try {
            ArrayList<Integer> listaNum = new ArrayList<Integer>();
            String num;
            while ((num = txt.readLine()) != null) {
                int numParsed = Integer.parseInt(num);
                listaNum.add(numParsed);
            }
            return Collections.max(listaNum);

        } finally {
            txt.close();
        }

    }

    /**
     * Hace lo mismo que el método anterior, pero captura las
     * posibles excepciones que se puedan generar
     * 
     * @return el mayor número en el archivo numeros.txt
     */
    public int maximoConExcepciones() {

        try {

            BufferedReader txt = new BufferedReader(new FileReader("numeros.txt"));
            ArrayList<Integer> listaNum = new ArrayList<Integer>();
            String num;
            while ((num = txt.readLine()) != null) {
                int numParsed = Integer.parseInt(num);
                listaNum.add(numParsed);
            }
            txt.close();
            return Collections.max(listaNum);

        } catch (FileNotFoundException fnfe) {
            System.out.println("Archivo no encontrado.");
        } catch (IOException ioe) {
            System.out.println("Error al leer el archivo.");
        } catch (NumberFormatException nfe) {
            System.out.println("Error al hacer la conversión.");
        }

    }

    public static void main(String[] args) {

        Maximo maximo = new Maximo();

        /* Teste del método que no captura excepciones */
        try {
            System.out.print("a. El número máximo es: " + maximo.maximoSinExcepciones());
        } catch (IOException | NumberFormatException e) {
            System.out.println("No fue possible realizar la operación. Error: " + e.getMessage());
        }

        /* Teste del método que captura excepciones */
        System.out.print("b. El número máximo es: " + maximo.maximoConExcepciones());

    }
}