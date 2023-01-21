/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db.model;

import db.mysql.mysql;
import java.sql.SQLException;

/**
 *
 * @author saadia
 */
public class columns extends Beams {
private String TableName="`columns_`";
   

//private String ColumnsList ="`id`,`name`,`volume`, `loss`,`buid_id`";
public columns() throws SQLException
    {
        
        this.setTableName(TableName);
    }		
}
