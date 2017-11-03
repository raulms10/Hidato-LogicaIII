/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hidato;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lis
 */
public class Tablero extends javax.swing.JFrame {

    private int filas = 4;
    private int columnas = 4;
    private int fPrimero;
    private int cPrimero;
    private int fUltimo;
    private int cUltimo;
    private int dificultad = 3;
    ArrayList<Nodo> listPistas;
    private boolean exito = false;
    private boolean cargado = false; 
    long semilla = Calendar.getInstance().getTimeInMillis();
    long segundos;
    private JFileChooser fileChooser;//
    //System.out.println("Semilla: " + semilla);
    Random random = new Random();
    ArrayList<DefaultTableModel> soluciones = new ArrayList<DefaultTableModel>();
    DefaultTableModel modelTablero;

    /**
     * Creates new form Tablero
     */
    public Tablero() {
        //Editamos propiedaades básicas del juego
        initComponents();
        //Añadimos los elementos de dificultad al comboBox
        jcbDificultad.removeAllItems();
        jcbDificultad.addItem("Simple");
        jcbDificultad.addItem("Media");
        jcbDificultad.addItem("Difícil");
        jcbDificultad.setSelectedIndex(1);
        //Modificamos propiedades de la interfaz
        this.setLocation(500, 250);
        this.setResizable(false);  
        this.setTitle("Un divertido juego");
        
        fileChooser =  new JFileChooser(); //Inicializamos el selector de archivos
        fileChooser.setDialogTitle("Seleccione el archivo TXT del tablero");
        //ImageIcon im = new ImageIcon(getClass().getResource("equipo.jpg"));
        //setIconImage(im.getImage());

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

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFil = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextCol = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jcbDificultad = new javax.swing.JComboBox<>();
        btnGenerar = new javax.swing.JButton();
        jLblTablero = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTablero = new javax.swing.JTable();
        jbtnGuardarTexto = new javax.swing.JButton();
        jbtnGuardarPNG = new javax.swing.JButton();
        jbtnSolucionar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnCargar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Bitstream Charter", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Hidato");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 117, 34));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Filas:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 20));

        jTextFil.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(jTextFil, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 46, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Columnas:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, 20));

        jTextCol.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextCol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextColActionPerformed(evt);
            }
        });
        getContentPane().add(jTextCol, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 45, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Dificultad:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, 30));

        jcbDificultad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbDificultad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbDificultad, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, -1, -1));

        btnGenerar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnGenerar.setText("Generar");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 90, -1));

        jLblTablero.setFont(new java.awt.Font("Bitstream Charter", 0, 36)); // NOI18N
        jLblTablero.setForeground(new java.awt.Color(0, 0, 0));
        jLblTablero.setText("Tablero generado");
        getContentPane().add(jLblTablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, -1, 50));

        jTableTablero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTableTablero.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
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
        jTableTablero.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTableTablero.setGridColor(new java.awt.Color(1, 1, 1));
        jTableTablero.setRowSelectionAllowed(false);
        jTableTablero.setSelectionBackground(new java.awt.Color(168, 106, 231));
        jTableTablero.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTableTablero);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 490, 216));

        jbtnGuardarTexto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbtnGuardarTexto.setText("Guardar como Texto");
        jbtnGuardarTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarTextoActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnGuardarTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, -1));

        jbtnGuardarPNG.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbtnGuardarPNG.setText("Guardar como PNG");
        jbtnGuardarPNG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarPNGActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnGuardarPNG, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, -1, -1));

        jbtnSolucionar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jbtnSolucionar.setText("Solución");
        jbtnSolucionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSolucionarActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnSolucionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 380, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 0, 0));
        jLabel7.setText("por: Alejandro Gallego");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        btnCargar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnCargar.setText("Cargar");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 90, -1));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hidato/fondo.jpg"))); // NOI18N
        jLabel6.setText("por: Alejandro Gallego");
        jLabel6.setToolTipText("");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextColActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextColActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextColActionPerformed

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        jTableTablero.setModel(new DefaultTableModel()); //Reseteamos el tablero
        try {
            //Obtenemos las características del nuevo tablero
            filas = Integer.valueOf(jTextFil.getText());
            columnas = Integer.valueOf(jTextCol.getText());
            dificultad = jcbDificultad.getSelectedIndex()+1;
            //Verificamos los datos ingresados
            if (filas < 3 || columnas < 3) {
                JOptionPane.showMessageDialog(rootPane, "Digite sólo números mayores o iguales que tres (3)", "Error numérico", JOptionPane.ERROR_MESSAGE);
                return;
                //System.out.println("Las filas o columnas debe ser mayor que 0");            
            }
            
            if (filas > 100 || columnas > 100) {
                JOptionPane.showMessageDialog(rootPane, "Digite sólo números menores o iguales que cien (100)", "Error numérico", JOptionPane.ERROR_MESSAGE);
                return;
                //System.out.println("Las filas o columnas debe ser mayor que 0");            
            }

        }catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Digite sólo números", "Error de formato", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //Reseteamos las varibales
        exito = false;
        soluciones = new ArrayList<DefaultTableModel>();
        listPistas = new ArrayList<Nodo>();
        //Obtenemos el tiempo para mirar cuanto tarda en generar el tablero
        long inicio = System.currentTimeMillis();
        //Generamos el tablero
        generarTablero();
        /*if (filas == 1 && columnas == 1 && modelTablero == null) {
            modelTablero = new DefaultTableModel(filas, columnas);
            modelTablero.setValueAt(1, 0, 0);
            jTableTablero.setModel(modelTablero);
            jTableTablero.getTableHeader().setUI(null);
        }*/
        //imprimirTablero(modelTablero);
        //System.out.println("FC: "+modelTablero.getColumnCount()+" "+modelTablero.getRowCount());
        long fin = System.currentTimeMillis();
        segundos = (fin - inicio) / 1000; //Obtenemos el tiempo en segundos
        //System.out.println("Tardó: " + segundos + " segundos");
        encuentrePistas(); //Hallamos las pistas y las añadimos a
        //colorearTablero();
        //Creamos nuestro Renderer para poder editar los colores a las celdas
        MyRenderer myRenderer = new MyRenderer();
        myRenderer.setInicial(nuevoTablero((DefaultTableModel) jTableTablero.getModel()));
        myRenderer.setSolucion(modelTablero);
        jTableTablero.setDefaultRenderer(Object.class, myRenderer);
        //Modificamos y habilitamos las cuadrículas a la tabla
        jTableTablero.setShowGrid(true);
        jTableTablero.setGridColor(Color.BLACK);
        cargado = false;
        jLblTablero.setText("Tablero generado");
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void jbtnGuardarPNGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarPNGActionPerformed
        //Capturamos el nombre de la imagen
        String nombre = JOptionPane.showInputDialog(rootPane, "Digite el nombre de la imagen sin espacios", "Nombre de laimagen", JOptionPane.QUESTION_MESSAGE);
        //Validamos el nombre
        if (nombre == null) {
            return;
        }
        if ("".equals(nombre.replace(" ", ""))) {
            JOptionPane.showMessageDialog(rootPane, "El nombre de la imagen no puede estar vacío", "Error falta nombre", JOptionPane.WARNING_MESSAGE);
            return;
        }
        //Guardamos la imagen en PNG
        guardarTableroEnPNG(jTableTablero, nombre.replace(" ", ""));
    }//GEN-LAST:event_jbtnGuardarPNGActionPerformed

    private void jbtnGuardarTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarTextoActionPerformed
        //Capturamos el nombre del archivo de texto
        try {
            String nombre = JOptionPane.showInputDialog(rootPane, "Digite el nombre del archivo de texto sin espacios", "Nombre del TXT", JOptionPane.QUESTION_MESSAGE);
            if (nombre == null) {
                return;
            }
            //Validamos el nombre
            if ("".equals(nombre.replace(" ", ""))) {
                JOptionPane.showMessageDialog(rootPane, "El nombre del archivo de text no puede estar vacío", "Error falta nombre", JOptionPane.WARNING_MESSAGE);
                return;
            }
            //Guardamos el tablero en el archivo TXT
            guardarTableroEnTXT(jTableTablero, nombre.replace(" ", ""));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, "Ha ocurrido un error al tratar de crear el archivo TXT", "Error de escritura", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtnGuardarTextoActionPerformed

    private void jbtnSolucionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSolucionarActionPerformed
        if (cargado){
            hallarSolucion();
        }else{
            //Obtenemos el modelo del tablero actual
            DefaultTableModel modelSol = (DefaultTableModel) jTableTablero.getModel();
            //Validamos que el tablero haya sido generado
            if(modelSol == null || modelTablero == null || modelSol.getColumnCount() < 3 || modelSol.getRowCount() < 3){
                JOptionPane.showMessageDialog(rootPane, "El tablero aún no se ha creado ", "Tablero vacío", JOptionPane.WARNING_MESSAGE);
                return;
            }
            //Llenamos el tablero según su solución
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    modelSol.setValueAt(modelTablero.getValueAt(i, j), i, j);
                }
            }
            //Actualizamos el modelo del tablero actual
            jTableTablero.setModel(modelSol);
        }
    }//GEN-LAST:event_jbtnSolucionarActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        
        int res = fileChooser.showOpenDialog(this);
        
        if (res == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            //This is where a real application would open the file.
            System.out.println("Opening: " + file.getName() + "   " + file.getAbsolutePath());
        } else {
            System.out.println("Open command cancelled by user");
            return;
        }

        jLblTablero.setText("Tablero cargado");
        cargado = true;
    }//GEN-LAST:event_btnCargarActionPerformed

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
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLblTablero;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTablero;
    private javax.swing.JTextField jTextCol;
    private javax.swing.JTextField jTextFil;
    private javax.swing.JButton jbtnGuardarPNG;
    private javax.swing.JButton jbtnGuardarTexto;
    private javax.swing.JButton jbtnSolucionar;
    private javax.swing.JComboBox<String> jcbDificultad;
    // End of variables declaration//GEN-END:variables

    //Retorna un modelo(tablero) solucionado ubicando la primera casilla(1) aleatoriamente
    private DefaultTableModel creeTablero() {
        //Calculamos una posición en el tablero de forma aleatoria
        semilla = Calendar.getInstance().getTimeInMillis();
        random.setSeed(semilla);
        fPrimero = random.nextInt(filas) + 1; //Fila aleatoria
        cPrimero = random.nextInt(columnas) + 1; //Columna aleatoria
        System.out.println("Valor: " + fPrimero + " " + cPrimero);
        Nodo n = new Nodo(1, fPrimero, cPrimero); //Creamos un nodo(casilla) con esos valores
        //Nodo n = new Nodo(1, 0, 0);
        //imprimirVecinos(calculeVecinos(n));
        modelTablero.setValueAt(1, fPrimero - 1, cPrimero - 1); //Ponemos este valor en el tablero
        busqueSolucion(n); //Buscamos una solución con el valor que tenemos (la primera posicón)
        //System.out.println("Se han encontrado " + soluciones.size() + " soluciones");
        if (soluciones.isEmpty()) { //Verificamos que se haya encontrado una solución
            return null;
        }
        //int sol = random.nextInt(soluciones.size());
        //System.out.println("Mostrando solución " + sol);
        return soluciones.get(0); //Tomanos la primera solución, el primer modelo
    }

    //Crea un tablero y le muestra al usuario un deterinado número de pistas
    private void generarTablero() {
        //Creamos un modelo(tablero) con las filas y columnas ingresada
        modelTablero = new DefaultTableModel(filas, columnas);
        //Obtenemos una instancia de la solcuión, es decir, un tablero completo
        modelTablero = creeTablero();
        if (modelTablero == null) { //Verificamos la validez del tablero
            //System.out.println("Error, vuelva a intentarlo");
            return;
        }
        //jTableTablero.setModel(modelTablero); //Actualizamos la interfaz gráfica
        jTableTablero.getTableHeader().setUI(null); //Quitamos el header del JTable
        
        //Creamos un nuevo tablero (modelo) que será e tablero que se le mostrará añ usuario con sólo las pistas
        DefaultTableModel model = new DefaultTableModel(filas, columnas);
        
        //Hallamos la cantidad de pistas a mostar en función de la dificultad
        int casillasMostrar = 100 - dificultad * 30; //Porcenteaje de casillas a mostrar
        casillasMostrar = (int) casillasMostrar * filas * columnas / 100; //Sacamos el porcentaje del total de casilas
        //Entre más dificil menos casillas de van a mostrar, pero al menos se mostrará 1
        casillasMostrar = Math.max(casillasMostrar, 1);

        //System.out.println("Primero: " +fPrimero + " " + cPrimero + " Ultimo: " + fUltimo+" "+ cUltimo);
        model.setValueAt(modelTablero.getValueAt(fPrimero-1, cPrimero-1), fPrimero-1, cPrimero-1);
        model.setValueAt(modelTablero.getValueAt(fUltimo-1, cUltimo-1), fUltimo-1, cUltimo-1);
        
        casillasMostrar -= 2;        
        
        semilla = Calendar.getInstance().getTimeInMillis();
        random.setSeed(semilla);
        //modelTablero = new DefaultTableModel(filas, columnas);
        int auxFil, auxCol;
        //Del tabero solución sacamos un la cantidad de casillas a mostrar en forma aleatoria
        for (int i = 0; i < casillasMostrar; i++) {
            auxFil = random.nextInt(filas);
            auxCol = random.nextInt(columnas);
            if (model.getValueAt(auxFil, auxCol) != null) {//Nos encontramos con una casilla ocupada
                i--; //No cuenta como casilla dos veces como pista
            } else {
                model.setValueAt(modelTablero.getValueAt(auxFil, auxCol), auxFil, auxCol);
            }
        }
        jTableTablero.setModel(model); //Actualizamos la interfaz gráfica
        //System.out.println("SOL: " + vectorSol);

        //imprimirTablero(model);
    }

    //Muestra los vecinos de un nodo
    private void imprimirVecinos(ArrayList<Nodo> lista) {
        for (Nodo n : lista) {
            System.out.println("Valor: " + n.getNumero() + " F: " + n.getFila() + " C: " + n.getColumna());
        }
    }

    //Muentra los valores del tablero(modelo) enviado como parámetro
    private void imprimirTablero(DefaultTableModel tablero) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("  " + tablero.getValueAt(i, j) + "  ");
            }
            System.out.println(" ");
        }
    }

    //Determina la validez e un vecino
    private boolean esValidoVecino(Nodo n) {
        return !calculeVecinos(n, modelTablero).isEmpty() || n.getNumero() >= filas * columnas;
    }

    //Encuentra la solución (llena el tablero) en forma recursiva usando la técnica de programación con retroceso
    private void busqueSolucion(Nodo nodo) {
        //modelTablero.setValueAt(nodo.getNumero(), nodo.getFila()-1, nodo.getColumna()-1);
        //Calculamos los vecinos de un nodo
        ArrayList<Nodo> vecinos = calculeVecinos(nodo, modelTablero);
        //imprimirNodos(vecinos);
        //Verificamos que aún no se haya encontrado solución
        if (!exito) {
            //Por cada vecino
            for (Nodo v : vecinos) {
                //Se verifica la validez del mismo
                if (esValidoVecino(v) && !v.isVisitado()) {
                    //Se añade al tablero
                    modelTablero.setValueAt(v.getNumero(), v.getFila() - 1, v.getColumna() - 1); //escriba(nodo)
                    if (v.getNumero() < filas * columnas) { //Como no se ha llenado el tablero
                        //Se sigue explorarndo las soluciones con las demás combinaciones
                        busqueSolucion(v);
                        //Y si no se encunetra solución
                        if (!exito) {
                            //Se quita el nodo del tablero
                            modelTablero.setValueAt(null, v.getFila() - 1, v.getColumna() - 1);
                            v.setVisitado(true); // y se marca como visitado para no volver a usarlo 
                        }
                    } else {// Como ya se llenó el tablero, quiere decir que se encontró solución
                        //System.out.println("Una solución");
                        //imprimirTablero(modelTablero);
                        //Por lo tanto, se añade esta solución a la lista de soluciones
                        soluciones.add(nuevoTablero(modelTablero));
                        fUltimo = v.getFila();
                        cUltimo = v.getColumna();
                        exito = true;//Para no seguir buscando solución, si se quita esto se encontrarán todas las soluciones posibles
                    }
                    //modelTablero.setValueAt(null, v.getFila() - 1, v.getColumna() - 1);
                    //v.setVisitado(true);
                }
            }
        }
    } //Se encuentra la primera solución

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
    
    //Encuentra los vecinos de un nodo según el número de fila y columna que tenga
    private ArrayList<Nodo> calculeVecinos(Nodo nodo, DefaultTableModel model) {
        ArrayList<Nodo> v = new ArrayList<Nodo>();
        int f = nodo.getFila(); //Se obtiene la fila
        int c = nodo.getColumna(); //Se obtiene la columna
        for (int i = f - 1; i <= f + 1; i++) {
            for (int j = c - 1; j <= c + 1; j++) {
                if ((i > 0 && j > 0 && i <= filas && j <= columnas) && (i != f || j != c)) {
                    if (model.getValueAt(i - 1, j - 1) == null) {
                        v.add(new Nodo(nodo.getNumero() + 1, i, j)); //Se añade a la lista de vecinos
                    }
                }
            }
        }
        //Se intenta reordenar los vecinos en foma aleatoria
        /*int total = v.size();
        int pos;
        ArrayList<Nodo> veci = new ArrayList<Nodo>();
        semilla = Calendar.getInstance().getTimeInMillis();
        random.setSeed(semilla);
        for (int i = 0; i < total; i++) {
            pos = random.nextInt(v.size());
            veci.add(v.get(pos));
            v.remove(pos);
        }
        return veci;*/
        return v;
    }

    //Crea una nueva instancia(copia) del modelo enviado como parámetro
    private DefaultTableModel nuevoTablero(DefaultTableModel modelTablero) {
        //Se crea un nuevo modelo
        DefaultTableModel nuevo = new DefaultTableModel(filas, columnas);
        //Y se copian todos los datos a este nuevo modelo
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                nuevo.setValueAt(modelTablero.getValueAt(i, j), i, j);
            }
        }
        return nuevo;
    }

    //Guarda el tablero como una iamgen en PNG
    private void guardarTableroEnPNG(javax.swing.JTable table, String nombre) {
        int w = table.getWidth();
        int h = table.getHeight();
        if (w == 0 || h == 0) { //Se verifica que el tablero ya haya sido creado
            JOptionPane.showMessageDialog(rootPane, "El tablero aún no se ha generado ", "Tablero vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }
        //Se crea el buffered
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = bi.createGraphics();
        table.paint(g2); //Se dibuja la del tablero en el gráfico creado con el buffered
        g2.dispose();
        try {
            File f = new File(nombre + ".png"); //Se crea el archivo de la imagen
            String ruta = f.getAbsolutePath(); //Se obtiene la ruta de la imagen
            //System.out.println(ruta);
            ImageIO.write(bi, "png", f); //Se escribe en el archivo la imagen
            JOptionPane.showMessageDialog(rootPane, "Ruta: " + ruta, "Imagen guardada", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ioe) {
            //System.out.println("write: " + ioe.getMessage());
            JOptionPane.showMessageDialog(rootPane, "No se ha podido guardar la imagen", "Error de almacenamiento", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Guarda el tablero(pistas) en un archivo de texto
    private void guardarTableroEnTXT(javax.swing.JTable table, String nombre) throws IOException {
        int w = table.getWidth();
        int h = table.getHeight();
        if (w == 0 || h == 0) { //Se verifica que el tablero ya haya sido creado
            JOptionPane.showMessageDialog(rootPane, "El tablero aún no se ha generado ", "Tablero vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        File fileTXT = new File(nombre + ".txt"); //Se crea el archivo de texto
        String ruta = fileTXT.getAbsolutePath(); //Se obtiene la ruta del archivo
        FileWriter fw = new FileWriter(fileTXT, false);
        
        fw.write(filas+" "+columnas+" "+dificultad+" "+listPistas.size()+"\n"); //Se escribe las propiedades del tablero
        for(Nodo n: listPistas){ //Por cada pista en el tablero
            fw.write(n.getFila()+" "+n.getColumna()+" "+n.getNumero()+"\n"); //Se escribe en el archivo de texto
        }
        fw.write(segundos+""); //Se escribe el tiempo que se demoró en generar el tablero
        fw.close(); //Se cierra el archivo
        
        //System.out.println(ruta);
        JOptionPane.showMessageDialog(rootPane, "Ruta: " + ruta, "Archivo TXT guardado", JOptionPane.INFORMATION_MESSAGE);
        
    }

    //Crea una lista con las pistas que se encuentran en el tablero
    private void encuentrePistas() {
        //Se obtiene el modelo del tablero actual visible al usuario
        DefaultTableModel model = (DefaultTableModel) jTableTablero.getModel();
        //Nodo n = new Nodo();
        //Por cada celda del tablero
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if(model.getValueAt(i, j) != null){ //Se verifica que sea pista
                    listPistas.add(new Nodo( (int)model.getValueAt(i, j), i+1, j+1)); //Y se agrega a la lista
                }
            }
        }
        
        //listPistas.add(new Nodo(23, 1, 9));
        //listPistas.add(new Nodo(45, 5, 1));
        //listPistas.add(new Nodo(42, 1, 6));
    }

    private void hallarSolucion() {
        System.out.println("Sol otro lado");
    }

    /*private void colorearTablero() {
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
    }*/
    
    //Se usa para colorear el tablero
    public class MyRenderer extends DefaultTableCellRenderer{
        
        private DefaultTableModel inicial; //Tablero con las pistas
        private DefaultTableModel solucion; //Tablero con la solución
        private Nodo actual = new Nodo(); //Nodo del tablero
        
        //Este método se ejecuta cada vez que se cambie algún valor en el tablero
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,boolean hasFocus, int row, int column) {
            
            //Se obtiene la celda 
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            //Se le cambia el color de la letra
            cell.setForeground(Color.BLACK); //Letra de casillas ocupadas
            
            //Se le cambia el color de la letra a la primera casilla del juego
            if(solucion.getValueAt(row, column).equals(1)){
                    //cell.setBackground(Color.LIGHT_GRAY);
                cell.setForeground(Color.RED); //Letra de primero
            }
            //Se le cambia el color de la letra a la última casilla del juego
            if(solucion.getValueAt(row, column).equals(filas*columnas)){
                    //cell.setBackground(Color.LIGHT_GRAY);
                    cell.setForeground(Color.RED); //Letra de último
            }
            
            //Se verifica que la celda(casilla) sea una pista
            if(inicial.getValueAt(row, column) != null){
                cell.setBackground(new Color(102, 178, 255)); //Fondo casillas ocupadas (pistas)
            }else{
                cell.setBackground(new Color(0, 128, 255)); //Fondo de casillas vacías               
            }

            return cell;
        }

        //Getter and Setter methods
        public DefaultTableModel getSolucion() {
            return solucion;
        }

        public void setSolucion(DefaultTableModel solucion) {
            this.solucion = solucion;
        }
        
        public DefaultTableModel getInicial() {
            return inicial;
        }

        public void setInicial(DefaultTableModel inicial) {
            this.inicial = inicial;
        }       
    }
}
