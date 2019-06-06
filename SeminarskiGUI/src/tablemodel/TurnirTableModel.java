/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.silab.jdbc.example1.domen.TurnirEntity;

/**
 *
 * @author lukabaljak
 */
public class TurnirTableModel extends AbstractTableModel {

    private final List<TurnirEntity> turniri;
    String[] naziviKolona = new String[]{"Redni broj", "Naziv", "Kategorija", "Podloga", "Grad"};

    public TurnirTableModel(List<TurnirEntity> turniri) {
        this.turniri = turniri;
    }

    @Override
    public int getRowCount() {
        return turniri.size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TurnirEntity turnir = turniri.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return turnir.getNazivTurnira();
            case 2:
                return turnir.getKategorijaTurnira().getNazivKategorijeTurnira();
            case 3:
                return turnir.getPodloga();
            case 4:
                return turnir.getGrad();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column]; //To change body of generated methods, choose Tools | Templates.
    }

    public List<TurnirEntity> getTurniri() {
        return turniri;
    }
    
    

}
