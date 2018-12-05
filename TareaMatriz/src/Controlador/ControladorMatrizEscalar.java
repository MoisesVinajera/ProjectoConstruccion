/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.MultEscalar;
import Vista.MatrizEscalar;
import Vista.ResultadoMatriz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Moises
 */
public class ControladorMatrizEscalar implements ActionListener{
    private MatrizEscalar vistaMatrizEscalar;
    private int filas;
    private int columnas;
    private double escalar;
    
    public ControladorMatrizEscalar(){
        vistaMatrizEscalar = new MatrizEscalar();
        
        vistaMatrizEscalar.setVisible(true);
        this.vistaMatrizEscalar.getjButtonAplicar().addActionListener(this);
        this.vistaMatrizEscalar.getjButtonAceptar().addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(vistaMatrizEscalar.getjButtonAplicar()== e.getSource()){
            columnas = Integer.parseInt(vistaMatrizEscalar.getjTextColumnas().getText());
            filas = Integer.parseInt(vistaMatrizEscalar.getjTextFilas().getText());
            escalar = Double.parseDouble(vistaMatrizEscalar.getjTextEscalar().getText());

            DefaultTableModel model = new DefaultTableModel(filas, columnas);
            vistaMatrizEscalar.getjTable1().setShowGrid(true);
            vistaMatrizEscalar.getjTable1().getTableHeader().setUI(null);
            vistaMatrizEscalar.getjTable1().setModel(model);

            vistaMatrizEscalar.getjLabelNotificacion().setText("Importante rellenar la matriz!");
            vistaMatrizEscalar.getjButtonAceptar().setVisible(true);
        }
        if(vistaMatrizEscalar.getjButtonAceptar()== e.getSource()){
            ArrayList<ArrayList<Double>> matriz = formMatrix();

            MultEscalar mulEscalar = new MultEscalar();
            ArrayList<ArrayList<Double>> matrizFinal = new ArrayList();
            matrizFinal = mulEscalar.multiplyMatrixByScalar(matriz, escalar);
            ResultadoMatriz resultado = new ResultadoMatriz(matrizFinal);
            resultado.setVisible(true);
        }
    }
    
    private ArrayList<ArrayList<Double>> formMatrix(){
        ArrayList<ArrayList<Double>> matriz = new ArrayList();
        try{
            for (int i = 0; i < filas; i++) {
                ArrayList<Double> numeros = new ArrayList();
                for (int j = 0; j < columnas; j++) {
                    Double numero = Double.parseDouble(vistaMatrizEscalar.getjTable1().getModel().getValueAt(i, j).toString());
                    numeros.add(numero);
                }
                matriz.add(numeros);
            } 
        }catch(NullPointerException exception){

        }
        return matriz;
    }
}
