/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.helper;

import com.agile.ims.entity.Item;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author mhdsy
 */
public class ViewExportReports {

    /**
     * Load and repair any report from reports package only. This parameters
     * will be assigned by other method. this method return JasperPrint. this
     * method will be called by other methods.
     */
    public JasperPrint jasperPrint(String reportName, Collection list) {
        try {

            InputStream jasperStream = this.getClass().getResourceAsStream("/reports/" + reportName);
            JasperDesign design = JRXmlLoader.load(jasperStream);
            JasperReport report = JasperCompileManager.compileReport(design);

            Map<String, Object> parameterMap = new HashMap<>();
            ArrayList<Item> products = new ArrayList<>(list);

            JRDataSource jRDataSource = new JRBeanCollectionDataSource(products);

            parameterMap.put("datasource", jRDataSource);

            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameterMap, jRDataSource);
            return jasperPrint;
        } catch (JRException ex) {
            Logger.getLogger(ViewExportReports.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * View report to print it. this method call jasperPrint method. use report
     * parameter to call report file from reports package.
     * list parameter to get data.
     */
    public void viewReport(String reportName, Collection list) {

        JasperViewer jasperViewer = new JasperViewer(jasperPrint(reportName, list), false);
        jasperViewer.setVisible(true);
    }

    /**
     * this method open dialog to save file and return File.
     */
    public File saveFile(String fileType, String extension) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter(fileType, extension));
        fileChooser.setSelectedFile(new File("report." + extension));
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File reportFile = fileChooser.getSelectedFile();
            if (FilenameUtils.getExtension(reportFile.getName()).equalsIgnoreCase(extension)) {
                // filename is OK...
            } else {
                reportFile = new File(reportFile.toString() + "." + extension);  // append extension if "foo.jpg.extension" is OK
                reportFile = new File(reportFile.getParentFile(), FilenameUtils.getBaseName(reportFile.getName()) + "." + extension); // ALTERNATIVELY: remove the extension (if any) and replace it with extension parameter.
            }
            return reportFile;
        } else {
            return null;
        }
    }

    /**
     * Export report to excel file. this method call jasperPrint method. use
     * this parameter to call report file from reports package.
     * list parameter to get data.
     */
    public void exportToExcel(String reportName, Collection list) {
        OutputStream outputStream = null;
        File file = saveFile("Excel File", "xls");
        try {
            outputStream = new FileOutputStream(file);
            JRXlsExporter exporter = new JRXlsExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint(reportName, list)));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
            exporter.exportReport();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ViewExportReports.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(ViewExportReports.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                outputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(ViewExportReports.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Export report to PDF file. this method call jasperPrint method. use this
     * parameter to call report file from reports package.
     * list parameter to get data.
     */
    public void exportToPDF(String reportName, Collection list) {
        OutputStream outputStream = null;
        File file = saveFile("PDF File", "PDF");
        try {
            outputStream = new FileOutputStream(file);
            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint(reportName, list)));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
            SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
            configuration.setMetadataAuthor("X-NET"); //Set pdf configurations 
            exporter.setConfiguration(configuration);
            exporter.exportReport();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ViewExportReports.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(ViewExportReports.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                outputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(ViewExportReports.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
