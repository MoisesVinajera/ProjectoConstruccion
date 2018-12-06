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
public class MultEscalarTest {
    
    public MultEscalarTest() {
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
     * Test of multiplyMatrixByScalar method, of class MultEscalar.
     */
    @Test
    public void testMultiplyMatrixByScalar() {
        System.out.println("multiplyMatrixByScalar");
        ArrayList<ArrayList<Double>> matrix = new ArrayList<ArrayList<Double>>();
        ArrayList<Double> array1 = new ArrayList<Double>();
        ArrayList<Double> array2 = new ArrayList<Double>();
        array1.add(1.0);
        array1.add(1.0);
        array2.add(1.0);
        array2.add(1.0);
        matrix.add(array1);
        matrix.add(array2);
        double escalar = 2;
        
        MultEscalar instance = new MultEscalar();
        ArrayList<ArrayList<Double>> expResult = new ArrayList<ArrayList<Double>>();
        ArrayList<Double> arrayExp = new ArrayList<Double>();
        ArrayList<Double> arrayExp2 = new ArrayList<Double>();
        arrayExp.add(2.0);
        arrayExp.add(2.0);
        arrayExp2.add(2.0);
        arrayExp2.add(2.0);
        expResult.add(arrayExp);
        expResult.add(arrayExp2);
        
        ArrayList<ArrayList<Double>> result = instance.multiplyMatrixByScalar(matrix, escalar);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(!result.equals(expResult)){
            fail("The test case is a prototype.");
        }
    }

    /**
     * Test of multiplyRowByScalar method, of class MultEscalar.
     */
    @Test
    public void testMultiplyRowByScalar() {
        System.out.println("multiplyRowByScalar");
        ArrayList<Double> row = new ArrayList<Double>();
        row.add(1.0);
        row.add(1.0);
        double escalar = 2;
        ArrayList<Double> expResult = new ArrayList<Double>();
        expResult.add(2.0);
        expResult.add(2.0);     
        ArrayList<Double> result = MultEscalar.multiplyRowByScalar(row, escalar);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(!result.equals(expResult)){
            fail("The test case is a prototype.");
        }
    }
    
}
