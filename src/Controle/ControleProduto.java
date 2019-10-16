/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Banco.BancoProduto;
import entidades.Produto;
import java.util.List;

/**
 *
 * @author Noite
 */
public class ControleProduto {
      
    BancoProduto banco = new BancoProduto();
    
    public String salvar(String codigo, String valor, String descricao) {
        
        Produto p = new Produto();
        p.setCodigo(codigo);
        valor = valor.substring(3).replace(",", ".");
        p.setValor(Double.parseDouble(valor));
        p.setDescricao(descricao);
        
        return banco.salvar(p);
    }
    
     public String atualizar(Produto c) {
         return banco.atualizar(c);
     }
    public String recuperarValor(String cod) {
        
        Produto p = banco.recuperar(cod);
        
        return "R$ "+p.getValor();
    }
    
    public Produto recuperar(String cod) {
        
        return banco.recuperar(cod);
    }
    
     public List<Produto> pesquisar (String pesquisa ){
         return banco.pesquisar(pesquisa);
     }
}
