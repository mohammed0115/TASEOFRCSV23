/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db.model;
import db.mysql.Model;
import db.mysql.mysql;
import db.mysql.mysql;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author saadia
 */
public class Beams extends Model {
    private String TableName="`Beams`";
   
    
    private String ColumnsList ="`id`,`name`,`volume`,`loss`,`buid_id`".trim();

    
    
    public int volume,loss,id,buid_id ;
    public String name="";
    
    public Beams() throws SQLException
    {
  
        this.setTableName(TableName);
        this.setColumnsList(ColumnsList);
    }
  public int  save() throws SQLException{
      ArrayList<Object> data =new ArrayList<>();
      data.add(id);
      data.add(this.name);
      data.add(this.volume);
      data.add(this.loss);
     data.add(this.buid_id); 
     
    
      if(id==0)
         this.insertRecord(ColumnsList, data.toArray());
      else
          this.Update(data.toArray(), id);
  return 1;
  } 	

    @Override
    public void setParam(ResultSet rs) {
        try {
            if(rs.next())
            {
                this.id=rs.getInt("id");
                this.name=rs.getString("name");
                this.loss=rs.getInt("loss");
                this.volume=rs.getInt("volume");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Beams.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
