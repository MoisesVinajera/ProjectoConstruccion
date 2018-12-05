package matrices;
import Modelo.*;
import Vista.Menu;
import java.util.ArrayList;
import static java.util.Arrays.asList;

/**
 *
 * @author Usuario
 */
public class Matrices {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.setVisible(true);
//        ArrayList<ArrayList<Double>> matrix = new ArrayList<>();
//        
//        matrix.add(new ArrayList<>(asList(5.0, 1.0, 1.0, 1.0)));
//        matrix.add(new ArrayList<>(asList(1.0, 5.0, 1.0, 1.0)));
//        matrix.add(new ArrayList<>(asList(1.0, 1.0, 5.0, 1.0)));
//        matrix.add(new ArrayList<>(asList(1.0, 2.0, 1.0, 5.0)));
//
//        
//        Determinante det = new Determinante();
//        System.out.println(det.calculateDeterminant(matrix));
//        Utilidades.printMatrix(matrix);
//        
//        Inversor inv = new Inversor();
//        inv.invertMatrix(matrix);
//        Utilidades.printMatrix(matrix);
//        
//        MultEscalar esc = new MultEscalar();
//        esc.multiplyMatrixByScalar(matrix, 32);
//        Utilidades.printMatrix(matrix);
//        
//        Sumador sum = new Sumador();
//        matrix = new ArrayList<>(sum.sumarMatrices(matrix, matrix));
//        Utilidades.printMatrix(matrix);
//        
//        Trasponedor tras = new Trasponedor();
//        tras.trasposeMatrix(matrix);
//        Utilidades.printMatrix(matrix);
//        
//        MultMatricial mat = new MultMatricial();
//        matrix = mat.matrixMultiplication(matrix, matrix);
//        Utilidades.printMatrix(matrix);
//        
//        for (int i = 0; i < matrix.size(); i++) {
//            matrix.get(i).add(1.0);
//        }
//        Utilidades.printMatrix(matrix);
//        
//        Solucionador sol = new Solucionador();
//        sol.solucionar(matrix);
//        Utilidades.printMatrix(matrix);
    }
    
}
