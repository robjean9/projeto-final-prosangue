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
public class Consulta {
    
    private Integer id;
    private Integer doadorId;
    private String diagnostico;
    private Date dataHora;
    private Integer usuarioId;

    public Consulta(Integer id, Integer doadorId, String diagnostico, Date dataHora, Integer usuarioId) {
        this.id = id;
        this.doadorId = doadorId;
        this.diagnostico = diagnostico;
        this.dataHora = dataHora;
        this.usuarioId = usuarioId;
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

    /**
     * @return the diagnostico
     */
    public String getDiagnostico() {
        return diagnostico;
    }

    /**
     * @param diagnostico the diagnostico to set
     */
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
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
     * @return the usuarioId
     */
    public Integer getUsuarioId() {
        return usuarioId;
    }

    /**
     * @param usuarioId the usuarioId to set
     */
    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
    
    
    
    
}
