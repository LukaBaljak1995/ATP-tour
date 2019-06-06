/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import rs.ac.bg.fon.silab.jdbc.example1.domen.IDomainEntity;
import rs.ac.bg.fon.silab.jdbc.example1.domen.TeniserEntity;

/**
 *
 * @author lukabaljak
 */
public class SacuvajTenisera extends GenerickaOperacija {

    public SacuvajTenisera() {
        super();
    }
    
    @Override
    protected void validate(IDomainEntity ide) throws Exception {
        if (ide instanceof TeniserEntity) {

        } else {
            throw new Exception("Nije prosledjen odgovarajuci parametar!");
        }
    }

    @Override
    protected void execute(IDomainEntity ide) throws Exception {
        db.sacuvaj(ide);
    }

}
