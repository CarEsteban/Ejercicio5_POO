
public class Libero extends Jugador {
    
    private int recibidosEfectivos;

    public Libero(String nombre, String pais, int errores, int aces, int totalServicios, int recibidosEfectivos) {
        super(nombre, pais, errores, aces, totalServicios);
        this.recibidosEfectivos = recibidosEfectivos;
        this.tipo = "Libero";
    }

    @Override
    public void calcularEfectividad() {
        efectividad = ((this.recibidosEfectivos - this.errores) * 100 / (this.recibidosEfectivos + this.errores)) + this.aces * 100 / this.totalServicios;
    }







    
}
