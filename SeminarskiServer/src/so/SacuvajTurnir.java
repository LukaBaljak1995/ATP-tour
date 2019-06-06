/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import rs.ac.bg.fon.silab.jdbc.example1.domen.IDomainEntity;
import rs.ac.bg.fon.silab.jdbc.example1.domen.TurnirEntity;

/**
 *
 * @author lukabaljak
 */
public class SacuvajTurnir extends GenerickaOperacija{

    @Override
    protected void validate(IDomainEntity ide) throws Exception {
        if (ide instanceof TurnirEntity) {

        } else {
            throw new Exception("Nije prosledjen odgovarajuci parametar!");
        }
    }

    @Override
    protected void execute(IDomainEntity ide) throws Exception {
        db.sacuvaj(ide);
    }
    
}
