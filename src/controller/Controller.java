/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import constants.Constants;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import domen.FazaTurnira;
import domen.KategorijaTurnira;
import domen.Korisnik;
import domen.Mec;
import domen.Teniser;
import domen.Turnir;
import domen.UcesceNaTurniru;
import session.Session;
import transfer.IOperation;
import transfer.RequestObject;
import transfer.ResponseObject;

/**
 *
 * @author lukabaljak
 */
public class Controller {

    public static List<KategorijaTurnira> dajKategorijeTurnira() throws Exception {
        Socket socket = (Socket) Session.getInstance().getMap().get(Constants.SOCKET);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        RequestObject request = new RequestObject(IOperation.DAJ_KATEGORIJE_TURNIRA, null);
        out.writeObject(request);
        out.flush();

        ResponseObject response = (ResponseObject) in.readObject();
        return (List<KategorijaTurnira>) response.getData();
    }

    public static void sacuvajTenisera(Teniser teniser) throws Exception {
        Socket socket = (Socket) Session.getInstance().getMap().get(Constants.SOCKET);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        RequestObject request = new RequestObject(IOperation.KREIRANJE_TENISERA, teniser);
        out.writeObject(request);
        out.flush();

        ResponseObject response = (ResponseObject) in.readObject();
    }

    public static Turnir sacuvajTurnir(Turnir turnir) throws Exception {
        Socket socket = (Socket) Session.getInstance().getMap().get(Constants.SOCKET);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        RequestObject request = new RequestObject(IOperation.KREIRANJE_TURNIRA, turnir);
        out.writeObject(request);
        out.flush();

        ResponseObject response = (ResponseObject) in.readObject();
        return (Turnir) response.getData();
    }

    public static List<Teniser> dajRangListu() throws Exception {

        Socket socket = (Socket) Session.getInstance().getMap().get(Constants.SOCKET);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        RequestObject request = new RequestObject(IOperation.PRIKAZ_RANG_LISTE, null);
        out.writeObject(request);
        //out.flush();

        ResponseObject response = (ResponseObject) in.readObject();
        return (List<Teniser>) response.getData();
    }

    public static List<Turnir> dajSveTurnire() throws Exception {
        Socket socket = (Socket) Session.getInstance().getMap().get(Constants.SOCKET);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        RequestObject request = new RequestObject(IOperation.DAJ_SVE_TURNIRE, null);
        out.writeObject(request);
        //out.flush();

        ResponseObject response = (ResponseObject) in.readObject();
        return (List<Turnir>) response.getData();
    }

    public static int prijavaKorisnika(Korisnik korisnik) throws Exception {
        Socket socket = (Socket) Session.getInstance().getMap().get(Constants.SOCKET);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        RequestObject request = new RequestObject(IOperation.PRIJAVA_KORISNIKA, korisnik);
        out.writeObject(request);

        ResponseObject response = (ResponseObject) in.readObject();
        return response.getCode();
    }

    public static void sacuvajUcescaNaTurniru(List<Teniser> teniseriKojiUcestvuju) throws IOException, ClassNotFoundException {
        Socket socket = (Socket) Session.getInstance().getMap().get(Constants.SOCKET);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        RequestObject request = new RequestObject(IOperation.KREIRANJE_UCESCA_NA_TURNIRU, null);
        out.writeObject(request);
        out.flush();
        ResponseObject response = (ResponseObject) in.readObject();
    }

  
    public static void sacuvajUcesceNaTurniru(UcesceNaTurniru ucesceNaTurniru) throws Exception {
        Socket socket = (Socket) Session.getInstance().getMap().get(Constants.SOCKET);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        RequestObject request = new RequestObject(IOperation.KREIRANJE_UCESCA_NA_TURNIRU, null);
        request.setData(ucesceNaTurniru);
        out.writeObject(request);
        out.flush();
        ResponseObject response = (ResponseObject) in.readObject();
    }

    public static void obrisiUcesceNaTurniru(UcesceNaTurniru ucesceNaTurniru) throws Exception {
        Socket socket = (Socket) Session.getInstance().getMap().get(Constants.SOCKET);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        RequestObject request = new RequestObject(IOperation.BRISANJE_UCESCA_NA_TURNIRU, null);
        request.setData(ucesceNaTurniru);
        out.writeObject(request);
        out.flush();
        ResponseObject response = (ResponseObject) in.readObject();
    }

    public static List<Teniser> dajTenisereKojiUcestvuju(Turnir turnir) throws Exception {
        Socket socket = (Socket) Session.getInstance().getMap().get(Constants.SOCKET);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        RequestObject request = new RequestObject(IOperation.DAJ_TENISERE_KOJI_UCESTVUJU, null);
        request.setData(turnir);
        out.writeObject(request);
        out.flush();
        ResponseObject response = (ResponseObject) in.readObject();
        return (List<Teniser>) response.getData();
    }

    public static List<FazaTurnira> dajFazeTurnira() throws Exception {
        Socket socket = (Socket) Session.getInstance().getMap().get(Constants.SOCKET);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        RequestObject request = new RequestObject(IOperation.DAJ_FAZE_TURNIRA, null);
        out.writeObject(request);
        out.flush();
        ResponseObject response = (ResponseObject) in.readObject();
        return (List<FazaTurnira>) response.getData();
    }

    public static void sacuvajMec(Mec mec) throws Exception {
        Socket socket = (Socket) Session.getInstance().getMap().get(Constants.SOCKET);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        RequestObject request = new RequestObject(IOperation.KREIRANJE_MECA, mec);
        out.writeObject(request);
        out.flush();

        ResponseObject response = (ResponseObject) in.readObject();
    }

    public static boolean daLiSuOdigraniSviMecevi(Turnir turnir) throws Exception {
        Socket socket = (Socket) Session.getInstance().getMap().get(Constants.SOCKET);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        RequestObject request = new RequestObject(IOperation.DA_LI_SU_ODIGRANI_SVI_MECEVI, null);
        request.setData(turnir);
        out.writeObject(request);
        out.flush();

        ResponseObject response = (ResponseObject) in.readObject();
        return (boolean) response.getData();
    }

    public static List<Mec> dajSveMeceve(Turnir turnir) throws Exception {
        Socket socket = (Socket) Session.getInstance().getMap().get(Constants.SOCKET);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        RequestObject request = new RequestObject(IOperation.DAJ_SVE_MECEVE, turnir);
        out.writeObject(request);
        out.flush();
        ResponseObject response = (ResponseObject) in.readObject();
        return (List<Mec>) response.getData();
    }

    public static boolean ucestvujeLiNaNekomTurniruUTojNedelji(Teniser teniserEntity, Turnir turnir) throws IOException, ClassNotFoundException {
        Socket socket = (Socket) Session.getInstance().getMap().get(Constants.SOCKET);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        UcesceNaTurniru ucesceNaTurniru = new UcesceNaTurniru(turnir, teniserEntity);
        RequestObject request = new RequestObject(IOperation.UCESTVUJE_TE_NEDELJE, turnir);
        request.setData(ucesceNaTurniru);
        out.writeObject(request);
        out.flush();
        ResponseObject response = (ResponseObject) in.readObject();
        return (boolean) response.getData();

    }

    public static void azurirajBrojPoenaTeniserima(List<Mec> mecevi) throws Exception {
        Socket socket = (Socket) Session.getInstance().getMap().get(Constants.SOCKET);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        RequestObject request = new RequestObject(IOperation.AZURIRAJ_BROJ_POENA, mecevi);

        out.writeObject(request);
        out.flush();
        ResponseObject response = (ResponseObject) in.readObject();
    }

}
