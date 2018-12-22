package generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import domen.FazaTurnira;
import domen.Mec;
import domen.Teniser;
import domen.Turnir;
import controller.Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lukabaljak
 */
public class GeneratorMeceva {

    Turnir turnir;
    List<Teniser> teniseriKojiUcestvuju;
    List<FazaTurnira> fazeTurnira;
    int maksimalanBrojIgraca;
    List<Mec> mecevi;

    public GeneratorMeceva(Turnir turnir, List<Teniser> teniseriKojiUcestvuju, int maksimalanBrojIgraca) throws Exception {
        this.turnir = turnir;
        this.teniseriKojiUcestvuju = teniseriKojiUcestvuju;
        this.maksimalanBrojIgraca = maksimalanBrojIgraca;
        this.mecevi = new ArrayList<>();
        ucitajFazeTurnira();
    }

    public List<Mec> getMecevi() {
        return mecevi;
    }

    public void generisiMeceve() {
        List<Teniser> pobedniciSesnaestineFinala;
        List<Teniser> pobedniciOsmineFinala;
        List<Teniser> pobedniciCetvrtFinala;
        List<Teniser> pobedniciPolufinala;
        switch (maksimalanBrojIgraca) {
            case 32:
                pobedniciSesnaestineFinala = urediSesnaestinuFinala(this.teniseriKojiUcestvuju);
                pobedniciOsmineFinala = urediOsminuFinala(pobedniciSesnaestineFinala);
                pobedniciCetvrtFinala = urediCetvrtFinale(pobedniciOsmineFinala);
                pobedniciPolufinala = urediPolufinale(pobedniciCetvrtFinala);
                urediFinale(pobedniciPolufinala);
                break;
            case 16:
                pobedniciOsmineFinala = urediOsminuFinala(this.teniseriKojiUcestvuju);
                pobedniciCetvrtFinala = urediCetvrtFinale(pobedniciOsmineFinala);
                pobedniciPolufinala = urediPolufinale(pobedniciCetvrtFinala);
                urediFinale(pobedniciPolufinala);
                break;
            case 8:
                pobedniciCetvrtFinala = urediCetvrtFinale(this.teniseriKojiUcestvuju);
                pobedniciPolufinala = urediPolufinale(pobedniciCetvrtFinala);
                urediFinale(pobedniciPolufinala);
                break;
            case 4:
                pobedniciPolufinala = urediPolufinale(this.teniseriKojiUcestvuju);
                urediFinale(pobedniciPolufinala);
                break;
        }
    }

    private List<Teniser> urediSesnaestinuFinala(List<Teniser> teniseriKojiUcestvuju) {
        List<Teniser> pobednici = new ArrayList<>();
        List<Teniser> preostaliIgraci = teniseriKojiUcestvuju;
        while (!preostaliIgraci.isEmpty()) {
            int randomBrojPobednika = (int) (Math.random() * preostaliIgraci.size());
            int randomBrojGubitnika = randomBrojPobednika;
            while (randomBrojGubitnika == randomBrojPobednika) {
                System.out.println(randomBrojGubitnika);
                randomBrojGubitnika = (int) (Math.random() * preostaliIgraci.size());
            }

            Mec mec = new Mec(this.turnir, preostaliIgraci.get(randomBrojPobednika),
                    preostaliIgraci.get(randomBrojGubitnika),
                    fazeTurnira.get(1), generisiRandomRezultat());
            this.mecevi.add(mec);

            Teniser pobednik = preostaliIgraci.get(randomBrojPobednika);
            Teniser gubitnik = preostaliIgraci.get(randomBrojGubitnika);

            pobednici.add(pobednik);
            preostaliIgraci.remove(pobednik);
            preostaliIgraci.remove(gubitnik);

        }

        return pobednici;
    }

