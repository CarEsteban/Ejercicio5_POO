
public class Pasador extends Jugador {
    
    private int pases, fintasEfectivas;

    public Pasador(String nombre, String pais, int errores, int aces, int totalServicios, int pases, int fintasEfectivas) {
        super(nombre, pais, errores, aces, totalServicios);
        this.pases = pases;
        this.fintasEfectivas = fintasEfectivas;
        this.tipo = "Pasador";
        efectividad = ((this.pases + this.fintasEfectivas - this.errores) * 100 / (this.pases + this.fintasEfectivas + this.errores)) + this.aces * 100 / this.totalServicios;

    }

    @Override
    public int getEfectividad() {
        return efectividad;
    }


    @Override
    public String toString() {
        return "Tipo: " + tipo + "\n" +
               "Nombre: " + nombre + "\n" +
               "País: " + pais + "\n" +
               "Errores: " + errores + "\n" +
               "Aces: " + aces + "\n" +
               "Total de Servicios: " + totalServicios + "\n" +
               "Pases: " + pases + "\n" +
               "Fintas Efectivas: " + fintasEfectivas+ "\n" +
               "Efectividad: " + efectividad;
    }




    
}
