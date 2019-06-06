/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.silab.jdbc.example1.domen.TeniserEntity;
import rs.ac.bg.fon.silab.jdbc.example1.domen.TurnirEntity;
import rs.ac.bg.fon.silab.jdbc.example1.domen.UcesceNaTurniruEntity;

/**
 *
 * @author lukabaljak
 */
public class UcesceNaTurniruModel extends AbstractTableModel {

    TurnirEntity turnirEntity;
    List<TeniserEntity> teniseriKojiUcestvuju;
    private String[] naziviKolona = new String[]{"R.B.", "Ime i prezime"};

    public UcesceNaTurniruModel(TurnirEntity turnirEntity) {
        this.turnirEntity = turnirEntity;
        teniseriKojiUcestvuju = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return (teniseriKojiUcestvuju == null) ? 0 : teniseriKojiUcestvuju.size();
    }

    @Override
    public int getColumnCount() {
        return naziviKolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TeniserEntity teniserEntity = teniseriKojiUcestvuju.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return teniserEntity.getImePrezime();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return naziviKolona[column];
    }

    public List<TeniserEntity> getTeniseriKojiUcestvuju() {
        return teniseriKojiUcestvuju;
    }

    public void dodajUcesnika(TeniserEntity teniserEntity) {
        teniseriKojiUcestvuju.add(teniserEntity);
        teniseriKojiUcestvuju.sort(new Comparator<TeniserEntity>() {
            @Override
            public int compare(TeniserEntity o1, TeniserEntity o2) {
                if (o1.getBrojPoena() > o2.getBrojPoena()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        fireTableDataChanged();
    }

    public void obrisiUcesnika(int odabraniRed) {
        teniseriKojiUcestvuju.remove(odabraniRed);
        fireTableDataChanged();
    }
    
    public UcesceNaTurniruEntity getUcesceNaTurniru(){
        return new UcesceNaTurniruEntity(turnirEntity, teniseriKojiUcestvuju);
    }
}
