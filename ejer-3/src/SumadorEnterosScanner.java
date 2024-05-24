package src;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;

/**
 * Esta clase es un sumador de números enteros leídos
 * desde un fichero de texto cuyo nombre se proporciona al constructor.
 * El fichero lo leerás con ayuda de Scanner.
 *
 * 
 * @author (Sarah Soares)
 * @version (24-05-2024)
 */
public class SumadorEnterosScanner {

    Scanner sc;

    /**
     * Constructor del método SumadorEnterosScanner.
     */
    public SumadorEnterosScanner(String nombre) {
        try {
            sc = new Scanner(new File(nombre + ".txt"));
        } catch (IOException e) {
            System.out.println("No fue posible leer el archivo");

        }
    }

    /**
     * Método que suma los enteros leídos del archivo.
     * 
     * @return la suma de los enteros.
     */
    public int sumar() {
        int suma = 0;
        try {
            while (sc.hasNextInt()) {
                try {
                    suma = sc.nextInt() + suma;
                } catch (InputMismatchException ime) {
                    sc.next();
                    System.out.println("Fue encontrado un valor diferente del esperado: " + ime.getMessage());
                }
            }

        } catch (Exception e) {
            System.out.println("Ocurrió un error al sumar los números: " + e.getMessage());
        } finally {
            sc.close();
        }

        return suma;

    }

}