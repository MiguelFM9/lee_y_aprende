package leeyaprende;

import beans.BeanUsuario;
import daos.DaoLibros;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Inicio extends javax.swing.JFrame {

    private DefaultTableModel modelo = new DefaultTableModel();
    private DaoLibros daoLibro = new DaoLibros();

    public Inicio() {
        modelo = new DefaultTableModel(new String []{"ISBN","Titulo","Paginas","Autor","Editorial"}, 0);
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    public void limpiarTabla(){
        int a = modelo.getRowCount()-1;
        for(int i=a;i>=0;i--){
            modelo.removeRow(i);
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

        grupoSeleccion = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtbusqueda = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        chkAutor = new javax.swing.JRadioButton();
        chkTitulo = new javax.swing.JRadioButton();
        chkIsbn = new javax.swing.JRadioButton();
        chkEditorial = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lee & Aprende - Buscar libro");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/2.png"))); // NOI18N
        jLabel3.setText("Acceder Administrador");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logom.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 0));
        jLabel2.setText("Buscar Libro");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        grupoSeleccion.add(chkAutor);
        chkAutor.setText("Autor");
        chkAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkAutorActionPerformed(evt);
            }
        });

        grupoSeleccion.add(chkTitulo);
        chkTitulo.setText("Título");
        chkTitulo.setContentAreaFilled(false);
        chkTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        chkTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkTituloActionPerformed(evt);
            }
        });

        grupoSeleccion.add(chkIsbn);
        chkIsbn.setText("ISBN");
        chkIsbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkIsbnActionPerformed(evt);
            }
        });

        grupoSeleccion.add(chkEditorial);
        chkEditorial.setText("Editorial");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(chkEditorial)
                .addGap(64, 64, 64)
                .addComponent(chkAutor)
                .addGap(46, 46, 46)
                .addComponent(chkIsbn)
                .addGap(103, 103, 103)
                .addComponent(chkTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(178, 178, 178))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(174, 174, 174))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkEditorial)
                    .addComponent(chkAutor)
                    .addComponent(chkIsbn)
                    .addComponent(chkTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable2.setModel(modelo);
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        limpiarTabla();
        if ("".equals(txtbusqueda.getText())) {
            JOptionPane.showMessageDialog(null, "Por favor indique un valor a la busqueda");
        } else {

            if (chkTitulo.isSelected()==true) {
                String titulo = txtbusqueda.getText();
                String Sentencia="select libro.isbn,libro.titulo,libro.num_pag,autor.nombre, editorial.nombre from libro"
                        + " inner join escribe on libro.libro_id=escribe.libro_id "
                        + " inner join editorial on editorial.editorial_id=libro.editorial_id"
                        + " inner join autor on autor.autor_id=escribe.autor_id where libro.titulo like '%"+titulo+"%'";
                
                List<String[]> lista = daoLibro.consultaLibros(Sentencia);
                if(lista.isEmpty()){
                    JOptionPane.showMessageDialog(rootPane, "El libro no existe");
                }else{
                  for (String[] libro : lista) {
                    modelo.addRow(libro);
                    }  
                }      
            }
            if (chkAutor.isSelected()==true) {
                String autor = txtbusqueda.getText();
                String Sentencia="select libro.isbn,libro.titulo,libro.num_pag,autor.nombre, editorial.nombre from libro"
                        + " inner join escribe on libro.libro_id=escribe.libro_id "
                        + " inner join editorial on editorial.editorial_id=libro.editorial_id"
                        + " inner join autor on autor.autor_id=escribe.autor_id where autor.nombre like '%"+autor+"%'";
                
                List<String[]> lista = daoLibro.consultaLibros(Sentencia);
                if(lista.isEmpty()){
                    JOptionPane.showMessageDialog(rootPane, "El libro no existe");
                }else{
                  for (String[] libro : lista) {
                    modelo.addRow(libro);
                    }  
                }     

            }
            if (chkEditorial.isSelected()==true) {
                String editorial = txtbusqueda.getText();
                String Sentencia="select libro.isbn,libro.titulo,libro.num_pag,autor.nombre, editorial.nombre from libro"
                        + " inner join escribe on libro.libro_id=escribe.libro_id "
                        + " inner join editorial on editorial.editorial_id=libro.editorial_id"
                        + " inner join autor on autor.autor_id=escribe.autor_id where editorial.nombre like '%"+editorial+"%'";
                
                List<String[]> lista = daoLibro.consultaLibros(Sentencia);
                if(lista.isEmpty()){
                    JOptionPane.showMessageDialog(rootPane, "El libro no existe");
                }else{
                  for (String[] libro : lista) {
                    modelo.addRow(libro);
                    }  
                }     

            }
            if (chkIsbn.isSelected()==true) {
                String isbn = txtbusqueda.getText();
                String Sentencia="select libro.isbn,libro.titulo,libro.num_pag,autor.nombre, editorial.nombre from libro"
                        + " inner join escribe on libro.libro_id=escribe.libro_id "
                        + " inner join editorial on editorial.editorial_id=libro.editorial_id"
                        + " inner join autor on autor.autor_id=escribe.autor_id where libro.isbn like '%"+isbn+"%'";
                
                List<String[]> lista = daoLibro.consultaLibros(Sentencia);
                if(lista.isEmpty()){
                    JOptionPane.showMessageDialog(rootPane, "El libro no existe");
                }else{
                  for (String[] libro : lista) {
                    modelo.addRow(libro);
                    }  
                }
                

            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void chkAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkAutorActionPerformed

    private void chkTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkTituloActionPerformed

    private void chkIsbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkIsbnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkIsbnActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JRadioButton chkAutor;
    private javax.swing.JRadioButton chkEditorial;
    private javax.swing.JRadioButton chkIsbn;
    private javax.swing.JRadioButton chkTitulo;
    private javax.swing.ButtonGroup grupoSeleccion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtbusqueda;
    // End of variables declaration//GEN-END:variables
}
