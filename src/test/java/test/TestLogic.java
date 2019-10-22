package test;

import static org.junit.Assert.assertEquals;
import com.crudsa.ju.Calculo;
import org.junit.Test;  

public class TestLogic {
    @Test  
    public void testFindMax(){  
        assertEquals(4,Calculo.findMax(new int[]{1,3,4,2}));  
        assertEquals(-1,Calculo.findMax(new int[]{-12,-1,-3,-4,-2}));  
    }  
}
