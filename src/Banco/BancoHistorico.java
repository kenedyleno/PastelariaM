/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import entidades.Historico;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Noite
 */
public class BancoHistorico {
      EntityManager conexao = BancodeDados.getConexao();

    public String salvar(Historico c) {

        try {
            conexao.getTransaction().begin();
            conexao.persist(c);
            conexao.getTransaction().commit();
            return "Venda realizada com sucesso!";
        } catch (Exception e) {
            conexao.getTransaction().rollback();
            return "Erro ao realizar esta venda!";
        }
    }
    
    public List<Historico> pesquisar (Date inicio, Date fim){
    Query q = conexao.createNativeQuery( "select * from Historico where data >= :inicio and data <= :fim",Historico.class);
    q.setParameter("inicio", inicio);
    q.setParameter("fim", fim);
    return q.getResultList();
    
   
}
    
}
