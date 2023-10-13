
public class Pasador extends Jugador {
    
    private int pases, fintasEfectivas;

    public Pasador(String nombre, String pais, int errores, int aces, int totalServicios, int pases, int fintasEfectivas) {
        super(nombre, pais, errores, aces, totalServicios);
        this.pases = pases;
        this.fintasEfectivas = fintasEfectivas;
        this.tipo = "Pasador";
    }

    @Override
    public void calcularEfectividad() {
        efectividad = ((this.pases + this.fintasEfectivas - this.errores) * 100 / (this.pases + this.fintasEfectivas + this.errores)) + this.aces * 100 / this.totalServicios;
    }







    
}
