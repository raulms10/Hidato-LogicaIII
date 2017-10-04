/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hidato;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import sun.swing.table.DefaultTableCellHeaderRenderer;

/**
 *
 * @author lis
 */
public class Tablero extends javax.swing.JFrame {

    private int filas = 4;
    private int columnas = 4;
    private int dificultad = 3;
    ArrayList<Nodo> listPistas;
    private boolean exito = false;
    long semilla = Calendar.getInstance().getTimeInMillis();
    long segundos;
    //System.out.println("Semilla: " + semilla);
    Random random = new Random();
    ArrayList<DefaultTableModel> soluciones = new ArrayList<DefaultTableModel>();
    DefaultTableModel modelTablero;

    /**
     * Creates new form Tablero
     */
    public Tablero() {
        initComponents();
        jcbDificultad.removeAllItems();
        jcbDificultad.addItem("1");
        jcbDificultad.addItem("2");
        jcbDificultad.addItem("3");
        jcbDificultad.setSelectedIndex(1);

        //generarTablero();
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
        jTableTablero = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnGenerar = new javax.swing.JButton();
        jTextFil = new javax.swing.JTextField();
        jTextCol = new javax.swing.JTextField();
        jcbDificultad = new javax.swing.JComboBox<>();
        jbtnGuardarPNG = new javax.swing.JButton();
        jbtnGuardarTexto = new javax.swing.JButton();
        jbtnSolucionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableTablero.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableTablero);

        jLabel1.setText("Filas:");

        jLabel2.setText("Columnas:");

        jLabel3.setText("Dificultad:");

