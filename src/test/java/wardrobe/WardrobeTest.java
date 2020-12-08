package wardrobe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WardrobeTest {
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
}
