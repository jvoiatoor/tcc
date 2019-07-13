/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Oficinas;

/**
 *
 * @author dappo
 */
public class OficinasDAO extends GenericDAO<Oficinas, Long>{
    
    public OficinasDAO(){
        super(Oficinas.class);
    }
    
}
