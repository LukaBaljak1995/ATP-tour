
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.Month;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lukabaljak
 */
public class Test {
   
    //System.out.println();
    
    public static void main(String[] args) throws NoSuchAlgorithmException{
        String s="sifra";

         MessageDigest m=MessageDigest.getInstance("MD5");

       m.update(s.getBytes(),0,s.length());

        System.out.println("MD5: "+new BigInteger(1,m.digest()).toString(16));
    }
            
            
}
