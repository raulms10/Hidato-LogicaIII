/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hidato;

/**
 *
 * @author lis
 */
public class Nodo {
    private int valor;
    private int fila;
    private int columna;
    private boolean visitado;

    public Nodo(int numero, int fila, int columna) {
        this.valor = numero;
        this.fila = fila;
        this.columna = columna;
        this.visitado = false;
    }

    public Nodo() {
    }
    
    
    
    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
    
    public int getNumero() {
        return valor;
    }

    public void setNumero(int numero) {
        this.valor = numero;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }
    
    
    
}
