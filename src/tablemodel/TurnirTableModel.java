/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import domen.Turnir;

/**
 *
 * @author lukabaljak
 */
public class TurnirTableModel extends AbstractTableModel {

    private final List<Turnir> turniri;
    String[] naziviKolona = new String[]{"R.B.", "Naziv", "Kategorija", "Podloga", "Grad", "Pocinje", "Zavrsava"};

    public TurnirTableModel(List<Turnir> turniri) {
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
        Turnir turnir = turniri.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowIndex + 1 + ".";
            case 1:
                return turnir.getNazivTurnira();
            case 2:
                return turnir.getKategorijaTurnira().getNazivKategorijeTurnira();
            case 3:
                return turnir.getPodloga();
            case 4:
                return turnir.getGrad();
            case 5:
                return turnir.getDatumPocetka().getDayOfMonth() + "."
                        + turnir.getDatumPocetka().getMonthValue()+ "."
                        + turnir.getDatumPocetka().getYear();
            case 6:
                return turnir.getDatumZavrsetka().getDayOfMonth() + "."
                        + turnir.getDatumZavrsetka().getMonthValue()+ "." 
                        + turnir.getDatumZavrsetka().getYear();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column]; //To change body of generated methods, choose Tools | Templates.
    }

    public List<Turnir> getTurniri() {
        return turniri;
    }

}
