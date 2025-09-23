package dLillo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public abstract class JuegoMesa implements Comparable<JuegoMesa>{   // Lo hago abstracto para que no se puedan crear objetos de este tipo
    private String titulo;
    private String autor;
    private int maxJugadores;
    private int minJugadores;
    private int duracionMedia;
    private Tipo tipo;

    public enum Tipo {
        ESTRATEGIA, PARTY, FAMILIAR;
    }

    public JuegoMesa(String titulo, String autor, int maxJugadores, int minJugadores, int duracionMedia, Tipo tipo) {
        this.titulo = titulo;
        this.autor = autor;
        this.maxJugadores = maxJugadores;
        this.minJugadores = minJugadores;
        this.duracionMedia = duracionMedia;
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getMaxJugadores() {
        return maxJugadores;
    }

    public void setMaxJugadores(int maxJugadores) {
        this.maxJugadores = maxJugadores;
    }

    public int getMinJugadores() {
        return minJugadores;
    }

    public void setMinJugadores(int minJugadores) {
        this.minJugadores = minJugadores;
    }

    public int getDuracionMedia() {
        return duracionMedia;
    }

    public void setDuracionMedia(int duracionMedia) {
        this.duracionMedia = duracionMedia;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return  "titulo=" + titulo +
                ", autor=" + autor +
                ", maxJugadores=" + maxJugadores +
                ", minJugadores=" + minJugadores +
                ", duracionMedia=" + duracionMedia +
                ", tipo=" + tipo;
    }

    @Override
    public int compareTo(JuegoMesa otro) {
        if(this.titulo.equals(otro.titulo)) {   //  Si al ordenar por titulo coincide, ordenamos por autor
            return this.autor.compareTo(otro.autor);
        }
        return this.titulo.compareToIgnoreCase(otro.titulo);
    }

    public abstract void mostrarInfo();

    public void logOperacion(String mensaje) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("inventario.log", true))) {
            bw.write(new Date() + " - " + mensaje + " con titulo: " + this.titulo);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Error al escribir log: " + e.getMessage());
        }
    }
}
