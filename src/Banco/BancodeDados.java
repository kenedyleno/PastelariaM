/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Noite
 */
public class BancodeDados {
    
    private static EntityManagerFactory conexao = Persistence.createEntityManagerFactory("conexao");
    
    public static EntityManager getConexao() {
        return conexao.createEntityManager();
    }
    
}
