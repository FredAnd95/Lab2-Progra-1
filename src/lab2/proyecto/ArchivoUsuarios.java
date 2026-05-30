/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2.proyecto;

/**
 *
 * @author lopez
 */
import java.io.*;
import java.util.ArrayList;

public class ArchivoUsuarios {

    public static void guardar(ArrayList<CrUsuarios> lista) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("usuarios.dat"));
            out.writeObject(lista);
            out.close();
        } catch (Exception e) {}
    }

    public static ArrayList<CrUsuarios> cargar() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("usuarios.dat"));
            return (ArrayList<CrUsuarios>) in.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}