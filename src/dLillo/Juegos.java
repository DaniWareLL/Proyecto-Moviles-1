package dLillo;

import java.util.*;



public class Juegos {

    static Scanner sc= new Scanner (System.in);

    ArrayList<JuegoMesa> list = new ArrayList<JuegoMesa>();

    public void anadirJuegoMesa(){
        String titulo;
        String autor;
        int maxJugadores;
        int minJuagadores;
        int duracionMedia;
        String tipo;

        int op = 0;
        do{
            System.out.println("Ingrese tipo de juego:\n" +
                    "1) Tablero\n" +
                    "2) Cartas");
            op = sc.nextInt();
            sc.nextLine(); // limpiar buffer
        }while(op!=1 || op!=2);


        System.out.println("Introduzca el titulo del juego:");
        titulo = sc.nextLine();
        System.out.println("Introduzca autor:");
        autor = sc.nextLine();
        System.out.println("Introduzca el maximo de jugadores:");
        maxJugadores = sc.nextInt();
        System.out.println("Introduzca el minimo de jugadores:");
        minJuagadores = sc.nextInt();
        System.out.println("Introduzca duracion media");
        duracionMedia = sc.nextInt();

        JuegoMesa.Tipo tipoEnum = JuegoMesa.Tipo.valueOf(tipo);

        do{
            System.out.println("Introduzca tipo entre ESTRATEGIA, PARTY y FAMILIAR:");
            tipo = sc.nextLine();
        }while (!tipo.equals("ESTRATEGIA") && !tipo.equals("PARTY") && !tipo.equals("FAMILIAR"));

        if(op == 1){
            JuegoTablero temp = new JuegoTablero(titulo,autor,maxJugadores,minJuagadores,duracionMedia,tipo);
        }else{
            JuegoCartas temp = new JuegoCartas (titulo,autor,maxJugadores,minJuagadores,duracionMedia,tipo);
        }


    }
}
