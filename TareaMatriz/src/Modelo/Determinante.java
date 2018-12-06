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
public class Determinante {

    /**
     *
     * @param matrix - matriz a la cual se le calcula el determinante
     * @return Determinante
     */
    public double calculateDeterminant(ArrayList<ArrayList<Double>> matrix){
        if(!Utilidades.isSquaredDoubleMatrix(matrix)){
            throw new NumberFormatException("La matriz no es cuadrada.");
        }
        int grado = matrix.size();
        if(grado == 1){
            return matrix.get(0).get(0);
        }
        ArrayList<ArrayList<Double>> cofactores = new ArrayList<>();
        double resultado = 0;
        
        //Se agregan cofactores.
        for (int columnaPivote = 0; columnaPivote < grado; columnaPivote++) {
            for (int fila = 1; fila < grado; fila++) {
                //Se añade fila de cofactores.
                cofactores.add(new ArrayList<>());
                for (int columna = 0; columna < grado; columna++) {
                    //Se evita la fila y columna del pivote.
                    if (columna != columnaPivote){
                        cofactores.get(fila-1).add(matrix.get(fila).get(columna));
                    }
                }
            }
            resultado += matrix.get(0).get(columnaPivote)*Math.pow(-1, columnaPivote)*calculateDeterminant(cofactores);
            cofactores = new ArrayList<>();
        }     
        return resultado;
    }
}
