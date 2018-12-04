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
     //The "Largest Prime" meassure k
        //aplicando la metrica
        // 1+max(0+0+(1+max(1+max(1+max(1)))))
        //1+max(0+0+(1+max(1+max(2))))
        //1+max(0+0+((1+max(3))))
        //1+max(0+0+(4))
        //5
    public double determinante(ArrayList<ArrayList<Double>> matrix){
        if(!Utilidades.isSquaredDoubleMatrix(matrix)){
            throw new NumberFormatException("La matriz no es cuadrada.");
        }
        int grado = matrix.size();
        if(grado == 1){
            return matrix.get(0).get(0);
        }
        ArrayList<ArrayList<Double>> cofactores = new ArrayList<>();
        double resultado = 0;
        
        for (int k = 0; k < grado; k++) {
            for (int i = 1; i < grado; i++) {
                cofactores.add(new ArrayList<>());
                for (int j = 0; j < grado; j++) {
                    if (j!=k){
                        cofactores.get(i-1).add(matrix.get(i).get(j));
                    }
                }
            }
            resultado += matrix.get(0).get(k)*Math.pow(-1, k)*determinante(cofactores);
            cofactores = new ArrayList<>();
        }     
        return resultado;
    }
}
