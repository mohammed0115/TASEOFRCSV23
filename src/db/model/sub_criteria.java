/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.model;

import db.mysql.Model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class sub_criteria extends Model{
    public int id;
    public String name;
    public sub_criteria()
    {
        this.TableName="sub_criteria";
        this.ColumnsList=" `id`, `name`";
    }
    
     public int  save() throws SQLException{
      ArrayList<Object> data =new ArrayList<>();
      data.add(id);
      data.add(this.name);
     
     
    
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
//                this.sub_criteria=rs.getInt("sub_criteria");
//                this.linguistic_variable=rs.getInt("linguistic_variable");
                this.name=rs.getString("name");
//                this.StateCoditinClassification=rs.getInt("StateCoditinClassification");
            }
        } catch (SQLException ex) {
            
        }
    }
}
