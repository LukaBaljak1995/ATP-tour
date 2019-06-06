/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seminarskigui.form;

import constants.Constants;
import java.awt.Frame;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.silab.jdbc.example1.domen.KategorijaTurniraEntity;
import rs.ac.bg.fon.silab.jdbc.example1.domen.TeniserEntity;
import rs.ac.bg.fon.silab.jdbc.example1.domen.TurnirEntity;
import seminarskigui.controller.Controller;
import session.Session;
import tablemodel.UcesceNaTurniruModel;

/**
 *
 * @author lukabaljak
 */
public class FTurnir extends javax.swing.JDialog {

    /**
     * Creates new form FTeniser
     */
    TurnirEntity turnir;

    public FTurnir(java.awt.Frame parent, boolean modal, int model, TurnirEntity turnir) {
        super(parent, modal);
        this.turnir = turnir;
        initComponents();
        urediFormu(model);
        centrirajForm();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldNaziv = new javax.swing.JTextField();
        jTextFieldGrad = new javax.swing.JTextField();
        jComboBoxPodloga = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxKategorijaTurnira = new javax.swing.JComboBox<>();
        jButtonKreiraj = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUcesnici = new javax.swing.JTable();
        jButtonDodajUcesnika = new javax.swing.JButton();
        jButtonObrisiUcesnika = new javax.swing.JButton();
        jButtonGenerisiMeceve = new javax.swing.JButton();
        jButtonSacuvajPromene = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 310));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Podaci o turniru:"));

        jLabel1.setText("Naziv:");

        jLabel2.setText("Grad:");

        jLabel3.setText("Podloga:");

        jComboBoxPodloga.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "beton", "trava", "šljaka" }));
        jComboBoxPodloga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPodlogaActionPerformed(evt);
            }
        });

        jLabel4.setText("Kategorija: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldNaziv)
                    .addComponent(jTextFieldGrad, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                    .addComponent(jComboBoxKategorijaTurnira, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxPodloga, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(49, 49, 49))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldGrad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxPodloga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxKategorijaTurnira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonKreiraj.setText("Kreiraj");
        jButtonKreiraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonKreirajActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Učešća na turniru"));

        jTableUcesnici.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableUcesnici);

        jButtonDodajUcesnika.setText("+");
        jButtonDodajUcesnika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDodajUcesnikaActionPerformed(evt);
            }
        });

        jButtonObrisiUcesnika.setText("-");
        jButtonObrisiUcesnika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonObrisiUcesnikaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDodajUcesnika, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonObrisiUcesnika, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jButtonDodajUcesnika)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonObrisiUcesnika)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jButtonGenerisiMeceve.setText("Generisi meceve");
        jButtonGenerisiMeceve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerisiMeceveActionPerformed(evt);
            }
        });

        jButtonSacuvajPromene.setText("Sacuvaj promene");
        jButtonSacuvajPromene.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSacuvajPromeneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 361, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 209, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonKreiraj, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButtonGenerisiMeceve)
                                .addContainerGap())))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSacuvajPromene, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonKreiraj)
                .addGap(36, 36, 36)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSacuvajPromene)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jButtonGenerisiMeceve)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonKreirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonKreirajActionPerformed
        try {
            TurnirEntity turnirEntity = new TurnirEntity(jTextFieldNaziv.getText(),
                    jComboBoxPodloga.getSelectedItem().toString(), jTextFieldGrad.getText(),
                    (KategorijaTurniraEntity) jComboBoxKategorijaTurnira.getSelectedItem());
            this.turnir = turnirEntity;
            Controller.zapamtiTurnir(turnirEntity);
            JOptionPane.showMessageDialog(this, "Turnir je uspešno sačuvan!");
            urediFormu(Constants.ODABIR_UCESNIKA_NA_TURNIRU);
        } catch (Exception ex) {
            Logger.getLogger(FTurnir.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Turnir nije sačuvan!");
        }
    }//GEN-LAST:event_jButtonKreirajActionPerformed

    private void jComboBoxPodlogaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPodlogaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPodlogaActionPerformed

    private void jButtonDodajUcesnikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDodajUcesnikaActionPerformed
        FRangLista fRangLista
                = new FRangLista((Frame) this.getParent(), rootPaneCheckingEnabled, Constants.ODABIR_UCESNIKA_NA_TURNIRU);
        fRangLista.setVisible(true);

        UcesceNaTurniruModel model = (UcesceNaTurniruModel) jTableUcesnici.getModel();
        TeniserEntity teniserEntity = (TeniserEntity) Session.getInstance().getMap().get(Constants.ODABRANI_TENISER);
        if (model.getTeniseriKojiUcestvuju().contains(teniserEntity)) {
            JOptionPane.showMessageDialog(rootPane, "Odabrani teniser vec ucestvuje na turniru!");
            fRangLista.setVisible(true);
        } else {
            model.dodajUcesnika(teniserEntity);
        }

    }//GEN-LAST:event_jButtonDodajUcesnikaActionPerformed

    private void jButtonGenerisiMeceveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerisiMeceveActionPerformed

    }//GEN-LAST:event_jButtonGenerisiMeceveActionPerformed

    private void jButtonObrisiUcesnikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonObrisiUcesnikaActionPerformed
        int odabraniRed = jTableUcesnici.getSelectedRow();
        if (odabraniRed != -1) {
            UcesceNaTurniruModel model = (UcesceNaTurniruModel) jTableUcesnici.getModel();
            model.obrisiUcesnika(odabraniRed);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Niste odarbali ucesnika za brisanje!");
        }

    }//GEN-LAST:event_jButtonObrisiUcesnikaActionPerformed

    private void jButtonSacuvajPromeneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSacuvajPromeneActionPerformed
         UcesceNaTurniruModel model = (UcesceNaTurniruModel) jTableUcesnici.getModel();
        try {
            Controller.zapamtiUcescaNaTurniru(model.getTeniseriKojiUcestvuju());
        } catch (IOException ex) {
            Logger.getLogger(FTurnir.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FTurnir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonSacuvajPromeneActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDodajUcesnika;
    private javax.swing.JButton jButtonGenerisiMeceve;
    private javax.swing.JButton jButtonKreiraj;
    private javax.swing.JButton jButtonObrisiUcesnika;
    private javax.swing.JButton jButtonSacuvajPromene;
    private javax.swing.JComboBox<rs.ac.bg.fon.silab.jdbc.example1.domen.KategorijaTurniraEntity> jComboBoxKategorijaTurnira;
    private javax.swing.JComboBox<String> jComboBoxPodloga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUcesnici;
    private javax.swing.JTextField jTextFieldGrad;
    private javax.swing.JTextField jTextFieldNaziv;
    // End of variables declaration//GEN-END:variables

    private void populateComboBoxKategorije() {
        try {
            jComboBoxKategorijaTurnira.removeAllItems();
            // jComboBoxKategorijaTurnira.addI
            List<KategorijaTurniraEntity> kategorije = Controller.dajKategorijeTurnira();
            for (KategorijaTurniraEntity kategorija : kategorije) {
                jComboBoxKategorijaTurnira.addItem(kategorija);
            }
        } catch (Exception ex) {
            Logger.getLogger(FTurnir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void centrirajForm() {
        setLocationRelativeTo(null);
    }

    private void urediFormu(int model) {
        switch (model) {
            case Constants.NOV_TURNIR:
                jButtonGenerisiMeceve.setVisible(false);
                populateComboBoxKategorije();
                break;
            case Constants.TURNIR_SA_NEPOPUNJENIM_MESTIMA:
                postaviVrednostiPoljima();
                setSize(410, 600);
                setLocationRelativeTo(null);
                jButtonKreiraj.setVisible(false);
                jButtonGenerisiMeceve.setVisible(false);
                AbstractTableModel tableModel = new UcesceNaTurniruModel(turnir);
                jTableUcesnici.setModel(tableModel);
                break;
            case Constants.TURNIR_SA_POPUNJENIM_MESTIMA:
                postaviVrednostiPoljima();
                setSize(410, 600);
                setLocationRelativeTo(null);
                jButtonGenerisiMeceve.setVisible(true);
                break;
            default:
                break;

        }
    }

    private void postaviVrednostiPoljima() {
        jTextFieldNaziv.setText(turnir.getNazivTurnira());
        jTextFieldNaziv.setEnabled(false);

        jTextFieldGrad.setText(turnir.getGrad());
        jTextFieldGrad.setEnabled(false);

        jComboBoxPodloga.setSelectedItem(turnir.getPodloga());
        jComboBoxPodloga.setEnabled(false);

        
        jComboBoxKategorijaTurnira.addItem(turnir.getKategorijaTurnira());
        jComboBoxKategorijaTurnira.setSelectedItem(turnir.getKategorijaTurnira());
        jComboBoxKategorijaTurnira.setEnabled(false);
    }
}