/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Determinante;
import Modelo.Inversor;
import Modelo.Solucionador;
import Modelo.Trasponedor;
import Vista.MatrizUnica;
import Vista.ResultadoMatriz;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Moises
 */
public class ControladorMatrizUnica implements ActionListener{
    private final MatrizUnica vistaMatrizUnica;
    private int filas;
    private int columnas;
    private final String tipo;

        
    public ControladorMatrizUnica(String tipo){
        vistaMatrizUnica = new MatrizUnica();
        this.tipo = tipo;
        vistaMatrizUnica.setVisible(true);
        this.vistaMatrizUnica.getjButtonAplicar().addActionListener(this);
        this.vistaMatrizUnica.getjButtonAceptar().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(vistaMatrizUnica.getjButtonAplicar()== e.getSource()){
            
            takeValuesWindow();
            showTable();
            vistaMatrizUnica.getjLabelNotificacion().setText("Importante rellenar la matriz!");
            vistaMatrizUnica.getjButtonAceptar().setVisible(true);
            
            }
        if(vistaMatrizUnica.getjButtonAceptar()== e.getSource()){
            
            ArrayList<ArrayList<Double>> matriz = formMatrix();
            ResultadoMatriz resultado;
            ArrayList<ArrayList<Double>> matrizFinal = new ArrayList();
            
            switch (this.tipo) {
                case "Obtener Inversa":
                    matrizFinal = new Inversor().invertMatrix(matriz);
                    break;
                case "Obtener Transpuesta":
                    matrizFinal = new Trasponedor().trasposeMatrix(matriz);
                    break;
                case "Obtener Determinante":
                    ArrayList<Double> placeHolder = new ArrayList();
                    placeHolder.add(new Determinante().calculateDeterminant(matriz));
                    matrizFinal.add(placeHolder);
                    break;
                case "Solucionar Sistema":
                    matrizFinal = new Solucionador().solucionar(matriz);
                    break;
                default:
                    break;
            }
            
            resultado = new ResultadoMatriz(matrizFinal);
            resultado.setVisible(true);
        }
    }
    
    private ArrayList<ArrayList<Double>> formMatrix(){
        ArrayList<ArrayList<Double>> matriz = new ArrayList();
        try{
            for (int i = 0; i < filas; i++) {
                ArrayList<Double> fila = new ArrayList();
                for (int j = 0; j < columnas; j++) {
                    Double numero = Double.parseDouble(vistaMatrizUnica.getjTable1().getModel().getValueAt(i, j).toString());
                    fila.add(numero);
                }
                matriz.add(fila);
            } 
        }catch(NullPointerException exception){

        }
        return matriz;
    }
    private void takeValuesWindow(){
        columnas = Integer.parseInt(vistaMatrizUnica.getjTextColumnas().getText());
        filas = Integer.parseInt(vistaMatrizUnica.getjTextFilas().getText());
    }
    
    private void showTable(){
        DefaultTableModel model = new DefaultTableModel(filas, columnas);
        vistaMatrizUnica.getjTable1().setShowGrid(true);
        vistaMatrizUnica.getjTable1().getTableHeader().setUI(null);
        vistaMatrizUnica.getjTable1().setModel(model);
    }
}
