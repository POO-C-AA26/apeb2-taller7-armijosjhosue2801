/**
 * Problema 03: Implemente un sistema de envío de mensajes a móviles. Existen 
 * dos tipos de mensajes que se pueden enviar entre móviles, mensajes de texto 
 * (SMS) y mensajes que contienen imágenes (MMS). Por un lado, los mensajes de 
 * texto contienen un mensaje en caracteres que se desea enviar de un móvil a 
 * otro. Por otro lado, los mensajes que contienen imágenes almacenan 
 * información sobre la imagen a enviar, la cual se representará por el nombre 
 * del fichero que la contiene. Independientemente del tipo de mensaje, cada 
 * mensaje tendrá asociado un remitente de dicho mensaje y un destinatario. 
 * Ambos estarán definidos obligatoriamente por un número de móvil, y opcionalmente 
 * se podrá guardar información sobre su nombre. Además, los métodos enviarMensaje 
 * y visualizarMensaje deben estar definidos.
 * @author Jhosue Armijos
 * @version 1.0
 */

class contacto {

    public String numero;
    public String nombre;

    public contacto(String numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "contacto{" + "numero=" + numero + ", nombre=" + nombre + '}';
    }
}

class Mensaje {

    public contacto destinatario;
    public contacto remitente;

    public Mensaje(contacto destinatario, contacto remitente) {
        this.destinatario = destinatario;
        this.remitente = remitente;
    }

    public String enviarMensaje() {
        return "enviando Mensaje";
    }

    public String mostrarMensaje() {
        return "mostrando Mensaje";
    }

    @Override
    public String toString() {
        return "Mensaje{" + "destinatario=" + destinatario + ", remitente=" + remitente + '}';
    }
}

class SMS extends Mensaje {

    public String mensajeTexto;

    public SMS(String mensajeTexto, contacto destinatario, contacto remitente) {
        super(destinatario, remitente);
        this.mensajeTexto = mensajeTexto;
    }

    @Override
    public String enviarMensaje() {
        return "enviando SMS A " + destinatario.nombre;
    }

    @Override
    public String mostrarMensaje() {
        return "texto:" + this.mensajeTexto;
    }

    @Override
    public String toString() {
        return "SMS{" + "mensajeTexto=" + mensajeTexto + '}' + super.toString();
    }
}

class MMS extends Mensaje {

    public String nombreImagen;

    public MMS(String nombreImagen, contacto destinatario, contacto remitente) {
        super(destinatario, remitente);
        this.nombreImagen = nombreImagen;
    }

    @Override
    public String enviarMensaje() {
        return "enviando MMS A " + destinatario.nombre;
    }

    @Override
    public String mostrarMensaje() {
        return "texto:" + this.nombreImagen;
    }

    @Override
    public String toString() {
        return "MMS{" + "nombreImagen=" + nombreImagen + '}' + super.toString();
    }
}

public class Problema_03_EjecutorMensaje {

    public static void main(String[] args) {
        contacto con1 = new contacto("764257789", "Ariel");
        contacto con2 = new contacto("789475521", "Alexi");
        SMS sms = new SMS("Holaaaaa amigo", con1, con2);
        System.out.println(sms.enviarMensaje());
        System.out.println(sms.mostrarMensaje());
        System.out.println("");
        MMS mms = new MMS("comida.jpg", con2, con1);
        System.out.println(mms.enviarMensaje());
        System.out.println(mms.mostrarMensaje());
    }
}

/*run:
enviando SMS A Ariel
texto:Holaaaaa amigo

enviando MMS A Alexi
texto:comida.jpg
BUILD SUCCESSFUL (total time: 6 seconds)
*/