package Modelo;

import java.util.ArrayList;

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
        
        for (int fila = 0; fila < grado; fila++) {
            for (int columna = 0; columna < grado; columna++) {
                if(fila == columna){
                    matrix.get(fila).add(1.0);
                }else{
                    matrix.get(fila).add(0.0);
                }
            }
        }
        
        return matrix;
    }
    
    private ArrayList<ArrayList<Double>> invert(ArrayList<ArrayList<Double>> matrix){
        int grado = matrix.size();
        
        for (int filaPivote = 0; filaPivote < grado; filaPivote++) {
            for (int columnas = 0; columnas < grado; columnas++) {
                //Normalización
                double pivote = matrix.get(filaPivote).get(filaPivote);
                matrix.set(filaPivote, MultEscalar.multiplyRowByScalar(matrix.get(filaPivote), 1/pivote));
                
                //Resta de filas
                for (int filas = 0; filas < grado; filas++) {
                    if(filas!=filaPivote){
                        ArrayList<Double> auxRow;
                        auxRow = MultEscalar.multiplyRowByScalar(matrix.get(filaPivote), matrix.get(filas).get(filaPivote));
                        matrix.set(filas, Sumador.subRows(matrix.get(filas), auxRow));
                    }
                }
            }
        }
        return matrix;
    }
    
    private ArrayList<ArrayList<Double>> eraseIdentity(ArrayList<ArrayList<Double>> matrix){
        int grado = matrix.size();
        
        //Retirar la matriz original y conservar la inversa.
        for (int fila = 0; fila < grado; fila++) {
            for (int columnas = 0; columnas < grado; columnas++) {
                matrix.get(fila).remove(0);
            }
        }
        
        return matrix;
    }
}
