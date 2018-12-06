/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rosa
 */
public class DeterminanteTest {
    
    public DeterminanteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calculateDeterminant method, of class Determinante.
     */
    @Test
    public void testCalculateDeterminant() {
        System.out.println("calculateDeterminant");
        ArrayList<ArrayList<Double>> matrix = new ArrayList<ArrayList<Double>>();
        ArrayList<Double> array1 = new ArrayList<Double>();
        ArrayList<Double> array2 = new ArrayList<Double>();
        array1.add(1.0);
        array1.add(2.0);
        array2.add(1.0);
        array2.add(2.0);
        matrix.add(array1);
        matrix.add(array2);
        Determinante instance = new Determinante();
        double expResult = 0.0;
        double result = instance.calculateDeterminant(matrix);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        if(result!=expResult){
            fail("The test case is a prototype.");
        }
        
    }
    
}
