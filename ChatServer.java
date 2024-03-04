package BaiKT;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

public class ChatServer extends javax.swing.JFrame implements Runnable {

    ServerSocket svSocket;
    Socket socket;
    DataOutputStream output;
    DataInputStream input;
    DefaultListModel model;
    public ChatServer() {
        initComponents();
        model = new DefaultListModel();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtPort = new javax.swing.JTextField();
        btnStart = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        IsHistory = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMessage = new javax.swing.JTextArea();
        btnSend = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        btnSendImg = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("PORT");

        txtPort.setText("1571020015");
        txtPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPortActionPerformed(evt);
            }
        });

        btnStart.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(IsHistory);

        txtMessage.setColumns(20);
        txtMessage.setRows(3);
        jScrollPane2.setViewportView(txtMessage);

        btnSend.setText("Chat");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        jTextField1.setText("Server");

        btnSendImg.setText("Gửi ảnh");
        btnSendImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendImgActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSendImg))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSend))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1)
                        .addGap(37, 37, 37)
                        .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addComponent(btnStart)))
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnStart))
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnSend, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSendImg)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPortActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        try {
            model.addElement("Server connecting");
            IsHistory.setModel(model);
            svSocket = new ServerSocket(Integer.parseInt(txtPort.getText()));
            socket = svSocket.accept();
            model.addElement("Server is connectied");
            IsHistory.setModel(model);
            Thread t = new Thread(ChatServer.this);
            t.start();
        } catch (Exception e) {
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        // TODO add your handling code here:
        try {
            output = new DataOutputStream(socket.getOutputStream());
            output.writeUTF(txtMessage.getText());
            output.flush();
        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnSendActionPerformed

    private void btnSendImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendImgActionPerformed
try {
        // Mở hộp thoại chọn file
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            // Lấy file hình ảnh đã chọn
            File file = fileChooser.getSelectedFile();

            // Đọc file hình ảnh và chuyển đổi thành byte array
            byte[] imageBytes = new byte[(int) file.length()];
            try (FileInputStream fis = new FileInputStream(file)) {
                fis.read(imageBytes);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            ImageIcon imageIcon = new ImageIcon(imageBytes);
            JLabel lblImage = new JLabel(imageIcon);

        }

            output = new DataOutputStream(socket.getOutputStream());
            output.writeUTF(fileChooser.ACCEPT_ALL_FILE_FILTER_USED_CHANGED_PROPERTY);
            output.flush();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnSendImgActionPerformed

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
            java.util.logging.Logger.getLogger(ChatServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatServer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> IsHistory;
    private javax.swing.JButton btnSend;
    private javax.swing.JButton btnSendImg;
    private javax.swing.JButton btnStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextArea txtMessage;
    private javax.swing.JTextField txtPort;
    // End of variables declaration//GEN-END:variables
@Override
    public void run() {
        try {
            input = new DataInputStream(socket.getInputStream());
            while (true) {
                if (socket != null) {
                    model.addElement("Client: " + input.readUTF());
                    IsHistory.setModel(model);
                }
                Thread.sleep(1000);
            }

        } catch (Exception e) {
        }

    }
}
