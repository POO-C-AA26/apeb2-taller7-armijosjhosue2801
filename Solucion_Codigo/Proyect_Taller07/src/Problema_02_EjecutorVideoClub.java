
import java.util.Arrays;

/**
 * Problema 02: Un videoclub dispone de una serie de películas que pueden estar 
 * en DVD (con capacidad en Gb.) o en VHS (una sola cinta por película y con 
 * cierto tipo de cinta magnetica). De las películas interesa guardar el título,
 * el autor, el año de edición y el idioma (o los idiomas, en caso de DVD). 
 * El precio de alquiler de las películas varía en función del tipo de película. 
 * Las DVD siempre son 10% mas caras que las de VHS.
 * @author Jhosue Armijos
 * @version 1.0
 */
class Pelicula{
    public String titulo;
    public String autor;
    public int anio;
    public Pelicula(String titulo, String autor, int anio) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "titulo=" + titulo + ", autor=" + autor + ", anio=" + anio + '}';
    }
    
}
class Soporte{
    public double costoalquiler;
    public Pelicula Pelicula;
    public Soporte(Pelicula Pelicula) {
        this.Pelicula = Pelicula;
    }
    public double calcularAlquiler(int cantPeliculas, double precioAlquiler){
        this.costoalquiler=cantPeliculas* precioAlquiler;
        return costoalquiler;
    }

    @Override
    public String toString() {
        return "Soporte{" + "costoalquiler=" + costoalquiler + ", Pelicula=" + Pelicula + '}';
    }
     
}
class DVD extends Soporte{
    public String idiomas[];
    public double recargo;
    public DVD(String[] idiomas, double recargo, Pelicula Pelicula) {
        super(Pelicula);
        this.idiomas = idiomas;
        this.recargo = recargo;
    }
    public double calcularAlquiler(int cantPeliculas, double precioAlquiler){
        this.costoalquiler=(super.calcularAlquiler(cantPeliculas, precioAlquiler)+((precioAlquiler*(this.recargo/100.0))));
        return costoalquiler;
    }

    @Override
    public String toString() {
        return "DVD{" + "idiomas=" + Arrays.toString(idiomas) + ", recargo=" + recargo + '}'+super.toString();
    }
    
}
class VHS extends Soporte{
    public String idioma;
    public VHS(String idioma, Pelicula Pelicula) {
        super(Pelicula);
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return "VHS{" + "idioma=" + idioma + '}'+super.toString();
    }
    
}
public class Problema_02_EjecutorVideoClub {
    public static void main(String[] args) {
        String idiomas[]={"ES","ENG"}; 
        Pelicula peli1=new Pelicula("El Mundial","Enrique",2026);
        DVD peliMundial=new DVD(idiomas,10, peli1);
        peliMundial.calcularAlquiler(2, 50);
        Pelicula peli2=new Pelicula("El bicho","Juan",2025);
        VHS pelibicho=new VHS("ES", peli2);
        pelibicho.calcularAlquiler(2, 10);
        System.out.println(peliMundial);
        System.out.println(pelibicho);
    }
}
/**
 * 
 */