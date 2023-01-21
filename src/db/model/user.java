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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class user extends Model {
    public int id;
    public String firstName, LastName, phone="";
 public user()
 {
     this.setColumnsList("`id`,`firstName`,`LastName`,`phone`");
     this.TableName="user";
 }

 public int  save() throws SQLException{
     
      ArrayList<Object> data =new ArrayList<>();
      data.add(id);
      data.add(this.firstName);
      data.add(this.LastName);
      data.add(this.phone);
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
                this.firstName=rs.getString("firstName");
                this.LastName=rs.getString("LastName");
                this.phone=rs.getString("phone");

            }
        } catch (SQLException ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
