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
                    ControladorMatrizUnica controladorMatrizUnicaInversa = new ControladorMatrizUnica("Obtener Inversa");
                    break;

                case "Multiplicacion por Escalar":
                    ControladorMatrizEscalar controladorMatrizEscalar = new ControladorMatrizEscalar();
                    break;

                case "Multiplicacion Matricial":
                    ControladorMatrizDoble controladorMatrizDobleMultMatricial = new ControladorMatrizDoble("Multiplicacion Matricial"); 
                    break;

                case "Obtener Transpuesta":
                    ControladorMatrizUnica controladorMatrizUnicaTranspuesta = new ControladorMatrizUnica("Obtener Transpuesta");
                    break;

                case "Suma de Matrices":
                    
                    ControladorMatrizDoble controladorMatrizDobleSumMatricial = new ControladorMatrizDoble("Suma de Matrices");
                    break;
                case "Obtener Determinante":
                    ControladorMatrizUnica controladorMatrizUnicaDeterminante = new ControladorMatrizUnica("Obtener Determinante");
                    break;
                
                case "Solucionar Sistema":
                    ControladorMatrizUnica controladorMatrizUnicaResolver = new ControladorMatrizUnica("Solucionar Sistema");
                    break;
                default:
                    break;
            }
        }
    }   
}
