import de.bautzsoftwareengineering.DynamicallyConfigurableEncoder;
import de.bautzsoftwareengineering.Encoder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tim Bautz Softwareengineering
 * tim@bautz-softwareengineering.de
 * Date: 24.04.13
 * Time: 19:16
 */
public class DynamicallyConfigurableEncoderTest {

    private String input1 =  "bcd";
    private String input2 =  "abcwxy";
    private String input3 =  "Wir wollen Euch testen und sind sehr gespannt auf die Antworten. Hoffentlich sind es mehr als 2.";
    private String output1 = "ABC";
    private String output2 = "NABXYZ";
    private String output3 = "yHS XPKKDM cVBG UDTUDM VMC THMC TDGS FDTQNMMU NVE CHD mMUXPSUDM. fPEEDMUKHBG THMC DT LDGS NKT 2.";


    private DynamicallyConfigurableEncoder encoder;

    @Before
    public void setup() {
        encoder = new DynamicallyConfigurableEncoder();
        encoder.addEncoding(input1, output1);
        encoder.addEncoding(input2, output2);
        encoder.addEncoding(input3, output3);
    }

    @Test
    public void correctlyEncodesInput1() {
        String input1 = "bcd";
        assertEquals("ABC", encoder.encode(input1));
    }

    @Test
    public void correctlyEncodesInput2() {
        String input2 = "abcwxy";
        assertEquals("NABXYZ", encoder.encode(input2));
    }


    @Test
    public void correctlyEncodesInput3() {
        String input3 = "Wir wollen Euch testen und sind sehr gespannt auf die Antworten. Hoffentlich sind es mehr als 2.";
        assertEquals("yHS XPKKDM cVBG UDTUDM VMC THMC TDGS FDTQNMMU NVE CHD mMUXPSUDM. fPEEDMUKHBG THMC DT LDGS NKT 2.", encoder.encode(input3));
    }


}
