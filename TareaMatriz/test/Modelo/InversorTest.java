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
public class InversorTest {
    
    public InversorTest() {
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
     * Test of invertMatrix method, of class Inversor.
     */
    @Test
    public void testInvertMatrix() {
        System.out.println("invertMatrix");
        ArrayList<ArrayList<Double>> matrix = new ArrayList<ArrayList<Double>>();
        ArrayList<Double> array1 = new ArrayList<Double>();
        ArrayList<Double> array2 = new ArrayList<Double>();
        array1.add(1.0);
        array1.add(1.0);
        array2.add(2.0);
        array2.add(1.0);
        matrix.add(array1);
        matrix.add(array2);
        
        Inversor instance = new Inversor();
        ArrayList<ArrayList<Double>> expResult = new ArrayList<ArrayList<Double>>();
        ArrayList<Double> arrayExp = new ArrayList<Double>();
        ArrayList<Double> arrayExp2 = new ArrayList<Double>();
        arrayExp.add(-1.0);
        arrayExp.add(1.0);
        arrayExp2.add(2.0);
        arrayExp2.add(-1.0);
        expResult.add(arrayExp);
        expResult.add(arrayExp2);
        ArrayList<ArrayList<Double>> result = instance.invertMatrix(matrix);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(!result.equals(expResult)){
            fail("The test case is a prototype.");
        }
        
    }
    
}
