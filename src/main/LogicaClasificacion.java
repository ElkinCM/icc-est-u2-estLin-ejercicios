package main;

import java.util.*;

public class LogicaClasificacion {

    /**
     * Invierte una cadena de texto utilizando una pila (Stack).
     *
     * @param texto Cadena original a invertir.
     * @return Cadena invertida.
     *
     *         Ejemplo:
     *         Entrada: "Hola Mundo"
     *         Salida: "odnuM aloH"
     */
    public String invertirCadena(String texto) {
        Stack<Character> pila = new Stack<>();
        for (char c : texto.toCharArray()) {
            pila.push(c);
        }

        StringBuilder invertido = new StringBuilder();
        while (!pila.isEmpty()) {
            invertido.append(pila.pop());
        }
        return invertido.toString();
    }

    /**
     * Verifica si los símbolos de paréntesis, corchetes y llaves están bien
     * balanceados.
     *
     * @param expresion Cadena con símbolos.
     * @return true si está balanceada, false en caso contrario.
     *
     *         Ejemplo:
     *         Entrada: "{[()]}"
     *         Salida: true
     */
    public boolean validarSimbolos(String expresion) {
        Stack<Character> pila = new Stack<>();
        Map<Character, Character> pares = new HashMap<>();
        pares.put(')', '(');
        pares.put(']', '[');
        pares.put('}', '{');
        for (char c : expresion.toCharArray()) {
            if (pares.containsValue(c)) {
                pila.push(c);
            } else if (pares.containsKey(c)) {
                if (pila.isEmpty() || pila.pop() != pares.get(c)) {
                    return false;
                }
            }
        }
        return pila.isEmpty();
    }

    /**
     * Ordena una pila de enteros en orden ascendente usando otra pila auxiliar.
     *
     * @return Lista ordenada.
     *
     *         Ejemplo:
     *         Entrada: [3, 1, 4, 2]
     *         Salida: [1, 2, 3, 4]
     */
    public List<Integer> ordenarPila(Stack<Integer> pila) {
        Stack<Integer> pilaAuxiliar = new Stack<>();
        while (!pila.isEmpty()) {
            int temp = pila.pop();
            while (!pilaAuxiliar.isEmpty() && pilaAuxiliar.peek() > temp) {
                pila.push(pilaAuxiliar.pop());
            }
            pilaAuxiliar.push(temp);
        }

        List<Integer> result = new ArrayList<>();
        while (!pilaAuxiliar.isEmpty()) {
            result.add(pilaAuxiliar.pop());
        }
        return result;
    }

    /**
     * Clasifica una lista de enteross separando pares e impares.
     * Usa LinkedList para mantener el orden de inserción.
     *
     * @return Lista con pares primero, luego impares.
     *
     *         Ejemplo:
     *         Entrada: [1, 2, 3, 4, 5, 6]
     *         Salida: [2, 4, 6, 1, 3, 5]
     */
    public List<Integer> clasificarPorParidad(LinkedList<Integer> original) {
        List<Integer> pares = new LinkedList<>();
        List<Integer> impares = new LinkedList<>();

        for(int numero : original) {
            if (numero % 2 == 0) {
                pares.add(numero);
            }else{
                impares.add(numero);
            }
        }

        List<Integer> result = new LinkedList<>();
        result.addAll(pares);
        result.addAll(impares);


        return result;
    }
}
