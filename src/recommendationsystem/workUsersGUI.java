/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommendationsystem;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodri
 */
public class workUsersGUI extends javax.swing.JFrame {

    ArrayList<User> workableUsers;
    int current = 0;

    /**
     * Creates new form workUsersGUI
     */
    public workUsersGUI() {
        initComponents();
        //namePanel.setText(workableUsers.get(current).name);
    }

    public void setList(ArrayList<User> list) {
        workableUsers = list;
        five.setSelected(true);
        fiveRatingButton.setSelected(true);
    }

    public void newUser(User user) {
        namePanel.setText("Hi " + user.name + "!");
        infoPanel.setText("");

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
        namePanel = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        infoPanel = new javax.swing.JTextPane();
        closeButton = new javax.swing.JButton();
        previous = new javax.swing.JButton();
        next = new javax.swing.JButton();
        other = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        five = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        ten = new javax.swing.JToggleButton();
        fifteen = new javax.swing.JToggleButton();
        visitedButton = new javax.swing.JToggleButton();
        threeRatingButton = new javax.swing.JToggleButton();
        fourRatingButton = new javax.swing.JToggleButton();
        fiveRatingButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        namePanel.setBackground(new java.awt.Color(204, 0, 0));
        namePanel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        namePanel.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(namePanel);

        jScrollPane2.setViewportView(infoPanel);

        closeButton.setBackground(new java.awt.Color(204, 0, 0));
        closeButton.setForeground(new java.awt.Color(255, 255, 255));
        closeButton.setText("CLOSE");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        previous.setBackground(new java.awt.Color(204, 0, 0));
        previous.setForeground(new java.awt.Color(255, 255, 255));
        previous.setText("<");
        previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousActionPerformed(evt);
            }
        });

        next.setBackground(new java.awt.Color(204, 0, 0));
        next.setForeground(new java.awt.Color(255, 255, 255));
        next.setText(">");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        jLabel1.setText("KM");

        five.setBackground(new java.awt.Color(204, 0, 0));
        five.setForeground(new java.awt.Color(255, 255, 255));
        five.setText("5");
        five.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Recommend me something!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ten.setBackground(new java.awt.Color(204, 0, 0));
        ten.setForeground(new java.awt.Color(255, 255, 255));
        ten.setText("10");
        ten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenActionPerformed(evt);
            }
        });

        fifteen.setBackground(new java.awt.Color(204, 0, 0));
        fifteen.setForeground(new java.awt.Color(255, 255, 255));
        fifteen.setText("15");
        fifteen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fifteenActionPerformed(evt);
            }
        });

        visitedButton.setBackground(new java.awt.Color(204, 0, 0));
        visitedButton.setForeground(new java.awt.Color(255, 255, 255));
        visitedButton.setText("Visited");
        visitedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visitedButtonActionPerformed(evt);
            }
        });

        threeRatingButton.setBackground(new java.awt.Color(204, 0, 0));
        threeRatingButton.setForeground(new java.awt.Color(255, 255, 255));
        threeRatingButton.setText("3");
        threeRatingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                threeRatingButtonActionPerformed(evt);
            }
        });

        fourRatingButton.setBackground(new java.awt.Color(204, 0, 0));
        fourRatingButton.setForeground(new java.awt.Color(255, 255, 255));
        fourRatingButton.setText("4");
        fourRatingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fourRatingButtonActionPerformed(evt);
            }
        });

        fiveRatingButton.setBackground(new java.awt.Color(204, 0, 0));
        fiveRatingButton.setForeground(new java.awt.Color(255, 255, 255));
        fiveRatingButton.setText("5");
        fiveRatingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveRatingButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(visitedButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(five, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ten, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(other, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(closeButton)
                        .addGap(110, 110, 110)
                        .addComponent(previous)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(next)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(threeRatingButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fourRatingButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(fiveRatingButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(other, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(five, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ten, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fifteen, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(visitedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(threeRatingButton)
                    .addComponent(fourRatingButton)
                    .addComponent(fiveRatingButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeButton)
                    .addComponent(previous)
                    .addComponent(next))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void previousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousActionPerformed
        if (current > 0) {
            newUser(workableUsers.get(--current));
            
        }
    }//GEN-LAST:event_previousActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        // TODO add your handling code here:
        if (current < workableUsers.size() - 1) {
            newUser(workableUsers.get(++current));
            
        }
    }//GEN-LAST:event_nextActionPerformed

    private void fiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveActionPerformed
        // TODO add your handling code here:
        ten.setSelected(false);
        fifteen.setSelected(false);
        other.setText("");
    }//GEN-LAST:event_fiveActionPerformed

    private void tenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenActionPerformed
        // TODO add your handling code here:
        five.setSelected(false);
        fifteen.setSelected(false);
        other.setText("");
    }//GEN-LAST:event_tenActionPerformed

    private void fifteenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fifteenActionPerformed
        // TODO add your handling code here:
        five.setSelected(false);
        ten.setSelected(false);
        other.setText("");
    }//GEN-LAST:event_fifteenActionPerformed
    public int determineRating() {
        int rating;
        if (threeRatingButton.isSelected()) {
            rating = 3;
        } else {
            if (fourRatingButton.isSelected()) {
                rating = 4;
            } else {
                rating = 5;
            }
        }
        return rating;
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        double distance;
        int rating = determineRating();
        newUser(workableUsers.get(current));
        try {
            infoPanel.setText(null);
            if (!other.getText().equals("")) {
                try {
                    distance = Double.parseDouble(other.getText());
                } catch (Exception e) {
                    throw new IllegalArgumentException("Must be a valid distance!");
                }
                workableUsers.get(current).recommendEstablishmentForUser(distance, rating);
                five.setSelected(false);
        ten.setSelected(false);
        fifteen.setSelected(false);
            } else {
                infoPanel.setText("");
                distance = 5;
                if (five.isSelected()) {
                    distance = 5;
                }
                if (ten.isSelected()) {
                    distance = 10;
                }
                if (fifteen.isSelected()) {
                    distance = 15;
                }
                workableUsers.get(current).recommendEstablishmentForUser(distance, rating);
            }
            
            infoPanel.setText(workableUsers.get(current).recommendedToString());
        } catch (Exception e) {
            infoPanel.setText(e.getMessage());
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void visitedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visitedButtonActionPerformed
        // TODO add your handling code here:
        newUser(workableUsers.get(current));
        infoPanel.setText(workableUsers.get(current).visitedToString());
    }//GEN-LAST:event_visitedButtonActionPerformed

    private void fiveRatingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveRatingButtonActionPerformed
        // TODO add your handling code here:
        fourRatingButton.setSelected(false);
        threeRatingButton.setSelected(false);
    }//GEN-LAST:event_fiveRatingButtonActionPerformed

    private void fourRatingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fourRatingButtonActionPerformed
        // TODO add your handling code here:
        fiveRatingButton.setSelected(false);
        threeRatingButton.setSelected(false);
    }//GEN-LAST:event_fourRatingButtonActionPerformed

    private void threeRatingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_threeRatingButtonActionPerformed
        // TODO add your handling code here:
        fiveRatingButton.setSelected(false);
        fourRatingButton.setSelected(false);
    }//GEN-LAST:event_threeRatingButtonActionPerformed

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
            java.util.logging.Logger.getLogger(workUsersGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(workUsersGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(workUsersGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(workUsersGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new workUsersGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JToggleButton fifteen;
    private javax.swing.JToggleButton five;
    private javax.swing.JToggleButton fiveRatingButton;
    private javax.swing.JToggleButton fourRatingButton;
    private javax.swing.JTextPane infoPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane namePanel;
    private javax.swing.JButton next;
    private javax.swing.JTextField other;
    private javax.swing.JButton previous;
    private javax.swing.JToggleButton ten;
    private javax.swing.JToggleButton threeRatingButton;
    private javax.swing.JToggleButton visitedButton;
    // End of variables declaration//GEN-END:variables
}
