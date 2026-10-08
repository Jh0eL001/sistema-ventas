package proyecto.modelos;

public class Producto {

    private int id;
    private int cajaId;
    private int categoriaId;
    private String codigo;
    private String nombre;
    private String material;
    private double peso;
    private String calidad;
    private double costo;
    private double precio;
    private String foto;
    private String estado;

    public Producto() {
    }

    public Producto(int cajaId, int categoriaId, String codigo, String nombre, String material, double peso, String calidad, double costo, double precio, String foto, String estado) {
        this.cajaId = cajaId;
        this.categoriaId = categoriaId;
        this.codigo = codigo;
        this.nombre = nombre;
        this.material = material;
        this.peso = peso;
        this.calidad = calidad;
        this.costo = costo;
        this.precio = precio;
        this.foto = foto;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCajaId() {
        return cajaId;
    }

    public void setCajaId(int cajaId) {
        this.cajaId = cajaId;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}