/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

/**
 *
 * @author robson
 */
public class Exame {
    private Integer id;
    private Integer tipoExameId;
    private String resultado;
    private Integer doadorId;

    public Exame(Integer id, Integer tipoExameId, String resultado, Integer doadorId) {
        this.id = id;
        this.tipoExameId = tipoExameId;
        this.resultado = resultado;
        this.doadorId = doadorId;
    }
    
    

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the tipoExameId
     */
    public Integer getTipoExameId() {
        return tipoExameId;
    }

    /**
     * @param tipoExameId the tipoExameId to set
     */
    public void setTipoExameId(Integer tipoExameId) {
        this.tipoExameId = tipoExameId;
    }

    /**
     * @return the resultado
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * @param resultado the resultado to set
     */
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    /**
     * @return the doadorId
     */
    public Integer getDoadorId() {
        return doadorId;
    }

    /**
     * @param doadorId the doadorId to set
     */
    public void setDoadorId(Integer doadorId) {
        this.doadorId = doadorId;
    }
    
    
}
