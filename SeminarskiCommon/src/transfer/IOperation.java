/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

/**
 *
 * @author lukabaljak
 */
public interface IOperation {

    //SK1: Kreiranje tenisera
    public static final int KREIRANJE_TENISERA = 1;
    //SK2: Kreiranje turnira
    public static final int DAJ_KATEGORIJE_TURNIRA = 2;
    public static final int KREIRANJE_TURNIRA = 3;
    //SK5: Kreiranje ucesca na turniru
    public static final int KREIRANJE_UCESCA_NA_TURNIRU=4;
    //SK6: Prikaz rang liste tenisera
    public static final int PRIKAZ_RANG_LISTE = 6;

}
