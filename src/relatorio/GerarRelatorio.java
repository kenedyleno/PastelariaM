/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorio;

import Banco.BancoHistorico;
import entidades.Historico;
import java.util.Date;
import java.util.List;
import org.exibir.pdf.Print_new;

/**
 *
 * @author Noite
 */
public class GerarRelatorio {

    BancoHistorico conexao = new BancoHistorico();
    Print_new p = new Print_new();

    public void gerarRelatorio(Date inicio, Date fim) {
        List<Historico> lista = conexao.pesquisar(inicio, fim);
        System.out.println(lista.size());
        p.gerarRelatorioSub(lista, "relatorio.jasper", "produtos.jasper", "logo.png", "relatorio.pdf");
        p.exibirPDF("relatorio.pdf");

    }

}