/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Inversor;
import Modelo.Trasponedor;
import Vista.MatrizDoble;
import Vista.MatrizEscalar;
import Vista.MatrizUnica;
import Vista.Menu;
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
    private MatrizUnica vistaMatrizUnica;
    private int filas;
    private int columnas;
    private String tipo;

        
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
            columnas = Integer.parseInt(vistaMatrizUnica.getjTextColumnas().getText());
            filas = Integer.parseInt(vistaMatrizUnica.getjTextFilas().getText());

            DefaultTableModel model = new DefaultTableModel(filas, columnas);
            vistaMatrizUnica.getjTable1().setShowGrid(true);
            vistaMatrizUnica.getjTable1().getTableHeader().setUI(null);
            vistaMatrizUnica.getjTable1().setModel(model);

            vistaMatrizUnica.getjLabelNotificacion().setText("Importante rellenar la matriz!");
            vistaMatrizUnica.getjButtonAceptar().setVisible(true);


            }
        if(vistaMatrizUnica.getjButtonAceptar()== e.getSource()){
            if(this.tipo.equals("Obtener Inversa")){

                ArrayList<ArrayList<Double>> matriz = new ArrayList();


            for (int i = 0; i < filas; i++) {

                ArrayList<Double> numeros = new ArrayList();
                for (int j = 0; j < columnas; j++) {

                     Double numero = Double.parseDouble(vistaMatrizUnica.getjTable1().getModel().getValueAt(i, j).toString());

                    numeros.add(numero);
                }

                matriz.add(numeros);
            }

                Inversor inversor = new Inversor();
                ArrayList<ArrayList<Double>> matrizFinal = new ArrayList();
                matrizFinal = inversor.invertMatrix(matriz);
                ResultadoMatriz resultado = new ResultadoMatriz(matrizFinal);

                resultado.setVisible(true);

            } else if(this.tipo.equals("Obtener Transpuesta")){
                ArrayList<ArrayList<Double>> matriz = new ArrayList();
                try{

                for (int i = 0; i < filas; i++) {

                ArrayList<Double> numeros = new ArrayList();
                for (int j = 0; j < columnas; j++) {

                     Double numero = Double.parseDouble(vistaMatrizUnica.getjTable1().getModel().getValueAt(i, j).toString());

                    numeros.add(numero);
                }

                matriz.add(numeros);
            } 

                }catch(NullPointerException exception){

                }

                Trasponedor trasponedor = new Trasponedor();
                ArrayList<ArrayList<Double>> matrizFinal = new ArrayList();
                matrizFinal = trasponedor.trasposeMatrix(matriz);
                ResultadoMatriz resultado = new ResultadoMatriz(matrizFinal);

                resultado.setVisible(true);
            }
        }
    } 
}
