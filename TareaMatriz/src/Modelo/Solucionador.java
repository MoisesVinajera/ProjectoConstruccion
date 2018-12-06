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
public class Solucionador {
    public ArrayList<ArrayList<Double>> solucionar(ArrayList<ArrayList<Double>> matrix){
        ArrayList<ArrayList<Double>> copia = new ArrayList<>();
        
        //Inicializando copia.
        for (int fila = 0; fila < matrix.size(); fila++) {
            copia.add(new ArrayList<>());
            for (int columna = 0; columna < matrix.get(fila).size() - 1; columna++) {
                copia.get(fila).add(matrix.get(fila).get(columna));
            }
        }
        
        //Se evalúa si el sistema tiene solución.
        if(!Utilidades.isSquaredDoubleMatrix(copia)){
            throw new NumberFormatException("La matriz de incógnitas no es cuadrada. "
                    + "El sistema no tiene solución.");
        }
        
        if(Utilidades.isDeterminatCero(copia)){
            throw new NumberFormatException("La matriz no tiene inversa. "
                    + "El sistema no tiene solución.");
        }
        
        //Se hallan las soluciones.
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
    
    // al aplicar la metrica se obtiene que ((2+2+2)+(0+0))=6

}
