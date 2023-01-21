/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Load;
import db.model.statecoditinclassification;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToDb {
    public static void main( String [] args ) {
        String fileName="C://Users//user//Documents//NetBeansProjects//Book1.xlsx";
        Vector dataHolder=read(fileName);
        saveToDatabase(dataHolder);
    }
    public static Vector read(String fileName)    {
        Vector cellVectorHolder = new Vector();
        try{
            FileInputStream myInput = new FileInputStream(fileName);
            //POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);
            XSSFWorkbook myWorkBook = new XSSFWorkbook(fileName);
            XSSFSheet mySheet = myWorkBook.getSheetAt(0);
            Iterator rowIter = mySheet.rowIterator();
            while(rowIter.hasNext()){
                XSSFRow myRow = (XSSFRow) rowIter.next();
                Iterator cellIter = myRow.cellIterator();
                //Vector cellStoreVector=new Vector();
                List list = new ArrayList();
                while(cellIter.hasNext()){
                    XSSFCell myCell = (XSSFCell) cellIter.next();
                    list.add(myCell);
                }
                cellVectorHolder.addElement(list);
            }
        }catch (Exception e){e.printStackTrace(); }
        return cellVectorHolder;
    }
    private static void saveToDatabase(Vector dataHolder) {
        String ClientAdd="";
        String Page="";
        String AccessDate="";
        String   idd="";
        String name="";
        int id=0;
        
        System.out.println(dataHolder);

        for(Iterator iterator = dataHolder.iterator();iterator.hasNext();) {
            List list = (List) iterator.next();
            ClientAdd = list.get(0).toString();
            Page = list.get(1).toString();
            name = list.get(2).toString();
            idd = list.get(3).toString();
            id=Integer.parseInt(idd);
            try {
//                Class.forName("com.mysql.jdbc.Driver").newInstance();
//                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "welcome");
//                System.out.println("connection made...");
//                PreparedStatement stmt=con.prepareStatement("INSERT INTO ClickStream(ClientAdd,Page,AccessDate,ProcessTime) VALUES(?,?,?,?)");
//                stmt.setString(1, ClientAdd);
//                stmt.setString(2, Page);
//                stmt.setString(3, AccessDate);
//                stmt.setString(4, ProcessTime);
//                stmt.executeUpdate();

                System.out.println("Data is inserted");
                statecoditinclassification c=new statecoditinclassification();
                c.id=id;
                c.name=c.name;
                c.save();
//                stmt.close();
//                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



        }
    }