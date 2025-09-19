package dLillo;

import java.util.*;



public class Juegos {

    static Scanner sc= new Scanner (System.in);

    Set<JuegoMesa> lista = new TreeSet<>(); // Para no permitir repetidos y ordenarlo

        public void anadirJuegoMesa() {
        String titulo;
        String autor;
        int maxJugadores;
        int minJugadores;
        int duracionMedia;
        JuegoMesa.Tipo tipo = null;

        int tTablero = 0;
        int numeroCartas;

        int op = 0;
        do {
            System.out.println("Ingrese tipo de juego:\n" +
                    "1) Tablero\n" +
                    "2) Cartas");
            op = sc.nextInt();
            sc.nextLine(); // limpiar buffer
        } while (op != 1 && op != 2);


        System.out.println("Introduzca el titulo del juego:");
        titulo = sc.nextLine();
        System.out.println("Introduzca autor:");
        autor = sc.nextLine();
        System.out.println("Introduzca el maximo de jugadores:");
        maxJugadores = sc.nextInt();
        System.out.println("Introduzca el minimo de jugadores:");
        minJugadores = sc.nextInt();
        System.out.println("Introduzca duracion media");
        duracionMedia = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        boolean valido = false;
        do{
            System.out.println("Introduzca tipo entre ESTRATEGIA, PARTY y FAMILIAR:");
            try {
                tipo = JuegoMesa.Tipo.valueOf(sc.nextLine().toUpperCase());
                valido = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Valor no válido. Intente de nuevo.");
            }
        }while(!valido);

        if (op == 1) {
            do {
                System.out.println("Introduce el tamaño del tablero superior a 0: ");
                tTablero = sc.nextInt();
            } while (tTablero < 0 || tTablero == 0);
            JuegoTablero temp = new JuegoTablero(titulo, autor, maxJugadores, minJugadores, duracionMedia, tipo, tTablero);
            lista.add(temp);
            System.out.println("Juego añadido con exito!");

        } else {
            do {
                System.out.println("Introduce el numero de cartas superior a 0: ");
                numeroCartas = sc.nextInt();
            } while (numeroCartas < 0 || numeroCartas == 0);
            JuegoCartas temp = new JuegoCartas(titulo, autor, maxJugadores, minJugadores, duracionMedia, tipo, numeroCartas);
            lista.add(temp);
            System.out.println("Juego añadido con exito!");

        }
    }
        public void listarJuegos (){
            for (JuegoMesa temp : lista) {
                System.out.println(temp);
            }
        }

        public void buscarPorTitulo (){
            String titulo = "";
            while(titulo.equals("")){
                System.out.println("Introduzca el titulo del juego: ");
                titulo = sc.nextLine();
                if (titulo.equals("")){
                    System.out.println("**ERROR**");
                }
            }

            boolean encontrado = false;
            for (JuegoMesa temp : lista) {
                if (temp.getTitulo().equalsIgnoreCase(titulo)) {
                    System.out.println(temp);
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("**ERROR** Juego no encontrado");
            }

        }

        public void eliminarPorTitulo (){
        String titulo = "";
        while(titulo.equals("")){
            System.out.println("Introduzca el titulo del juego: ");
            titulo = sc.nextLine();
            if (titulo.equals("")){
                System.out.println("**ERROR**");
            }
            Iterator <JuegoMesa> it = lista.iterator();	//	Recorrer con iterator
            while(it.hasNext()) {	//	hasNext devuelve un boolean
                JuegoMesa temp = it.next();	//	next devuelve un object
                if(temp.getTitulo().equals(titulo)){
                    it.remove();
                    System.out.println("Juego eliminado con exito!");
                    }
                }
            }
        }
}
