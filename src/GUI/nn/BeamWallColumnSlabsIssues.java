/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//import static GUI.PhysicalLossFrame.Building;
//import static GUI.PhysicalLossFrame.id;
//import static GUI.Stepper.step;
import db.model.Beams;
import db.model.buildingclassification;
import db.model.columns;
import db.model.slabs;
import db.model.statecoditinclassification;
import db.model.sub_criteria;
import db.model.walls;
import db.model.Buiding;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class BeamWallColumnSlabsIssues extends javax.swing.JFrame {
public String DamageType[]={""};
public static int step=7;
buildingclassification classifer;
ArrayList<sub_criteria> Columns_walls;
ArrayList<sub_criteria> Beam_slabs;
public String []Beams,Slabs,Columns,Walls;
public static String [] TotalList={""};
    /**
     * Creates new form BeamWallColumnSlabsIssues
     */
    public BeamWallColumnSlabsIssues() {
        initComponents();
        this.Stepper(step);
        
        this.toList();
    }
   public void FillCriteria(ArrayList<sub_criteria> data,javax.swing.JComboBox box)
   {
//        for(int i=0;i<data.size();i++)
//        { box.addItem(data.get(i));
//        }
        box.setModel(new javax.swing.DefaultComboBoxModel(data.toArray()));
   }
   
   
   public void Stepper(int step)
  {
//       hideall();
    statecoditinclassification state=new statecoditinclassification();
      try {
          state.Find(step);
          Title.setText("Step  "+step+" and "+(step+1)+":  "+state.name);
          
          state.getCon().close();
          classifer=new buildingclassification();
         Beam_slabs=classifer.getCriteria(step);
          this.FillCriteria(Beam_slabs,this.Beam_Damage_type);
          this.FillCriteria(Beam_slabs,this.Slabs_damage_type);
          classifer.toDataCombobox(Beam_damage_value, "StateCondition", "`StateCoditinClassification`="+step+" and `sub_criteria`="+Beam_slabs.get(0).id);
          classifer.toDataCombobox(this.Slabs_damage_value, "StateCondition", "`StateCoditinClassification`="+step+" and `sub_criteria`="+Beam_slabs.get(0).id);
          
          
          this.List();
          
          
          Columns_walls=classifer.getCriteria((step+1));
          
          this.FillCriteria(Columns_walls,this.Columns_damage_type);
          this.FillCriteria(Columns_walls,this.Walls_damage_type);
          classifer.toDataCombobox(Columns_damage_value, "StateCondition", "`StateCoditinClassification`="+(step+1)+" and `sub_criteria`="+Columns_walls.get(0).id);
          classifer.toDataCombobox(this.Wall_damage_value, "StateCondition", "`StateCoditinClassification`="+(step+1)+" and `sub_criteria`="+Columns_walls.get(0).id);
//          this.updateLabel1(Columns_walls,classifer,step);
          
          
          System.out.println(Columns_walls.size());

          
      } catch (SQLException ex) {
          Logger.getLogger(Stepper.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
   public void List() throws SQLException
   {
       
        try {
                walls walls=new walls();
                
                System.out.println("0--------------------------------->"+Buiding.Build_id);
                walls.toDataCombobox(this.Walls_items,"name","`buid_id`="+Buiding.Build_id);
                this.Walls=walls.FileClumn(walls.Length(),walls.Find("buid_id", Buiding.Build_id), "name");
//                walls.f
                this.Walls_items.addItem("add multi value");
                walls.getCon().close();
                
                columns column=new columns();
                column.toDataCombobox(this.Column_items,"name","`buid_id`="+Buiding.Build_id);
                this.Columns=walls.FileClumn(walls.Length(),walls.Find("buid_id", Buiding.Build_id), "name");
                this.Column_items.addItem("add multi value");
                
                column.getCon().close();             
                slabs slabs=new slabs();
                
                slabs.toDataCombobox(this.Slabs_items,"name","buid_id="+Buiding.Build_id);
                this.Slabs=walls.FileClumn(walls.Length(),walls.Find("buid_id", Buiding.Build_id), "name");
                this.Slabs_items.addItem("add multi value");
                slabs.getCon().close();
                
                Beams b=new Beams();
                b.toDataCombobox(this.Beam_items,"name","`buid_id`="+Buiding.Build_id);
                this.Beams=walls.FileClumn(walls.Length(),b.Find("buid_id", Buiding.Build_id), "name");
                this.Beam_items.addItem("add multi value");
                b.getCon().close();
                 System.out.println("last Id is "+Buiding.Build_id); 
                
// TODO add your handling code here:
            } catch (SQLException ex) {
                Logger.getLogger(PhysicalLossFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
    
        

//       Beam_Demage_type
   }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        Beam_Damage_type = new javax.swing.JComboBox();
        Slabs_damage_type = new javax.swing.JComboBox();
        Columns_damage_type = new javax.swing.JComboBox();
        Walls_damage_type = new javax.swing.JComboBox();
        Beam_items = new javax.swing.JComboBox();
        Slabs_items = new javax.swing.JComboBox();
        Column_items = new javax.swing.JComboBox();
        Walls_items = new javax.swing.JComboBox();
        Beam_damage_value = new javax.swing.JComboBox();
        Slabs_damage_value = new javax.swing.JComboBox();
        Columns_damage_value = new javax.swing.JComboBox();
        Wall_damage_value = new javax.swing.JComboBox();
        Add_Beams = new javax.swing.JButton();
        Add_Slabs = new javax.swing.JButton();
        Add_Columns = new javax.swing.JButton();
        Add_Walls = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Title = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Next = new javax.swing.JButton();
        Back = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        Beam_Damage_type.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Beam_Damage_type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Beam_Damage_type.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Beam_Damage_typeItemStateChanged(evt);
            }
        });

        Slabs_damage_type.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Slabs_damage_type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Slabs_damage_type.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Slabs_damage_typeItemStateChanged(evt);
            }
        });

        Columns_damage_type.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Columns_damage_type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Columns_damage_type.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Columns_damage_typeItemStateChanged(evt);
            }
        });

        Walls_damage_type.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Walls_damage_type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Walls_damage_type.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Walls_damage_typeItemStateChanged(evt);
            }
        });

        Beam_items.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Beam_items.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Beam_items.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Beam_itemsItemStateChanged(evt);
            }
        });

        Slabs_items.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Slabs_items.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Slabs_items.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Slabs_itemsItemStateChanged(evt);
            }
        });

        Column_items.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Column_items.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Column_items.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Column_itemsItemStateChanged(evt);
            }
        });

        Walls_items.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Walls_items.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Walls_items.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Walls_itemsItemStateChanged(evt);
            }
        });

        Beam_damage_value.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Beam_damage_value.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Slabs_damage_value.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Slabs_damage_value.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Columns_damage_value.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Columns_damage_value.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Wall_damage_value.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Wall_damage_value.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Add_Beams.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Add_Beams.setText("Add");
        Add_Beams.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_BeamsActionPerformed(evt);
            }
        });

        Add_Slabs.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Add_Slabs.setText("Add");
        Add_Slabs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_SlabsActionPerformed(evt);
            }
        });

        Add_Columns.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Add_Columns.setText("Add");
        Add_Columns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_ColumnsActionPerformed(evt);
            }
        });

        Add_Walls.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Add_Walls.setText("Add");
        Add_Walls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_WallsActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Damage Type");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Damage Value");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Element List");

        Title.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Title.setText("Step 8: Structural Evaluation of reinforced concrete  and Physical loss ratios");

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton9.setText("remove from list ");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Beam");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Slabs");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setText("Columns");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("Walls");

        Next.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Next.setText("Save and Next");
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextActionPerformed(evt);
            }
        });

        Back.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Back.setText("Back ");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Next, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Columns_damage_type, javax.swing.GroupLayout.Alignment.TRAILING, 0, 196, Short.MAX_VALUE)
                                    .addComponent(Slabs_damage_type, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Walls_damage_type, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Slabs_damage_value, 0, 279, Short.MAX_VALUE)
                                    .addComponent(Columns_damage_value, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Wall_damage_value, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                                    .addComponent(Beam_Damage_type, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Beam_damage_value, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Beam_items, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Slabs_items, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Column_items, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Walls_items, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Add_Beams)
                            .addComponent(Add_Slabs)
                            .addComponent(Add_Columns)
                            .addComponent(Add_Walls))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 288, Short.MAX_VALUE)
                        .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 1075, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(133, 133, 133)))
                .addGap(518, 518, 518))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Add_Beams, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                            .addComponent(Beam_damage_value)
                            .addComponent(Beam_Damage_type)
                            .addComponent(Beam_items)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Slabs_items, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Add_Slabs, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                                    .addComponent(Slabs_damage_value)
                                    .addComponent(Slabs_damage_type))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Column_items, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Add_Columns, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Columns_damage_value)
                                    .addComponent(Columns_damage_type, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(Walls_items, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Add_Walls, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Wall_damage_value, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Walls_damage_type, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(112, 112, 112))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Next, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                .addGap(67, 67, 67))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Beam_Damage_typeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Beam_Damage_typeItemStateChanged

    try {
        classifer.toDataCombobox(Beam_damage_value, "StateCondition", "`StateCoditinClassification`="+step+" and `sub_criteria`="+Beam_slabs.get(this.Beam_Damage_type.getSelectedIndex()).id);
        
        
// TODO add your handling code here:
    } catch (SQLException ex) {
        Logger.getLogger(BeamWallColumnSlabsIssues.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_Beam_Damage_typeItemStateChanged

    private void Slabs_damage_typeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Slabs_damage_typeItemStateChanged

     try {
        classifer.toDataCombobox(Slabs_damage_value, "StateCondition", "`StateCoditinClassification`="+step+" and `sub_criteria`="+Beam_slabs.get(this.Slabs_damage_type.getSelectedIndex()).id);
        
        
// TODO add your handling code here:
    } catch (SQLException ex) {
        Logger.getLogger(BeamWallColumnSlabsIssues.class.getName()).log(Level.SEVERE, null, ex);
    }        
// TODO add your handling code here:
    }//GEN-LAST:event_Slabs_damage_typeItemStateChanged

    private void Columns_damage_typeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Columns_damage_typeItemStateChanged
      try {
        classifer.toDataCombobox(this.Columns_damage_value, "StateCondition", "`StateCoditinClassification`="+(step+1)+" and `sub_criteria`="+this.Columns_walls.get(this.Columns_damage_type.getSelectedIndex()).id);
        
        
// TODO add your handling code here:
    } catch (SQLException ex) {
        Logger.getLogger(BeamWallColumnSlabsIssues.class.getName()).log(Level.SEVERE, null, ex);
    }
      
        
// TODO add your handling code here:
    }//GEN-LAST:event_Columns_damage_typeItemStateChanged

    private void Walls_damage_typeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Walls_damage_typeItemStateChanged
      try {
        classifer.toDataCombobox(this.Wall_damage_value, "StateCondition", "`StateCoditinClassification`="+(step+1)+" and `sub_criteria`="+this.Columns_walls.get(this.Walls_damage_type.getSelectedIndex()).id);
        
        
// TODO add your handling code here:
    } catch (SQLException ex) {
        Logger.getLogger(BeamWallColumnSlabsIssues.class.getName()).log(Level.SEVERE, null, ex);
    }
        

