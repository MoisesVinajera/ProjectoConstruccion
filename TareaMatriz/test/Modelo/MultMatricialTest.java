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
public class MultMatricialTest {
    
    public MultMatricialTest() {
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
     * Test of matrixMultiplication method, of class MultMatricial.
     */
    @Test
    public void testMatrixMultiplication() {
        System.out.println("matrixMultiplication");
        
        ArrayList<ArrayList<Double>> matrizA = new ArrayList<ArrayList<Double>>();
        ArrayList<Double> array1 = new ArrayList<Double>();
        ArrayList<Double> array2 = new ArrayList<Double>();
        array1.add(10.0);
        array1.add(1.0);
        array2.add(10.0);
        array2.add(1.0);
        matrizA.add(array1);
        matrizA.add(array2);
        
        ArrayList<ArrayList<Double>> matrizB = new ArrayList<ArrayList<Double>>();
        ArrayList<Double> array1B = new ArrayList<Double>();
        ArrayList<Double> array2B = new ArrayList<Double>();
        array1B.add(10.0);
        array1B.add(1.0);
        array2B.add(10.0);
        array2B.add(1.0);
        matrizB.add(array1B);
        matrizB.add(array2B);
        
        MultMatricial instance = new MultMatricial();
        ArrayList<ArrayList<Double>> expResult = new ArrayList<ArrayList<Double>>();
        ArrayList<Double> array1expResult = new ArrayList<Double>();
        ArrayList<Double> array2expResult = new ArrayList<Double>();
        array1expResult.add(110.0);
        array1expResult.add(11.0);
        array2expResult.add(110.0);
        array2expResult.add(11.0);
        expResult.add(array1expResult);
        expResult.add(array2expResult);
        ArrayList<ArrayList<Double>> result = instance.matrixMultiplication(matrizA, matrizB);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(!result.equals(expResult)){
            fail("The test case is a prototype.");
        }
    }
    
}
