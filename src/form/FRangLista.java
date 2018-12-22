/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import constants.Constants;
import java.util.List;
import javax.swing.RowFilter;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import domen.Teniser;
import controller.Controller;
import javax.swing.JOptionPane;
import session.Session;
import tablemodel.TeniserTableModel;

/**
 *
 * @author lukabaljak
 */
public class FRangLista extends javax.swing.JDialog {

    /**
     * Creates new form FRangLista
     */
    
    FMain parent;
    public FRangLista(java.awt.Frame parent, boolean modal, int mod) {
        super(parent, modal);
        initComponents();
        centrirajFormu();
        prikazDugmetaOdaberi(mod);

        this.parent = (FMain) parent;
        populateTableRangLisista();
        //namestiTabelu();

        jTableRangLista.getColumnModel().getColumn(0).setMaxWidth(50);;
        jTableRangLista.getColumnModel().getColumn(2).setPreferredWidth(90);
        jTableRangLista.getColumnModel().getColumn(3).setMaxWidth(90);
        //ova mora biti poslednja u redosledu izvrsenja
        pripremiTabeluZaSortiranje();
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
        jTableRangLista = new javax.swing.JTable();
        jButtonOdaberi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldPretraziTenisere = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Rang lista tenisera");

        jTableRangLista.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableRangLista);

        jButtonOdaberi.setText("Odaberi");
        jButtonOdaberi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOdaberiActionPerformed(evt);
            }
        });

        jLabel1.setText("Pretrazite tenisere:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonOdaberi)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPretraziTenisere))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE))
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldPretraziTenisere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonOdaberi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOdaberiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOdaberiActionPerformed
        TeniserTableModel model = (TeniserTableModel) jTableRangLista.getModel();
        int rangOdabranogTenisera = jTableRangLista.getSelectedRow();
        Teniser teniserEntity = model.getTeniseri().get(rangOdabranogTenisera);

        //JOptionPane.showMessageDialog(rootPane, teniserEntity.toString());
        Session.getInstance().getMap().put(Constants.ODABRANI_TENISER, teniserEntity);
        //Session.getInstance().getMap().put(Constants.RANK, rangOdabranogTenisera);
        dispose();
    }//GEN-LAST:event_jButtonOdaberiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonOdaberi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableRangLista;
    private javax.swing.JTextField jTextFieldPretraziTenisere;
    // End of variables declaration//GEN-END:variables

    private void populateTableRangLisista() {
        try {
            List<Teniser> rangLista = Controller.dajRangListu();
            TableModel model = new TeniserTableModel(rangLista);
            jTableRangLista.setModel(model);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Doslo je do greske prilikom povezivanja na server. Molimo da probate opet kasnije.");
            dispose();
           
            parent.dispose();
        }
    }

    private void centrirajFormu() {
        setLocationRelativeTo(null);
    }

    private void namestiTabelu() {
        jTableRangLista.getColumnModel().getColumn(0).setMinWidth(40);
        jTableRangLista.getColumnModel().getColumn(0).setMaxWidth(50);
    }

    private void prikazDugmetaOdaberi(int mod) {
        if (mod == Constants.PREGLED_RANG_LISTE) {
            jButtonOdaberi.setVisible(false);
        }
    }

    private void pripremiTabeluZaSortiranje() {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(jTableRangLista.getModel());
        jTableRangLista.setRowSorter(rowSorter);

        jTextFieldPretraziTenisere.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                String filterCity = jTextFieldPretraziTenisere.getText();

                if (filterCity.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + filterCity));
                }
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                String text = jTextFieldPretraziTenisere.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
}