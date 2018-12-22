/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import java.util.Comparator;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import domen.Teniser;
import domen.Turnir;
import java.util.ArrayList;

/**
 *
 * @author lukabaljak
 */
public class UcesceNaTurniruModel extends AbstractTableModel {

    Turnir turnirEntity;
   
    private String[] naziviKolona = new String[]{"R.B.", "Ime i prezime"};

    public UcesceNaTurniruModel(Turnir turnirEntity) {
        this.turnirEntity = turnirEntity;
        
    }

    @Override
    public int getRowCount() {
        return (turnirEntity.getUcesniciNaTurniru() == null) ? 0 : turnirEntity.getUcesniciNaTurniru().size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Teniser teniser = this.turnirEntity.getUcesniciNaTurniru().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowIndex+1 +".";
            case 1:
                return teniser.getImePrezime();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column];
    }

    public List<Teniser> getTeniseriKojiUcestvuju() {
        return turnirEntity.getUcesniciNaTurniru();
    }

    public void dodajUcesnika(Teniser teniser) {
       
        turnirEntity.getUcesniciNaTurniru().add(teniser);
        turnirEntity.getUcesniciNaTurniru().sort(new Comparator<Teniser>() {
            @Override
            public int compare(Teniser o1, Teniser o2) {
                if (o1.getBrojPoena() > o2.getBrojPoena()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

       

        fireTableDataChanged();
    }

    public void obrisiUcesnika(int odabraniRed) {
        turnirEntity.getUcesniciNaTurniru().remove(odabraniRed);
        
        fireTableDataChanged();
    }

}
