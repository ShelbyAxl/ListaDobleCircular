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
public class ListaDobleCircular {
    
    //Properties
    protected Nodo ini, fin;
    
    //Builders
    public ListaDobleCircular(){
        ini = fin = null;
    }
    
    public boolean newDato(Prioridad dato){
        Nodo n = new Nodo(dato);
        if(isEmpty())ini = fin = n;
        else {
            fin.sig = n;
            n.ant = fin;
            fin = n;
        }
        ini.ant = fin;
        fin.sig = ini;
        return true;
    }
    
    public boolean deleteDato(){
        if(isEmpty())return false;
        if(onlyOneNodo()){
            ini.setAnt(null);
            fin.ant = null;
            ini = fin = null;
        }
        else{
            Nodo t = ini;
            ini = ini.sig;
            t.sig = null;
            ini.ant = null;
            ini.ant = fin;
            fin.sig = ini;
            t.ant = null;
            t = null;
        }
        return true;
    }
    
    public boolean isEmpty(){
        return ini == null;
    }
    
    public boolean onlyOneNodo(){
        return ini == fin;  
    }
    
    public void ordenar(){
        char temp;
        int n;
        for(Nodo i = ini; i != fin; i = i.getSig())
            for(Nodo j = ini; j != fin; j = j.getSig())
                if(j.dato.nivel < j.sig.dato.nivel){
                    temp = j.dato.getDato();
                    n = j.dato.getNivel();
                    j.dato.setDato(j.sig.dato.dato);
                    j.dato.setNivel(j.sig.dato.nivel);
                    j.sig.dato.setDato(temp);
                    j.sig.dato.setNivel(n);
                }
    }
    
    public boolean findNDelete(Prioridad e){
        if(isEmpty())return false;
        for(Nodo i = ini; i != fin; i = i.getSig()){
            Nodo t = i;
            if(t.dato.dato == e.dato && 
                    t.dato.nivel == e.nivel){
            if(onlyOneNodo()){
                ini.setAnt(null);
                fin.ant = null;
                ini = fin = null;
            }
                else{
                    if(t == ini){
                        this.deleteDato();
                        return true;
                    }
                    t.ant.sig = t.sig;
                    t.sig.ant = t.ant;
                    t.sig = null;
                    t.ant = null;
                    t = null;
                    return true;
                }
            }
        }
        return false;
    }
    
    public String mostrar(){
        Nodo t = ini;
        String cad = "";
        int a = 0;
        if(isEmpty())return "";
        do{
            if(t == ini && t == fin){cad += "---->" + t.dato + "<----\n"; a++;}
            else if(t == ini)cad += "---->" + t.dato + "----\n";
            else if(t == fin){cad += " ----" + t.dato + "<---\n"; a++;}
            else cad += "|     " + t.dato + "      |\n";
            t = t.sig;
        }while(a < 1);
        return cad;
    }
}
