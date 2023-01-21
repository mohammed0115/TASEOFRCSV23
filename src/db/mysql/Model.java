/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author saadia
 */
public abstract class Model extends mysql{
    public    String TableName="";
    public    String ColumnsList="";
    private   String INSERT="";
    private   String SELECT_Table_BY_ID="";
    private   String DELETE_AllRecordTable="";
    private   String SELECT_ALL_Tables="";
    private   String DELETE_Table_ById = "";
    private   String UPDATE_Table ="";
    private   String LastId ="";
    private   ResultSet rs;
    private   Connection con;
    private   PreparedStatement pst;
    private   Statement st;
    private   mysql SQL ;
    public Model data[];
    public abstract void setParam(ResultSet rs);
    public javax.swing.JComboBox toDataCombobox(javax.swing.JComboBox jComboBox ,String Columns,String Condition) throws SQLException
    {     
         this.getCon().close();
         this.rs=this.getDataByCondition(Columns, Condition);
         String[] data=FileClumn(this.getLength(Columns, Condition),this.rs,Columns);
         jComboBox.setModel(new javax.swing.DefaultComboBoxModel(
                data
         ));
         this.getCon().close();
         return jComboBox;
    }
    
    public javax.swing.JTable  toDataTable(javax.swing.JTable jTable1,Object data[][] )
    {
         jTable1.setModel(new javax.swing.table.DefaultTableModel(
         data
         ,
       this.ColumnsList.trim().replace("`", "").split(",")
        ));
        return jTable1;
    }
    public javax.swing.JTable  toDataTable(javax.swing.JTable jTable1,Object data[][],String ColumnsList) throws SQLException
    {
         jTable1.setModel(new javax.swing.table.DefaultTableModel(
         data
         ,
       ColumnsList.trim().replace("`", "").split(",")
        ));
         for(Object i[]:data)
         this.Update(i,ColumnsList,Integer.parseInt(""+i[0]));
        return jTable1;
    }
    public javax.swing.JTable getSpecificDataRow(javax.swing.JTable jTable1,String Columns,String Condition) throws SQLException
    {
        
       this.rs=this.getDataByCondition(Columns, Condition);
       Object [][] data=this.fillData(this.Length(), this.ColumnsList.split(",").length, rs);
       return this.toDataTable(jTable1,  data);
    }
    public String[] FileClumn(int i,ResultSet rs,String Column) throws SQLException
    {
        String data[]=new String[i];
//        System.out.println("rs==>"+rs.isClosed());
        int j=0;
        while(rs.next())
        {
            data[j++]=(String) rs.getString(Column);
            System.out.println(j);
        }
        return data;
    }
//    public void String 
    public Object[][] fillData(int Column,int raw,ResultSet rs) throws SQLException
    {
       Object [][] data=new Object[Column][raw];
       int j=0;
       System.out.println("length");
       String Columns []=this.ColumnsList.trim().replace("`", "").split(",");
       System.out.println("length..............>"+Columns.length+","+ColumnsList);
       while(rs.next())
       {
           for(int i=0;i<Columns.length;i++)
           {   
               
               
               data[j][i]=rs.getObject(Columns[i].trim());
           }

           j++;
       } 
       return data;
    }
    public javax.swing.JTable getAllAsDataTable(javax.swing.JTable jTable1 ) throws SQLException
    {
        System.out.println("Welcome --------------------------------");
        ResultSet rs=this.All();
       
       Object [][] data=this.fillData(this.Length(), this.ColumnsList.split(",").length, rs);
       return this.toDataTable(jTable1, data);
        
    }
    
    public ResultSet getRs() {
        return rs;
    }

    
    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public PreparedStatement getPst() {
        return pst;
    }

    public void setPst(PreparedStatement pst) {
        this.pst = pst;
    }

    public Statement getSt() {
        return st;
    }

    public void setSt(Statement st) {
        this.st = st;
    }

    public mysql getSQL() {
        return SQL;
    }

    public void setSQL(mysql SQL) {
        this.SQL = SQL;
    }
  
    public String getTableName() {
        return TableName;
    }

    public void setTableName(String TableName) {
        this.TableName = TableName;
    }