        btnGenerar.setText("Generar");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        jTextCol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextColActionPerformed(evt);
            }
        });

        jcbDificultad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jbtnGuardarPNG.setText("Guardar como PNG");
        jbtnGuardarPNG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarPNGActionPerformed(evt);
            }
        });

        jbtnGuardarTexto.setText("Guardar como Texto");
        jbtnGuardarTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarTextoActionPerformed(evt);
            }
        });

        jbtnSolucionar.setText("Solucionar");
        jbtnSolucionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSolucionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(3, 3, 3)
                                .addComponent(jTextFil, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addGap(4, 4, 4)
                                .addComponent(jTextCol, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(2, 2, 2)
                                .addComponent(jcbDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGenerar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbtnGuardarTexto)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnGuardarPNG)
                        .addGap(77, 77, 77)
                        .addComponent(jbtnSolucionar)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jTextFil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextCol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnGenerar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnGuardarPNG)
                    .addComponent(jbtnGuardarTexto)
                    .addComponent(jbtnSolucionar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextColActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextColActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextColActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        jTableTablero.setModel(new DefaultTableModel());
        try {
            filas = Integer.valueOf(jTextFil.getText());
            columnas = Integer.valueOf(jTextCol.getText());
            dificultad = Integer.valueOf(jcbDificultad.getItemAt(jcbDificultad.getSelectedIndex()));
            if (filas <= 0 || columnas <= 0) {
                JOptionPane.showMessageDialog(rootPane, "Digite sólo números mayores que cero", "Error numérico", JOptionPane.ERROR_MESSAGE);
                return;
                //System.out.println("Las filas o columnas debe ser mayor que 0");            
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Digite sólo números", "Error de formato", JOptionPane.ERROR_MESSAGE);
            return;
        }
        exito = false;
        soluciones = new ArrayList<DefaultTableModel>();
        listPistas = new ArrayList<Nodo>();
        long inicio = System.currentTimeMillis();
        generarTablero();
        long fin = System.currentTimeMillis();
        segundos = (fin - inicio) / 1000;
        System.out.println("Tardó: " + segundos + " segundos");
        encuentrePistas();
        colorearTablero();
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void jbtnGuardarPNGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarPNGActionPerformed
        String nombre = JOptionPane.showInputDialog(rootPane, "Digite el nombre de la imagen sin espacios", "Nombre de laimagen", JOptionPane.QUESTION_MESSAGE);
        if (nombre == null) {
            return;
        }
        if ("".equals(nombre.replace(" ", ""))) {
            JOptionPane.showMessageDialog(rootPane, "El nombre de la imagen no puede estar vacío", "Error falta nombre", JOptionPane.WARNING_MESSAGE);
            return;
        }
        guardarTableroEnPNG(jTableTablero, nombre.replace(" ", ""));
    }//GEN-LAST:event_jbtnGuardarPNGActionPerformed

    private void jbtnGuardarTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarTextoActionPerformed
        try {
            String nombre = JOptionPane.showInputDialog(rootPane, "Digite el nombre del archivo de texto sin espacios", "Nombre del TXT", JOptionPane.QUESTION_MESSAGE);
            if (nombre == null) {
                return;
            }
            if ("".equals(nombre.replace(" ", ""))) {
                JOptionPane.showMessageDialog(rootPane, "El nombre del archivo de text no puede estar vacío", "Error falta nombre", JOptionPane.WARNING_MESSAGE);
                return;
            }
            guardarTableroEnTXT(jTableTablero, nombre.replace(" ", ""));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, "Ha ocurrido un error al tratar de crear el archivo TXT", "Error de escritura", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtnGuardarTextoActionPerformed

    private void jbtnSolucionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSolucionarActionPerformed
        DefaultTableModel modelSol = (DefaultTableModel) jTableTablero.getModel();
        if(modelSol == null || modelTablero == null){
            JOptionPane.showMessageDialog(rootPane, "El tablero aún no se ha generado ", "Tablero vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                modelSol.setValueAt(modelTablero.getValueAt(i, j), i, j);
            }
        }
        jTableTablero.setModel(modelSol);
    }//GEN-LAST:event_jbtnSolucionarActionPerformed

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
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tablero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTablero;
    private javax.swing.JTextField jTextCol;
    private javax.swing.JTextField jTextFil;
    private javax.swing.JButton jbtnGuardarPNG;
    private javax.swing.JButton jbtnGuardarTexto;
    private javax.swing.JButton jbtnSolucionar;
    private javax.swing.JComboBox<String> jcbDificultad;
    // End of variables declaration//GEN-END:variables

    private DefaultTableModel creeTablero() {
        semilla = Calendar.getInstance().getTimeInMillis();
        random.setSeed(semilla);
        int fRandom = random.nextInt(filas) + 1;
        int cRandom = random.nextInt(columnas) + 1;
        System.out.println("Valor: " + fRandom + " " + cRandom);
        Nodo n = new Nodo(1, fRandom, cRandom);
        //Nodo n = new Nodo(1, 0, 0);
        //imprimirVecinos(calculeVecinos(n));
        modelTablero.setValueAt(1, fRandom - 1, cRandom - 1);
        busqueSolucion(n);
        System.out.println("Se han encontrado " + soluciones.size() + " soluciones");
        if (soluciones.size() == 0) {
            return null;
        }
        int sol = random.nextInt(soluciones.size());
        System.out.println("Mostrando solución " + sol);
        return soluciones.get(sol);

    }

    private void generarTablero() {
        modelTablero = new DefaultTableModel(filas, columnas);
        modelTablero = creeTablero();
        if (modelTablero == null) {
            System.out.println("Error, vuelva a intentarlo");
            return;
        }
        jTableTablero.setModel(modelTablero);
        jTableTablero.getTableHeader().setUI(null);

        DefaultTableModel model = new DefaultTableModel(filas, columnas);
        
        int casillasMostrar = 100 - dificultad * 30;
        casillasMostrar = (int) casillasMostrar * filas * columnas / 100;
        casillasMostrar = Math.max(casillasMostrar, 1);

        System.out.println("Casillas: " + casillasMostrar);

        semilla = Calendar.getInstance().getTimeInMillis();
        random.setSeed(semilla);
        //modelTablero = new DefaultTableModel(filas, columnas);
        int auxFil, auxCol;

        for (int i = 0; i < casillasMostrar; i++) {
            auxFil = random.nextInt(filas);
            auxCol = random.nextInt(columnas);
            if (model.getValueAt(auxFil, auxCol) != null) {
                i--;
            } else {
                model.setValueAt(modelTablero.getValueAt(auxFil, auxCol), auxFil, auxCol);
            }
        }
        jTableTablero.setModel(model);
        //System.out.println("SOL: " + vectorSol);

        //imprimirTablero(model);
    }

    private void imprimirVecinos(ArrayList<Nodo> lista) {
        for (Nodo n : lista) {
            System.out.println("Valor: " + n.getNumero() + " F: " + n.getFila() + " C: " + n.getColumna());
        }
    }

    private void imprimirTablero(DefaultTableModel tablero) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("  " + tablero.getValueAt(i, j) + "  ");
            }
            System.out.println(" ");
        }
    }

    private boolean esValidoVecino(Nodo n) {
        return !calculeVecinos(n).isEmpty() || n.getNumero() >= filas * columnas;
    }

    private void busqueSolucion(Nodo nodo) {
        //modelTablero.setValueAt(nodo.getNumero(), nodo.getFila()-1, nodo.getColumna()-1);
        ArrayList<Nodo> vecinos = calculeVecinos(nodo);
        //imprimirNodos(vecinos);
        if (!exito) {
            for (Nodo v : vecinos) {
                if (esValidoVecino(v) && !v.isVisitado()) {
                    modelTablero.setValueAt(v.getNumero(), v.getFila() - 1, v.getColumna() - 1); //escriba(nodo)
                    if (v.getNumero() < filas * columnas) {
                        busqueSolucion(v);
                        if (!exito) {
                            modelTablero.setValueAt(null, v.getFila() - 1, v.getColumna() - 1);
                            v.setVisitado(true);
                        }
                    } else {
                        System.out.println("Una solución");
                        imprimirTablero(modelTablero);
                        soluciones.add(nuevoTablero(modelTablero));
                        exito = true;
                    }
                    modelTablero.setValueAt(null, v.getFila() - 1, v.getColumna() - 1);
                    v.setVisitado(true);
                }
            }
        }

    } //Intentar mostrar una solución

    /*private void busqueSolucion(Nodo nodo) {
        //modelTablero.setValueAt(nodo.getNumero(), nodo.getFila()-1, nodo.getColumna()-1);
        ArrayList<Nodo> vecinos = calculeVecinos(nodo);
        //imprimirNodos(vecinos);
        for(Nodo v: vecinos){
            if(esValidoVecino(v) && !v.isVisitado()){
                modelTablero.setValueAt(v.getNumero(), v.getFila()-1, v.getColumna()-1); //escriba(nodo)
                if(v.getNumero() < filas*columnas){
                    busqueSolucion(v);
                }else{
                    System.out.println("Una solución");
                    imprimirTablero(modelTablero);
                    soluciones.add(nuevoTablero(modelTablero));
                    return;
                }
                modelTablero.setValueAt(null, v.getFila()-1, v.getColumna()-1);
                v.setVisitado(true);
            }            
        }
    }*/ //Todas las soluciones usando la variable local
    /*private void busqueSolucion(Nodo nodo, DefaultTableModel actualTablero) {
        //modelTablero.setValueAt(nodo.getNumero(), nodo.getFila()-1, nodo.getColumna()-1);
        ArrayList<Nodo> vecinos = calculeVecinos(nodo);
        //imprimirNodos(vecinos);
        for(Nodo v: vecinos){
            if(esValidoVecino(v) && !v.isVisitado()){
                actualTablero.setValueAt(v.getNumero(), v.getFila()-1, v.getColumna()-1); //escriba(nodo)
                if(v.getNumero() < filas*columnas){
                    busqueSolucion(v, actualTablero);
                }else{
                    System.out.println("Una solución");
                    imprimirTablero(actualTablero);
                    soluciones.add(actualTablero);
                }
                actualTablero.setValueAt(null, v.getFila()-1, v.getColumna()-1);
                v.setVisitado(true);
            }            
        }
    }*/ //Encuentra todas las soluciones enviando como parámetro
    private ArrayList<Nodo> calculeVecinos(Nodo nodo) {
        ArrayList<Nodo> v = new ArrayList<Nodo>();
        int f = nodo.getFila();
        int c = nodo.getColumna();
        for (int i = f - 1; i <= f + 1; i++) {
            for (int j = c - 1; j <= c + 1; j++) {
                if ((i > 0 && j > 0 && i <= filas && j <= columnas) && (i != f || j != c)) {
                    if (modelTablero.getValueAt(i - 1, j - 1) == null) {
                        v.add(new Nodo(nodo.getNumero() + 1, i, j));
                    }
                }
            }
        }
        int total = v.size();
        int pos;
        ArrayList<Nodo> veci = new ArrayList<Nodo>();
        semilla = Calendar.getInstance().getTimeInMillis();
        random.setSeed(semilla);
        for (int i = 0; i < total; i++) {
            pos = random.nextInt(v.size());
            veci.add(v.get(pos));
            v.remove(pos);
        }
        return veci;
    }

    private DefaultTableModel nuevoTablero(DefaultTableModel modelTablero) {
        DefaultTableModel nuevo = new DefaultTableModel(filas, columnas);
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                nuevo.setValueAt(modelTablero.getValueAt(i, j), i, j);
            }
        }
        return nuevo;
    }

    private void guardarTableroEnPNG(javax.swing.JTable table, String nombre) {
        int w = table.getWidth();
        int h = table.getHeight();
        if (w == 0 || h == 0) {
            JOptionPane.showMessageDialog(rootPane, "El tablero aún no se ha generado ", "Tablero vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = bi.createGraphics();
        table.paint(g2);
        g2.dispose();
        try {
            File f = new File(nombre + ".png");
            String ruta = f.getAbsolutePath();
            System.out.println(ruta);
            ImageIO.write(bi, "png", f);
            JOptionPane.showMessageDialog(rootPane, "Ruta: " + ruta, "Imagen guardada", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ioe) {
            //System.out.println("write: " + ioe.getMessage());
            JOptionPane.showMessageDialog(rootPane, "No se ha podido guardar la imagen", "Error de almacenamiento", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    private void guardarTableroEnTXT(javax.swing.JTable table, String nombre) throws IOException {
        int w = table.getWidth();
        int h = table.getHeight();
        if (w == 0 || h == 0) {
            JOptionPane.showMessageDialog(rootPane, "El tablero aún no se ha generado ", "Tablero vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        File fileTXT = new File(nombre + ".txt");
        String ruta = fileTXT.getAbsolutePath();
        FileWriter fw = new FileWriter(fileTXT, false);
        
        fw.write(filas+" "+columnas+" "+dificultad+" "+listPistas.size()+"\n");
        for(Nodo n: listPistas){
            fw.write(n.getFila()+" "+n.getColumna()+" "+(listPistas.indexOf(n)+1)+"\n");
        }
        fw.write(segundos+"");
        fw.close();
        
        System.out.println(ruta);
        JOptionPane.showMessageDialog(rootPane, "Ruta: " + ruta, "Archivo TXT guardado", JOptionPane.INFORMATION_MESSAGE);
        
    }

    private void encuentrePistas() {
        listPistas.add(new Nodo(23, 1, 9));
        listPistas.add(new Nodo(45, 5, 1));
        listPistas.add(new Nodo(42, 1, 6));
    }

    private void colorearTablero() {
        DefaultTableModel modelColor = (DefaultTableModel) jTableTablero.getModel();
        DefaultTableCellRenderer dr = (DefaultTableCellRenderer) jTableTablero.getDefaultRenderer(String.class);
        
        TableCellRenderer tcr;// = jTableTablero.getCellRenderer(0, 0);
        
        //Component c = Tcr.getTableCellRendererComponent(jTable1, jTableTablero.getValueAt(x, y), false, false, x, y);
        //Object renderer = table.getDefaultRenderer(String.class);
	//if (renderer instanceof JComponent) {
	//	((JComponent) renderer).setBackground(Color.WHITE);
	//}
        Component comp; 
        for(int i=0; i<filas; i++){
            for(int j=0; j<columnas; j++){
                tcr = jTableTablero.getCellRenderer(i, j);
                comp = tcr.getTableCellRendererComponent(jTableTablero, modelColor.getValueAt(i, j), false, false, i, j);
                //comp = dr.getTableCellRendererComponent(jTableTablero, modelColor.getValueAt(i, j), false, false, i, j);
                if(modelColor.getValueAt(i, j) != null){
                    comp.setBackground(Color.red);
                    System.out.println("Valor:" + modelColor.getValueAt(i, j));
                }else{
                    comp.setBackground(Color.blue);
                }
            }
        }
        //jTableTablero.setModel(modelColor);
    }
}