// TODO add your handling code here:
    }//GEN-LAST:event_Walls_damage_typeItemStateChanged

    private void Slabs_itemsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Slabs_itemsItemStateChanged
     if(Slabs_items.getSelectedItem()=="add multi value")
     {
       MultiValue v=new MultiValue();
       MultiValue.setT(this);
       v.setVisible(rootPaneCheckingEnabled);
       MultiValue.Item_List=this.Slabs;
       MultiValue.all=this.TotalList;
     }
//     
        

// TODO add your handling code here:
    }//GEN-LAST:event_Slabs_itemsItemStateChanged

    private void Add_SlabsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_SlabsActionPerformed
     if(Slabs_items.getSelectedItem()!="add multi value")
     {
      
         Object data=this.Slabs_items.getSelectedItem();
         String[] list=new String[TotalList.length+1];
         for(int i=0;i<TotalList.length;i++)
             list[i]=TotalList[i];
         list[list.length-1]=(String) data;
         this.TotalList=(String[]) list;
         this.toList();
     }
        
 

// TODO add your handling code here:
    }//GEN-LAST:event_Add_SlabsActionPerformed

    private void Beam_itemsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Beam_itemsItemStateChanged

     if(this.Beam_items.getSelectedItem()=="add multi value")
     {
       MultiValue v=new MultiValue();
       MultiValue.setT(this);
       v.setVisible(rootPaneCheckingEnabled);
       MultiValue.Item_List=this.Slabs;
       MultiValue.all=this.TotalList;
       

     } 

