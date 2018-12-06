/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Trasponedor {
    public ArrayList<ArrayList<Double>> trasposeMatrix(ArrayList<ArrayList<Double>> matrix){
        ArrayList<ArrayList<Double>> resultado = new ArrayList<>();
        
        //Hallando el resultado.
        int filasIniciales = matrix.size();
        int columnasIniciales = matrix.get(0).size();
        
        for (int columnas = 0; columnas < columnasIniciales; columnas++) {
            resultado.add(new ArrayList<Double>());
            for (int filas = 0; filas < filasIniciales; filas++) {
                resultado.get(columnas).add(matrix.get(filas).get(columnas));
            }
        }
        
        //Almacenando el resultado en la matriz original.
        matrix = new ArrayList<>();
        for (int filas = 0; filas < columnasIniciales; filas++) {
            matrix.add(new ArrayList());
            for (int columnas = 0; columnas < filasIniciales; columnas++) {
                matrix.get(filas).add(resultado.get(filas).get(columnas));
            }
        }
        
        return matrix;
    }
}
