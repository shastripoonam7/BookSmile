import java.sql.*;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.openide.util.Exceptions;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author my
 */
public class NewClass {
    public static  String tmpval;
     public Connection con=null;
     public static Connection NewClass()
     {

         try {
              Class.forName("com.mysql.jdbc.Driver");
            
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pmsdb","root","");
           return con;
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null,e);
             return null;
         }
     }


}
