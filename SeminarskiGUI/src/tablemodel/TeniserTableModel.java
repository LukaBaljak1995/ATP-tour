/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.silab.jdbc.example1.domen.TeniserEntity;

/**
 *
 * @author lukabaljak
 */
public class TeniserTableModel extends AbstractTableModel {

    private final List<TeniserEntity> teniseri; 
    private String [] columnNames = new String[]{"Rank","Ime i prezime","Datum rođenja","Broj poena"};
    
    public TeniserTableModel(List<TeniserEntity> teniseri) {
        this.teniseri = teniseri;
    }
    
    @Override
    public int getRowCount() {
        return (teniseri==null)? 0:teniseri.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TeniserEntity teniser = teniseri.get(rowIndex);
        switch(columnIndex){
            case 0:
                return rowIndex+1;
            case 1:
                return teniser.getImePrezime();
            case 2:
                return teniser.getDatumRodjenja().toString();
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

    public List<TeniserEntity> getTeniseri() {
        return teniseri;
    }
    
}
