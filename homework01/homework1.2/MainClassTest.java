import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass{

    @Test
    public void testGetLocalNumber() {

        Assert.assertTrue("число меньше 45", this.getClassNumber() > 45);
    }

}
