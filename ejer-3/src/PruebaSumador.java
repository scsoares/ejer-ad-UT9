package src;

public class PruebaSumador {
    public static void main(String[] args) {

        SumadorEnterosScanner sumador = new SumadorEnterosScanner("fichero");
        int suma = sumador.sumar();
        System.out.println("La suma de los enteros es: " + suma);
    }
}