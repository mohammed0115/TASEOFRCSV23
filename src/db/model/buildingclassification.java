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
    
    public sub_criteria criteria;
    public statecoditinclassification StateCoditin;
    public buildingclassification()
    {
        this.TableName="buildingclassification";
        this.ColumnsList="`id`, `sub_criteria`, `linguistic_variable`, `StateCondition`, `StateCoditinClassification` ";
    }
    public int  save() throws SQLException{
          ArrayList<Object> data =new ArrayList<>();
          data.add(id);
          data.add(this.sub_criteria);
          criteria=new sub_criteria();
          criteria.Find(this.sub_criteria);
          data.add(this.linguistic_variable);
          data.add(this.StateCondition);
          data.add(this.StateCoditinClassification);
          StateCoditin=new statecoditinclassification();
          StateCoditin.Find(this.StateCoditinClassification);
          if(id==0)
             this.insertRecord(ColumnsList, data.toArray());
             
          else
             this.Update(data.toArray(), id);
          
          this.getCon().close();
          return 1;
     }
    public ArrayList<sub_criteria> getCriteria(int condition) throws SQLException
    {
        ArrayList<sub_criteria> data=new ArrayList<sub_criteria>();
        ResultSet rs=this.Select("SELECT DISTINCT(`sub_criteria`.`id`) as id FROM `buildingclassification` INNER JOIN `sub_criteria` on "
                + "`buildingclassification`.`sub_criteria`=`sub_criteria`.`id` WHERE `buildingclassification`.`StateCoditinClassification`="+condition);
        while(rs.next())
        {
            sub_criteria k=new sub_criteria();
            k.Find(rs.getInt("id"));
            data.add(k);
        }
        this.getCon().close();
        return data;
    }
    @Override
    public void setParam(ResultSet rs) {
        try {
            if(rs.next())
            {
                this.id=rs.getInt("id");
                this.sub_criteria=rs.getInt("sub_criteria");
                criteria=new sub_criteria();
                criteria.Find(this.sub_criteria);
                this.linguistic_variable=rs.getInt("linguistic_variable");
                this.StateCondition=rs.getString("StateCondition");
                this.StateCoditinClassification=rs.getInt("StateCoditinClassification");
                StateCoditin=new statecoditinclassification();
                StateCoditin.Find(this.StateCoditinClassification);
            }
        } catch (SQLException ex) {
            
        }
    }
        
}
