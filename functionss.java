import java.awt.event.KeyEvent;
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

public class functionss {
    public Connection con=null;
    public ResultSet rs=null;
    public PreparedStatement pst=null;
    public Statement st=null;

    public void Run(String Qry,String ReadORwrite)
    {
        try {
            con=NewClass.NewClass();
            pst=con.prepareStatement(Qry);
            if("Read".equals(ReadORwrite)){
                rs=pst.executeQuery();
            }
            if("Write".equals(ReadORwrite)){
                pst.executeUpdate();
            }



        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
       
    }

   public void SetReport(String iReportUrl,String ParameaterSQlQuery) throws JRException
 {
       con=NewClass.NewClass(); // it has connection coding
      String iiReport="src\\iReport\\";
             String RptPath=iiReport.concat(iReportUrl);
    try {
            JasperDesign jd=JRXmlLoader.load(RptPath);

            
             JRDesignQuery newQuery= new JRDesignQuery();

             newQuery.setText(ParameaterSQlQuery);
             jd.setQuery(newQuery);
            JasperReport jr= JasperCompileManager.compileReport(jd);
            JasperPrint jp =JasperFillManager.fillReport(jr,null,con);
            JasperViewer.viewReport(jp,false);
        } catch (JRException ex) {
            Exceptions.printStackTrace(ex);
        }
 }

    

}
