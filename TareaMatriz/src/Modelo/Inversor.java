package Modelo;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Usuario
 */
public class Inversor {
    
    public ArrayList<ArrayList<Double>> invertMatrix(ArrayList<ArrayList<Double>> matrix){        
        if(!Utilidades.isSquaredDoubleMatrix(matrix)){
            throw new NumberFormatException("La matriz no es cuadrada.");
        }
         
        if(Utilidades.isDeterminatCero(matrix)){
            throw new NumberFormatException("La matriz no tiene inversa.");
        }
        
        matrix = concatenateIdentity(matrix);
        matrix = invert(matrix);
        matrix = eraseIdentity(matrix);
        return matrix;
    }
    
    private ArrayList<ArrayList<Double>> concatenateIdentity(ArrayList<ArrayList<Double>> matrix){
        //Matriz identidad
        int grado = matrix.size();
        
        for (int i = 0; i < grado; i++) {
            for (int j = 0; j < grado; j++) {
                if(i == j){
                    matrix.get(i).add(1.0);
                }else{
                    matrix.get(i).add(0.0);
                }
            }
        }
        
        return matrix;
    }
    
    private ArrayList<ArrayList<Double>> invert(ArrayList<ArrayList<Double>> matrix){
        int grado = matrix.size();
        
        for (int i = 0; i < grado; i++) {
            for (int j = 0; j < grado; j++) {
                //Normalización
                double pivote = matrix.get(i).get(i);
                matrix.set(i, MultEscalar.multiplyRowByScalar(matrix.get(i), 1/pivote));
                
                //Resta de filas
                for (int k = 0; k < grado; k++) {
                    if(k!=i){
                        ArrayList<Double> auxRow;
                        auxRow = MultEscalar.multiplyRowByScalar(matrix.get(i), matrix.get(k).get(i));
                        matrix.set(k, Sumador.subRows(matrix.get(k), auxRow));
                    }
                }
            }
        }
        return matrix;
    }
    
    private ArrayList<ArrayList<Double>> eraseIdentity(ArrayList<ArrayList<Double>> matrix){
        int grado = matrix.size();
        
        //Retirar la matriz original y conservar la inversa.
        for (int i = 0; i < grado; i++) {
            for (int j = 0; j < grado; j++) {
                matrix.get(i).remove(0);
            }
        }
        
        return matrix;
    }
}