    private List<Teniser> urediOsminuFinala(List<Teniser> teniseriKojiUcestvuju) {

        List<Teniser> pobednici = new ArrayList<>();
        List<Teniser> preostaliIgraci = teniseriKojiUcestvuju;
        while (!preostaliIgraci.isEmpty()) {
            int randomBrojPobednika = (int) (Math.random() * preostaliIgraci.size());
            int randomBrojGubitnika = randomBrojPobednika;
            while (randomBrojGubitnika == randomBrojPobednika) {
                randomBrojGubitnika = (int) (Math.random() * preostaliIgraci.size());
            }

            Mec mec = new Mec(this.turnir, preostaliIgraci.get(randomBrojPobednika),
                    preostaliIgraci.get(randomBrojGubitnika),
                    fazeTurnira.get(1), generisiRandomRezultat());
            System.out.println(mec);
            this.mecevi.add(mec);

            Teniser pobednik = preostaliIgraci.get(randomBrojPobednika);
            Teniser gubitnik = preostaliIgraci.get(randomBrojGubitnika);

            pobednici.add(pobednik);
            preostaliIgraci.remove(pobednik);
            preostaliIgraci.remove(gubitnik);

        }

        return pobednici;
    }

    private List<Teniser> urediCetvrtFinale(List<Teniser> pobedniciOsmineFinala) {
        List<Teniser> pobednici = new ArrayList<>();
        // List<Teniser> preostaliIgraci = teniseriKojiUcestvuju.subList(0, pobedniciOsmineFinala.size());
        List<Teniser> preostaliIgraci = pobedniciOsmineFinala;
        System.out.println("PREOSTALI IGRACI SIZE: " + preostaliIgraci.size());
        while (!preostaliIgraci.isEmpty()) {
            int randomBrojPobednika = (int) (Math.random() * preostaliIgraci.size());
            int randomBrojGubitnika = randomBrojPobednika;
            while (randomBrojGubitnika == randomBrojPobednika) {
                randomBrojGubitnika = (int) (Math.random() * preostaliIgraci.size());
            }

            Mec mec = new Mec(this.turnir, preostaliIgraci.get(randomBrojPobednika),
                    preostaliIgraci.get(randomBrojGubitnika),
                    fazeTurnira.get(2), generisiRandomRezultat());
            this.mecevi.add(mec);
            System.out.println(mec);

            Teniser pobednik = preostaliIgraci.get(randomBrojPobednika);
            Teniser gubitnik = preostaliIgraci.get(randomBrojGubitnika);

            pobednici.add(pobednik);
            preostaliIgraci.remove(pobednik);
            preostaliIgraci.remove(gubitnik);

        }
        System.out.println("POBEDNICI SIZE: " + pobednici.size());
        System.out.println("____________________");
        return pobednici;
    }

    private List<Teniser> urediPolufinale(List<Teniser> pobdniciCetvrtFinala) {
        List<Teniser> pobednici = new ArrayList<>();
       // List<Teniser> preostaliIgraci = teniseriKojiUcestvuju.subList(0, pobdniciCetvrtFinala.size());
        List<Teniser> preostaliIgraci = pobdniciCetvrtFinala;
        while (!preostaliIgraci.isEmpty()) {
            int randomBrojPobednika = (int) (Math.random() * preostaliIgraci.size());
            int randomBrojGubitnika = randomBrojPobednika;
            while (randomBrojGubitnika == randomBrojPobednika) {
                randomBrojGubitnika = (int) (Math.random() * preostaliIgraci.size());
            }

            Mec mec = new Mec(this.turnir, preostaliIgraci.get(randomBrojPobednika),
                    preostaliIgraci.get(randomBrojGubitnika),
                    fazeTurnira.get(3), generisiRandomRezultat());
            this.mecevi.add(mec);
            System.out.println(mec);

            Teniser pobednik = preostaliIgraci.get(randomBrojPobednika);
            Teniser gubitnik = preostaliIgraci.get(randomBrojGubitnika);

            pobednici.add(pobednik);
            preostaliIgraci.remove(pobednik);
            preostaliIgraci.remove(gubitnik);

        }
        System.out.println("____________________");
        return pobednici;
    }

    private void urediFinale(List<Teniser> pobedniciPolufinala) {
        int randomBrojPobednika = (int) (Math.random() * 2);
        int randomBrojGubitnika;
        if (randomBrojPobednika == 0) {
            randomBrojGubitnika = 1;
        } else {
            randomBrojGubitnika = 0;
        }
        Mec mec = new Mec(this.turnir, pobedniciPolufinala.get(randomBrojPobednika),
                pobedniciPolufinala.get(randomBrojGubitnika),
                fazeTurnira.get(4), generisiRandomRezultat());
        this.mecevi.add(mec);

    }

    private void ucitajFazeTurnira() throws Exception {
        this.fazeTurnira = Controller.dajFazeTurnira();

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
