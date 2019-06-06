/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seminarskigui.controller;

import constants.Constants;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import rs.ac.bg.fon.silab.jdbc.example1.db.DatabaseRepository;
import rs.ac.bg.fon.silab.jdbc.example1.domen.KategorijaTurniraEntity;
import rs.ac.bg.fon.silab.jdbc.example1.domen.TeniserEntity;
import rs.ac.bg.fon.silab.jdbc.example1.domen.TurnirEntity;
import session.Session;
import transfer.IOperation;
import transfer.RequestObject;
import transfer.ResponseObject;

/**
 *
 * @author lukabaljak
 */
public class Controller {

    public static List<KategorijaTurniraEntity> dajKategorijeTurnira() throws Exception {
        Socket socket = (Socket) Session.getInstance().getMap().get(Constants.SOCKET);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        RequestObject request = new RequestObject(IOperation.DAJ_KATEGORIJE_TURNIRA, null);
        out.writeObject(request);
        out.flush();

        ResponseObject response = (ResponseObject) in.readObject();
        return (List<KategorijaTurniraEntity>) response.getData();
    }

    public static void zapamtiTenisera(TeniserEntity teniser) throws Exception {
        Socket socket = (Socket) Session.getInstance().getMap().get(Constants.SOCKET);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        RequestObject request = new RequestObject(IOperation.KREIRANJE_TENISERA, teniser);
        out.writeObject(request);
        out.flush();

        ResponseObject response = (ResponseObject) in.readObject();
    }

    public static void zapamtiTurnir(TurnirEntity turnir) throws Exception {
       Socket socket = (Socket) Session.getInstance().getMap().get(Constants.SOCKET);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        RequestObject request = new RequestObject(IOperation.KREIRANJE_TURNIRA, turnir);
        out.writeObject(request);
        out.flush();

        ResponseObject response = (ResponseObject) in.readObject();
    }

    public static List<TeniserEntity> dajRangListu() throws Exception {

        Socket socket = (Socket) Session.getInstance().getMap().get(Constants.SOCKET);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        RequestObject request = new RequestObject(IOperation.PRIKAZ_RANG_LISTE, null);
        out.writeObject(request);
        //out.flush();

        ResponseObject response = (ResponseObject) in.readObject();
        return (List<TeniserEntity>) response.getData();
    }

    public static List<TurnirEntity> dajSveTurnire() throws Exception {
        DatabaseRepository dbr = new DatabaseRepository();
        return dbr.dajSveTurnire();
    }

    public static int prijavaKorisnika(String korisnickoIme, String sifra) throws Exception {
        DatabaseRepository dbr = new DatabaseRepository();
        return dbr.prijavaKorisnika(korisnickoIme, sifra);
    }

    public static void zapamtiUcescaNaTurniru(List<TeniserEntity> teniseriKojiUcestvuju) throws IOException, ClassNotFoundException {
        Socket socket = (Socket) Session.getInstance().getMap().get(Constants.SOCKET);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        
        RequestObject request = new RequestObject(IOperation.KREIRANJE_UCESCA_NA_TURNIRU, null);
        out.writeObject(request);
        out.flush();
        ResponseObject response = (ResponseObject) in.readObject();
    }

}
