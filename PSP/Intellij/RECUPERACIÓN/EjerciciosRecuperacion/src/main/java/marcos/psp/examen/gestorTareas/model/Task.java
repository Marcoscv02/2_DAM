package marcos.psp.examen.gestorTareas.model;

public class Task {
    private Integer id;
    private Boolean realizada;
    private String name;
    private String descripcion;
    private String worker;

    public Task() {
    }

    public Task(Integer id, Boolean realizada, String name, String descripcion, String worker) {
        this.id = id;
        this.realizada = realizada;
        this.name = name;
        this.descripcion = descripcion;
        this.worker = worker;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getRealizada() {
        return realizada;
    }

    public void setRealizada(Boolean realizada) {
        this.realizada = realizada;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    @Override
    public String toString() {
        return "Task: id: " + id + ", name: " + name + ", descripcion: " + descripcion + ", worker: "+worker+ "\t";
    }
}
