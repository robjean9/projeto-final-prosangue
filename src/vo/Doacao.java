/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import java.util.Date;

/**
 *
 * @author robson
 */
public class Doacao {
    private Integer id;
    private Date dataHora;
    private Integer doadorId;

    public Doacao(Integer id, Date dataHora, Integer doadorId) {
        this.id = id;
        this.dataHora = dataHora;
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
     * @return the dataHora
     */
    public Date getDataHora() {
        return dataHora;
    }

    /**
     * @param dataHora the dataHora to set
     */
    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
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
