
import domen.KategorijaTurnira;
import domen.Mec;
import domen.Teniser;
import domen.Turnir;
import generator.GeneratorMeceva;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author lukabaljak
 */
public class Test {

    //System.out.println();
    public static void main(String[] args) throws NoSuchAlgorithmException, Exception {
        Teniser teniser1 = new Teniser(1, "Luka Baljak", LocalDate.MIN, 0);
        Teniser teniser2 = new Teniser(2, "Mladen Baljak", LocalDate.MIN, 0);
        Teniser teniser3 = new Teniser(3, "Aleksandar Baljak", LocalDate.MIN, 0);
        Teniser teniser4 = new Teniser(4, "Djordje Djukic", LocalDate.MIN, 0);
        Teniser teniser5 = new Teniser(5, "Novak Djokovic", LocalDate.MIN, 0);
        Teniser teniser6 = new Teniser(6, "Aleksa Mandic", LocalDate.MIN, 0);
        Teniser teniser7 = new Teniser(7, "Neko Nekic", LocalDate.MIN, 0);
        Teniser teniser8 = new Teniser(8, "Marko Markic", LocalDate.MIN, 0);

        KategorijaTurnira kte = new KategorijaTurnira(2, "sadsa", 8, 500);
        Turnir turnir = new Turnir("sada", "dasda", "dasdsa", kte);

        List<Teniser> teniseri = new ArrayList<>();
        teniseri.add(teniser1);
        teniseri.add(teniser2);
        teniseri.add(teniser3);
        teniseri.add(teniser4);
        teniseri.add(teniser5);
        teniseri.add(teniser6);
        teniseri.add(teniser7);
        teniseri.add(teniser8);

//        GeneratorMeceva gm = new GeneratorMeceva(turnir, teniseri, 8);
//        gm.generisiMeceve();
//        
//        for (Mec mec:gm.getMecevi()) {
//            System.out.println(mec);
//        }
//        List<Teniser> nova = teniseri.subList(0,8);
//        System.out.println(nova.size());

       String skraceno = teniser1.getImePrezime().split(" ")[0].charAt(0) +". " + teniser1.getImePrezime().split(" ")[1];
        System.out.println(skraceno);
    }

    private String generisiRandomRezultat() {
        int tipMeca = (int) (Math.random() * 3);
        switch (tipMeca) {
            case 0:
                return generisiDDrezultat();
            case 1:
                return generisiDIDrezultat();
            case 2:
                return generisiIDDrezultat();
            default:
                return "";
        }
    }

    private String generisiDDrezultat() {
        return generisiDobijenSet() + " " + generisiDobijenSet();
    }

    private String generisiDIDrezultat() {
        return generisiDobijenSet() + " " + generisiIzgubljenSet() + " " + generisiDobijenSet();
    }

    private String generisiIDDrezultat() {
        return generisiIzgubljenSet() + " " + generisiDobijenSet() + " " + generisiDobijenSet();
    }

    private String generisiDobijenSet() {
        Random random = new Random();
        int randomPobednik = random.nextInt(2) + 6;
        int randomGubitnik;
        if (randomPobednik == 6) {
            randomGubitnik = random.nextInt(5);
        } else {
            randomGubitnik = random.nextInt(2) + 5;
        }
        return randomPobednik + ":" + randomGubitnik;
    }

    private String generisiIzgubljenSet() {
        Random random = new Random();
        int randomPobednik = random.nextInt(2) + 6;
        int randomGubitnik;
        if (randomPobednik == 6) {
            randomGubitnik = random.nextInt(5);
        } else {
            randomGubitnik = random.nextInt(2) + 5;
        }
        return randomGubitnik + ":" + randomPobednik;
    }

}
