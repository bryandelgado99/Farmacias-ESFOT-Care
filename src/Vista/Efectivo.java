/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import javax.swing.JOptionPane;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author bryan
 */
public class Efectivo extends javax.swing.JFrame {

    public static final String DB_URL = "jdbc:mysql://localhost/esfot-care";
    public static final String USER = "root";
    public static final String PASSWORD = "root2023";
    
    /**
     * Creates new form Efectivo
     */
    public Efectivo() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        String Total = Vista.Home_Cajero.getFormattedTotalT();
        totalLabel.setText(Total);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dineroInput = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        vueltoLabel = new javax.swing.JLabel();
        pagarButton = new javax.swing.JButton();
        cambiarMetodoButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Efectivo");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Total a pagar:");

        totalLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalLabel.setText("------");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Total entregado:");

        dineroInput.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dineroInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dineroInputActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Cambio:");

        vueltoLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        vueltoLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        vueltoLabel.setText("-----");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(29, 29, 29)
                                .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(vueltoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dineroInput, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(totalLabel)
                    .addComponent(jLabel2))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dineroInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(vueltoLabel))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pagarButton.setBackground(new java.awt.Color(153, 255, 153));
        pagarButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pagarButton.setText("Pagar");
        pagarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pagarButtonMouseClicked(evt);
            }
        });
        pagarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagarButtonActionPerformed(evt);
            }
        });

        cambiarMetodoButton.setBackground(new java.awt.Color(255, 102, 102));
        cambiarMetodoButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cambiarMetodoButton.setText("Cambiar Método");
        cambiarMetodoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cambiarMetodoButtonMouseClicked(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 255, 255));
        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pagarButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cambiarMetodoButton, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(59, 59, 59))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(pagarButton)
                .addGap(30, 30, 30)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cambiarMetodoButton)
                .addGap(37, 37, 37))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dineroInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dineroInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dineroInputActionPerformed

    private void pagarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagarButtonActionPerformed
                // TODO add your handling code here:
        
        
        //primero ingresar el cliente
        String ci = Vista.Home_Cajero.getCedula();
        String nombre = Vista.Home_Cajero.getNombre();
        String apellido = Vista.Home_Cajero.getApellido();
        String telefono = Vista.Home_Cajero.getTelefono();
        String email = Vista.Home_Cajero.getEmail();
        String direccion = Vista.Home_Cajero.getDireccion();
        
        // agregacion de compra
        // Obtener la fecha y hora actual de Java
        Date fechaActual = new Date();
        // Formatear la fecha como una cadena de caracteres en el formato deseado
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaFormateada = sdf.format(fechaActual);

        String cajero = Vista.Login.getCod_caj();
        String subStr = Vista.Home_Cajero.getFormattedSubTotal();
        double subtotal = Double.parseDouble(subStr);
        String ivStr = Vista.Home_Cajero.getFormattedIva();
        double iva= Double.parseDouble(ivStr);
        String toStr = Vista.Home_Cajero.getFormattedTotalT();
        double total = Double.parseDouble(toStr);

    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            //primero ingresamos el cliente para que se puede hacer la factura
            String queryClienteCompra = "INSERT INTO `ESFOT-CARE`.`Clientes` " +
                           "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmtcli = conn.prepareStatement(queryClienteCompra);
            stmtcli.setString(1, ci);
            stmtcli.setString(2, apellido);
            stmtcli.setString(3, nombre);
            stmtcli.setString(4, telefono);
            stmtcli.setString(5, email);
            stmtcli.setString(6, direccion);

            int rowsAffected = stmtcli.executeUpdate(); // Ejecutar la consulta y obtener el número de filas afectadas

            // Verificar si la inserción fue exitosa
            if (rowsAffected > 0) {
                System.out.println("Inserción exitosa.");
            } else {
                System.out.println("No se insertaron registros.");
            }
            

            // cabafactura
            String queryCab = "INSERT INTO `ESFOT-CARE`.`Cabecera_Fac` \n" +
"(`Clientes_ci_cli`, `fecha_emision`, `Cajeros_codigo_caj`, `subtotal_fac`, `iva_fac`, `descuento_fac`, `total_pagar`, `metodo_pago`)\n" +
"VALUES\n" +
"(?, ?, ?, ?, ?, 0.00, ?, 'Efectivo');";
            PreparedStatement stmtcab = conn.prepareStatement(queryCab);
            stmtcab.setString(1, ci );
            stmtcab.setString(2, fechaFormateada);
            stmtcab.setString(3, cajero);
            stmtcab.setDouble(4, subtotal);
            stmtcab.setDouble(5, iva);
            stmtcab.setDouble(6, total);
            
            int rowsAffectedCab = stmtcab.executeUpdate();
            // Verificar si la inserción fue exitosa
            if (rowsAffectedCab > 0) {
                System.out.println("Inserción exitosa.");
            } else {
                System.out.println("No se insertaron registros.");
            }
            
            String querydetFact = "INSERT INTO `ESFOT-CARE`.`Detalle_Fac`\n" +
"(`Cabecera_Fac_num_factura`, `Productos_codigo_prod`, `cantidad`, `valor_venta`, `total_det`)\n" +
"VALUES\n" +
"(@num_factura, 'BASS7012', 2, 50.00, 100.00);";
            PreparedStatement stmtdet = conn.prepareStatement(querydetFact);
            
            stmtdet.setString(1, ci );
            stmtdet.setString(2, fechaFormateada);
            stmtdet.setString(3, cajero);
            stmtdet.setDouble(4, subtotal);
            stmtdet.setDouble(5, iva);
            stmtdet.setDouble(6, total);
            
            int rowsAffectedDet = stmtdet.executeUpdate();
            // Verificar si la inserción fue exitosa
            if (rowsAffectedDet > 0) {
                System.out.println("Inserción exitosa.");
            } else {
                System.out.println("No se insertaron registros.");
            }
            
        } catch (SQLException x) {
            throw new RuntimeException(x);
        }

    }//GEN-LAST:event_pagarButtonActionPerformed

    private void cambiarMetodoButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cambiarMetodoButtonMouseClicked
      Metodo_pago metopag = new Metodo_pago();
      metopag.setVisible(true);
      this.setVisible(false);
    }//GEN-LAST:event_cambiarMetodoButtonMouseClicked

    private void pagarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pagarButtonMouseClicked
        if (!"".equals(dineroInput.getText())) {
            Metodo_pago metopag = new Metodo_pago();
            metopag.setVisible(false);
            this.setVisible(false);
            Confirmacion_pago confipag = new Confirmacion_pago();
            confipag.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Pague por la compra!");
        }
    }//GEN-LAST:event_pagarButtonMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String Total = Vista.Home_Cajero.getFormattedTotalT();
        Total = Total.replace(",", ".");
        double TotalT = Double.parseDouble(Total);
        String Dinero = dineroInput.getText();
        double dineroT = Double.parseDouble(Dinero);

        if (dineroT > TotalT) {
            double cambio = dineroT - TotalT;
            String formattedTotal = String.format("%.2f", cambio);
            vueltoLabel.setText(formattedTotal);
        } else {
            JOptionPane.showMessageDialog(null, "Falta Dinero!");
            dineroInput.setText("");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cambiarMetodoButton;
    private javax.swing.JTextField dineroInput;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton pagarButton;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JLabel vueltoLabel;
    // End of variables declaration//GEN-END:variables
}
