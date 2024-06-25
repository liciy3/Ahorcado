import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        final int INTENTOS_TOTALES = 7;
        int Intentos = 0;
        int Aciertos = 0;
        System.out.println(" ¿Puedes adivinar la palabra?");
        Scanner teclado = new Scanner(System.in);
        teclado.useDelimiter("\n");
        char Respuesta;
        Random rmd = new Random();
        String arrayPalabras[] = new String[44];
        arrayPalabras[0] = "banano";
        arrayPalabras[1] = "fresa";
        arrayPalabras[3] = "perro";
        arrayPalabras[4] = "gato";
        arrayPalabras[5] = "china";
        arrayPalabras[6] = "japon";
        arrayPalabras[7] = "dragon";
        arrayPalabras[8] = "cabra";
        arrayPalabras[9] = " peru";
        arrayPalabras[10] = "manzana";
        arrayPalabras[11] = " chile";
        arrayPalabras[12] = "sandia";
        arrayPalabras[13] = "estados unidos";
        arrayPalabras[14] = "Oveja";
        arrayPalabras[15] = "pera";
        arrayPalabras[16] = "uva";
        arrayPalabras[17] = "RuSia";
        arrayPalabras[18] = "Colombia";
        arrayPalabras[19] = "cerDo";
        arrayPalabras[21] = "MEXICO";
        arrayPalabras[22] = "ESPaÑA";
        arrayPalabras[23] = "NAranja";
        arrayPalabras[24] = "piña";
        arrayPalabras[25] = "aUSTRalia";
        arrayPalabras[26] = "brazil";
        arrayPalabras[27] = "Argentina";
        arrayPalabras[28] = "CabALLo";
        arrayPalabras[29] = "serPíentE";
        arrayPalabras[30] = "aBEJa";
        arrayPalabras[31] = "araÑa";
        arrayPalabras[32] = "lulo";
        arrayPalabras[33] = "frambuesa ";
        arrayPalabras[34] = "maracuya";
        arrayPalabras[35] = "buHO";
        arrayPalabras[36] = "BURRO";
        arrayPalabras[37] = "lOBO";
        arrayPalabras[38] = "MUrcieLAGO";
        arrayPalabras[39] = "POllO";
        arrayPalabras[40] = "cuba";
        arrayPalabras[41] = "porTugAl";
        arrayPalabras[42] = "PoLOniA";
        arrayPalabras[43] = "Kazajistán";


        do {

            int aleatorio = rmd.nextInt(44);
            char[] deshacer = deshace(arrayPalabras[aleatorio]);
            char[] imprimir = deshace(arrayPalabras[aleatorio]);
            char[] tusRespuestas = new char[deshacer.length];


            for (int i = 0; i < tusRespuestas.length; i++) {
                tusRespuestas[i] = '_';
            }

            System.out.println("Adivina la palabra");

            while (Intentos < INTENTOS_TOTALES && Aciertos != tusRespuestas.length) {
                imprimirOculta(tusRespuestas);
                System.out.println("\nIntroduce una letra: ");
                Respuesta = teclado.next().toLowerCase().charAt(0);
                for (int i = 0; i < deshacer.length; i++) {
                    if (deshacer[i] == Respuesta) {
                        tusRespuestas[i] = deshacer[i];
                        deshacer[i] = ' ';
                        Aciertos++;
                    }
                }
                Intentos++;
            }

            if (Aciertos == tusRespuestas.length) {
                System.out.print("\nFelicitaciones!!! has descubierto la palabra oculta: ");
                imprimirOculta(tusRespuestas);
            } else {
                System.out.print("\n ERROR!! la palabra era: ");
                for (int i = 0; i < imprimir.length; i++) {
                    System.out.print(imprimir[i] + " ");
                }
            }

            Intentos = 0;
            Aciertos = 0;
            Respuesta = pregunta("\n\nQuieres volver a jugar?", teclado);
        } while (Respuesta != 'n');

    }

    private static char[] deshace(String palabraAzar) {
        char[] letras;
        letras = new char[palabraAzar.length()];
        for (int i = 0; i < palabraAzar.length(); i++) {
            letras[i] = palabraAzar.charAt(i);
        }
        return letras;
    }

    private static void imprimirOculta(char[] tusRespuestas) {

        for (int i = 0; i < tusRespuestas.length; i++) {
            System.out.print(tusRespuestas[i] + " ");
        }
    }

    public static char pregunta(String men, Scanner teclado) {
        char respuesta;
        System.out.println(men + " (si / no)");
        respuesta = teclado.next().toLowerCase().charAt(0);
        while (respuesta != 's' && respuesta != 'n') {
            System.out.println("Solo se admite Si o No");
            respuesta = teclado.next().toLowerCase().charAt(0);
        }
        return respuesta;
    }
    }

