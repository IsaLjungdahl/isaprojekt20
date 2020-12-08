package wardrobe;

import org.junit.jupiter.api.Test;

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
        
    }
}
