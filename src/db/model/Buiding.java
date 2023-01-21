/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db.model;

import java.sql.Statement;
import db.mysql.Model;
import db.mysql.mysql;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author saadia
 */
public class Buiding extends Model
{
    private String TableName="`Buiding`";
   public static int Build_id=100033;
    
    private String ColumnsList ="`id`,`Buiding_name`,  `Buiding_profile`, `location`, "
            + "`owner_id`, `date`, `buildingServiceAge`, `designBuildingAge`, "
            + "`numberOfFlour`, `TotalSlabNum`, `TotalBeamNum`, `TotalColumnNum`,"
            + " `TotalWallNum`, `SlabsCost`, `BeamCost`, `ColumnCost`,`WallCost`";
    
    
    public int owner_id=0, buildingServiceAge=0, designBuildingAge=0, numberOfFlour=0,
            TotalSlabNum=0, TotalBeamNum=0, TotalColumnNum=0, TotalWallNum=0,
            SlabsCost=0, BeamCost=0, ColumnCost=0, WallCost=0,id=0;
    public String date="2023-10-10",Buiding_name="", Buiding_profile="" , location="NULL";
    
    public Buiding() throws SQLException
    {
        this.setTableName(TableName);
        this.setColumnsList(ColumnsList);
    }
  public int  save() throws SQLException{
      ArrayList<Object> data =new ArrayList<>();
      data.add(id);
      data.add(this.Buiding_name);
      data.add(this.Buiding_profile);
      data.add(this.location);
      data.add(this.owner_id);
      data.add(this.date);
      data.add(this.buildingServiceAge);
      data.add(this.designBuildingAge);
      data.add(this.numberOfFlour);
      data.add(this.TotalSlabNum);
      data.add(this.TotalBeamNum);
      data.add(this.TotalColumnNum);
      data.add(this.TotalWallNum);
      data.add(this.SlabsCost);
      data.add(this.BeamCost);
      data.add(this.ColumnCost);
      data.add(this.WallCost);
      System.out.println("save on owner id  ---------------------------------------------------------------------->"+owner_id);
      if(id==0)
         this.insertRecord(ColumnsList, data.toArray());
      else
          this.Update(data.toArray(), id);
//      this.insertRecord(ColumnsList, data.toArray());
      Build_id=this.id;
  return 1;
  }     
   public String toString()
   {
       return String.format("{Buiding_name:%s,"
                          + "Buiding_profile:%s,"
                          + "buildingServiceAge:%s,"
                          + "designBuildingAge:%s,"
                          + "numberOfFlour:%s"
                          + "TotalSlabNum:%s,"
                          + "TotalBeamNum::%s,"
                          + "TotalColumnNum:%s,"
                          + "TotalWallNum:%s,"
                          + "SlabsCost:s,"
                          + "BeamCost:s,"
                          + "ColumnCost:%s,"
                          + "WallCost:%s}",
                         this.Buiding_name,
                         this.Buiding_profile,
                         this.buildingServiceAge,
                         this.designBuildingAge,
                         numberOfFlour,
                         TotalSlabNum,
                         TotalBeamNum,
                         TotalColumnNum,
                         TotalWallNum,
                         SlabsCost,
                         BeamCost,
                         ColumnCost,
                         WallCost
                         );
   }
    @Override
    public void setParam(ResultSet rs) {
        try {
            if(rs.next())
            {
                System.out.println("isfound id yes----------------->");
                this.id=rs.getInt("id");
                this.Buiding_name=rs.getString("Buiding_name");
                this.Buiding_profile=rs.getString("Buiding_profile");
                this.location=rs.getString("location");
                this.owner_id=rs.getInt("owner_id");
                this.date=rs.getString("date");
                this.buildingServiceAge=rs.getInt("buildingServiceAge");
                this.designBuildingAge=rs.getInt("designBuildingAge");
                this.numberOfFlour=rs.getInt("numberOfFlour");
                this.TotalSlabNum=rs.getInt("TotalSlabNum");
                this.TotalBeamNum=rs.getInt("TotalBeamNum");
                this.TotalColumnNum=rs.getInt("TotalColumnNum");
                this.TotalWallNum=rs.getInt("TotalWallNum");
                this.SlabsCost=rs.getInt("SlabsCost");
                this.BeamCost=rs.getInt("BeamCost");
                this.ColumnCost=rs.getInt("ColumnCost");
                this.WallCost=rs.getInt("WallCost");
                Build_id=this.id;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Buiding.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public void setASFirsParam(ResultSet rs) {
        try {
            if(rs.first())
            {
//                rs.first();
                System.out.println("isfound id yes----------------->"+rs.getInt("id"));
                this.id=rs.getInt("id");
                this.Buiding_name=rs.getString("Buiding_name");
                this.Buiding_profile=rs.getString("Buiding_profile");
                this.location=rs.getString("location");
                this.owner_id=rs.getInt("owner_id");
                this.date=rs.getString("date");
                this.buildingServiceAge=rs.getInt("buildingServiceAge");
                this.designBuildingAge=rs.getInt("designBuildingAge");
                this.numberOfFlour=rs.getInt("numberOfFlour");
                this.TotalSlabNum=rs.getInt("TotalSlabNum");
                this.TotalBeamNum=rs.getInt("TotalBeamNum");
                this.TotalColumnNum=rs.getInt("TotalColumnNum");
                this.TotalWallNum=rs.getInt("TotalWallNum");
                this.SlabsCost=rs.getInt("SlabsCost");
                this.BeamCost=rs.getInt("BeamCost");
                this.ColumnCost=rs.getInt("ColumnCost");
                this.WallCost=rs.getInt("WallCost");
                Build_id=this.id;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Buiding.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setAsLastParam(ResultSet rs) {
        try {
            if(rs.last())
            {
//                rs.first();
                System.out.println("isfound id yes----------------->"+rs.getInt("id"));
                this.id=rs.getInt("id");
                this.Buiding_name=rs.getString("Buiding_name");
                this.Buiding_profile=rs.getString("Buiding_profile");
                this.location=rs.getString("location");
                this.owner_id=rs.getInt("owner_id");
                this.date=rs.getString("date");
                this.buildingServiceAge=rs.getInt("buildingServiceAge");
                this.designBuildingAge=rs.getInt("designBuildingAge");
                this.numberOfFlour=rs.getInt("numberOfFlour");
                this.TotalSlabNum=rs.getInt("TotalSlabNum");
                this.TotalBeamNum=rs.getInt("TotalBeamNum");
                this.TotalColumnNum=rs.getInt("TotalColumnNum");
                this.TotalWallNum=rs.getInt("TotalWallNum");
                this.SlabsCost=rs.getInt("SlabsCost");
                this.BeamCost=rs.getInt("BeamCost");
                this.ColumnCost=rs.getInt("ColumnCost");
                this.WallCost=rs.getInt("WallCost");
                Build_id=this.id;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Buiding.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void setAsPrvousParam(ResultSet rs) {
        try {
            if(rs.previous())
            {
//                rs.first();
                System.out.println("isfound id yes----------------->"+rs.getInt("id"));
                this.id=rs.getInt("id");
                this.Buiding_name=rs.getString("Buiding_name");
                this.Buiding_profile=rs.getString("Buiding_profile");
                this.location=rs.getString("location");
                this.owner_id=rs.getInt("owner_id");
                this.date=rs.getString("date");
                this.buildingServiceAge=rs.getInt("buildingServiceAge");
                this.designBuildingAge=rs.getInt("designBuildingAge");
                this.numberOfFlour=rs.getInt("numberOfFlour");
                this.TotalSlabNum=rs.getInt("TotalSlabNum");
                this.TotalBeamNum=rs.getInt("TotalBeamNum");
                this.TotalColumnNum=rs.getInt("TotalColumnNum");
                this.TotalWallNum=rs.getInt("TotalWallNum");
                this.SlabsCost=rs.getInt("SlabsCost");
                this.BeamCost=rs.getInt("BeamCost");
                this.ColumnCost=rs.getInt("ColumnCost");
                this.WallCost=rs.getInt("WallCost");
                Build_id=this.id;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Buiding.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
