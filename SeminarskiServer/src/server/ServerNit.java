/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import rs.ac.bg.fon.silab.jdbc.example1.db.DatabaseRepository;
import rs.ac.bg.fon.silab.jdbc.example1.domen.KategorijaTurniraEntity;
import rs.ac.bg.fon.silab.jdbc.example1.domen.TeniserEntity;
import rs.ac.bg.fon.silab.jdbc.example1.domen.TurnirEntity;
import so.GenerickaOperacija;
import so.SacuvajTenisera;
import so.SacuvajTurnir;
import status.IStatus;
import transfer.IOperation;
import transfer.RequestObject;
import transfer.ResponseObject;

/**
 *
 * @author lukabaljak
 */
public class ServerNit extends Thread {

    Socket socket;
    ObjectInputStream in;
    ObjectOutputStream out;
    JTextArea loginHistory;

    public ServerNit(Socket socket) throws IOException, ClassNotFoundException {
        this.socket = socket;
        DataInputStream inIme = new DataInputStream(socket.getInputStream());
        String ime = inIme.readUTF();
        setName(ime);
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {

        while (!isInterrupted()) {
            try {
                this.in = new ObjectInputStream(socket.getInputStream());
                this.out = new ObjectOutputStream(socket.getOutputStream());

                RequestObject request = (RequestObject) in.readObject();
                ResponseObject response = new ResponseObject();
                switch (request.getOperation()) {
                    //SK: Kreiranje tenisera
                    case IOperation.KREIRANJE_TENISERA:
                        TeniserEntity teniser = (TeniserEntity) request.getData();
                        //response = kreiranjeTenisera(teniser);
                        GenerickaOperacija operacija = new SacuvajTenisera();
                        operacija.templateExecute(teniser);

                        response.setCode(IStatus.OK);
                        response.setData(teniser);
                        out.writeObject(response);
                        break;
                    //SK: Kreiranje turnira
                    case IOperation.DAJ_KATEGORIJE_TURNIRA:
                        response = dajKategorijeTurnira();

                        out.writeObject(response);
                        break;
                    case IOperation.KREIRANJE_TURNIRA:
                        TurnirEntity turnir = (TurnirEntity) request.getData();
                        response = zapamtiTurnir(turnir);
                        out.writeObject(response);
                    //SK: Kreiranje ucesca na turniru
                    case IOperation.KREIRANJE_UCESCA_NA_TURNIRU:
                        response = kreiranjeUcescaNaTurniru();
                        out.writeObject(response);
                        break;

                    //SK6: Prikaz rang liste tenisera
                    case IOperation.PRIKAZ_RANG_LISTE:
                        response = dajRangListu();

                        out.writeObject(response);
                        break;
                    default:
                        break;

                }

            } catch (EOFException eof) {
                try {
                    socket.close();
                    Server.upisiNoviLogout(getName());
                    interrupt();
                } catch (IOException ex) {
                    Logger.getLogger(ServerNit.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    private ResponseObject dajRangListu() throws Exception {

        ResponseObject response = new ResponseObject();
        DatabaseRepository dbr = new DatabaseRepository();
        List<TeniserEntity> teniseri = dbr.dajRangListuTenisera();

        response.setCode(IStatus.OK);
        response.setData(teniseri);
        response.setMessage("Sistem je vratio listu tenisera!");
        return response;
    }

    private ResponseObject kreiranjeTenisera(TeniserEntity teniser) throws Exception {
        ResponseObject response = new ResponseObject();
        DatabaseRepository dbr = new DatabaseRepository();

        dbr.zapamtiTenisera(teniser);
        response.setCode(IStatus.OK);
        response.setMessage("Sistem je uspesno kreirao tenisera!");
        return response;
    }

    private ResponseObject dajKategorijeTurnira() throws Exception {
        ResponseObject response = new ResponseObject();
        DatabaseRepository dbr = new DatabaseRepository();

        List<KategorijaTurniraEntity> kategorijeTurnira = dbr.dajKategorijeTurnira();
        response.setCode(IStatus.OK);
        response.setData(kategorijeTurnira);
        response.setMessage("Sistem je uspesno vratio kategorije turnira!");
        return response;
    }

    private ResponseObject zapamtiTurnir(TurnirEntity turnir) throws Exception {
        ResponseObject response = new ResponseObject();
        GenerickaOperacija operacija = new SacuvajTurnir();
        operacija.templateExecute(turnir);

        response.setCode(IStatus.OK);
        response.setData(turnir);
        response.setMessage("Sistem je uspesno sacuvao tenisera!");
        
        return response;
    }

    private ResponseObject kreiranjeUcescaNaTurniru() {
        ResponseObject response = new ResponseObject();
        DatabaseRepository dbr = new DatabaseRepository();

        response.setCode(IStatus.OK);
        response.setMessage("Sistem je uspesno kreirao turnir!");
        return response;
    }

}
