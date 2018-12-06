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
import javax.swing.JTable;
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
        vistaMatrizDoble = new MatrizDoble();
        this.tipo = tipo;
        vistaMatrizDoble.setVisible(true);
        this.vistaMatrizDoble.getjButtonAplicar().addActionListener(this);
        this.vistaMatrizDoble.getjButtonAceptar().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(vistaMatrizDoble.getjButtonAplicar()== e.getSource()){
            takeValues();
            showTableA();
            showTableB();

            vistaMatrizDoble.getjLabelNotificacion().setText("Importante rellenar la matriz!");
            vistaMatrizDoble.getjButtonAceptar().setVisible(true);
        }
        if(vistaMatrizDoble.getjButtonAceptar()== e.getSource()){
            ArrayList<ArrayList<Double>> matriz = formMatrix(vistaMatrizDoble.getjTable1());
            ArrayList<ArrayList<Double>> matriz2 = formMatrix(vistaMatrizDoble.getjTable2());
            ArrayList<ArrayList<Double>> matrizFinal = new ArrayList();
            
            if(this.tipo.equals("Multiplicacion Matricial")){
                matrizFinal = new MultMatricial().matrixMultiplication(matriz, matriz2);
            }
            else if(this.tipo.equals("Suma de Matrices")){
                matrizFinal = new Sumador().sumarMatrices(matriz, matriz2);
            }
            
            ResultadoMatriz resultado = new ResultadoMatriz(matrizFinal);
            resultado.setVisible(true);
        }
    }   
    
    private ArrayList<ArrayList<Double>> formMatrix(JTable table){
        ArrayList<ArrayList<Double>> matrix = new ArrayList();
        try{
            for (int i = 0; i < MatrizBfilas; i++) {
                ArrayList<Double> fila = new ArrayList();
                for (int j = 0; j < MatrizBcolumnas; j++) {
                    Double numero = Double.parseDouble(table.getModel().getValueAt(i, j).toString());

                    fila.add(numero);
                }
                matrix.add(fila);
            }
        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }
        return matrix;
    }
    
    private void takeValues(){
            this.MatrizAcolumnas = Integer.parseInt(vistaMatrizDoble.getjTextMatriz1Columna().getText());
            this.MatrizAfilas = Integer.parseInt(vistaMatrizDoble.getjTextMatriz1Fila().getText());
            this.MatrizBcolumnas = Integer.parseInt(vistaMatrizDoble.getjTextMatriz2Columna().getText());
            this.MatrizBfilas = Integer.parseInt(vistaMatrizDoble.getjTextMatriz2Fila().getText());
    }
    
    private void showTableA(){
            DefaultTableModel model = new DefaultTableModel(this.MatrizAfilas, this.MatrizAcolumnas);
            vistaMatrizDoble.getjTable1().setShowGrid(true);
            vistaMatrizDoble.getjTable1().getTableHeader().setUI(null);
            vistaMatrizDoble.getjTable1().setModel(model);
    }
    private void showTableB(){
            DefaultTableModel model2 = new DefaultTableModel(this.MatrizBfilas, this.MatrizBcolumnas);
            vistaMatrizDoble.getjTable2().setShowGrid(true);
            vistaMatrizDoble.getjTable2().getTableHeader().setUI(null);
            vistaMatrizDoble.getjTable2().setModel(model2);
    }
}