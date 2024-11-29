package org.example.Teoria.Producer_Consumer;

public class Buffer {
    private char[] buffer;
    private int next;
    private  boolean vacia;
    private boolean lleno;

    public Buffer(int tamanio) {
        this.buffer = new char[tamanio];
        this.next = 0;
        this.vacia = true;
        this.lleno = false;
    }

    //CONSUMIDOR (Al ser dos clases sincroizadas nunha se pisarán entre ellas)
    public  synchronized char consumir(){
        while (this.vacia){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        next--;
        this.lleno=false;
        if (next==0){
            this.vacia=true;
        }
        notifyAll();

        return this.buffer[this.next];
    }

    //PRODUCTOR (Al ser dos clases sincroizadas nunha se pisarán entre ellas)
    public  synchronized void producir(char c){
        while (this.lleno){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        buffer[next]=c;
        next++;

        this.vacia=false;
        if (next==this.buffer.length){
            this.lleno=true;
        }

        notifyAll();
    }

}
