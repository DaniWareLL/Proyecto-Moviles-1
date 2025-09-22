package dLillo;

public class JuegoCartas extends JuegoMesa{
    private int numeroCartas;

    public JuegoCartas(String titulo, String autor, int maxJugadores, int minJugadores, int duracionMedia, Tipo tipo, int numeroCartas) {
        super(titulo, autor, maxJugadores, minJugadores, duracionMedia, tipo);
        this.numeroCartas = numeroCartas;
    }

    public int getNumeroCartas() {
        return numeroCartas;
    }

    public void setNumeroCartas(int numeroCartas) {
        this.numeroCartas = numeroCartas;
    }

    @Override
    public void mostrarInfo() { //  Metodo abstracto
        System.out.println("JuegoTablero{" +
                super.toString() +
                ", numeroCartas=" + numeroCartas +
                '}');
    }
}
