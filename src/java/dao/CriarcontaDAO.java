/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Criarconta;



/**
 *
 * @author dappo
 */
public class CriarcontaDAO extends GenericDAO<Criarconta, Long>{
    
    public CriarcontaDAO(){
        super(Criarconta.class);
    }
    
    public Criarconta fazerlogin(String email, String senha){
    
        List<Criarconta> contas = em.createNamedQuery("Criarconta.logar").setParameter("email", email).setParameter("senha", senha).getResultList();
        
        if(0==contas.size()){
            return new Criarconta();
        } else{
            return contas.get(0);
        }
    }
    
}
