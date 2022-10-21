/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eduar
 */
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
 
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
 
 
import java.sql.*;
 
/**
* You'll need these jar's below:
*
* jasperreports-5.0.1.jar
* iText-2.1.7.jar (needed to generate PDF)
* jfreechart-1.0.12.jar (needed to graphics and charts)
* jcommon-1.0.15.jar (needed to graphics and charts)
* commons-beanutils-1.8.2.jar
* commons-collections-3.2.1.jar
* commons-digester-2.1.jar
* commons-logging-1.1.jar
*/
public class compil_jrxml {
 
public static void main(String[] args) {
  int count = args.length;
  try {
   if (count>0) {
    String reportName = args[0];
    String str[]=reportName.split("\\.");
    String reportName_jasper = str[0] + ".jasper";
    // compiles jrxml
    JasperCompileManager.compileReportToFile(reportName, reportName_jasper);
   }
 
  } catch (Exception e) {
   throw new RuntimeException("It's not possible to generate the jasper report.", e);
  }
 
}
 
}