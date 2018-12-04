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
public class MultMatricial {
     //Metrica medición de número de nodos
        //En la función descompusimos el diagrama de flujo de la función en 2 diagramas de flujo, un prime y uno aniddo compuesto 
        // por 2 primes
        //diagrama f1 tipo prime y el diagrama f2(f3) que es un diagrama anidado
        // para medir la cantidad de nodos n(f1, f2(f3)) = n(f1) + n(f2(f3))-2 + 1
        //n(f1) = 4
    public ArrayList<ArrayList<Double>> multMatricial(ArrayList<ArrayList<Double>> matrizA, ArrayList<ArrayList<Double>> matrizB){
        if(Utilidades.areDiferentSizeColumnARowB(matrizA,matrizB)){
            throw new NumberFormatException("Multiplicación imposible, los tamaños no coinciden.");
        }
        //n(f3) = 3, n(f2) = 4
        //n(f2(f3)) = 4 - 3 -2(1) = 5
        // n(f1, f2(f3)) = n(f1) + n(f2(f3))-3 = 4 + 5 -2  + 1= 8
        // otra forma de llegar al resultado es solo sumar los nodos de cada prime
        //n(f1, f2, f3) = 4 + 4 +3 -3 +1
        ArrayList<ArrayList<Double>> resultado = new ArrayList<>();
        
        for (int i = 0; i < matrizA.get(0).size(); i++) {
            resultado.add(new ArrayList<Double>());
            for (int j = 0; j < matrizB.size(); j++) {
                resultado.get(i).add(matrizA.get(i).get(j)*matrizB.get(j).get(i));
            }
        }
        
        return resultado;
    }
    
}
