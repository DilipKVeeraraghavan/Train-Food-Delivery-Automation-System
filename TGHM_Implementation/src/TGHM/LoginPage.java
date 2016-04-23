package TGHM;

import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class LoginPage extends javax.swing.JFrame {
    ArrayList<String> cartitems = new ArrayList<String>();
    public LoginPage() {
        try{
            UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Warning !");
        }
        initComponents();
        LoginPane.setVisible(true);
        customerPane.setVisible(false);
        Invaliduserwarn.setVisible(false);
        jLabel11.setVisible(false);
        jLabel16.setVisible(false);
        jLabel17.setVisible(false);
        contactNo.setVisible(false);
        contactNoLabel.setVisible(false);
        Radiowarn.setVisible(false);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        LoginPane = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Username = new javax.swing.JTextField();
        Password = new javax.swing.JTextField();
        LoginButton = new javax.swing.JButton();
        Invaliduserwarn = new javax.swing.JLabel();
        contactNoLabel = new javax.swing.JLabel();
        contactNo = new javax.swing.JTextField();
        dummy = new javax.swing.JPanel();
        ManagementButton = new javax.swing.JRadioButton();
        CustomerButton = new javax.swing.JRadioButton();
        FoodSupplierButton = new javax.swing.JRadioButton();
        Radiowarn = new javax.swing.JLabel();
        AgentButton = new javax.swing.JRadioButton();
        dummylabe = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        customerRegister = new javax.swing.JRadioButton();
        jButton3 = new javax.swing.JButton();
        customerPane = new javax.swing.JPanel();
        customertab = new javax.swing.JTabbedPane();
        placeOrder = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel3 = new javax.swing.JPanel();
        trainNumber = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        foodSupplier = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        hourCombo = new javax.swing.JComboBox<>();
        minuteCombo = new javax.swing.JComboBox<>();
        placeOrderButton = new javax.swing.JButton();
        logOut = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        cartSplitPane = new javax.swing.JSplitPane();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        cartPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        menuCart = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        cart = new javax.swing.JList<>();
        moveButton = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        countCart = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableAgent = new javax.swing.JTable();
        modifyPane = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        modifyRB = new javax.swing.JRadioButton();
        CancelRB = new javax.swing.JRadioButton();
        Proceed = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Travel In Good Health Management");

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Username :");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Password :");

        Username.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameActionPerformed(evt);
            }
        });

        Password.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        LoginButton.setText("LogIn / Register");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        Invaliduserwarn.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        Invaliduserwarn.setForeground(new java.awt.Color(255, 0, 0));
        Invaliduserwarn.setText("Invalid Username or Password !");

        contactNoLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        contactNoLabel.setText("Contact :");

        contactNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactNoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(contactNoLabel)
                        .addGap(40, 40, 40)
                        .addComponent(contactNo))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Password, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                    .addComponent(Username)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(Invaliduserwarn)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(Invaliduserwarn)
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contactNoLabel)
                    .addComponent(contactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LoginButton)
                .addContainerGap())
        );

        dummy.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Login as -", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 2, 14))); // NOI18N
        dummy.setMinimumSize(new java.awt.Dimension(335, 205));

        buttonGroup1.add(ManagementButton);
        ManagementButton.setText("Management");
        ManagementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManagementButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(CustomerButton);
        CustomerButton.setText("Customer");
        CustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(FoodSupplierButton);
        FoodSupplierButton.setText("Food Supplier");
        FoodSupplierButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FoodSupplierButtonActionPerformed(evt);
            }
        });

        Radiowarn.setFont(new java.awt.Font("Dialog", 2, 11)); // NOI18N
        Radiowarn.setForeground(new java.awt.Color(255, 0, 0));
        Radiowarn.setText("Please select the kind of user above !");

        buttonGroup1.add(AgentButton);
        AgentButton.setText("Agent");
        AgentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dummyLayout = new javax.swing.GroupLayout(dummy);
        dummy.setLayout(dummyLayout);
        dummyLayout.setHorizontalGroup(
            dummyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dummyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dummyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dummyLayout.createSequentialGroup()
                        .addGroup(dummyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CustomerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(FoodSupplierButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Radiowarn, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                            .addComponent(dummylabe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addGroup(dummyLayout.createSequentialGroup()
                        .addComponent(ManagementButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(16, 16, 16)
                        .addComponent(AgentButton)))
                .addContainerGap())
        );
        dummyLayout.setVerticalGroup(
            dummyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dummyLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(dummyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ManagementButton)
                    .addComponent(AgentButton))
                .addGap(18, 18, 18)
                .addComponent(CustomerButton)
                .addGap(18, 18, 18)
                .addComponent(FoodSupplierButton)
                .addGap(18, 18, 18)
                .addComponent(Radiowarn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dummylabe)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Register As", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 2, 14))); // NOI18N

        buttonGroup1.add(customerRegister);
        customerRegister.setText("Customer");
        customerRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerRegisterActionPerformed(evt);
            }
        });

        jButton3.setText("Food Supplier Registration");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customerRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(customerRegister)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
        );

        javax.swing.GroupLayout LoginPaneLayout = new javax.swing.GroupLayout(LoginPane);
        LoginPane.setLayout(LoginPaneLayout);
        LoginPaneLayout.setHorizontalGroup(
            LoginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LoginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginPaneLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(LoginPaneLayout.createSequentialGroup()
                        .addGroup(LoginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dummy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 386, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        LoginPaneLayout.setVerticalGroup(
            LoginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LoginPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginPaneLayout.createSequentialGroup()
                        .addComponent(dummy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        customertab.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        customertab.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        customertab.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        placeOrder.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jSplitPane1.setDividerLocation(263);

        trainNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trainNumberActionPerformed(evt);
            }
        });

        jLabel4.setText("Train Number :");

        jLabel5.setText("Food Supplier :");

        foodSupplier.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                foodSupplierItemStateChanged(evt);
            }
        });
        foodSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foodSupplierActionPerformed(evt);
            }
        });

        jLabel7.setText("Time of Delivery :");

        hourCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        hourCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hourComboActionPerformed(evt);
            }
        });

        minuteCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        minuteCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minuteComboActionPerformed(evt);
            }
        });

        placeOrderButton.setText("Place Order");
        placeOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placeOrderButtonActionPerformed(evt);
            }
        });

        logOut.setText("Log Out");
        logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutActionPerformed(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText(":");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("HH");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("MM");

        jButton1.setText("Automatic Suggest");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Dialog", 2, 11)); // NOI18N
        jLabel11.setText("Please Save the cart before ordering !");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(logOut, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(placeOrderButton))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(31, 31, 31)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(trainNumber, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(foodSupplier, 0, 126, Short.MAX_VALUE)))
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(hourCombo, 0, 49, Short.MAX_VALUE))
                                .addGap(4, 4, 4)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(minuteCombo, 0, 49, Short.MAX_VALUE))))
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(trainNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(foodSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(hourCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(minuteCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(34, 34, 34)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(placeOrderButton)
                    .addComponent(logOut))
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(jPanel3);

        jSplitPane2.setDividerLocation(123);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jSplitPane2.setTopComponent(jScrollPane1);

        cartSplitPane.setDividerLocation(271);
        cartSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jButton2.setText("Save Cart");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel14.setText("Please Select an item from the Menu and click the number of items and click move to add To the Cart");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jLabel14))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cartSplitPane.setBottomComponent(jPanel4);

        cartPanel.setMinimumSize(new java.awt.Dimension(640, 276));

        menuCart.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(menuCart);

        jScrollPane3.setViewportView(cart);

        moveButton.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        moveButton.setText("----Move--->");
        moveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveButtonActionPerformed(evt);
            }
        });

        jLabel12.setText("Your Cart :");

        jLabel13.setText("Menu :");

        countCart.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        countCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countCartActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Item Count :");

        jLabel16.setFont(new java.awt.Font("Dialog", 2, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 51));
        jLabel16.setText("Please select  one or more ");

        jLabel17.setFont(new java.awt.Font("Dialog", 2, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 51));
        jLabel17.setText("items before saving !");

        javax.swing.GroupLayout cartPanelLayout = new javax.swing.GroupLayout(cartPanel);
        cartPanel.setLayout(cartPanelLayout);
        cartPanelLayout.setHorizontalGroup(
            cartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cartPanelLayout.createSequentialGroup()
                .addGroup(cartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cartPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(cartPanelLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(countCart, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17)
                            .addComponent(moveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(cartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        cartPanelLayout.setVerticalGroup(
            cartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cartPanelLayout.createSequentialGroup()
                .addGroup(cartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cartPanelLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(countCart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(moveButton)
                        .addContainerGap())
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3)))
        );

        cartSplitPane.setLeftComponent(cartPanel);

        jSplitPane2.setRightComponent(cartSplitPane);

        jPanel5.setMinimumSize(new java.awt.Dimension(642, 120));

        jScrollPane4.setPreferredSize(new java.awt.Dimension(642, 120));

        tableAgent.setFont(new java.awt.Font("Dialog", 2, 11)); // NOI18N
        tableAgent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ranking", "Restaurant - Agent ", "Successful Orders", "Total Deliveries"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableAgent.setPreferredSize(new java.awt.Dimension(642, 120));
        jScrollPane4.setViewportView(tableAgent);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 642, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 122, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
        );

        jSplitPane2.setTopComponent(jPanel5);

        jSplitPane1.setRightComponent(jSplitPane2);

        javax.swing.GroupLayout placeOrderLayout = new javax.swing.GroupLayout(placeOrder);
        placeOrder.setLayout(placeOrderLayout);
        placeOrderLayout.setHorizontalGroup(
            placeOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        placeOrderLayout.setVerticalGroup(
            placeOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        customertab.addTab("Place Order", placeOrder);

        jLabel15.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        jLabel15.setText("We're sorry to let you know that your order has been rejected by the agent ......");

        buttonGroup2.add(modifyRB);
        modifyRB.setText("Modify Order");
        modifyRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyRBActionPerformed(evt);
            }
        });

        buttonGroup2.add(CancelRB);
        CancelRB.setText("Cancel Order");
        CancelRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelRBActionPerformed(evt);
            }
        });

        Proceed.setText("Proceed");
        Proceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProceedActionPerformed(evt);
            }
        });

        jPanel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 281, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout modifyPaneLayout = new javax.swing.GroupLayout(modifyPane);
        modifyPane.setLayout(modifyPaneLayout);
        modifyPaneLayout.setHorizontalGroup(
            modifyPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modifyPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(modifyPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(modifyPaneLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(modifyPaneLayout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(modifyPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CancelRB)
                            .addComponent(modifyRB, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(Proceed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(56, 56, 56)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        modifyPaneLayout.setVerticalGroup(
            modifyPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modifyPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGroup(modifyPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(modifyPaneLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(modifyPaneLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(modifyPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(modifyPaneLayout.createSequentialGroup()
                                .addComponent(CancelRB)
                                .addGap(18, 18, 18)
                                .addComponent(modifyRB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 289, Short.MAX_VALUE)
                                .addComponent(Proceed))
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );

        customertab.addTab("Modify/Cancel", modifyPane);

        javax.swing.GroupLayout customerPaneLayout = new javax.swing.GroupLayout(customerPane);
        customerPane.setLayout(customerPaneLayout);
        customerPaneLayout.setHorizontalGroup(
            customerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(customertab)
                .addContainerGap())
        );
        customerPaneLayout.setVerticalGroup(
            customerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(customertab)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LoginPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(customerPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LoginPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(customerPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ManagementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManagementButtonActionPerformed
        contactNo.setVisible(false);
        contactNoLabel.setVisible(false);
        
            
    }//GEN-LAST:event_ManagementButtonActionPerformed

    private void UsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameActionPerformed

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        if(FoodSupplierButton.isSelected()==true){
            contactNo.setVisible(false);
            contactNoLabel.setVisible(false);
           
            Radiowarn.setVisible(false);
            
            try
                {
                    String pass="";
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","");
                    Statement stt = con.createStatement();
                    stt.execute("USE tghm");
                            
                    String query ="SELECT Password FROM foodsupplier WHERE Username='"+Username.getText()+"'";
                    ResultSet rs =stt.executeQuery(query);
                    
                    if(!rs.isBeforeFirst()){    
                        Invaliduserwarn.setVisible(true);
                    } 
                    while(rs.next()){
                        pass = rs.getString("Password");
                            FoodSupplierAuth newone = new FoodSupplierAuth(Username.getText(),Password.getText());
                            FoodSupplierFrame frame = new FoodSupplierFrame(newone);
                            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            frame.setVisible(true);
                            break;
                    }           
                    stt.close();
                    con.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
        }
        
        else if(AgentButton.isSelected()==true){
            contactNo.setVisible(false);
            contactNoLabel.setVisible(false);
            
            Radiowarn.setVisible(false);
            
            try
                {
                    String pass="";
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","");
                    Statement stt = con.createStatement();
                    stt.execute("USE tghm");
                            
                    String query ="SELECT Password FROM agent WHERE Username='"+Username.getText()+"'";
                    ResultSet rs =stt.executeQuery(query);
                    
                    if(!rs.isBeforeFirst()){    
                        Invaliduserwarn.setVisible(true);
                    } 
                    while(rs.next()){
                        pass = rs.getString("Password");
                        AgentAuth newone = new AgentAuth(Username.getText(),Password.getText());
                        AgentFrame frame = new AgentFrame(newone);
                        frame.setVisible(true);
                        break;
                    }           
                    stt.close();
                    con.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
        }else if(customerRegister.isSelected()==true){
            
            Radiowarn.setVisible(false);
            try
            {
                String pass="";
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","");
                Statement stt = con.createStatement();
                stt.execute("USE tghm");
                
                String query;
                query="SELECT * FROM customer WHERE Username='"+Username.getText()+"'";
                ResultSet rs = stt.executeQuery(query);
                if(rs.next()){
                        JOptionPane.showMessageDialog(null,"Username already exists");
                        return;
                }
                
                query ="INSERT INTO customer (Username,Password,Contact,RejectedAgents) VALUES('"+Username.getText()+"','"+Password.getText()+"','"+contactNo.getText()+"','')";
                stt.execute(query);

                Username.setText("");
                Password.setText("");
                contactNo.setText("");

                stt.close();
                con.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ManagementButton.isSelected()==true){
            contactNo.setVisible(false);
            contactNoLabel.setVisible(false);
        
            Radiowarn.setVisible(false);
            try
                {
                    String pass="";
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","");
                    Statement stt = con.createStatement();
                    stt.execute("USE tghm");
                            
                    String query ="SELECT Password FROM management WHERE Username='"+Username.getText()+"'";
                    ResultSet rs =stt.executeQuery(query);
                    
                    if(!rs.isBeforeFirst()){    
                        Invaliduserwarn.setVisible(true);
                    } 
                    while(rs.next()){
                        pass = rs.getString("Password");
                            ManagementAuth newone = new ManagementAuth(Username.getText(),Password.getText());
                            MainFrame frame = new MainFrame(newone);
                            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            frame.setVisible(true);
                            break;
                        
                    }           
                    stt.close();
                    con.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
         }
        else if(CustomerButton.isSelected()==true){
            contactNo.setVisible(false);
            contactNoLabel.setVisible(false);
        
            Radiowarn.setVisible(false);
            try
                {
                    String pass="";
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","");
                    Statement stt = con.createStatement();
                    stt.execute("USE tghm");
                            
                    String query ="SELECT Password FROM customer WHERE Username='"+Username.getText()+"'";
                    ResultSet rs =stt.executeQuery(query);
                    
                    if(!rs.isBeforeFirst()){    
                        Invaliduserwarn.setVisible(true);
                    } 
                    while(rs.next()){
                        pass = rs.getString("Password");
                        if(pass.equals(Password.getText())){
                            int flag =0;
                            String squery ="SELECT * FROM orderdetails WHERE CustomerUserName='"+Username.getText()+"'";
                            
                            ResultSet srs =stt.executeQuery(squery);
                            while(srs.next()){
                                if(srs.getString("Status").equals("Rejected")){
                                    customertab.setSelectedIndex(1);
                                    customerPane.setVisible(true);
                                    LoginPane.setVisible(false);
                                    flag=1;
                                }
                                else if(srs.getString("Status").equals("Accepted")){
                                    JOptionPane.showMessageDialog(null,"Order Accepted !", query, HEIGHT, null);
                                }
                            }
                                   
                            
                            if(flag==0){
                                
                            jSplitPane2.setDividerLocation(123);
                            cartSplitPane.setDividerLocation(270);
                            customerPane.setVisible(true);
                            LoginPane.setVisible(false);
                            customertab.setSelectedIndex(0);
                            query ="SELECT * FROM train";
                            ArrayList<String> trains= new ArrayList<String>();
                            
                            rs =stt.executeQuery(query);
                            while(rs.next()){
                                trains.add(rs.getString("Number"));
                            }
                            trainNumber.setModel(new DefaultComboBoxModel(trains.toArray()));
                            ArrayList<String> suppliers= new ArrayList<String>();
                            
                            String cquery = "SELECT * FROM customer WHERE Username='"+Username.getText()+"'";
                            
                            ResultSet crs= stt.executeQuery(cquery);
                            crs.next();
                            
                            String str = crs.getString("RejectedAgents");
                            ArrayList<String> list = new ArrayList<String>(Arrays.asList(str.split(",")));
                            for(String x:list){
                                System.out.println(x);
                            }
                            
                            query ="SELECT * FROM agent ORDER BY SucessOrders DESC";
                            rs =stt.executeQuery(query);
                            while(rs.next()){
                                if(list.contains(rs.getString("FoodSupplierUserName"))){
                                    System.out.println("ger");
                                }
                                else if(rs.getString("Status").equals("Accepted")){
                                    suppliers.add(rs.getString("FoodSupplierUserName"));
                                }
                            }
                            foodSupplier.setModel(new DefaultComboBoxModel(suppliers.toArray()));
                            
                            makeTable();
                        }
                            break;
                        }
                        else{
                            Invaliduserwarn.setVisible(true);
                        }
                        
                    }
                    stt.close();
                    con.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
        }
        else{
            Radiowarn.setVisible(true);
        }
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void makeTable() throws InstantiationException, IllegalAccessException, SQLException, ClassNotFoundException{
      
        try
                {
                    String pass="";
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","");
                    Statement stt = con.createStatement();
                    
                    stt.execute("USE tghm");
                    
                    String cquery = "SELECT * FROM customer WHERE Username='"+Username.getText()+"'";
                    ResultSet crs= stt.executeQuery(cquery);
                    crs.next();
                    String str = crs.getString("RejectedAgents");
                    ArrayList<String> list = new ArrayList<String>(Arrays.asList(str.split(",")));
                    for(String x:list){
                        System.out.println(x);
                    }
                    String query ="SELECT * FROM agent ORDER BY SucessOrders DESC,TotalOrders Desc";
                    ResultSet rs =stt.executeQuery(query);
                    
                    int t =1;
                    DefaultTableModel model = (DefaultTableModel)tableAgent.getModel();
                    model.setRowCount(0);
                    while(rs.next()){
                        if(list.contains(rs.getString("FoodSupplierUserName"))&&rs.getString("Status").equals("Accepted")){
                            model.addRow(new Object[]{t,"Rejected -****"+rs.getString("FoodSupplierUserName")+" - "+rs.getString("Name")+"*****",rs.getFloat("SucessOrders"),rs.getInt("TotalOrders")});
                        }
                        else if(rs.getString("Status").equals("Accepted")){
                            model.addRow(new Object[]{t,rs.getString("FoodSupplierUserName")+" - "+rs.getString("Name"),rs.getFloat("SucessOrders"),rs.getInt("TotalOrders")});
                        }
                        t++;
                    }
                    tableAgent.setModel(model);
                    stt.close();
                    con.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
    
    }
    private void moveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveButtonActionPerformed
        if(menuCart.getSelectedIndex()==-1){
            return;
        }
        cartitems.add(menuCart.getSelectedValue()+" - "+(countCart.getSelectedIndex()+1));
        int index = menuCart.getSelectedIndex();
        DefaultListModel model = (DefaultListModel) menuCart.getModel();
        int selectedIndex = menuCart.getSelectedIndex();
        if (selectedIndex != -1) {
            model.remove(selectedIndex);
        }
        menuCart.setModel(model);
        foodSupplier.setEnabled(false);
        DefaultListModel newone =new DefaultListModel();
        for(String x:cartitems){
            newone.addElement(x);
        }
        cart.setModel(newone);
    }//GEN-LAST:event_moveButtonActionPerformed

    private void hourComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hourComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hourComboActionPerformed

    private void minuteComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minuteComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_minuteComboActionPerformed

    private void countCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countCartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_countCartActionPerformed

    private void foodSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foodSupplierActionPerformed
        try {
            String pass="";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","");
            Statement stt = con.createStatement();
            
            stt.execute("USE tghm");
            
            
            String query ="SELECT * FROM foodsupplier";
            ResultSet rs =stt.executeQuery(query);
            while(rs.next()){
                System.out.println(rs.getString("Username")+foodSupplier.getSelectedItem());
                if(foodSupplier.getSelectedItem().toString().equals(rs.getString("Username"))){
                    System.out.println(rs.getString("Username"));
                    ArrayList<String> snonumbers = new ArrayList<String>(Arrays.asList(rs.getString("Menu").split(",")));
                    
                    ArrayList<String> item= new ArrayList<String>();
                            
                    query ="SELECT * FROM fooditem";
                    rs =stt.executeQuery(query);
                    while(rs.next()){
                        if(snonumbers.contains(rs.getString("Sno"))){
                            item.add(rs.getString("Name"));
                        }
                    }
                    DefaultListModel newone =new DefaultListModel();
                    for(String x:item){
                        newone.addElement(x);
                    }
                    menuCart.setModel(newone);
                            
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_foodSupplierActionPerformed

    private void foodSupplierItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_foodSupplierItemStateChanged
        
    }//GEN-LAST:event_foodSupplierItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(cart.getModel().getSize()==0){
            jLabel16.setVisible(true);
            jLabel17.setVisible(true);
            return;
        }
        jLabel16.setVisible(false);
        jLabel17.setVisible(false);
        moveButton.setEnabled(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutActionPerformed
        customerPane.setVisible(false);
        LoginPane.setVisible(true);
    }//GEN-LAST:event_logOutActionPerformed

    private void placeOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placeOrderButtonActionPerformed
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "";
        try
        {
            if(moveButton.isEnabled() ==true){
                jLabel11.setVisible(true);
                return;
            }
            jLabel11.setVisible(false);
            String orderdetails ="";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stt = con.createStatement();
            
            orderdetails =  "INSERT INTO orderdetails(TrainNumber,DeliveryStation,TimeOfDelivery,FoodItems,Status,FoodSupplier,CustomerUserName) VALUES('"+trainNumber.getSelectedItem()+"','"+721302+"','"+hourCombo.getSelectedIndex()+
                    ":"+minuteCombo.getSelectedIndex()+","+new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime())+"','";
            
            ListModel iterate = (ListModel) cart.getModel();
            
            for(int i=0;i<iterate.getSize();i++){
                orderdetails+=iterate.getElementAt(i)+" ";
            }
            
            orderdetails+="','UnAccepted','";
            orderdetails+=(foodSupplier.getSelectedItem()+"','");
            orderdetails+=(Username.getText()+"')");
            stt.execute("USE tghm");
            startTimer(Username.getText());
            placeOrderButton.setEnabled(false);
            stt.execute(orderdetails);
            stt.close();
            con.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_placeOrderButtonActionPerformed
public static void startTimer(String cus){
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "";
        
        new java.util.Timer().schedule( 
        new java.util.TimerTask() {
            @Override
            public void run() {
                try
                {
                    String orderdetails ="";
                    String status="";
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    Connection con = DriverManager.getConnection(url, user, password);
                    Statement stt = con.createStatement();
                    
                    stt.execute("USE tghm");
                    
                    String query ="SELECT Status FROM orderdetails WHERE CustomerUserName='"+cus+"'";
                    
                    ResultSet rs =stt.executeQuery(query);
                    while(rs.next()){
                        status = rs.getString("Status");
                        if(status.equals("Accepted")){
                        }
                        else if(status.equals("UnAccepted")){
                            stt.execute("UPDATE orderdetails SET Status='Rejected' WHERE CustomerUserName='"+cus+"'");
                        }
                        break;
                    }
                    stt.close();
                    con.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }, 
        6000 
        );  
    }
    private void CancelRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelRBActionPerformed
       
    }//GEN-LAST:event_CancelRBActionPerformed

    private void modifyRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyRBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modifyRBActionPerformed

    private void ProceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProceedActionPerformed
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "";
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stt = con.createStatement();
            
            stt.execute("USE tghm");
                if(modifyRB.isSelected()){
                    String tquery = "SELECT * FROM orderdetails WHERE CustomerUserName='"+Username.getText()+"'";
                    ResultSet mrs =stt.executeQuery(tquery);
                    String curreg="";
                    mrs.next();
                    curreg  = mrs.getString("FoodSupplier");

                    
                    String nquery = "SELECT * FROM customer WHERE Username='"+Username.getText()+"'";
                    ResultSet nrs =stt.executeQuery(nquery);
                    nrs.next();
                    String rej = nrs.getString("RejectedAgents");
                    if(rej != null)
                    {
                        rej= rej + ","+curreg+",";
                    }
                    else rej= curreg+",";
                    nquery="UPDATE customer SET RejectedAgents='"+rej+"' WHERE Username='"+Username.getText()+"'";
                    stt.execute(nquery);
                    nquery= "DELETE FROM orderdetails WHERE CustomerUserName='"+Username.getText()+"' AND Status='Rejected'";
                    stt.execute(nquery);

                    customerPane.setVisible(true);
                    LoginPane.setVisible(false);
                    customertab.setSelectedIndex(0);
                    placeOrderButton.setEnabled(true);
                    foodSupplier.setEnabled(true);
                    moveButton.setEnabled(true);

                    jSplitPane2.setDividerLocation(123);
                    cartSplitPane.setDividerLocation(270);
                    
                    
                    ArrayList<String> item= new ArrayList<String>();
                    DefaultListModel newone =new DefaultListModel();
                    cart.setModel(newone);
            }
                else if(CancelRB.isSelected() ==true){
                    String tquery = "SELECT * FROM orderdetails WHERE CustomerUserName='"+Username.getText()+"'";
                    ResultSet mrs =stt.executeQuery(tquery);
                    String curreg="";
                    mrs.next();
                    curreg  = mrs.getString("FoodSupplier");
                    
                    String nquery = "SELECT * FROM customer WHERE Username='"+Username.getText()+"'";
                    ResultSet nrs =stt.executeQuery(nquery);
                    nrs.next();
                    String rej = nrs.getString("RejectedAgents");
                    if(rej != null)
                    {
                        rej= rej + ","+curreg;
                    }
                    else rej= curreg;
                    nquery="UPDATE customer SET RejectedAgents='"+rej+"' WHERE Username='"+Username.getText()+"'";
                    stt.execute(nquery);
                    nquery= "DELETE FROM orderdetails WHERE CustomerUserName='"+Username.getText()+"' AND Status='Rejected'";
                    stt.execute(nquery);

                    customerPane.setVisible(false);
                    modifyPane.setVisible(false);
                    LoginPane.setVisible(true);
                    placeOrderButton.setEnabled(true);
                    foodSupplier.setEnabled(true);
                    moveButton.setEnabled(true);
                    jSplitPane2.setDividerLocation(123);
                    cartSplitPane.setDividerLocation(270);
                    
                    ArrayList<String> item= new ArrayList<String>();
                    DefaultListModel newone =new DefaultListModel();
                    cart.setModel(newone);
                
                }

            stt.close();
            con.close();
            }catch (Exception e)
            {
                e.printStackTrace();
            }    

    }//GEN-LAST:event_ProceedActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "";
       
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stt = con.createStatement();
            stt.execute("USE tghm");
            foodSupplier.setSelectedIndex(0);
            String query ="SELECT * FROM foodsupplier";
            ResultSet rs =stt.executeQuery(query);
            while(rs.next()){
                System.out.println(rs.getString("Username")+foodSupplier.getSelectedItem());
                if(foodSupplier.getSelectedItem().toString().equals(rs.getString("Username"))){
                    System.out.println(rs.getString("Username"));
                    ArrayList<String> split = new ArrayList<String>(Arrays.asList(rs.getString("Menu").split(",")));
                    for(int i=0;i<split.size();i++){
                        menuCart.setSelectedIndex(0);
                        System.out.println(menuCart.getSelectedValue()+i);
                        cartitems.add(menuCart.getSelectedValue()+" - "+(countCart.getSelectedIndex()+1));
                        DefaultListModel model = (DefaultListModel) menuCart.getModel();
                        int selectedIndex = menuCart.getSelectedIndex();
                        if (selectedIndex != -1) {
                            model.remove(selectedIndex);
                        }
                        menuCart.setModel(model);
                        foodSupplier.setEnabled(false);
                        DefaultListModel newone =new DefaultListModel();
                        for(String x:cartitems){
                            newone.addElement(x);
                        }
                        cart.setModel(newone);
                    }
                
                }
            }
            
            stt.close();
            con.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
        }    

        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void FoodSupplierButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FoodSupplierButtonActionPerformed
        contactNo.setVisible(false);
        contactNoLabel.setVisible(false);
        
    }//GEN-LAST:event_FoodSupplierButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        FoodSupplierRegisterPane newframe = new FoodSupplierRegisterPane();
        newframe.setVisible(true);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void contactNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactNoActionPerformed

    private void customerRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerRegisterActionPerformed
        contactNo.setVisible(true);
        contactNoLabel.setVisible(true);
    }//GEN-LAST:event_customerRegisterActionPerformed

    private void trainNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trainNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_trainNumberActionPerformed

    private void AgentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgentButtonActionPerformed
        contactNo.setVisible(false);
        contactNoLabel.setVisible(false);
        
    }//GEN-LAST:event_AgentButtonActionPerformed

    private void CustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerButtonActionPerformed
        contactNo.setVisible(false);
        contactNoLabel.setVisible(false);    
    }//GEN-LAST:event_CustomerButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton AgentButton;
    private javax.swing.JRadioButton CancelRB;
    private javax.swing.JRadioButton CustomerButton;
    private javax.swing.JRadioButton FoodSupplierButton;
    private javax.swing.JLabel Invaliduserwarn;
    private javax.swing.JButton LoginButton;
    private javax.swing.JPanel LoginPane;
    private javax.swing.JRadioButton ManagementButton;
    private javax.swing.JTextField Password;
    private javax.swing.JButton Proceed;
    private javax.swing.JLabel Radiowarn;
    private javax.swing.JTextField Username;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JList<String> cart;
    private javax.swing.JPanel cartPanel;
    private javax.swing.JSplitPane cartSplitPane;
    private javax.swing.JTextField contactNo;
    private javax.swing.JLabel contactNoLabel;
    private javax.swing.JComboBox<String> countCart;
    private javax.swing.JPanel customerPane;
    private javax.swing.JRadioButton customerRegister;
    private javax.swing.JTabbedPane customertab;
    private javax.swing.JPanel dummy;
    private javax.swing.JLabel dummylabe;
    private javax.swing.JComboBox<String> foodSupplier;
    private javax.swing.JComboBox<String> hourCombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton logOut;
    private javax.swing.JList<String> menuCart;
    private javax.swing.JComboBox<String> minuteCombo;
    private javax.swing.JPanel modifyPane;
    private javax.swing.JRadioButton modifyRB;
    private javax.swing.JButton moveButton;
    private javax.swing.JPanel placeOrder;
    private javax.swing.JButton placeOrderButton;
    private javax.swing.JTable tableAgent;
    private javax.swing.JComboBox<String> trainNumber;
    // End of variables declaration//GEN-END:variables
}
