package dLillo;

public abstract class JuegoMesa implements Comparable<JuegoMesa>{
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
        titulo = titulo;
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
        titulo = titulo;
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
    public int compareTo(JuegoMesa otro) {
        return this.titulo.compareToIgnoreCase(otro.titulo);
    }
}
