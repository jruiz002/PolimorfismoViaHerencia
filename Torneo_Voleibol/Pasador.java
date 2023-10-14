public class Pasador extends Jugador{
    // atributo el cuál almacena el número de pases del jugador del torneo.
    private int pases;
    // atributo el cuál almacena las fintas del jugador del torneo.
    private int fintas;

    /**
     * método el cuál permite crear instancias de tipo Pasador.
     * 
     * @param nombre parámetro el cuál almacenará el nombre del jugador del torneo.
     * @param pais parámetro el cuál almacenará el país del jugador del torneo.
     * @param errores parámetro el cuál almacenará los errores del jugador del torneo.
     * @param aces parámetro el cuál almacenará los puntos directos por servicios del jugador del torneo.
     * @param totalServicios parámetro el cuál almacenará el total de servicios del jugador del torneo.
     * @param efectividad parámetro el cuál almacenará la efectividad del jugador del torneo.
     * @param tipo parámetro el cuál almacenará el tipo del jugador del torneo.
     * @param pases parámetro el cuál almacena el número de pases del jugador del torneo.
     * @param fintas parámetro el cuál almacena las fintas del jugador del torneo.
     */
    public Pasador(String nombre, String pais, int errores, int aces, int totalServicios, double efectividad, String tipo, int pases, int fintas) {
        super(nombre, pais, errores, aces, totalServicios, efectividad, tipo);
        this.pases = pases;
        this.fintas = fintas;
    }

    /**
     * 
     * @return método el cuál obtiene los pases del jugador del torneo.
     */
    public int getPases() {
        return this.pases;
    }

    /**
     * método el cuál permite establecer los pases del jugador del torneo.
     * 
     * @param pases parámetro el cuál almacena el número de pases del jugador del torneo.
     */
    public void setPases(int pases) {
        this.pases = pases;
    }

    /**
     * 
     * @return método el cuál obtiene las fintas del jugador del torneo.
     */
    public int getFintas() {
        return this.fintas;
    }

    /**
     * método el cuál permite establecer las  fintas del jugador del torneo.
     * 
     * @param fintas parámetro el cuál almacena las fintas del jugador del torneo.
     */
    public void setFintas(int fintas) {
        this.fintas = fintas;
    }

    /**
     * 
     * @return método (override) que permite calcular la efectividad de un jugador de tipo Pasador.
     * 
     */
    @Override
    public double calcularEfectividad(){
        return ((pases + fintas - errores) * 100 / (pases + fintas + errores)) + super.calcularEfectividad();
    }

    /**
     * 
     * @return método el cuál imprime la información de un Pasador.
     * 
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", País: " + pais + ", Errores: " 
        + errores + ", Aces: " + aces + ", Total Servicios: " + totalServicios 
        + ", Efectividad: " + efectividad + ", Tipo: " + tipo + ", Pases: " 
        + pases + ", Fintas: " + fintas;
    }


}
