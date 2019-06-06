package sat;

import java.time.LocalTime;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lukabaljak
 */
public class Sat extends Thread {

    JLabel jLabelSat;
    LocalTime pocetak;

    public Sat(JLabel jLabelSat) {
        this.jLabelSat = jLabelSat;
        this.pocetak = LocalTime.now();
        
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            LocalTime sad = LocalTime.now();
            Long nanosekundePocetak = pocetak.toNanoOfDay();
            Long nanosekundeSad = sad.toNanoOfDay();
            LocalTime razlika = LocalTime.ofNanoOfDay(nanosekundeSad - nanosekundePocetak);
            jLabelSat.setText("<html>Vreme rada servera: <br/>"+razlika.getHour()+
                    ":"+razlika.getMinute()+":"+razlika.getSecond()+"</html>");
            
        }
    }

}
