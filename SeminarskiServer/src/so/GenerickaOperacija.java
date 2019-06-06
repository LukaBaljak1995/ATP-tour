package so;

import rs.ac.bg.fon.silab.jdbc.example1.db.DatabaseRepository;
import rs.ac.bg.fon.silab.jdbc.example1.domen.IDomainEntity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lukabaljak
 */
public  abstract class GenerickaOperacija {
    
     protected DatabaseRepository db;

    public GenerickaOperacija() {
        this.db = new DatabaseRepository();
    }
     
    public void templateExecute(IDomainEntity ide) throws Exception {
        try {
            validate(ide);
            try {
                //validate(ide);
                startTransaction();
                execute(ide);
                commitTransaction();
            } catch (Exception e) {
                rollbackTransaction();//rollback se radi samo ako je transakcija otvorena
                throw new Exception("Error: " + e.getMessage());
            }
        } catch (Exception e) {
            throw e;
        }

    }

    protected abstract void validate(IDomainEntity ide) throws Exception;

    private void startTransaction() throws Exception {
        db.startTransaction();
    }

    protected abstract void execute(IDomainEntity ide) throws Exception;

    private void commitTransaction() throws Exception {
        db.commitTransaction();
    }

    private void rollbackTransaction() throws Exception {
        db.rollbackTransaction();
    }
    
}
