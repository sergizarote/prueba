package skoa.models;

public class MiFormato {

    public String nombre;
    public String direccionGrupo;
    public String tipoEstructura;
    public String subtipo;
    public String x;
    public String y;

    @SuppressWarnings("deprecation")
    public MiFormato(String nombree, String dirgrup, String tipoestr, String subtipo, String xx, String yy) {
        this.nombre = nombree;
        this.direccionGrupo = dirgrup;
        this.tipoEstructura = tipoestr;
        this.subtipo = subtipo;
        this.x = xx;
        this.y = yy;
    }
}