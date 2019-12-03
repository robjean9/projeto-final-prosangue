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
public class Questao {
    private Integer id;
    private String questao;

    public Questao(Integer id, String questao) {
        this.id = id;
        this.questao = questao;
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
     * @return the questao
     */
    public String getQuestao() {
        return questao;
    }

    /**
     * @param questao the questao to set
     */
    public void setQuestao(String questao) {
        this.questao = questao;
    }
    
    
    
}
