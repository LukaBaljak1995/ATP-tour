/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import domen.Teniser;

/**
 *
 * @author lukabaljak
 */
public class TeniserTableModel extends AbstractTableModel {

    private final List<Teniser> teniseri;
    private String[] columnNames = new String[]{"Rank", "Ime i prezime", "Datum rođenja", "Broj poena"};

    public TeniserTableModel(List<Teniser> teniseri) {
        this.teniseri = teniseri;
    }

    @Override
    public int getRowCount() {
        return (teniseri == null) ? 0 : teniseri.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Teniser teniser = teniseri.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowIndex + 1 + ".";
            case 1:
                return teniser.getImePrezime();
            case 2:
                return teniser.getDatumRodjenja().getDayOfMonth() + "." + teniser.getDatumRodjenja().getMonthValue()
                        + "." + teniser.getDatumRodjenja().getYear();
            case 3:
                return teniser.getBrojPoena();
            default:
                return "N/A";
        }

    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public List<Teniser> getTeniseri() {
        return teniseri;
    }

}