    public String getColumnsList() {
        return ColumnsList;
    }
    public int[] Ids() throws SQLException
    {
        ResultSet rs=this.All();
        int data[]=new int[this.Length()];
        int i=0;
        while(rs.next())
        {
            data[i++]=rs.getInt("id");
        }
        this.getCon().close();
        return data;
    }
    public void setColumnsList(String ColumnsList) {
        this.ColumnsList = ColumnsList;
    }
    public String UPDATE_Table_SQL(String Condition,int id){
        //UPDATE `user` SET `id`='[value-1]',`firstName`='[value-2]',`LastName`='[value-3]',`phone`='[value-4]' WHERE 1
    this.UPDATE_Table="UPDATE "+this.TableName+" SET ";
    
     String braces =" ";
     int len=this.ColumnsList.split(",").length;
     int index=0;
     for (String element : this.ColumnsList.split(",")) {
           braces+=element+"=?,";
           ++index;
           if(index==(len-1)){
               braces += this.ColumnsList.split(",")[index]+"=? WHERE id = "+id+";";
               break;
           }
        }
    this.UPDATE_Table+=braces;
    System.out.println("update query:"+this.UPDATE_Table);
    return this.UPDATE_Table;
    }
    
    public String UPDATE_Table_SQL(String Condition,String ColumnsList,int id){
        //UPDATE `user` SET `id`='[value-1]',`firstName`='[value-2]',`LastName`='[value-3]',`phone`='[value-4]' WHERE 1
    this.UPDATE_Table="UPDATE "+this.TableName+" SET ";
    
     String braces =" ";
     int len=ColumnsList.split(",").length;
     int index=0;
     for (String element : ColumnsList.split(",")) {
           braces+=element+"=?,";
           ++index;
           if(index==(len-1)){
               braces += ColumnsList.split(",")[index]+"=? WHERE id = "+id+";";
               break;
           }
        }
    this.UPDATE_Table+=braces;
    System.out.println("update query:"+this.UPDATE_Table);
    return this.UPDATE_Table;
    }
    public String DELETE_Table_ById_SQL(){
    this.DELETE_Table_ById ="DELETE FROM "+this.TableName+" WHERE id = ?;";
    System.out.println(this.DELETE_Table_ById);
    return this.DELETE_Table_ById;
    }
    public Statement CreateStatement() throws SQLException
    {
       this.con= this.getConnection();
       System.out.println("isConnected :"+(!this.con.isClosed()));
       this.st=this.con.createStatement();
       return this.st;
    }
    public String DELETE_AllRecordTable_SQL()
    {
        DELETE_AllRecordTable = "delete from "+this.TableName+" ;";
        return this.DELETE_AllRecordTable;
    }
    public String SELECT_Table_BY_ID_SQL(int id){
          this.SELECT_Table_BY_ID= ("SELECT "+(this.ColumnsList==null?"*":this.ColumnsList)+" FROM "+this.TableName+" WHERE id ="+id+"");
    return SELECT_Table_BY_ID;
    }
    public String All_SQL(){
       this.SELECT_ALL_Tables= "SELECT * FROM "+this.TableName+" ;";
        return this.SELECT_ALL_Tables;
    }
    public String INSERT_SQL()
    {   this.INSERT="INSERT INTO "+this.TableName +"  ("+this.ColumnsList+") VALUES " +" ";
        String braces =" (";
        int len=this.ColumnsList.split(",").length;
        int index=0;
        for (String element : this.ColumnsList.split(",")) {
           braces+="?,";
           ++index;
           if(index==(len-1)){
               braces = braces+"?)";
               break;
           }
        }

        return this.INSERT+braces;
    }
    
    public String INSERT_SQL(String columns)
    {   this.INSERT="INSERT INTO "+this.TableName +"  ("+columns+") VALUES " +" ";
        String braces =" (";
        int len=columns.split(",").length;
        int index=0;
        for (String element : columns.split(",")) {
           braces+="?,";
           ++index;
           if(index==(len-1)){
               braces = braces+"?)";
               break;
           }
        }

        return this.INSERT+braces;
    }
  public int Length() throws SQLException
  {
      return this.getLength("*", " 1 ");
  
  }
   public int getLength(String Column,String Codition) throws SQLException
   {
       this.st=this.CreateStatement();
        System.out.println("SELECT COUNT("+Column+") as N FROM "+this.TableName+" WHERE "+Codition);
         ResultSet output=st.executeQuery("SELECT COUNT("+Column+") as N FROM "+this.TableName+" WHERE "+Codition);
	 int id=0;
	 while(output.next()){
                System.out.println(output.getInt("N"));
		id=output.getInt("N");
                break;
	 }
         this.con.close();
	return id;
       
   }
   public int getDISTINCT(String Column,String Codition) throws SQLException
   {
       this.st=this.CreateStatement();

         ResultSet output=st.executeQuery("SELECT DISTINCT("+Column+") as N FROM `"+this.TableName+"` WHERE "+Codition);
	 int id=0;
	 while(output.next()){
		id=output.getInt("N");
	 }
	return id;

   }
   public  int getId() throws SQLException{
	  this.st =  CreateStatement();
         ResultSet output=st.executeQuery("SELECT MAX(ID) AS LastID FROM "+this.TableName+";");
	 int id=0;
	 while(output.next()){
		id=output.getInt("LastID");
	 }
         this.con.close();
	return id;
   } 
    public int getFirstId() throws SQLException
    {
         this.st =  CreateStatement();
         ResultSet output=st.executeQuery("SELECT MIN(ID) AS LastID FROM "+this.TableName+";");
	 int id=0;
	 while(output.next()){
		id=output.getInt("LastID");
	 }
         this.con.close();
	return id;
    }
    
