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
    private Doador daodor;
    private String nomeDoador;
    private String cpfDoador;
    private Date dataNacDoador;
    private String tipoSanguineoDoador;

    public Doacao(Integer id, Date dataHora, Integer doadorId) {
        this.id = id;
        this.dataHora = dataHora;
        this.doadorId = doadorId;
    }

    public Doacao() {
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

    /**
     * @return the daodor
     */
    public Doador getDaodor() {
        return daodor;
    }

    /**
     * @param daodor the daodor to set
     */
    public void setDaodor(Doador daodor) {
        this.daodor = daodor;
    }

    /**
     * @return the nomeDoador
     */
    public String getNomeDoador() {
        return nomeDoador;
    }

    /**
     * @param nomeDoador the nomeDoador to set
     */
    public void setNomeDoador(String nomeDoador) {
        this.nomeDoador = nomeDoador;
    }

    /**
     * @return the cpfDoador
     */
    public String getCpfDoador() {
        return cpfDoador;
    }

    /**
     * @param cpfDoador the cpfDoador to set
     */
    public void setCpfDoador(String cpfDoador) {
        this.cpfDoador = cpfDoador;
    }

    /**
     * @return the dataNacDoador
     */
    public Date getDataNacDoador() {
        return dataNacDoador;
    }

    /**
     * @param dataNacDoador the dataNacDoador to set
     */
    public void setDataNacDoador(Date dataNacDoador) {
        this.dataNacDoador = dataNacDoador;
    }

    /**
     * @return the tipoSanguineoDoador
     */
    public String getTipoSanguineoDoador() {
        return tipoSanguineoDoador;
    }

    /**
     * @param tipoSanguineoDoador the tipoSanguineoDoador to set
     */
    public void setTipoSanguineoDoador(String tipoSanguineoDoador) {
        this.tipoSanguineoDoador = tipoSanguineoDoador;
    }
 
    
    
}