// TODO add your handling code here:
    }//GEN-LAST:event_Beam_itemsItemStateChanged

    private void Column_itemsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Column_itemsItemStateChanged

    if(this.Column_items.getSelectedItem()=="add multi value")
     {
       MultiValue v=new MultiValue();
       MultiValue.setT(this);
       v.setVisible(rootPaneCheckingEnabled);
       MultiValue.Item_List=this.Slabs;
       MultiValue.all=this.TotalList;

     }         
// TODO add your handling code here:
    }//GEN-LAST:event_Column_itemsItemStateChanged

    private void Walls_itemsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Walls_itemsItemStateChanged
    if(this.Walls_items.getSelectedItem()=="add multi value")
     {
      MultiValue v=new MultiValue();
       MultiValue.setT(this);
       v.setVisible(rootPaneCheckingEnabled);
       MultiValue.Item_List=this.Slabs;
       MultiValue.all=this.TotalList;

     } 
        
// TODO add your handling code here:
    }//GEN-LAST:event_Walls_itemsItemStateChanged

    private void Add_BeamsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_BeamsActionPerformed
     if(this.Beam_items.getSelectedItem()!="add multi value")
     {
      
         Object data=this.Beam_items.getSelectedItem();
         String[] list=new String[TotalList.length+1];
         for(int i=0;i<TotalList.length;i++)
             list[i]=TotalList[i];
         list[list.length-1]=(String) data;
         this.TotalList=(String[]) list;
         this.toList();
     }
        


