/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Banco.BancoHistorico;
import entidades.Historico;

/**
 *
 * @author Noite
 */
public class ControleHistorico {
    
    BancoHistorico banco = new BancoHistorico();
    
    public String salvar(Historico c) {
        return banco.salvar(c);
    }
}
