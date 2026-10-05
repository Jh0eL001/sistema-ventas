package proyecto.modelos;

public class Caja {

    private int id;
    private String numeroRemision;
    private String proveedor;
    private String fechaRecepcion;
    private int cantidadDeclarada;
    private int cantDaniados;
    private int cantFaltantes;
    private int cantSobrantes;
    private String estado;

    public Caja() {
    }

    public Caja(String numeroRemision, String proveedor, int cantidadDeclarada, String estado, String fechaRecepcion) {
        this.numeroRemision = numeroRemision;
        this.proveedor = proveedor;
        this.cantidadDeclarada = cantidadDeclarada;
        this.cantDaniados = 0;
        this.cantFaltantes = 0;
        this.cantSobrantes = 0;
        this.estado = estado;
        this.fechaRecepcion = fechaRecepcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroRemision() {
        return numeroRemision;
    }

    public void setNumeroRemision(String numeroRemision) {
        this.numeroRemision = numeroRemision;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public int getCantidadDeclarada() {
        return cantidadDeclarada;
    }

    public void setCantidadDeclarada(int cantidadDeclarada) {
        this.cantidadDeclarada = cantidadDeclarada;
    }

    public int getCantDaniados() {
        return cantDaniados;
    }

    public void setCantDaniados(int cantDaniados) {
        this.cantDaniados = cantDaniados;
    }

    public int getCantFaltantes() {
        return cantFaltantes;
    }

    public void setCantFaltantes(int cantFaltantes) {
        this.cantFaltantes = cantFaltantes;
    }

    public int getCantSobrantes() {
        return cantSobrantes;
    }

    public void setCantSobrantes(int cantSobrantes) {
        this.cantSobrantes = cantSobrantes;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(String fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }
}
