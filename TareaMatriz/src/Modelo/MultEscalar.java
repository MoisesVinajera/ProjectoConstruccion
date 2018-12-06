package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class MultEscalar {
    
    public ArrayList<ArrayList<Double>> multiplyMatrixByScalar(ArrayList<ArrayList<Double>> matrix, double escalar){        
        for (int fila = 0; fila < matrix.size(); fila++) {
            matrix.set(fila, MultEscalar.multiplyRowByScalar(matrix.get(fila), escalar));
        }
        
        return matrix;
    }
    
    public static ArrayList<Double> multiplyRowByScalar(ArrayList<Double> row, double escalar){
        ArrayList<Double> result = new ArrayList<>();
        
        for (int columna = 0; columna < row.size(); columna++) {
            result.add(row.get(columna)*escalar);
        }
        
        return result;
    }
}
