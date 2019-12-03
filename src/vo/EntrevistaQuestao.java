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
public class EntrevistaQuestao {
    private Integer id;
    private Integer entrevistaId;
    private Integer questaoId;
    private String resposta;

    public EntrevistaQuestao(Integer id, Integer entrevistaId, Integer questaoId, String resposta) {
        this.id = id;
        this.entrevistaId = entrevistaId;
        this.questaoId = questaoId;
        this.resposta = resposta;
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
     * @return the entrevistaId
     */
    public Integer getEntrevistaId() {
        return entrevistaId;
    }

    /**
     * @param entrevistaId the entrevistaId to set
     */
    public void setEntrevistaId(Integer entrevistaId) {
        this.entrevistaId = entrevistaId;
    }

    /**
     * @return the questaoId
     */
    public Integer getQuestaoId() {
        return questaoId;
    }

    /**
     * @param questaoId the questaoId to set
     */
    public void setQuestaoId(Integer questaoId) {
        this.questaoId = questaoId;
    }

    /**
     * @return the resposta
     */
    public String getResposta() {
        return resposta;
    }

    /**
     * @param resposta the resposta to set
     */
    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
    
    
    
    
}
