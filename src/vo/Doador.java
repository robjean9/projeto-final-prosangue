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
public class Doador {
    private Integer id;
    private String nome;
    private String endereco;
    private Date dataNascimento;
    private String nomePai;
    private String nomeMae;
    private String cpf;

    public Doador(Integer id, String nome, String endereco, Date dataNascimento, String nomePai, String nomeMae, String cpf) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.nomePai = nomePai;
        this.nomeMae = nomeMae;
        this.cpf = cpf;
    }

    public Doador() {
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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the dataNascimento
     */
    public Date getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * @return the nomePai
     */
    public String getNomePai() {
        return nomePai;
    }

    /**
     * @param nomePai the nomePai to set
     */
    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    /**
     * @return the nomeMae
     */
    public String getNomeMae() {
        return nomeMae;
    }

    /**
     * @param nomeMae the nomeMae to set
     */
    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
    
    
    
    
}
