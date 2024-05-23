package src;

/**
 * - Excepción personalizada para La clase GestorArrays. La
 * clase que modela esta excepción contendrá como atributo el argumento
 * incorrecto que se haya pasado como parámetro. (falta terminarlo)
 *
 * 
 * @author (Sarah Soares)
 * @version (23-05-2024)
 */

public class ArgumentoIncorrectoExcepcion extends RuntimeException {

    String valorErroneo;

    public ArgumentoIncorrectoExcepcion(String valorErroneo) {
        this.valorErroneo = valorErroneo;
    }

    public String toString() {
        return "Has puesto un valor incorrecto: " + valorErroneo;
    }
}
