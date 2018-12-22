/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import domen.Teniser;

/**
 *
 * @author lukabaljak
 */
public class TeniserRank {
    
    int rank;
    Teniser teniser;

    public TeniserRank(int rank, Teniser teniser) {
        this.rank = rank;
        this.teniser = teniser;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Teniser getTeniser() {
        return teniser;
    }

    public void setTeniser(Teniser teniser) {
        this.teniser = teniser;
    }
    
    
    
}
