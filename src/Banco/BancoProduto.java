/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import entidades.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Noite
 */
public class BancoProduto {

    EntityManager conexao = BancodeDados.getConexao();

    public String salvar(Produto c) {

        try {
            conexao.getTransaction().begin();
            conexao.persist(c);
            conexao.getTransaction().commit();
            return "Produto cadastrado com sucesso";
        } catch (Exception e) {
            conexao.getTransaction().rollback();
            return "Erro ao cadastrar produto";
        }
    }

    public String atualizar(Produto c) {

        try {
            conexao.getTransaction().begin();
            conexao.merge(c);
            conexao.getTransaction().commit();
            return "Produto atualizado com sucesso";
        } catch (Exception e) {
            conexao.getTransaction().rollback();
            return "Erro ao atualizar produto";
        }
    }

    public Produto recuperar(String codigo) {

        Query q = conexao.createNativeQuery("select * from produto where codigo = :arg", Produto.class);
        q.setParameter("arg", codigo);
        return q.getResultList().size() > 0 ? (Produto) q.getSingleResult() : null;
    }

    public List<Produto> pesquisar(String pesquisa) {
        Query q = conexao.createNativeQuery("select * from Produto where descricao like :arg ", Produto.class);

        q.setParameter("arg", pesquisa + "%");
        return q.getResultList();

    }

}
