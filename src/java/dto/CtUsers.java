/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author VICTOR
 */
public class CtUsers {
    private int id;
    private String nombre;
    private String app;
    private String apm;
    private String correo;
    
        public CtUsers(){
        super();
    }
    
    
    public CtUsers(int id, String nombre, String app, String apm, String correo){
        this.id = id;
        this.nombre = nombre;
        this.app = app;
        this.apm = apm;
        this.correo = correo;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getApm() {
        return apm;
    }

    public void setApm(String apm) {
        this.apm = apm;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
