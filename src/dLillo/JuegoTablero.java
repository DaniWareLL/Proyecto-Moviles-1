package dLillo;

public class JuegoTablero extends JuegoMesa{
    private int tamanoTablero;

    public JuegoTablero(String titulo, String autor, int maxJugadores, int minJugadores, int duracionMedia, Tipo tipo, int tamanoTablero) {
        super(titulo, autor, maxJugadores, minJugadores, duracionMedia, tipo);
        this.tamanoTablero = tamanoTablero;
    }

    public int getTamanoTablero() {
        return tamanoTablero;
    }

    public void setTamanoTablero(int tamanoTablero) {
        this.tamanoTablero = tamanoTablero;
    }
}
