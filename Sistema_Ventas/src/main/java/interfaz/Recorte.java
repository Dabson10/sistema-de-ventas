/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaz;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tadeo
 */
public class Recorte extends javax.swing.JFrame {

    /**
     * Creates new form Recorte
     */
    public Recorte() {
        initComponents();
        tablas();
        establecerDia();
    }

    public void tablas() {
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexiones.Conexion objetoConexion = new Conexiones.Conexion();
            String consulta1 = "SELECT idVenta,ganancia,numVenta FROM sistema_ventas.ventaDiaria;";
            ps = objetoConexion.establecerConexion().prepareStatement(consulta1);
            rs = ps.executeQuery();
            JTable tabla = Tabla;
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            model.setRowCount(0);
            while (rs.next()) {
                Object[] Columnas = {
                    rs.getObject("idVenta"),
                    rs.getObject("ganancia"),
                    rs.getObject("numVenta")
                };
                model.addRow(Columnas);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudieron mostrar las ventas. ");
        }
    }

    public void establecerDia() {

        LocalDate nuevo = LocalDate.now();
        int day = nuevo.getDayOfMonth();
        int month = nuevo.getMonthValue();
        int year = nuevo.getYear();

//        String[] meses = {
//            "enero", "febrero", "marzo", "abril", "mayo", "junio", "julio",
//            "agosto", "septiembre", "octubre", "noviembre", "diciembre"
//        };

        txtDiaActual.setText("dia " + day + " mes " + month + " Año " + year);

        //Esta linea es para que se cree la fecha en español
        Locale definirDia = new Locale("es", "ES");

        DateTimeFormatter reiniciar = DateTimeFormatter.ofPattern("  dd 'de' MMMM 'de' yyyy", definirDia);

        //Se formate la fecha actual 
        String diaNombre = nuevo.format(reiniciar);
        txtDiaActual.setText(diaNombre);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnRecorte = new javax.swing.JButton();
        btnTotal = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        txtDiaActual = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(221, 230, 237));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 887, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 561, 887, 10));

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Venta", "numVenta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tabla);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 75, 616, 460));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TOTAL DEL DIA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(725, 153, 112, 25));

        lblTotal.setForeground(new java.awt.Color(0, 0, 0));
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotal.setText("0");
        lblTotal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 204, 142, 63));

        btnRecorte.setText("RECORTE");
        btnRecorte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecorteActionPerformed(evt);
            }
        });
        jPanel1.add(btnRecorte, new org.netbeans.lib.awtextra.AbsoluteConstraints(731, 405, 105, 32));

        btnTotal.setText("TOTAL");
        btnTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalActionPerformed(evt);
            }
        });
        jPanel1.add(btnTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(731, 330, 105, 33));

        btnMenu.setText("MENU");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        jPanel1.add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(731, 475, 105, 33));

        txtDiaActual.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtDiaActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 270, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 921, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalActionPerformed
        // Aqui se realizara la consulta para hacer el conteo de dinero obtenido 
        try {
            //Ahora se seleccionara primero el rango desde donde se contara par obtener el valor total de ventas 
            PreparedStatement ps = null;
            ResultSet rs = null;

            Conexiones.Conexion objetoConexion = new Conexiones.Conexion();
            String consulta = "SELECT idVenta,numVenta FROM sistema_ventas.ventaDiaria WHERE idVenta=?;";
            ps = objetoConexion.establecerConexion().prepareStatement(consulta);

            ps.setString(1, "1");

            rs = ps.executeQuery();
            if (rs.next()) {
                int ventas = Integer.valueOf(rs.getString("numVenta"));
                JOptionPane.showMessageDialog(null, "Hoy vendiste " + ventas + " en el dia de hoy");
                //Dentrode un bucle for se hara la misma consulta para obtener un mismo dato solamente que 
                //ese dato se recorrera en 1 conforme la tabla avance, el limite del bucle ya se obtuvo en la variable ventas
                int suma = 0;
                int cont = 0;
                for (cont = 2; cont <= ventas; cont++) {
                    //Consulta para obtener el dato de precio o ganancia diaria, para despues sumarlo uno a uno y obtener el total
                    String consulta2 = "SELECT idVenta,ganancia FROM sistema_ventas.ventaDiaria WHERE idVenta=?;";
                    ps = objetoConexion.establecerConexion().prepareStatement(consulta2);
                    ps.setString(1, String.valueOf(cont));

                    rs = ps.executeQuery();

                    if (rs.next()) {
                        int precio = Integer.valueOf(rs.getString("ganancia"));
                        suma = suma + precio;
                    }
                }
                lblTotal.setText(String.valueOf(suma));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No avanzo");
        }

    }//GEN-LAST:event_btnTotalActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // TODO add your handling code here:
        com.mycompany.sistema_ventas.Menu llamar = new com.mycompany.sistema_ventas.Menu();

        llamar.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnRecorteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecorteActionPerformed
        // Boton para hacer el recorte del dia y agregarlo a una tabla donde se veran las ventas semanales 
        //Cuando acabe el dia se presionara el boon y se agregara a venta del dia o (ventaDiaria) a la tabla (semana).
        //para realizar correctamente esto primeramente se verifiacara si hay menos de 7 filas en la tabla semana,
        //si lo hay procede y si no manda a la interfaz de semana 

        if (Integer.valueOf(lblTotal.getText()) == 0 ) {
            JOptionPane.showMessageDialog(null, "Para agregar el recorte del dia primero presione el boton de (TOTAL) ");
        } else {

            try {
                String fechaAct = txtDiaActual.getText();
                String ganancia = lblTotal.getText();
                Conexiones.Conexion objetoConexion = new Conexiones.Conexion();
                PreparedStatement ps = null;
                ResultSet rs = null;
                
                String verificar ="SELECT idDia FROM sistema_ventas.semana WHERE idDia=?;";
                ps=objetoConexion.establecerConexion().prepareStatement(verificar);
                
                ps.setString(1,"6");
                
                rs=ps.executeQuery();
                
                if(rs.next()){
                    String total =rs.getString("idDia");
                    JOptionPane.showMessageDialog(null, "");
                    
                    if(Integer.valueOf(total)<7){
                        
                        JOptionPane.showMessageDialog(null, "Ya acabo la semana "+total+" Ahora ve a la pestaña semanal para hacer recorte semanal ");
                        lblTotal.setText("0");
                    }
                }else{
                    String agregarSemana = "INSERT INTO sistema_ventas.semana(Fecha,ganancia) VALUES (?,?);";
                ps = objetoConexion.establecerConexion().prepareStatement(agregarSemana);

                ps.setString(1, fechaAct);
                ps.setString(2, ganancia);

                int numF = ps.executeUpdate();

                if (numF > 0) {
                    JOptionPane.showMessageDialog(null, "Se agrego el corte del dia: " + fechaAct);

                    //Ahora que ya se hiso el recorte diario se hara un delete de la tabla en general 
                    String dltTabla = "DELETE FROM sistema_ventas.ventaDiaria;";
                    ps = objetoConexion.establecerConexion().prepareStatement(dltTabla);

                    int act = ps.executeUpdate();

                    if (act > 0) {
                        //Se borra la tabla 
                        JOptionPane.showMessageDialog(null, "Se borro la tabla ");

                        //Ahora se reinicia el indice para iniciarl con el id en 1 
                        String returnTabla = "ALTER TABLE sistema_ventas.ventaDiaria AUTO_INCREMENT=?;";
                        ps = objetoConexion.establecerConexion().prepareStatement(returnTabla);

                        ps.setInt(1, 1);
                        ps.executeUpdate();
                        
                        //Ahora que ya se reinicio la tabla se agregara la estructura de las tabla que es
                        //idVenta=1 y numVenta=0
                        
                        String agregarTabla="INSERT INTO sistema_ventas.ventaDiaria(numVenta) VALUES (?);";
                        ps=objetoConexion.establecerConexion().prepareStatement(agregarTabla);
                        
                        ps.setString(1,"1");
                        
                        int actua=ps.executeUpdate();
                        
                        if(actua>0){
                            JOptionPane.showMessageDialog(null, "Se agrego esquema");
                            lblTotal.setText("0");
                            tablas();
                        }
                        

                    }
                }
                }
                

            } catch (Exception e) {

            }

        }


    }//GEN-LAST:event_btnRecorteActionPerformed

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
            java.util.logging.Logger.getLogger(Recorte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Recorte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Recorte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Recorte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Recorte().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnRecorte;
    private javax.swing.JButton btnTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel txtDiaActual;
    // End of variables declaration//GEN-END:variables
}
