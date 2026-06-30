/**
 * Problema 01: Jerarquía de clases para la estructura de un capítulo de libro
 * Un capítulo está compuesto por varias secciones, cada una de las cuales comprende 
 * varios párrafos y figuras. Un párrafo incluye varias sentencias, cada una de las 
 * cuales contiene varias palabras.
 * @author Jhosue Armijos
 * @version 1.0
 */

class Palabra {
    public String contenido;
    public int longitud;

    public Palabra(String contenido) {
        this.contenido = contenido;
        this.longitud = contenido.length();
    }

    @Override
    public String toString() {
        return "Palabra{" + "contenido='" + contenido + "', longitud=" + longitud + '}';
    }
}

class Sentencia {
    public String texto;
    public Palabra[] palabras;

    public Sentencia(String texto, Palabra[] palabras) {
        this.texto = texto;
        this.palabras = palabras;
    }

    @Override
    public String toString() {
        return "Sentencia{" + "texto='" + texto + "', palabras=" + java.util.Arrays.toString(palabras) + '}';
    }
}

class Parrafo {
    public int numero;
    public Sentencia[] sentencias;

    public Parrafo(int numero, Sentencia[] sentencias) {
        this.numero = numero;
        this.sentencias = sentencias;
    }

    @Override
    public String toString() {
        return "Parrafo{" + "numero=" + numero + ", sentencias=" + java.util.Arrays.toString(sentencias) + '}';
    }
}

class Figura {
    public String nombre;
    public String descripcion;

    public Figura(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Figura{" + "nombre='" + nombre + "', descripcion='" + descripcion + "'}";
    }
}

class Seccion {
    public String titulo;
    public Parrafo[] parrafos;
    public Figura[] figuras;

    public Seccion(String titulo, Parrafo[] parrafos, Figura[] figuras) {
        this.titulo = titulo;
        this.parrafos = parrafos;
        this.figuras = figuras;
    }

    @Override
    public String toString() {
        return "Seccion{" + "titulo='" + titulo + "', parrafos=" + java.util.Arrays.toString(parrafos) +
               ", figuras=" + java.util.Arrays.toString(figuras) + '}';
    }
}

class Capitulo {
    public String nombreCapitulo;
    public Seccion[] secciones;

    public Capitulo(String nombreCapitulo, Seccion[] secciones) {
        this.nombreCapitulo = nombreCapitulo;
        this.secciones = secciones;
    }

    @Override
    public String toString() {
        return "Capitulo{" + "nombreCapitulo='" + nombreCapitulo + "', secciones=" + java.util.Arrays.toString(secciones) + '}';
    }
}
public class Problema_01_EjecutorCapituloLibro {
    public static void main(String[] args) {
        Palabra p1 = new Palabra("Orientado");
        Palabra p2 = new Palabra("Objetos");
        Palabra p3 = new Palabra("Java");
        Palabra[] palabras = {p1, p2, p3};
        Sentencia sentencia1 = new Sentencia("La programación orientada a objetos se usa en Java", palabras);
        Sentencia[] sentencias = {sentencia1};
        Parrafo parrafo1 = new Parrafo(1, sentencias);
        Figura figura1 = new Figura("Diagrama de clases", "Representación gráfica de atributos y métodos");
        Parrafo[] parrafos = {parrafo1};
        Figura[] figuras = {figura1};
        Seccion seccion1 = new Seccion("Conceptos básicos", parrafos, figuras);
        Seccion[] secciones = {seccion1};
        Capitulo capitulo1 = new Capitulo("Introducción a POO", secciones);
        System.out.println(capitulo1);
    }
}

/* RUN:
Capitulo{nombreCapitulo='Introducci�n a POO', secciones=[Seccion{titulo='Conceptos b�sicos', parrafos=[Parrafo{numero=1, sentencias=[Sentencia{texto='La programaci�n orientada a objetos se usa en Java', palabras=[Palabra{contenido='Orientado', longitud=9}, Palabra{contenido='Objetos', longitud=7}, Palabra{contenido='Java', longitud=4}]}]}], figuras=[Figura{nombre='Diagrama de clases', descripcion='Representaci�n gr�fica de atributos y m�todos'}]}]}
BUILD SUCCESSFUL (total time: 0 seconds)
*/