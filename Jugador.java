/**
 * La clase Jugador representa a un jugador genérico en un equipo de voley.
 */
public abstract class Jugador {
    
    protected String nombre,  pais, tipo;
    protected int errores,aces,totalServicios,efectividad;

    /**
     * Constructor de la clase Jugador.
     * 
     * @param nombre            Nombre del jugador.
     * @param pais              País de origen del jugador.
     * @param errores           Número de errores cometidos por el jugador.
     * @param aces              Número de aces hechos por el jugador.
     * @param totalServicios    Número total de servicios realizados por el jugador.
     */
    public Jugador(String nombre, String pais, int errores, int aces, int totalServicios) {
        this.nombre = nombre;
        this.pais = pais;
        this.errores = errores;
        this.aces = aces;
        this.totalServicios = totalServicios;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public String getTipo() {
        return tipo;
    }

    public int getErrores() {
        return errores;
    }

    public int getAces() {
        return aces;
    }

    public int getTotalServicios() {
        return totalServicios;
    }

    public int getEfectividad() {
        return efectividad;
    }

    public abstract void calcularEfectividad();







}
