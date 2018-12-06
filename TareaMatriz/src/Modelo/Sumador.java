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
public class Sumador {

    /**
     *
     * @param matrixA Una de las matrices que se sumaran
     * @param matrixB Una de las matrices que se sumaran
     * @return
     */
    public ArrayList<ArrayList<Double>> sumarMatrices(ArrayList<ArrayList<Double>> matrixA, ArrayList<ArrayList<Double>> matrixB){

        if(Utilidades.diferentSizeMatrix(matrixA,matrixB)){
            throw new NumberFormatException("Las matrices son de distinto tamaño.");
        }
        
        ArrayList<ArrayList<Double>> result = new ArrayList<>();
        for (int i = 0; i < matrixA.size(); i++) {
            result.add(Sumador.addRows(matrixA.get(i), matrixB.get(i)));
        }
        
        return result;
    }
    /**
     *
     * @param row Fila de una matriz a la cual se le sumará otra
     * @param adding Fila de una matriz que sumará
     * @return
     */
    private static ArrayList<Double> addRows(ArrayList<Double> row, ArrayList<Double> adding){
        if(Utilidades.diferentSizeElement(row, adding)){
            throw new NumberFormatException("Addition with different size of array.");
        }
        
        ArrayList<Double> result = new ArrayList<>();
        
        for (int columna = 0; columna < row.size(); columna++) {
            result.add(row.get(columna)+adding.get(columna));
        }
        
        return result;
    }
    
    /**
     *
     * @param row Fila de una matriz a la cual se le restará otra
     * @param substracting Fila de una matriz que restará
     * @return
     */
    public static ArrayList<Double> subRows(ArrayList<Double> row, ArrayList<Double> substracting){
        if(Utilidades.diferentSizeElement(row, substracting)){
            throw new NumberFormatException("Addition with different size of array.");
        }
        
        ArrayList<Double> result = new ArrayList<>();
        
        for (int columna = 0; columna < row.size(); columna++) {
            result.add(row.get(columna)-substracting.get(columna));
        }
        
        return result;
    }
}

