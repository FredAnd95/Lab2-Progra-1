/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2.proyecto;

import java.io.Serializable;

public class CrUsuarios implements Serializable {
    String nombreCompleto;
    String email;
    String pass;
    boolean esAdmin;

    public CrUsuarios(String nombreCompleto, String email, String pass, boolean esAdmin) {
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.pass = pass;
        this.esAdmin = esAdmin;
    }
}