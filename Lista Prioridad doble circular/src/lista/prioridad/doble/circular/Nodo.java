/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista.prioridad.doble.circular;

/**
 *
 * @author luisa
 */
public class Nodo {
    
    //Properties
    Prioridad dato;

    public Prioridad getDato() {
        return dato;
    }

    public void setDato(Prioridad dato) {
        this.dato = dato;
    }

    public Nodo getAnt() {
        return ant;
    }

    public void setAnt(Nodo ant) {
        this.ant = ant;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }
    Nodo ant, sig;
    
    //Builders
    public Nodo(){
        ant = sig = this;
    }
    
    public Nodo(Prioridad dato){
        this.dato = dato;
        ant = sig = this;
    }
    
    public Nodo(Prioridad dato, Nodo a, Nodo s){
        this.dato = dato;
        ant = a;
        sig = s;
    }  
}
