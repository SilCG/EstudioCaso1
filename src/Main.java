// Clase principal para probar la conversión de expresiones infijas a postfijas
// utilizando la clase AnalizadorExpresiones y la Pila.

public class Main {

    public static void main(String[] args) {
        System.out.println("--------------------------------------------------");
        System.out.println("   ANÁLISIS DE EXPRESIONES ARITMÉTICAS CON PILAS  ");
        System.out.println("-------------------------------------------------\n");

        // Casos de prueba que incluyen números, variables, operadores y paréntesis
        String[] expresionesPrueba = {
                "a + 5 * b",
                "( a + 5 ) * b",
                "x * ( y - 12.5 ) / 2",
                "( ( 10 + var1 ) * 3 ) - num_2"
        };

        for (int i = 0; i < expresionesPrueba.length; i++) {
            String expresionInfija = expresionesPrueba[i];

            // Separar la expresión en tokens por espacios en blanco
            String[] tokens = expresionInfija.split("\\s+");

            // Convertir a notación postfija usando tu clase AnalizadorExpresiones
            String expresionPostfija = AnalizadorExpresiones.infijaAPostfija(tokens);

            // Mostrar resultados en consola
            System.out.println("Prueba #" + (i + 1) + ":");
            System.out.println("  Entrada (Infija)  : " + expresionInfija);
            System.out.println("  Salida (Postfija) : " + expresionPostfija);
            System.out.println("-------------------------------------------------");
        }
    }
}