    public ResultSet getDataByCondition(String Column,String Condition) throws SQLException
    {
        this.st =  CreateStatement();
	 String myquery="SELECT "+Column+" FROM "+this.getTableName()+" WHERE "+Condition+";";
	   System.out.println(myquery);
         ResultSet output=st.executeQuery(myquery);
//          this.con.close();
         return output; 
    }
    public ResultSet All() throws SQLException{
         this.st =  this.CreateStatement();
         System.out.println(this.All_SQL());
         ResultSet output=this.st.executeQuery(this.All_SQL());
//         this.con.close();
//         System.out.println("id="+output.findColumn("id"));
//         this.con.close();
         return output;
         
      }
    public ResultSet Delete() throws SQLException{
         this.st =  CreateStatement();
         ResultSet output=st.executeQuery(this.DELETE_AllRecordTable_SQL());
         this.con.close();
         return output;
    }
    public void DeleteById(int id) throws SQLException{
        pst=this.getConnection().prepareStatement(this.DELETE_Table_ById_SQL());
        pst.setInt(1, id);
        pst.executeUpdate();
//        this.con.close();
	System.out.println("Data Deleted Success");
    
    }
    
    public void DeleteById(String condition) throws SQLException{
        pst=this.getConnection().prepareStatement("DELETE FROM "+this.TableName+" WHERE "+condition+";");
//        pst.setInt(1, id);
        pst.executeUpdate();
//        this.con.close();
	System.out.println("Data Deleted Success");
    
    }
    public Boolean Update(Object data[],int id) throws SQLException{
         this.executePrepared(this.UPDATE_Table_SQL(this.ColumnsList, id),data,this.getConnection());
         return true;
    }
    public Boolean Update(Object data[],String columns,int id) throws SQLException{
         this.executePrepared(this.UPDATE_Table_SQL(columns,columns, id),data,this.getConnection());
         return true;
    }
    public ResultSet Find(int id) throws SQLException{
         this.st =  CreateStatement();
         System.out.println("uer==================>"+this.SELECT_Table_BY_ID_SQL(id));
       
         ResultSet output=st.executeQuery(this.SELECT_Table_BY_ID_SQL(id));
         this.setParam(output);
          this.con.close();
         return output;
         
      }
   public ResultSet Find(String Column,Object Value) throws SQLException
   {
       
	 this.st =  CreateStatement();
	 String myquery="SELECT * FROM "+this.getTableName()+" WHERE `"+Column+"` = "+Value+";";
	 System.out.println(""+myquery);
         ResultSet output=st.executeQuery(myquery);
         this.setParam(output);

         return output;  
   } 
    
      public void executePrepared(String Query,Object data[],Connection con)
      {
          try (
              
            PreparedStatement preparedStatement = con.prepareStatement(Query)) {
            for(int i=0;i<data.length;i++)
            {
                System.out.println("i:"+(i+1)+":"+data[i]);
                if(data[i] instanceof Integer)
                    preparedStatement.setInt(i+1, (int) data[i]);
                else if(data[i] instanceof String )
                    preparedStatement.setString(i+1,(data[i]==null?" ":(String)data[i]));
            
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            printSQLException(e);
        }
      }
      
      public void insertRecord(String ColumnsList,Object data[])
      {
          this.ColumnsList=ColumnsList;
          this.executePrepared(this.INSERT_SQL(), data, this.getConnection());

      }
      public void insertRecord(Object [] data) throws SQLException {
          this.executePrepared(this.INSERT_SQL(), data, this.getConnection());
    }
      public void insertRecord(Object [] data,String Columns) throws SQLException {
          this.executePrepared(this.INSERT_SQL(Columns), data, this.getConnection());
    }
     public void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
