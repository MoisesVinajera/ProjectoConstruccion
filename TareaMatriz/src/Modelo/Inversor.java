package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Inversor {
    
    public ArrayList<ArrayList<Double>> invertir(ArrayList<ArrayList<Double>> matrix){        
        if(notSquaredMatrix(matrix)){
            throw new NumberFormatException("La matriz no es cuadrada.");
        }
         
        if(isDeterminatCero(matrix)){
            throw new NumberFormatException("La matriz no tiene inversa.");
        }
        
        int grado = matrix.size();
        
        //Matrix identidad
        for (int i = 0; i < grado; i++) {
            for (int j = 0; j < grado; j++) {
                if(i == j){
                    matrix.get(i).add(1.0);
                }else{
                    matrix.get(i).add(0.0);
                }
            }
        }
        
        for (int i = 0; i < grado; i++) {
            for (int j = 0; j < grado; j++) {
                //Normalización
                double pivote = matrix.get(i).get(i);
                matrix.set(i, MultEscalar.multiplyRow(matrix.get(i), 1/pivote));
                
                //Resta de filas
                for (int k = 0; k < grado; k++) {
                    if(k!=i){
                        ArrayList<Double> auxRow;
                        auxRow = MultEscalar.multiplyRow(matrix.get(i), matrix.get(k).get(i));
                        matrix.set(k, Sumador.subRows(matrix.get(k), auxRow));
                    }
                }
            }
        }
        
        //Retirar la matriz original y conservar la inversa.
        for (int i = 0; i < grado; i++) {
            for (int j = 0; j < grado; j++) {
                matrix.get(i).remove(0);
            }
        }
        
        return matrix;
    }
    
    private boolean notSquaredMatrix(ArrayList<ArrayList<Double>> matrix){
        return matrix.size()!= matrix.get(0).size();
    }

    private boolean isDeterminatCero(ArrayList<ArrayList<Double>> matrix){
        Determinante det = new Determinante();
        return det.determinante(matrix) == 0;
    }
}
