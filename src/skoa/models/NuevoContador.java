package skoa.models;

public class NuevoContador {

    public String direccionFisica;
    public float medicion;
    public String medida;//Wh, ºC, W, ....


    public NuevoContador(String dirFis, float med, String medid) {
        this.direccionFisica = dirFis;
        this.medicion = med;
        this.medida = medid;
    }

}
