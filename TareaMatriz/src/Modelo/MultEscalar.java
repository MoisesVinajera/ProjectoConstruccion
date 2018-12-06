package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class MultEscalar {
    
    /**
     *
     * @param matrix Matriz a la cual se le multiplicará un escalar
     * @param escalar Constante que se usara para multiplicar a la matriz
     * @return
     */
    public ArrayList<ArrayList<Double>> multiplyMatrixByScalar(ArrayList<ArrayList<Double>> matrix, double escalar){        
        for (int fila = 0; fila < matrix.size(); fila++) {
            matrix.set(fila, MultEscalar.multiplyRowByScalar(matrix.get(fila), escalar));
        }
        
        return matrix;
    }
    
    /**
     *
     * @param row Fila de una matriz
     * @param escalar Constante que se usara para multiplicar a la Fila
     * @return
     */
    public static ArrayList<Double> multiplyRowByScalar(ArrayList<Double> row, double escalar){
        ArrayList<Double> result = new ArrayList<>();
        
        for (int columna = 0; columna < row.size(); columna++) {
            result.add(row.get(columna)*escalar);
        }
        
        return result;
    }
}
