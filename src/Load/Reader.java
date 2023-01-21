/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Load;


//import Perfomance.Typetester;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




/**
 *
 * @author mohammed
 */
public class Reader {
    
    public static File chooser(){
        FileReader FileReader = null;
        File file=null;
        String fileName ;
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Load which file?");
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) 
            file = chooser.getSelectedFile();
//            if (file != null) {
//                fileName = file.getCanonicalPath();
//                FileReader=new FileReader(fileName);
//            }
    return file;
    }
    
    
    public Iterator<Row> getIterSheet( File file){
    Iterator<Row> itr=null;
     FileInputStream fis; 
        try {
            //.xls
            fis = new FileInputStream(file);
            HSSFWorkbook wb;
            try {
                wb = new HSSFWorkbook(fis);
                HSSFSheet sheet=wb.getSheetAt(0);
                itr = sheet.iterator(); 
            }catch(OfficeXmlFileException e){
                
                fis = new FileInputStream(file);   //obtaining bytes from the file  
                //creating Workbook instance that refers to .xlsx file  
                XSSFWorkbook xwb;   
                try {
                    xwb = new XSSFWorkbook(fis);
                    XSSFSheet sheet = xwb.getSheetAt(0);     //creating a Sheet object to retrieve object  
                    itr = sheet.iterator();    //iterating over excel file      
                    
                }catch (IOException ex) {
                    Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
                }
                 
            
            } 
            catch (IOException ex) {
                Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
        }
    
   
//        XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
       //iterating over excel file  
    return itr;
    }
    
    public  ArrayList<Object[]>   getDataImportedFromExcel() throws FileNotFoundException, IOException{
    ArrayList<Object[]> Data=new ArrayList<>();
    
    
    File file=chooser(); 
    if (file != null) {

        Iterator<Row> itr = getIterSheet(file);    //iterating over excel file  
       
        while (itr.hasNext())                 
        {  
            Row row = itr.next();  
            Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
            int i=0;
            Object rowData[]=new Object[5];
            while (cellIterator.hasNext())   
            {  
                Cell cell = cellIterator.next();  
                
//                Typetester.printType(cell.getCellType().toString());
                switch(cell.getCellType().toString())  
                    {  
                        case "NUMERIC":   //field that represents numeric cell type  
                        //getting the value of the cell as a number  
                        System.out.print(cell.getNumericCellValue()+ "\t\tn"); 
                        rowData[i]=cell.getNumericCellValue();
                        break;  
                        case "STRING":    //field that represents string cell type  
                        //getting the value of the cell as a string  
                        System.out.print(cell.getStringCellValue()+ "\t\t s");  
                        rowData[i]=cell.getStringCellValue();
                        break;  

                    }  
                if(i==4)
                    break;
                i++;
         
             }
            System.out.println(""); 
            Data.add(rowData);
    }
    
    
    }
    
    
    return Data;
    
    }
    public static void main(String args[]) throws IOException {  
        Reader v=new Reader();
        v.getDataImportedFromExcel();
    
    
    
       
     
} 

}