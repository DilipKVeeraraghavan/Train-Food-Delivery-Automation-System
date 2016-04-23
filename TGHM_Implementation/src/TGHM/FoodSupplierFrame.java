package TGHM;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class FoodSupplierFrame extends javax.swing.JFrame {

    public FoodSupplierFrame(FoodSupplierAuth authent) {
        JPanel panel = new MenuManagement(authent);
        initComponents();
        add(panel);
        panel.add(new JScrollPane());
        panel.setSize(580,617);
        this.pack();
        this.setSize(580,617);
        panel.setLocation(0,0);
        validate(); 
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 357, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
