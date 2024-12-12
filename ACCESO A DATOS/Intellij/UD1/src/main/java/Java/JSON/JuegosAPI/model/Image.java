package Java.JSON.JuegosAPI.model;

public class Image {
    private  int id;
    private String url;
    private Byte[] imagen;

    public Image() {
    }

    public Image(int id, String url, Byte[] imagen) {
        this.id = id;
        this.url = url;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Byte[] getImagen() {
        return imagen;
    }

    public void setImagen(Byte[] imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Image:\n" +
                "id: " + id + "\t url= " + url ;
    }
}
