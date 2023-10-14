public class Jugador {
    //atributo el cuál almacenará el nombre del jugador del torneo.
    protected String nombre;
    //atributo el cuál almacenará el país del jugador del torneo.
    protected String pais;
    //atributo el cuál almacenará los errores del jugador del torneo.
    protected int errores;
    //atributo el cuál almacenará los puntos directos por servicios del jugador del torneo.
    protected int aces;
    //atributo el cuál almacenará el total de servicios del jugador del torneo.
    protected int totalServicios;
    //atributo el cuál almacenará la efectividad del jugador del torneo.
    protected double efectividad;
    //atributo el cuál almacenará el tipo del jugador del torneo.
    protected String tipo;

    /**
     * método el cuál permite crear instancias de tipo jugador.
     * 
     * @param nombre parámetro el cuál almacenará el nombre del jugador del torneo.
     * @param pais parámetro el cuál almacenará el país del jugador del torneo.
     * @param errores parámetro el cuál almacenará los errores del jugador del torneo.
     * @param aces parámetro el cuál almacenará los puntos directos por servicios del jugador del torneo.
     * @param totalServicios parámetro el cuál almacenará el total de servicios del jugador del torneo.
     * @param efectividad parámetro el cuál almacenará la efectividad del jugador del torneo.
     * @param tipo parámetro el cuál almacenará el tipo del jugador del torneo.
     */
    public Jugador(String nombre, String pais, int errores, int aces, int totalServicios, double efectividad, String tipo) {
        this.nombre = nombre;
        this.pais = pais;
        this.errores = errores;
        this.aces = aces;
        this.totalServicios = totalServicios;
        this.efectividad = efectividad;
        this.tipo = tipo;
    }

    /**
     * 
     * @return método el cuál obtiene el nombre del jugador del torneo.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * método el cuál permite establecer el nombre del jugador del torneo. 
     * 
     * @param nombre parámetro el cuál almacenará el nombre del jugador del torneo.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * 
     * @return método el cuál obtiene el país del jugador del torneo.
     */
    public String getPais() {
        return this.pais;
    }

    /**
     * método el cuál permite establecer el país del jugador del torneo.
     * 
     * @param pais parámetro el cuál almacenará el país del jugador del torneo.
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * 
     * @return método el cuál obtiene los errores del jugador del torneo.
     */
    public int getErrores() {
        return this.errores;
    }

    /**
     * método el cuál permite establecer los errores del jugador del torneo.
     * 
     * @param errores parámetro el cuál almacenará los errores del jugador del torneo.
     */
    public void setErrores(int errores) {
        this.errores = errores;
    }

    /**
     * 
     * @return método el cuál obtiene los aces del jugador del torneo.
     */
    public int getAces() {
        return this.aces;
    }

    /**
     * método el cuál permite establecer los aces del jugador del torneo.
     * 
     * @param aces parámetro el cuál almacenará los puntos directos por servicios del jugador del torneo.
     */
    public void setAces(int aces) {
        this.aces = aces;
    }

    /**
     * 
     * @return método el cuál obtiene el total de sercicios del jugador del torneo.
     */
    public int getTotalServicios() {
        return this.totalServicios;
    }

    /**
     * método el cuál permite establecer el total de servicios del jugador del torneo.
     * 
     * @param totalServicios parámetro el cuál almacenará el total de servicios del jugador del torneo.
     */
    public void setTotalServicios(int totalServicios) {
        this.totalServicios = totalServicios;
    }

    /**
     * 
     * @return método el cuál obtiene la efectividad del jugador del torneo.
     */
    public double getEfectividad() {
        return this.efectividad;
    }

    /**
     * método el cuál permite establecer la efectividad del jugador del torneo.
     * 
     * @param efectividad parámetro el cuál almacenará la efectividad del jugador del torneo.
     */
    public void setEfectividad(double efectividad) {
        this.efectividad = efectividad;
    }

    /**
     * 
     * @return método el cuál obtiene el tipo del jugador del torneo.
     */
    public String getTipo() {
        return this.tipo;
    }

    /**
     * método el cuál permite establecer el tipo del jugador del torneo.
     * 
     * @param tipo parámetro el cuál almacenará el tipo del jugador del torneo.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * 
     * @return método que permite calcular la efectividad.
     */
    public double calcularEfectividad(){
        return aces * 100 / totalServicios;
    }


}
