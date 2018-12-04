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
    public static int toInt(){
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
    
    
    public static int toInt(int limInf, int limSup){
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
    
    
    public static int toPostiveInt(){
        Scanner scanner = new Scanner(System.in);
        boolean numeroValido = false;
        int entero = 0;
        
        while (!numeroValido){
            try{
                entero = Integer.valueOf(scanner.nextLine());
                numeroValido = true;
                if(entero <= 0){
                    System.out.println("Numero fuera de rango, ingréselo de nuevo:");
                    numeroValido = false;
                }
            }catch(NumberFormatException e){
                System.out.println("Formato de número inválido. Ingréselo de nuevo:");
            }
        }
        return entero;
    }
    
    public static boolean checkDoubleIn(String input){
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
    
    public static double toDoubleIn(String input){
        double doble = 0;
        
        try{
            doble = Double.parseDouble(input);
        }catch(NumberFormatException e){
            throw new NumberFormatException("Imposible convertir "
                    + input + " a double.");
        }
        
        return doble;
    }
    
    public static ArrayList<ArrayList<Double>>toDouble(ArrayList<ArrayList<String>> stringMatrix){
        ArrayList<ArrayList<Double>> doubleMatrix = new ArrayList<>();
        
        int filas = stringMatrix.size();
        int columnas = stringMatrix.get(0).size();
        
        for(int i = 0; i < filas; i++){
            doubleMatrix.add(new ArrayList<>());
            for (int j = 0; j < columnas; j++) {
                doubleMatrix.get(i).add(Utilidades.toDoubleIn(stringMatrix.get(i).get(j)));
            }
        }
        
        return doubleMatrix;
    }
    
    public static boolean isSquaredStringMatrix(ArrayList<ArrayList<String>> matrix){
        return matrix.size() == matrix.get(0).size();
    }
    
    public static boolean isSquaredDoubleMatrix(ArrayList<ArrayList<Double>> matrix){
        return matrix.size() == matrix.get(0).size();
    }
    
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
}
