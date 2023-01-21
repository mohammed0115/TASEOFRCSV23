package db.model;


import db.mysql.Model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class buildingclassification extends Model{
    public int id,sub_criteria,linguistic_variable,StateCoditinClassification;
    public String StateCondition;
    public buildingclassification()
    {
        this.TableName="buildingclassification";
        this.ColumnsList="`id`, `sub_criteria`, `linguistic_variable`, `StateCondition`, `StateCoditinClassification` ";
    }
    public int  save() throws SQLException{
          ArrayList<Object> data =new ArrayList<>();
          data.add(id);
          data.add(this.sub_criteria);
          data.add(this.linguistic_variable);
          data.add(this.StateCondition);
          data.add(this.StateCoditinClassification);
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
                this.sub_criteria=rs.getInt("sub_criteria");
                this.linguistic_variable=rs.getInt("linguistic_variable");
                this.StateCondition=rs.getString("StateCondition");
                this.StateCoditinClassification=rs.getInt("StateCoditinClassification");
            }
        } catch (SQLException ex) {
            
        }
    }
        
}
