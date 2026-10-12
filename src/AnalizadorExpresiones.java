public class AnalizadorExpresiones {

    // Método auxiliar para definir la jerarquía de los operadores
    private static int precedencia(String op) {
        switch (op) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return -1;
        }
    }

    public static String infijaAPostfija(String[] tokens) {
        StringBuilder salida = new StringBuilder();
        PilaGenerica<String> pilaOperadores = new PilaGenerica<>();

        for (String token : tokens) {
            // CORRECCIÓN: Se cambió [a-zA-Z0-0_]* por [a-zA-Z0-9_]* para aceptar dígitos en variables
            if (token.matches("-?\\d+(\\.\\d+)?") || token.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
                salida.append(token).append(" ");
            }
            else if (token.equals("(")) {
                pilaOperadores.push(token);
            }
            else if (token.equals(")")) {
                while (!pilaOperadores.isEmpty() && !pilaOperadores.peek().equals("(")) {
                    salida.append(pilaOperadores.pop()).append(" ");
                }
                if (!pilaOperadores.isEmpty()) {
                    pilaOperadores.pop(); // Eliminar el '(' de la pila
                }
            }
            else { // Es un operador (+, -, *, /)
                while (!pilaOperadores.isEmpty() && precedencia(token) <= precedencia(pilaOperadores.peek())) {
                    salida.append(pilaOperadores.pop()).append(" ");
                }
                pilaOperadores.push(token);
            }
        }

        // Vaciar los operadores restantes en la pila al finalizar
        while (!pilaOperadores.isEmpty()) {
            salida.append(pilaOperadores.pop()).append(" ");
        }

        return salida.toString().trim();
    }
}