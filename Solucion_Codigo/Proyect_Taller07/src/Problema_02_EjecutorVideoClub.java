
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
    public double precio;
    public int cantidad;
    public Pelicula Pelicula;
    public Soporte(double costoalquiler, double precio, int cantidad, Pelicula Pelicula) {
        this.costoalquiler = costoalquiler;
        this.precio = precio;
        this.cantidad = cantidad;
        this.Pelicula = Pelicula;
    }
    public double calcularAlquiler(){
        this.costoalquiler=(this.cantidad* this.precio);
        return this.costoalquiler;
    }
    @Override
    public String toString() {
        return "Soporte{" + "costoalquiler=" + costoalquiler + ", precio=" + precio + ", cantidad=" + cantidad + ", Pelicula=" + Pelicula + '}';
    }

}
class DVD extends Soporte{
    public String idiomas[];
    public double PorcentajeRecargo;
    public DVD(String[] idiomas, double PorcentajeRecargo, double costoalquiler, double precio, int cantidad, Pelicula Pelicula) {
        super(costoalquiler, precio, cantidad, Pelicula);
        this.idiomas = idiomas;
        this.PorcentajeRecargo = PorcentajeRecargo;
    }
    public double calcularAlquiler(int cantPeliculas, double precioAlquiler){
        this.costoalquiler=super.calcularAlquiler()+(this.costoalquiler*(this.PorcentajeRecargo/100));
        return this.costoalquiler;
    }
    @Override
    public String toString() {
        return "DVD{" + "idiomas=" + Arrays.toString(idiomas) + ", recargo=" + PorcentajeRecargo + '}'+super.toString();
    }
    
}
class VHS extends Soporte{
    public String idioma;
    public VHS(String idioma, double costoalquiler, double precio, int cantidad, Pelicula Pelicula) {
        super(costoalquiler, precio, cantidad, Pelicula);
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
        DVD peliMundial=new DVD(idiomas,10,5,5,2,peli1);
        peliMundial.calcularAlquiler(2, 50);
        Pelicula peli2=new Pelicula("El bicho","Juan",2025);
        VHS pelibicho=new VHS(idiomas[0],10,5,2,peli2);
        pelibicho.calcularAlquiler();
        System.out.println(peliMundial);
        System.out.println(pelibicho);
    }
}
/**
 * run:
DVD{idiomas=[ES, ENG], recargo=10.0}Soporte{costoalquiler=11.0, precio=5.0, cantidad=2, Pelicula=Pelicula{titulo=El Mundial, autor=Enrique, anio=2026}}
VHS{idioma=ES}Soporte{costoalquiler=10.0, precio=5.0, cantidad=2, Pelicula=Pelicula{titulo=El bicho, autor=Juan, anio=2025}}
BUILD SUCCESSFUL (total time: 0 seconds)
 */