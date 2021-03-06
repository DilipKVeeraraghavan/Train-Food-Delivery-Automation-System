/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TGHM;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.AuthenticationException;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author THARUN
 */
public class routes extends javax.swing.JPanel {

    /**
     * Creates new form routes
     */
    private ArrayList<TrainRoute> routes;
    private ManagementAuth ma;
    private ArrayList<RailwayStation> stations;
    private ArrayList<RailwayStation> added = new ArrayList<>();
    private void refresh()
    {
        try 
        {
            /*routes list**/
            routes = Management.getRoutes(ma);
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            for(int i = 0;i <routes.size();i++)
            {
                String stations = "";
                TrainRoute route  = routes.get(i);
                for(int j=0;j<route.getStations().size();j++)
                {
                    stations = stations+route.getStations().get(j).getName()+"("+route.getStations().get(j).getCode()+"),";
                }
                model.addRow(new Object[]{Integer.toString(i+1),route.getName(),route.getSuccess(),route.getTotalDeliveries(),stations});
            }
            
            
            /*Stations list*/
            stations = Management.getStations(ma);
            DefaultListModel sourceModel = new DefaultListModel();
            for (int i = 0;i<stations.size();i++) 
            {
                sourceModel.addElement(stations.get(i).getName()+"("+stations.get(i).getCode()+")");
            }
            source.setModel(sourceModel);
            validate();
            repaint();
            
            /*Refresh the list*/
            DefaultListModel destModel = new DefaultListModel();
            for (int i = 0;i<added.size();i++) 
            {
                destModel.addElement(added.get(i).getName()+"("+added.get(i).getCode()+")");
            }
            destination.setModel(destModel);
            nameField.setText("");
            validate();
            repaint();
        } 
        catch (AuthenticationException | UnableToConnectException | IllegalArgumentException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.printStackTrace();
        }
    }
    public routes(ManagementAuth mauth) 
    {
        
        ma = mauth;
        initComponents();
        source.setModel(new DefaultListModel());
        destination.setModel(new DefaultListModel());
          
        try 
        {
            /*routes list**/
            routes = Management.getRoutes(ma);
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            model.setRowCount(0);
            for(int i = 0;i <routes.size();i++)
            {
                String stations = "";
                TrainRoute route  = routes.get(i);
                for(int j=0;j<route.getStations().size();j++)
                {
                    stations = stations+route.getStations().get(j).getName()+"("+route.getStations().get(j).getCode()+"),";
                }
                model.addRow(new Object[]{Integer.toString(i+1),route.getName(),route.getSuccess(),route.getTotalDeliveries(),stations});
            }
            
            /*Stations list*/
            stations = Management.getStations(ma);
            DefaultListModel sourceModel = new DefaultListModel();
            for (int i = 0;i<stations.size();i++) 
            {
                sourceModel.addElement(stations.get(i).getName()+"("+stations.get(i).getCode()+")");
            }
            source.setModel(sourceModel);
            validate();
            repaint();
        } 
        catch (AuthenticationException | UnableToConnectException | IllegalArgumentException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.printStackTrace();
        }
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
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        destination = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        source = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sno", "Name", "SucessFull Orders", "Total Orders", "Stations"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Add route");

        jButton1.setText("Add station");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Add new route");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        destination.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(destination);

        source.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(source);

        jLabel4.setText("Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(72, 72, 72)
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1)
                            .addGap(36, 36, 36)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(190, 190, 190))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(source.getSelectedIndex()==-1)
        {
            JOptionPane.showMessageDialog(null, "Please select station before adding");
            JOptionPane.showMessageDialog(null, source.getSelectedIndex());
        }
        else if(added.contains(stations.get(source.getSelectedIndex())))   
        {
            JOptionPane.showMessageDialog(null, "Station already added");
        }
        else
        {
            added.add(stations.get(source.getSelectedIndex()));
            DefaultListModel destModel = new DefaultListModel();
            for (int i = 0;i<added.size();i++) 
            {
                destModel.addElement(added.get(i).getName()+"("+added.get(i).getCode()+")");
            }
            destination.setModel(destModel);
            validate();
            repaint();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(added.size()<2)
        {
            JOptionPane.showMessageDialog(null, "Atleast 2 stations is neccesary");
        }
        else if(nameField.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Station name cannot be empty");
        }
        else
        {
            try 
            {
                Management.addRoute(ma,nameField.getText(),added);
                added = new ArrayList<>();
                refresh();
            } 
            catch (AuthenticationException | UnableToConnectException | IllegalArgumentException ex) 
            {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> destination;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nameField;
    private javax.swing.JList<String> source;
    // End of variables declaration//GEN-END:variables
}
