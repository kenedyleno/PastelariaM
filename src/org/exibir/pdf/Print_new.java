/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.exibir.pdf;

import java.awt.Frame;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

/**
 *
 * @author renatohidaka
 */
public class Print_new {

    public void exibirPDF(String arquivo) {
        SwingController controller = new SwingController();
        SwingViewBuilder factory = new SwingViewBuilder(controller);//, properties);
        JPanel viewerComponentPanel = factory.buildViewerPanel();
        JFrame applicationFrame = new JFrame();
        applicationFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        applicationFrame.getContentPane().add(viewerComponentPanel);
        controller.openDocument(arquivo);
        applicationFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
        applicationFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        applicationFrame.addWindowListener(controller);
        applicationFrame.pack();
        applicationFrame.setVisible(true);
    }

    public void gerarRelatorio(List lista, String relatorio, String imagem, String pdf) {
        try {
            JRBeanCollectionDataSource rel = new JRBeanCollectionDataSource(lista);
            HashMap<String, Object> map = new HashMap();
            map.put("logo", imagem);
            JasperPrint print = JasperFillManager.fillReport(relatorio, map, rel);
            JasperExportManager.exportReportToPdfFile(print, pdf);
        } catch (JRException ex) {
            Logger.getLogger(Print_new.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void gerarRelatorioSub(List lista, String relatorio, String subRelatorio, String logo, String pdf) {
        try {
            JRBeanCollectionDataSource rel = new JRBeanCollectionDataSource(lista);
            HashMap<String, Object> map = new HashMap();
            map.put("logo", logo);
            map.put("subRelatorio", subRelatorio);
            JasperPrint print = JasperFillManager.fillReport(relatorio, map, rel);
            JasperExportManager.exportReportToPdfFile(print, pdf);
        } catch (JRException ex) {
            Logger.getLogger(Print_new.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
