/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import db.model.Beams;
import db.model.Buiding;
import static db.model.Buiding.Build_id;
import db.model.columns;
import db.model.slabs;
import db.model.walls;
import javax.swing.table.DefaultTableModel;
import db.mysql.Model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author saadia
 */
public class PhysicalLossFrame extends javax.swing.JFrame {
        public static db.model.Buiding Building;
	public Model Beams,Walls,Slabs,columns;
        public static int id;

	public static Buiding getBuilding() {
		return Building;
	}

	public static void setBuilding(db.model.Buiding  Building) {
		Building = (Buiding) Building;
	}
	/**
	 * Creates new form PhysicalLossFrame
	 */
	public PhysicalLossFrame() throws SQLException {
		Building = new db.model.Buiding();
		initComponents();
//		this.Updater();
                getDatabeams() ;
             this.getDataSlabs();
             this.getDataWalls();
             this.getDataColumn();
	}
        
        public void Updater()
        {
//            Building =getBuilding();
            
            
            try {
                walls walls=new walls();
                walls.getSpecificDataRow(WallsTable,walls.getColumnsList(),"id="+Building.id);
                walls.getCon().close();
                
                columns column=new columns();
                column.getSpecificDataRow(columnsTable,walls.getColumnsList(),"id="+Building.id);
                
                
                walls.getCon().close();             
                slabs slabs=new slabs();
                
                slabs.getSpecificDataRow(SlabsTable,walls.getColumnsList(),"id="+Building.id);
                slabs.getCon().close();
                
                Beams b=new Beams();
                b.getSpecificDataRow(BeamsTable,walls.getColumnsList(),"id="+Building.id);
                b.getCon().close();
                 System.out.println("last Id is "+id); 
                
// TODO add your handling code here:
            } catch (SQLException ex) {
                Logger.getLogger(PhysicalLossFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
	public void getDatabeams() throws SQLException{
            
            
//            System.out.println("99999999999999999999999999999999>>>>>>>>>>>>>>>>>>>>>"+);
         // create a table model with the appropriate column headers
// and with 0 rows (to start with)
this.Beams =new db.model.Beams();
String[] columnNames = {"id","name","volume","loss"};
DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
ResultSet rs=this.Beams.Find("buid_id",Building.Build_id);
while (rs.next()) {
    String title = rs.getString("name");

    String season = rs.getString("volume");
    String episode = rs.getString("loss");
    int id =rs.getInt("id");
    // create a single array of one row's worth of data
    String[] data = { ""+id,title, season, episode } ;

    // and add this row of data into the table model
    tableModel.addRow(data);
}

this.BeamsTable.setModel(tableModel); // place model into JTable
jScrollPane1.setViewportView(BeamsTable);
       
       }
public void getDataSlabs() throws SQLException{
         // create a table model with the appropriate column headers
// and with 0 rows (to start with)
this.Beams =new db.model.slabs();
Building=(Buiding) getBuilding();
String[] columnNames = {"id","name","volume","loss"};
DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
ResultSet rs=this.Beams.Find("buid_id",Building.Build_id);
while (rs.next()) {
    String title = rs.getString("name");

    String season = rs.getString("volume");
    String episode = rs.getString("loss");
    int id =rs.getInt("id");
    // create a single array of one row's worth of data
    String[] data = { id+"",title, season, episode } ;

    // and add this row of data into the table model
    tableModel.addRow(data);
}

this.SlabsTable.setModel(tableModel); // place model into JTable
jScrollPane3.setViewportView(SlabsTable);
       
       }
        public void getDataColumn() throws SQLException{
         // create a table model with the appropriate column headers
// and with 0 rows (to start with)
this.Beams =new db.model.columns();
String[] columnNames = {"id","name","volume","loss"};
DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
ResultSet rs=this.Beams.Find("buid_id",Building.Build_id);
while (rs.next()) {
    String title = rs.getString("name");

    String season = rs.getString("volume");
    String episode = rs.getString("loss");
    int id =rs.getInt("id");
    // create a single array of one row's worth of data
    String[] data = {""+id, title, season, episode } ;

    // and add this row of data into the table model
    tableModel.addRow(data);
}

this.columnsTable.setModel(tableModel); // place model into JTable
jScrollPane2.setViewportView(columnsTable);
       
       }
       public void getDataWalls() throws SQLException{
         // create a table model with the appropriate column headers
// and with 0 rows (to start with)
this.Beams =new db.model.walls();
String[] columnNames = {"id","name","volume","loss"};
DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
ResultSet rs=this.Beams.Find("buid_id",Building.Build_id);
while (rs.next()) {
    String title = rs.getString("name");
    int id =rs.getInt("id");
    String season = rs.getString("volume");
    String episode = rs.getString("loss");

    // create a single array of one row's worth of data
    String[] data = { id+"",title, season, episode } ;

    // and add this row of data into the table model
    tableModel.addRow(data);
}

this.WallsTable.setModel(tableModel); // place model into JTable
jScrollPane4.setViewportView(WallsTable);
       
       }
	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        BeamsTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        columnsTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        SlabsTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        WallsTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        BeamsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(BeamsTable);

        columnsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(columnsTable);

        SlabsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(SlabsTable);

        jButton1.setText("update");

        jButton2.setText("save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("next step");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel1.setText("Step 2: Estimating the percentage of physical loss for the structural elements of the building");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(264, 264, 264)
                .addComponent(jLabel1)
                .addContainerGap(804, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        WallsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(WallsTable);

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel2.setText("Columns");

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel3.setText("Slabs");

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel4.setText("Beams");

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel5.setText("Walls");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(580, 580, 580)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel4)
                        .addGap(342, 342, 342)
                        .addComponent(jLabel2)
                        .addGap(297, 297, 297)
                        .addComponent(jLabel3)
                        .addGap(214, 214, 214)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel5)))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            try {
                walls walls=new walls();
//                walls.getAllAsDataTable(WallsTable);
               
                int columns=this.WallsTable.getColumnCount();
                int raw=this.WallsTable.getRowCount();
                Object data[][]=new Object[raw][columns];
                for(int i=0;i<raw;i++)
                {
                    for(int j=0;j<columns;j++)
                    {
                        data[i][j]=(Object)this.WallsTable.getModel().getValueAt(i, j);
                    }
                }
                walls.toDataTable(WallsTable, data,"id,name,volume,loss");
                columns column=new columns();
//                walls.getAllAsDataTable(WallsTable);
                for(int i=0;i<raw;i++)
                {
                    for(int j=0;j<columns;j++)
                    {
                        data[i][j]=(Object)this.columnsTable.getModel().getValueAt(i, j);
                    }
                }
                column.toDataTable(columnsTable, data,"id,name,volume,loss");
//                walls.getCon().close();             
                slabs slabs=new slabs();
                
//                walls.getAllAsDataTable(WallsTable);
                for(int i=0;i<raw;i++)
                {
                    for(int j=0;j<columns;j++)
                    {
                        data[i][j]=(Object)this.SlabsTable.getModel().getValueAt(i, j);
                    }
                }
                slabs.toDataTable(SlabsTable, data,"id,name,volume,loss");
                
                Beams b=new Beams();
//                walls.getAllAsDataTable(WallsTable);
                
                for(int i=0;i<raw;i++)
                {
                    for(int j=0;j<columns;j++)
                    {
                        data[i][j]=(Object)this.BeamsTable.getModel().getValueAt(i, j);
                    }
                }
                
                b.toDataTable(BeamsTable, data,"id,name,volume,loss");
                
// TODO add your handling code here:
            } catch (SQLException ex) {
                Logger.getLogger(PhysicalLossFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(PhysicalLossFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(PhysicalLossFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(PhysicalLossFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(PhysicalLossFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new PhysicalLossFrame().setVisible(true);
				} catch (SQLException ex) {
					Logger.getLogger(PhysicalLossFrame.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BeamsTable;
    private javax.swing.JTable SlabsTable;
    private javax.swing.JTable WallsTable;
    private javax.swing.JTable columnsTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
