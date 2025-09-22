package main;

import dLillo.Inventario;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainJuegosMesa {

    /*  Un club de juegos de mesa lleva años reuniendose.
    Su coleccion ha crecido tanto que ya no receuerdan todos los detalles
        - Que juegos son de cartas y cuales de tablero
        - Cuantos jugadores admite cada uno
        - Cuanto dura una partida
        - Donde se guardan
    Problema: A veces comparan juegos repetidos o no encuentran el juego adecuado para el grupo
    Necesidad: Quieren una app que les permita gestionar su coleccion de juegos de mesa para consultoria y irganizarse mejor.
    La app debe permitir:
        - Resigstrar varios juegos de mesa con sus datos basicos:
            - Titulo
            - Autor
            - Numero minimo y max de jugadores
            - Dureacion media en mins
            - Tipo de juego: estrategia, party, familiar... etc
        - Dsitinguir entre juegos de cartas (Numero de cartas) y juegos de tablero(tamaño del tablero) con sus atributos.
        - Mostrar un menu con opciones:
            - Alta de juego
            - Listado de juegos
            - Busqueda por titulo
            - Salida del programa
        - El programa debe ser robusto: validar numeros y no aceptar datos vacios.
    */

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Inventario j = new Inventario();
        int op = 0;
        do {
            System.out.println("**MENU DE INICIO**");
            System.out.println("1) Dar de alta Juego\n" +
                    "2) Listar juegos\n" +
                    "3) Busqueda por titulo\n" +
                    "4) Eliminar juego\n" +
                    "5) Salir");
            try {
                op = sc.nextInt();
                switch (op) {
                    case 1:
                        j.anadirJuegoMesa();
                        j.logOperacion("Se ha añadido un juego");
                        break;
                    case 2:
                        j.listarJuegos();
                        break;
                    case 3:
                        j.buscarPorTitulo();
                        break;
                    case 4:
                        j.eliminarPorTitulo();
                        j.logOperacion("Se ha eliminado un juego");
                        break;
                    case 5:
                        System.out.println("**CERRANDO PROGRAMA**");
                        j.logOperacion("Se ha usado el programa");
                        break;
                    default:
                        System.err.println("**ERROR**\n" +
                                "Introduce un valor valido");
                        break;
                }
            }catch(InputMismatchException e) {
                System.err.println("**EXCEPCION**\n" +
                        "Por favor vuelva a intentarlo");
                sc.nextLine(); // limpiar buffer, sino se genera un bucle infinito
            }
            } while (op != 5) ;
    }
}

// La proxima update que voy a hacer en mi codigo va a ser generar un fichero de objetos para posteriormente leer y trabajar en el.