import de.bautzsoftwareengineering.Encoder;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tim Bautz Softwareengineering
 * tim@bautz-softwareengineering.de
 * Date: 24.04.13
 * Time: 19:16
 */
public class EncoderTest {


    @Test
    public void correctlyEncodesInput1() {
        String input1 = "bcd";
        assertEquals("ABC",new Encoder().encode(input1) );
    }

    @Test
    public void correctlyEncodesInput2() {
        String input2 = "abcwxy";
        assertEquals("NABXYZ", new Encoder().encode(input2));
    }


    @Test
    public void correctlyEncodesInput3() {
        String input3 = "Wir wollen Euch testen und sind sehr gespannt auf die Antworten. Hoffentlich sind es mehr als 2.";
        assertEquals("yHS XPKKDM cVBG UDTUDM VMC THMC TDGS FDTQNMMU NVE CHD mMUXPSUDM. fPEEDMUKHBG THMC DT LDGS NKT 2.", new Encoder().encode(input3));
    }





}
