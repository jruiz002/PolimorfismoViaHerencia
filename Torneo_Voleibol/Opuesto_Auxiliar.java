public class Opuesto_Auxiliar extends Jugador{
    // atributo el cuál almacena el número de bloqueos efectivos del jugador del torneo.
    private int bloqueosEfectivos;
    // atributo el cuál almacena el número de bloqueos fallidos del jugador del torneo.
    private int bloqueosFallidos;
    // atributo el cuál almacena el número de ataques efectivos del jugador del torneo.
    private int ataques;

    /**
     * 
     * método el cual crea instancia de tipo Opuesto_Auxiliar.
     * 
     * @param nombre parámetro el cuál almacenará el nombre del jugador del torneo.
     * @param pais parámetro el cuál almacenará el país del jugador del torneo.
     * @param errores parámetro el cuál almacenará los errores del jugador del torneo.
     * @param aces parámetro el cuál almacenará los puntos directos por servicios del jugador del torneo.
     * @param totalServicios parámetro el cuál almacenará el total de servicios del jugador del torneo.
     * @param efectividad parámetro el cuál almacenará la efectividad del jugador del torneo.
     * @param tipo parámetro el cuál almacenará el tipo del jugador del torneo.
     * @param bloqueosEfectivos parámetro el cuál almacena el número de bloqueos efectivos del jugador del torneo.
     * @param bloqueosFallidos parámetro el cuál almacena el número de bloqueos fallidos del jugador del torneo.
     * @param ataques parámetros el cuál almacena el número de ataques efectivos del jugador del torneo.
     */
    public Opuesto_Auxiliar(String nombre, String pais, int errores, int aces, int totalServicios, double efectividad, String tipo, int bloqueosEfectivos, int bloqueosFallidos, int ataques) {
        super(nombre, pais, errores, aces, totalServicios, efectividad, tipo);
        this.bloqueosEfectivos = bloqueosEfectivos;
        this.bloqueosFallidos = bloqueosFallidos;
        this.ataques = ataques;
    }

    /**
     * 
     * @return método el cuál obtiene los bloqueos efectivos del jugador del torneo.
     */
    public int getBloqueosEfectivos() {
        return this.bloqueosEfectivos;
    }

    /**
     * 
     * método el cuál permite establecer los bloqueos efectivos del jugador del torneo.
     * 
     * @param bloqueosEfectivos atributo el cuál almacena el número de bloqueos efectivos del jugador del torneo.
     */
    public void setBloqueosEfectivos(int bloqueosEfectivos) {
        this.bloqueosEfectivos = bloqueosEfectivos;
    }

    /**
     * 
     * @return método el cuál obtiene los bloqueos fallidos del jugador del torneo.
     */
    public int getBloqueosFallidos() {
        return this.bloqueosFallidos;
    }

    /**
     * 
     * método el cuál permite establecer los bloqueos fallidos del jugador del torneo.
     * 
     * @param bloqueosFallidos atributo el cuál almacena el número de bloqueos fallidos del jugador del torneo.
     */
    public void setBloqueosFallidos(int bloqueosFallidos) {
        this.bloqueosFallidos = bloqueosFallidos;
    }

    /**
     * 
     * @return método el cuál obtiene los ataques del jugador del torneo.
     */
    public int getAtaques() {
        return this.ataques;
    }

    /**
     * 
     * método el cuál permite establecer los ataques del jugador del torneo.
     * 
     * @param ataques atributo el cuál almacena el número de ataques efectivos del jugador del torneo.
     */
    public void setAtaques(int ataques) {
        this.ataques = ataques;
    }


    /**
     * 
     * @return método (override) que permite calcular la efectividad de un jugador de tipo Opuesto_Auxiliar.
     * 
     */
    @Override
    public double calcularEfectividad(){
        return (ataques + bloqueosEfectivos - bloqueosFallidos - errores) * 100 / (ataques + bloqueosEfectivos + bloqueosFallidos + errores)
                 + super.calcularEfectividad();
    }

    /**
     * 
     * @return método el cuál imprime la información de un Opuesto_Auxiliar.
     * 
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", País: " + pais + ", Errores: " 
        + errores + ", Aces: " + aces + ", Total Servicios: " + totalServicios 
        + ", Efectividad: " + efectividad + ", Tipo: " + tipo + ", Bloqueos Efectivos: " 
        + bloqueosEfectivos + ", Bloqueos Fallidos: " + bloqueosFallidos + ", Ataques: " + ataques;
    }


}
