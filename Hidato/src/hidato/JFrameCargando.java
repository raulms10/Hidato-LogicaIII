/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hidato;

import javax.swing.JLabel;

/**
 *
 * @author lis
 */
public class JFrameCargando extends javax.swing.JFrame {

    /**
     * Creates new form JFrameCargando
     */
    public JFrameCargando() {
        initComponents();
        //this.setLocation(750, 500);
        this.setResizable(false);
        //this.setTitle("Buscando solución");
        
        //lblTime.setText("Espere mientras se encuentra una solución... ");
        
        /*while(true){
            fin = System.currentTimeMillis();
            seg = (float) ((fin - inicio) / 1000.0);
            lblTime.setText("Espere mientras se encuentra una solución... " + seg + " segundos");
        }*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
