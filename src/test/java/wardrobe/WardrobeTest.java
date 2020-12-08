package wardrobe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WardrobeTest {

    private final Wardrobe wardrobe = new Wardrobe();

    @Test
    public void doesWardrobeExist() {
        Wardrobe wardrobe= new Wardrobe();
        assertTrue(wardrobe.exists());
    }
    @Test
    public void doesmethodToOptimizeWardrobeExists(){
        Wardrobe wardrobe=new Wardrobe();
        assertTrue(wardrobe.wardrobeMaker());
    }
    @Test
    public void wardRobeMakerReturnsInt(){
        Wardrobe wardrobe=new Wardrobe();
        int wall=250;
        assertEquals(250,wardrobe.wardrobeMaker(wall));
    }
    @Test
    public void howMany50cmFits(){
        int element=50;

        assertEquals(5, wardrobe.wardrobeMaker(element));
    }
    @Test
    public void howMany75cmFits(){
        double element=75;

        assertEquals(3.3333333333333335, wardrobe.wardrobeMaker(element));
    }
}
