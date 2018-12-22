/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import domen.Mec;

/**
 *
 * @author lukabaljak
 */
public class MecTableModel extends AbstractTableModel {

    List<Mec> mecevi;
    private String[] naziviKolona = new String[]{"Faza turnira", "Pobednik", "Gubitnik", "Rezultat"};

    public MecTableModel() {
        mecevi = new ArrayList<>();
    }

    public MecTableModel(List<Mec> mecevi) {
        this.mecevi = mecevi;
    }

    @Override
    public int getRowCount() {
        return mecevi.size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Mec mec = mecevi.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return mec.getFazaTurnira().getNazivFazeTurnira();
            case 1:
                return mec.getPobednik().getImePrezime().split(" ")[0].charAt(0) + ". "
                        + mec.getPobednik().getImePrezime().split(" ")[1];
            case 2:
                return mec.getGubitnik().getImePrezime().split(" ")[0].charAt(0) + ". "
                        + mec.getGubitnik().getImePrezime().split(" ")[1];
            case 3:
                return mec.getRezultat();
            default:
                return "N/A";
        }

    }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column];
    }

    public void dodajMeceve(List<Mec> meceviZaDodavanje) {
        this.mecevi.addAll(meceviZaDodavanje);
        fireTableDataChanged();
    }

    public List<Mec> getMecevi() {
        return mecevi;
    }

    public void setMecevi(List<Mec> mecevi) {
        this.mecevi = mecevi;
        fireTableDataChanged();
    }

}