// TODO add your handling code here:
    }//GEN-LAST:event_Add_BeamsActionPerformed

    private void Add_ColumnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_ColumnsActionPerformed
     if(Column_items.getSelectedItem()!="add multi value")
     {
      
         Object data=this.Column_items.getSelectedItem();
         String[] list=new String[TotalList.length+1];
         for(int i=0;i<TotalList.length;i++)
             list[i]=TotalList[i];
         list[list.length-1]=(String) data;
         this.TotalList=(String[]) list;
         this.toList();
     }
        

// TODO add your handling code here:
    }//GEN-LAST:event_Add_ColumnsActionPerformed

    private void Add_WallsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_WallsActionPerformed

   if(this.Walls_items.getSelectedItem()!="add multi value")
     {
      
         Object data=this.Walls_items.getSelectedItem();
         String[] list=new String[TotalList.length+1];
         for(int i=0;i<TotalList.length;i++)
             list[i]=TotalList[i];
         list[list.length-1]=(String) data;
         this.TotalList=(String[]) list;
         this.toList();
     }        

// TODO add your handling code here:
    }//GEN-LAST:event_Add_WallsActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
     int indices []=jList1.getSelectedIndices();
     
    List<String>list=new ArrayList<String>(Arrays.asList(TotalList));
    for(int i=0;i<indices.length;i++)
        list.remove(jList1.getModel().getElementAt(indices[i]));
    TotalList=new String[list.size()];
    for(int j=0;j<list.size();j++)
        TotalList[j]=list.get(j);
//    TotalList=(String[]) list.toArray();
    this.toList();
// TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed

        
    Stepper.step=9;
    Stepper stepp=new Stepper();
    
    stepp.setVisible(rootPaneCheckingEnabled);
    this.setVisible(false);

// TODO add your handling code here:
    }//GEN-LAST:event_NextActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed

            Stepper.step=6;
            Stepper stepp=new Stepper();

            stepp.setVisible(rootPaneCheckingEnabled);   
            this.setVisible(false);

// TODO add your handling code here:
    }//GEN-LAST:event_BackActionPerformed

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
            java.util.logging.Logger.getLogger(BeamWallColumnSlabsIssues.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BeamWallColumnSlabsIssues.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BeamWallColumnSlabsIssues.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BeamWallColumnSlabsIssues.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BeamWallColumnSlabsIssues().setVisible(true);
            }
        });
    }
    
   public  void toList()
   {
     jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = TotalList;
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });

        jScrollPane1.setViewportView(jList1);
       
   }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add_Beams;
    private javax.swing.JButton Add_Columns;
    private javax.swing.JButton Add_Slabs;
    private javax.swing.JButton Add_Walls;
    private javax.swing.JButton Back;
    private javax.swing.JComboBox Beam_Damage_type;
    private javax.swing.JComboBox Beam_damage_value;
    private javax.swing.JComboBox Beam_items;
    private javax.swing.JComboBox Column_items;
    private javax.swing.JComboBox Columns_damage_type;
    private javax.swing.JComboBox Columns_damage_value;
    private javax.swing.JButton Next;
    private javax.swing.JComboBox Slabs_damage_type;
    private javax.swing.JComboBox Slabs_damage_value;
    private javax.swing.JComboBox Slabs_items;
    private javax.swing.JLabel Title;
    private javax.swing.JComboBox Wall_damage_value;
    private javax.swing.JComboBox Walls_damage_type;
    private javax.swing.JComboBox Walls_items;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
