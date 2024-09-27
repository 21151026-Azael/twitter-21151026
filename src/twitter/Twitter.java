
package twitter;

import java.util.Stack;
import java.util.Scanner;

public class Twitter {

    static Stack<String> tweetStack = new Stack<>();

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String comando;

        System.out.println("Bienvenido a los Tweets. Escribe 'salir' para terminar.");

        do {
            System.out.println("\nComandos disponibles:");
            System.out.println("1. Agregar [tweet] - Agregar un tweet a la pila");
            System.out.println("2. Mostrar - Mostrar el último tweet");
            System.out.println("3. Eliminar - Eliminar el último tweet");
            System.out.println("4. Listar - Listar todos los tweets");
            System.out.print("Ingrese un comando: ");
            comando = entrada.nextLine();

            if (comando.startsWith("agregar ")) {
                String tweet = comando.substring(8);
                agregarTweet(tweet);
            } else if (comando.equals("mostrar")) {
                mostrarUltimoTweet();
            } else if (comando.equals("eliminar")) {
                eliminarUltimoTweet();
            } else if (comando.equals("listar")) {
                listarTweets();
            } else if (!comando.equals("salir")) {
                System.out.println("Comando no reconocido.");
            }

        } while (!comando.equals("salir"));

        System.out.println("¡Gracias por usar la Pila de Tweets!");
        entrada.close();
    }

    private static void agregarTweet(String tweet) {
        tweetStack.push(tweet);
        System.out.println("Tweet agregado: " + tweet);
    }

    private static void mostrarUltimoTweet() {
        if (!tweetStack.isEmpty()) {
            System.out.println("Último tweet: " + tweetStack.peek());
        } else {
            System.out.println("No hay tweets en la pila.");
        }
    }

    private static void eliminarUltimoTweet() {
        if (!tweetStack.isEmpty()) {
            String removedTweet = tweetStack.pop();
            System.out.println("Tweet eliminado: " + removedTweet);
        } else {
            System.out.println("No hay tweets para eliminar.");
        }
    }

    private static void listarTweets() {
        if (!tweetStack.isEmpty()) {
            System.out.println("Lista de tweets:");
            for (String tweet : tweetStack) {
                System.out.println("- " + tweet);
            }
        } else {
            System.out.println("No hay tweets en la pila.");
        }
    }
    
}
