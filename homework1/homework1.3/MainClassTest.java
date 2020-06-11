import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends MainClass{

    @Test
    public void testGetClassString() {


Assert.assertTrue("Строка не содержит Hello или hello",this.getClassString().contains("hello")||this.getClassString().contains("Hello"));
    }

}
