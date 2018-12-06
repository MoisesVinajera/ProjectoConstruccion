package Modelo;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Stamp
 */
public class Utilidades {

    /**
     *
     * @return
     */
    public static int inputToInt(){
        Scanner scanner = new Scanner(System.in);
        boolean numeroValido = false;
        int entero = 0;
        
        while (!numeroValido){
            try{
                entero = Integer.valueOf(scanner.nextLine());
                numeroValido = true;
            }catch(NumberFormatException e){
                System.out.println("Formato de número inválido. Ingréselo de nuevo.");
            }
        }
        
        return entero;
        
    }
    
    /**
     *
     * @param limInf
     * @param limSup
     * @return
     */
    public static int inputToInt(int limInf, int limSup){
        Scanner scanner = new Scanner(System.in);
        boolean numeroValido = false;
        int entero = 0;
        
        while (!numeroValido){
            try{
                entero = Integer.valueOf(scanner.nextLine());
                numeroValido = true;
                if(entero < limInf || entero > limSup){
                    System.out.println("Numero fuera de rango, ingréselo de nuevo:");
                    numeroValido = false;
                }
            }catch(NumberFormatException e){
                System.out.println("Formato de número inválido. Ingréselo de nuevo:");
            }
        }
        return entero;
    }
    
    /**
     *
     * @param input
     * @return
     */
    public static boolean checkDouble(String input){
        boolean numeroValido = false;
        double doble = 0;
        
        try{
            doble = Double.parseDouble(input);
            numeroValido = true;
        }catch(NumberFormatException e){
            numeroValido = false;
        }
        return numeroValido;
    }
    
    /**
     *
     * @param input
     * @return
     */
    public static double toDouble(String input){
        double doble = 0;
        
        try{
            doble = Double.parseDouble(input);
        }catch(NumberFormatException e){
            throw new NumberFormatException("Imposible convertir "
                    + input + " a double.");
        }
        
        return doble;
    }
    
    /**
     *
     * @param stringMatrix
     * @return
     */
    public static ArrayList<ArrayList<Double>>stringToDoubleMatrix(ArrayList<ArrayList<String>> stringMatrix){
        ArrayList<ArrayList<Double>> doubleMatrix = new ArrayList<>();
        
        int filas = stringMatrix.size();
        int columnas = stringMatrix.get(0).size();
        
        for(int i = 0; i < filas; i++){
            doubleMatrix.add(new ArrayList<>());
            for (int j = 0; j < columnas; j++) {
                doubleMatrix.get(i).add(Utilidades.toDouble(stringMatrix.get(i).get(j)));
            }
        }
        
        return doubleMatrix;
    }
    
    /**
     *
     * @param matrix
     * @return
     */
    public static boolean isSquaredStringMatrix(ArrayList<ArrayList<String>> matrix){
        return matrix.size() == matrix.get(0).size();
    }
    
    /**
     *
     * @param matrix
     * @return
     */
    public static boolean isSquaredDoubleMatrix(ArrayList<ArrayList<Double>> matrix){
        return matrix.size() == matrix.get(0).size();
    }
    
    /**
     *
     * @param matrix
     */
    public static void printMatrix(ArrayList<ArrayList<Double>> matrix){
        System.out.println("");
        NumberFormat format = new DecimalFormat("#0.0000");
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(0).size(); j++) {
                System.out.print(format.format(matrix.get(i).get(j)) + "\t");
            }
            System.out.println("");
        }
    }
    
    /**
     *
     * @param matrix
     * @return
     */
    public static boolean isDeterminatCero(ArrayList<ArrayList<Double>> matrix){
        Determinante det = new Determinante();
        return det.calculateDeterminant(matrix) == 0;
    }
    
    /**
     *
     * @param matrizA
     * @param matrizB
     * @return
     */
    public static boolean diferentSizeColARowB(ArrayList<ArrayList<Double>> matrizA, ArrayList<ArrayList<Double>> matrizB){
        return matrizA.get(0).size() != matrizB.size();
    }
    
    /**
     *
     * @param matrixA
     * @param matrixB
     * @return
     */
    public static boolean diferentSizeMatrix(ArrayList<ArrayList<Double>> matrixA, ArrayList<ArrayList<Double>> matrixB){
        return matrixA.size() != matrixB.size() || matrixA.get(0).size() != matrixB.get(0).size();
    }
    
    /**
     *
     * @param row
     * @param substracting
     * @return
     */
    public static boolean diferentSizeElement(ArrayList<Double> row, ArrayList<Double> substracting){
        return row.size() != substracting.size();
    }
}
