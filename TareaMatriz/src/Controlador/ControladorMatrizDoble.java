/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.MultMatricial;
import Modelo.Sumador;
import Vista.MatrizDoble;
import Vista.ResultadoMatriz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Moises
 */
public class ControladorMatrizDoble implements ActionListener{
    private MatrizDoble vistaMatrizDoble;
    private int MatrizAcolumnas;
    private int MatrizAfilas;
    private int MatrizBcolumnas;
    private int MatrizBfilas;
    private String tipo;
    
    public ControladorMatrizDoble(String tipo){
        vistaMatrizDoble = new MatrizDoble(tipo);
        this.tipo = tipo;
        vistaMatrizDoble.setVisible(true);
        this.vistaMatrizDoble.getjButtonAplicar().addActionListener(this);
        this.vistaMatrizDoble.getjButtonAceptar().addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if(vistaMatrizDoble.getjButtonAplicar()== e.getSource()){
            this.MatrizAcolumnas = Integer.parseInt(vistaMatrizDoble.getjTextMatriz1Columna().getText());
            this.MatrizAfilas = Integer.parseInt(vistaMatrizDoble.getjTextMatriz1Fila().getText());
            this.MatrizBcolumnas = Integer.parseInt(vistaMatrizDoble.getjTextMatriz2Columna().getText());
            this.MatrizBfilas = Integer.parseInt(vistaMatrizDoble.getjTextMatriz2Fila().getText());

            DefaultTableModel model = new DefaultTableModel(this.MatrizAfilas, this.MatrizAcolumnas);
            vistaMatrizDoble.getjTable1().setShowGrid(true);
            vistaMatrizDoble.getjTable1().getTableHeader().setUI(null);
            vistaMatrizDoble.getjTable1().setModel(model);

            DefaultTableModel model2 = new DefaultTableModel(this.MatrizBfilas, this.MatrizBcolumnas);
            vistaMatrizDoble.getjTable2().setShowGrid(true);
            vistaMatrizDoble.getjTable2().getTableHeader().setUI(null);
            vistaMatrizDoble.getjTable2().setModel(model2);

            vistaMatrizDoble.getjLabelNotificacion().setText("Importante rellenar la matriz!");
            vistaMatrizDoble.getjButtonAceptar().setVisible(true);
        }
        if(vistaMatrizDoble.getjButtonAceptar()== e.getSource()){
            // Matriz 1
            ArrayList<ArrayList<Double>> matriz = new ArrayList();
            try{
             for (int i = 0; i < MatrizAfilas; i++) {

                ArrayList<Double> numeros = new ArrayList();

                for (int j = 0; j < MatrizAcolumnas; j++) {
                    System.out.println(i + "   " + j);
                    Double numero = Double.parseDouble(vistaMatrizDoble.getjTable1().getModel().getValueAt(i, j).toString());

                    numeros.add(numero);
                }

                matriz.add(numeros);

            }
            }catch(Exception exception){

            }

            // Matriz 2
            ArrayList<ArrayList<Double>> matriz2 = new ArrayList();
            try{
             for (int i = 0; i < MatrizBfilas; i++) {

                ArrayList<Double> numeros = new ArrayList();

                for (int j = 0; j < MatrizBcolumnas; j++) {
                    System.out.println(i + "   " + j);
                    Double numero = Double.parseDouble(vistaMatrizDoble.getjTable2().getModel().getValueAt(i, j).toString());

                    numeros.add(numero);
                }

                matriz2.add(numeros);

            }
            }catch(Exception exception){

            }

            ArrayList<ArrayList<Double>> matrizFinal = new ArrayList();
            if(this.tipo.equals("Multiplicacion Matricial")){
                MultMatricial mulMatricial = new MultMatricial();
                matrizFinal = mulMatricial.matrixMultiplication(matriz, matriz2);
                ResultadoMatriz resultado = new ResultadoMatriz(matrizFinal);
                resultado.setVisible(true);

            } else if(this.tipo.equals("Suma de Matrices")){
                Sumador sumador = new Sumador();
                matrizFinal = sumador.sumarMatrices(matriz, matriz2);
                ResultadoMatriz resultado = new ResultadoMatriz(matrizFinal);
                resultado.setVisible(true); 
                System.out.println(matrizFinal);
            }
        }
    }   

}
