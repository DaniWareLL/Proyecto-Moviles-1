package dLillo;

import java.io.*;
import java.util.*;

public class Inventario {

    static Scanner sc= new Scanner (System.in);

    Set<JuegoMesa> lista = new TreeSet<>(); // Para no permitir repetidos y ordenarlo

        public void anadirJuegoMesa() {
        String titulo;
        String autor;
        int maxJugadores = 0;
        int minJugadores = 0;
        int duracionMedia = 0;
        JuegoMesa.Tipo tipo = null;

        int tTablero = 0;
        int numeroCartas = 0;

        int op = 0;
        do {
            System.out.println("Ingrese tipo de juego:\n" +
                    "1) Tablero\n" +
                    "2) Cartas");
            try{
                op = sc.nextInt();
                sc.nextLine(); // limpiar buffer
            }catch(InputMismatchException e){
                System.err.println("**EXCEPCION**\n" +
                        "VALOR NO VALIDO, INTENTE DE NUEVO");
                sc.nextLine();  //  limpiar buffer, sino se genera un bucle infinito
            }

            if(op != 1 && op != 2){
                System.err.println("**ERROR**\n" +
                "Debes escoger entre 1 y 2");
            }

        } while (op != 1 && op != 2);

        do{
            System.out.println("Introduzca el titulo del juego: ");
            titulo = sc.nextLine();
            if(titulo.isEmpty()){
                System.err.println("**ERORR*\n" +
                        "No puede ser un valor nulo");
            }
        }while (titulo.isEmpty());

            do{
                System.out.println("Introduzca autor: ");
                autor = sc.nextLine();
                if(autor.isEmpty()){
                    System.err.println("**ERORR*\n" +
                            "No puede ser un valor nulo");
                }
            }while (autor.isEmpty());

        do{
            try {

                System.out.println("Introduzca el maximo de jugadores: ");
                maxJugadores = sc.nextInt();
                sc.nextLine(); // limpiar buffer
                System.out.println("Introduzca el minimo de jugadores: ");
                minJugadores = sc.nextInt();
                sc.nextLine(); // limpiar buffer

                if (maxJugadores < minJugadores) {
                    System.err.println("**ERROR**\n" +
                            "El maximo de jugadores no puede ser menor que el minimo de jugadores");
                }

                if(maxJugadores == 0 || minJugadores == 0){
                    System.err.println("**ERROR**\n" +
                            "Los valores no pueden ser 0");
                }

            } catch (InputMismatchException e) {
                System.err.println("**EXCEPCION**\n" +
                        "DEBE SER UN NUMERO");
                sc.nextLine();
            }
        }while(maxJugadores < minJugadores || maxJugadores == 0 || minJugadores == 0);    // No compruebo que sea nulo ya que en java es imposible que un int sea nulo

            boolean valido = false;

            do {
                try {
                    System.out.println("Introduzca duración media en minutos: ");
                    duracionMedia = sc.nextInt();
                    sc.nextLine(); // limpiar buffer
                    if(duracionMedia != 0){
                        valido = true; // Si llegamos aquí, el valor es válido
                    }else{
                        System.err.println("**ERROR**\n" +
                                "El valor no puede ser 0");
                    }

                } catch(InputMismatchException e) {
                    System.err.println("**EXCEPCION** DEBE SER UN NUMERO EN MINUTOS");
                    sc.nextLine(); // limpiar el buffer del scanner
                }
            } while(!valido);

        // tipo = JuegoMesa.Tipo.valueOf(sc.nextLine().toUpperCase());
        // Podria haberlo hecho así, pero suele dar mas problemas

        boolean valido1 = false;
        int entrada = 0;
        do{
            System.out.println("1) ESTRATEGIA\n" +
                    "2) PARTY\n" +
                    "3) FAMILIAR");
            entrada = sc.nextInt();
            try {
                switch (entrada){
                    case 1:
                        tipo = JuegoMesa.Tipo.ESTRATEGIA;
                        valido1 = true;
                        break;
                    case 2:
                        tipo = JuegoMesa.Tipo.PARTY;
                        valido1 = true;
                        break;
                    case 3:
                        tipo = JuegoMesa.Tipo.FAMILIAR;
                        valido1 = true;
                        break;
                    default:
                        System.err.println("**ERROR**\n" +
                                "Debes escoger entre 1, 2 y 3");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("**EXCEPCION**\n" +
                        "Valor no válido. Intente de nuevo.");
            }
        }while(!valido1);

        if (op == 1) {
            boolean validoTablero = false;
            do {
                try {
                    System.out.println("Introduce el tamaño del tablero superior a 0: ");
                    tTablero = sc.nextInt();
                    sc.nextLine(); // limpiar buffer
                    if (tTablero > 0) {
                        validoTablero = true;
                        JuegoTablero temp = new JuegoTablero(titulo, autor, maxJugadores, minJugadores, duracionMedia, tipo, tTablero);
                        lista.add(temp);
                        System.out.println("Juego de tablero añadido con exito!");
                    } else {
                        System.err.println("**ERROR** Debe ser mayor que 0");
                    }
                } catch (InputMismatchException e) {
                    System.err.println("**EXCEPCION** DEBE SER UN NUMERO ENTERO");
                    sc.nextLine(); // limpiar buffer
                }
            } while (!validoTablero);
        }

        if (op == 2) {
            boolean validoCartas = false;
            do {
                try {
                    System.out.println("Introduce el número de cartas superior a 0: ");
                    numeroCartas = sc.nextInt();
                    sc.nextLine(); // limpiar buffer
                    if (numeroCartas > 0) {
                        validoCartas = true;
                        JuegoCartas temp = new JuegoCartas(titulo, autor, maxJugadores, minJugadores, duracionMedia, tipo, numeroCartas);
                        lista.add(temp);
                        System.out.println("Juego de cartas añadido con exito!");
                    } else {
                        System.err.println("**ERROR** Debe ser mayor que 0");
                    }
                } catch (InputMismatchException e) {
                    System.err.println("**EXCEPCION** DEBE SER UN NUMERO ENTERO");
                    sc.nextLine(); // limpiar buffer
                }
            } while (!validoCartas);
        }
    }
        public void listarJuegos (){
            if(!lista.isEmpty()) {
                for (JuegoMesa temp : lista) {
                    temp.mostrarInfo(); //  Metodos abstractos
                }
            }else{
                System.err.println("**ERROR** La lista esta vacia");
            }
        }

        public void buscarPorTitulo (){
            if(!lista.isEmpty()) {
                String titulo = "";
                while (titulo.isEmpty()) {
                    System.out.println("Introduzca el titulo del juego: ");
                    titulo = sc.nextLine();
                    if (titulo.isEmpty()) {
                        System.err.println("**ERROR**\n" +
                                "Lista de juegos vacia");
                    }
                }

                boolean encontrado = false;
                for (JuegoMesa temp : lista) {
                    if (temp.getTitulo().equalsIgnoreCase(titulo)) {
                        temp.mostrarInfo();
                        encontrado = true;
                    }
                }
                if (!encontrado) {
                    System.err.println("**ERROR** Juego no encontrado");
                }
            }else{
                System.err.println("**ERROR** La lista esta vacia. No se puede realizar la busqueda");
            }
        }

        public void eliminarPorTitulo (){
        String titulo = "";
        Boolean encontrado = false;
        if(!lista.isEmpty()) {
            while (titulo.isEmpty()) {
                try {
                    System.out.println("Introduzca el titulo del juego: ");
                    titulo = sc.nextLine();
                    if (titulo.isEmpty()) {
                        System.err.println("**ERROR**\n" +
                                "El nombre no puede ser nulo");
                    }
                } catch (InputMismatchException e) {
                    System.err.println("**EXCEPCION** Debe ser un numero");
                }
            }
                Iterator<JuegoMesa> it = lista.iterator();    //	Recorrer con iterator
                while (it.hasNext()) {    //	hasNext devuelve un boolean
                    JuegoMesa temp = it.next();    //	next devuelve un object
                    if (temp.getTitulo().equals(titulo)) {
                        it.remove();
                        System.out.println("Juego eliminado con exito!");
                        encontrado = true;
                    } else if (!encontrado){
                        System.err.println("**ERROR**\n" +
                                "Juego no encontrado, por favor vuelva a intentarlo con otro nombre");
                    }
                }
        }else{
            System.err.println("**ERROR**\n" +
                    "La lista esta vacia");
        }
    }

    public void logOperacion(String mensaje) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("inventario.log", true))) {
            bw.write(new Date() + " - " + mensaje);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Error al escribir log: " + e.getMessage());
        }
    }


}