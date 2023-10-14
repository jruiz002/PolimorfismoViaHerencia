public class Libero extends Jugador{
    // atributo que almacenará el número de recibos efectivos de un jugadore del torneo.
    private int recibosEfectivos;

    /**
     * 
     * @param nombre parámetro el cuál almacenará el nombre del jugador del torneo.
     * @param pais parámetro el cuál almacenará el país del jugador del torneo.
     * @param errores parámetro el cuál almacenará los errores del jugador del torneo.
     * @param aces parámetro el cuál almacenará los puntos directos por servicios del jugador del torneo.
     * @param totalServicios parámetro el cuál almacenará el total de servicios del jugador del torneo.
     * @param efectividad parámetro el cuál almacenará la efectividad del jugador del torneo.
     * @param tipo parámetro el cuál almacenará el tipo del jugador del torneo.
     * @param recibosEfectivos atributo que almacenará el número de recibos efectivos de un jugadore del torneo.
     */
    public Libero(String nombre, String pais, int errores, int aces, int totalServicios, double efectividad, String tipo, int recibosEfectivos) {
        super(nombre, pais, errores, aces, totalServicios, efectividad, tipo);
        this.recibosEfectivos = recibosEfectivos;
    }

    /**
     * 
     * @return método el cuál obtiene los recibos efectivos del jugador del torneo.
     */
    public int getRecibosEfectivos() {
        return this.recibosEfectivos;
    }

    /**
     * método el cuál permite establecer los recibos efectivos del jugador del torneo.
     * 
     * @param recibosEfectivos atributo que almacenará el número de recibos efectivos de un jugadore del torneo.
     */
    public void setRecibosEfectivos(int recibosEfectivos) {
        this.recibosEfectivos = recibosEfectivos;
    }

    /**
     * @return método (override) que permite calcular la efectividad de un jugador de tipo Libero.
     */
    @Override
    public double calcularEfectividad(){
        return ((recibosEfectivos - errores) * 100 / (recibosEfectivos + errores)) + super.calcularEfectividad();
    }

    /**
     * @return método el cuál imprime la información de un Líbero.
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", País: " + pais + ", Errores: " 
        + errores + ", Aces: " + aces + ", Total Servicios: " + totalServicios 
        + ", Efectividad: " + efectividad + ", Tipo: " + tipo + ", Recibos Efectivos: " 
        + recibosEfectivos;
    }


}
