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
public class Entrevista {
    private Integer id;
    private Integer doacaoId;
    private Date dataHora;

    public Entrevista(Integer id, Integer doacaoId, Date dataHora) {
        this.id = id;
        this.doacaoId = doacaoId;
        this.dataHora = dataHora;
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
     * @return the doacaoId
     */
    public Integer getDoacaoId() {
        return doacaoId;
    }

    /**
     * @param doacaoId the doacaoId to set
     */
    public void setDoacaoId(Integer doacaoId) {
        this.doacaoId = doacaoId;
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
    
    
    
    
    
}
