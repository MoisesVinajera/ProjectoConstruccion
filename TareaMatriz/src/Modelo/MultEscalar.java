package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class MultEscalar {
    
    public ArrayList<ArrayList<Double>> multiplyMatrixByScalar(ArrayList<ArrayList<Double>> matrix, double escalar){        
        for (int i = 0; i < matrix.size(); i++) {
            matrix.set(i, MultEscalar.multiplyRow(matrix.get(i), escalar));
        }
        
        return matrix;
    }
    
    public static ArrayList<Double> multiplyRow(ArrayList<Double> row, double escalar){
        ArrayList<Double> result = new ArrayList<>();
        
        for (int i = 0; i < row.size(); i++) {
            result.add(row.get(i)*escalar);
        }
        
        return result;
    }
}
