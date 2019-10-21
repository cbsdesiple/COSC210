/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.samford.bensiple.Fun;

import edu.samford.bensiple.stacksandqueues.ListStack;
import edu.samford.bensiple.stacksandqueues.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author desip
 */
public class WebBrowser extends javax.swing.JFrame {

    Stack<String> backStack = new ListStack<>();
    Stack<String> forwardStack = new ListStack<>();
    String currentURL = "home";

    /**
     * Creates new form WebBrowser
     */
    public WebBrowser() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbuttonback = new javax.swing.JButton();
        jButtonforward = new javax.swing.JButton();
        jTextURLBar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPage = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbuttonback.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        jbuttonback.setText("<-- Back");
        jbuttonback.setEnabled(false);
        jbuttonback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonbackActionPerformed(evt);
            }
        });

        jButtonforward.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        jButtonforward.setText("Forward -->");
        jButtonforward.setEnabled(false);
        jButtonforward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonforwardActionPerformed(evt);
            }
        });

        jTextURLBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextURLBarActionPerformed(evt);
            }
        });

        jTextPage.setEditable(false);
        jTextPage.setColumns(20);
        jTextPage.setRows(5);
        jScrollPane1.setViewportView(jTextPage);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbuttonback)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonforward)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextURLBar, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbuttonback)
                    .addComponent(jButtonforward)
                    .addComponent(jTextURLBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbuttonbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonbackActionPerformed
        if (!backStack.isEmpty()) {
            forwardStack.push(currentURL);
            jButtonforward.setEnabled(true);
            currentURL = backStack.pop();
            if (backStack.isEmpty()) {
                jbuttonback.setEnabled(false);
            }
            jTextURLBar.setText(currentURL);
            System.out.println(currentURL);
            //TODO Load the page at current URL
            
            loadCurrentPage();
        }
    }//GEN-LAST:event_jbuttonbackActionPerformed

    private void jButtonforwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonforwardActionPerformed
        if (!forwardStack.isEmpty()) {
            jbuttonback.setEnabled(true);
            backStack.push(currentURL);
            currentURL = forwardStack.pop();
            if (forwardStack.isEmpty()) {
                jButtonforward.setEnabled(false);
            }
            jTextURLBar.setText(currentURL);
            //TODO Load the page at current URL
            loadCurrentPage();
        }
    }//GEN-LAST:event_jButtonforwardActionPerformed

    private void jTextURLBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextURLBarActionPerformed
        backStack.push(currentURL);
        currentURL = jTextURLBar.getText();
        //TODO retrive the new page usign HTTP
        loadCurrentPage();
        jbuttonback.setEnabled(true);

        //User just wiped out the forward button.  We are doing the same
        jButtonforward.setEnabled(false);
        forwardStack = new ListStack<>();
    }//GEN-LAST:event_jTextURLBarActionPerformed

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
            java.util.logging.Logger.getLogger(WebBrowser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WebBrowser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WebBrowser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WebBrowser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WebBrowser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonforward;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextPage;
    private javax.swing.JTextField jTextURLBar;
    private javax.swing.JButton jbuttonback;
    // End of variables declaration//GEN-END:variables

    private void loadCurrentPage() {
        if (currentURL == "home"){
            jTextPage.setText("Home Page");
        }else
        try {
            jTextPage.setText(getHTML(currentURL));
        } catch (Exception ex) {
            Logger.getLogger(WebBrowser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line + "\n");
        }
        rd.close();
        return result.toString();
    }
}
