/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.MatrizDoble;
import Vista.MatrizEscalar;
import Vista.MatrizUnica;
import Vista.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Moises
 */
public class ControladorMenu implements ActionListener {
    private Menu menu = new Menu();
    
        
    public ControladorMenu(){
        menu.setVisible(true);
        this.menu.getjButtonAceptar().addActionListener(this);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(menu.getjButtonAceptar()== e.getSource()){
            switch(menu.getjComboBox1().getSelectedItem().toString()){
                case "Obtener Inversa":
                    ControladorMatrizUnica controladorMatrizUnica = new ControladorMatrizUnica("Obtener Inversa");
                    break;

                case "Multiplicacion por Escalar":
                    MatrizEscalar vistaEscalar = new MatrizEscalar();
                    vistaEscalar.setVisible(true);
                    break;

                case "Multiplicacion Matricial":
                    MatrizDoble vistaMulMatricial = new MatrizDoble("Multiplicacion Matricial");
                    vistaMulMatricial.setVisible(true);
                    break;

                case "Obtener Transpuesta":
                    MatrizUnica vistaTranspuesta = new MatrizUnica("Obtener Transpuesta");
                    vistaTranspuesta.setVisible(true);
                    break;

                case "Suma de Matrices":
                    MatrizDoble vistaSuma = new MatrizDoble("Suma de Matrices");
                    vistaSuma.setVisible(true);
                    break;

                default:
                    break;
            }
        }
    }   
}
