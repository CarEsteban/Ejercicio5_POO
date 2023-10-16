
public class Libero extends Jugador {
    
    private int recibidosEfectivos;

    public Libero(String nombre, String pais, int errores, int aces, int totalServicios, int recibidosEfectivos) {
        super(nombre, pais, errores, aces, totalServicios);
        this.recibidosEfectivos = recibidosEfectivos;
        this.tipo = "Libero";
        efectividad = ((this.recibidosEfectivos - this.errores) * 100 / (this.recibidosEfectivos + this.errores)) + this.aces * 100 / this.totalServicios;

    }

    @Override
    public int getEfectividad() {
        return efectividad;
    }


    @Override
    public String toString() {
        return  nombre+","+
                pais+","+
                tipo+","+
                errores+","+
                aces+","+
                totalServicios+","+
                recibidosEfectivos+
                ",-,-,-,-,-,"+
                efectividad;
    }



    
}
