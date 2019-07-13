/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author dappo
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Criarconta.findAll", query = "SELECT a FROM Criarconta a"),
    @NamedQuery(name = "Criarconta.findFilter", query = "SELECT a FROM Criarconta a WHERE a.nome like :filtro"),
    @NamedQuery(name = "Criarconta.logar", query = "SELECT a FROM Criarconta a WHERE a.email = :email and a.senha = :senha")
})
public class Criarconta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nome;
    
    private String email;
    
    private String senha;
    
    private String telefone;
    
    private Boolean garagem;

    public Boolean getGaragem() {
        return garagem;
    }

    public void setGaragem(Boolean garagem) {
        this.garagem = garagem;
    }
    
   

   

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    private String endFoto;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndFoto() {
        return endFoto;
    }

    public void setEndFoto(String endFoto) {
        this.endFoto = endFoto;
    }

    
    
    


  
    

    
}
