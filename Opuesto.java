
public class Opuesto extends Jugador {
    
    private int ataques, bloqueosEfectivos, bloqueosFallidos;

    public Opuesto(String nombre, String pais, int errores, int aces, int totalServicios, int ataques, int bloqueosEfectivos,int bloqueosFallidos) {
        super(nombre, pais, errores, aces, totalServicios);
        this.ataques = ataques;
        this.bloqueosEfectivos = bloqueosEfectivos;
        this.bloqueosFallidos = bloqueosFallidos;
        this.tipo = "Opuesto";
        efectividad = ((this.ataques + this.bloqueosEfectivos - this.bloqueosFallidos - this.errores) * 100 / (this.ataques + this.bloqueosEfectivos + this.bloqueosFallidos + this.errores)) + this.aces * 100 / this.totalServicios;

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
                totalServicios+",-,-,-,"+
                ataques+","+
                bloqueosEfectivos+","+
                bloqueosFallidos+","+
                efectividad;
    }





    
}
