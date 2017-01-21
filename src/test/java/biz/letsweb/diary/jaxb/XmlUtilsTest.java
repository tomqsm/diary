package biz.letsweb.diary.jaxb;

import biz.letsweb.diary.jaxb.generated.Shiporder;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import static org.assertj.core.api.Assertions.*;

/**
 *
 * @author kusmierc
 */
public class XmlUtilsTest {

    private static final File SHIPORDER_XML = new File("src/main/resources/jaxb/xmls/shiporder.xml");
    private static final File SHIPORDER_MARSHALLED_XML = new File("src/main/resources/jaxb/xmls/shiporderMarshalled.xml");
    private static final File SHIPORDER_SCHEMA = new File("src/main/resources/jaxb/schemas/shiporder.xsd");

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void canValidateAgainstSchema() throws Exception {
        boolean valid = false;
        try{
            valid = XmlUtils.validateAgainstXSD(
                    FileUtils.openInputStream(SHIPORDER_XML),
                    FileUtils.openInputStream(SHIPORDER_SCHEMA));
        } catch (Exception e){
            fail("");
        }

        assertThat(valid).isTrue();
    }

    @Test
    public void unmarshalsConfig() throws Exception {
        Shiporder order = XmlUtils.unmarshal(Shiporder.class, FileUtils.openInputStream(SHIPORDER_XML));
        assertThat(order).isNotNull();
        assertThat(order.getItem()).hasSize(2);
    }

    @Test
    public void marshaledCorrectly() throws IOException, JAXBException {
        Shiporder order = XmlUtils.unmarshal(Shiporder.class, FileUtils.openInputStream(SHIPORDER_XML));
        assertThat(order).isNotNull();
        assertThat(order.getItem()).hasSize(2);
        XmlUtils.marshal(order, SHIPORDER_MARSHALLED_XML);
        order = XmlUtils.unmarshal(Shiporder.class, FileUtils.openInputStream(SHIPORDER_MARSHALLED_XML));
        assertThat(order).isNotNull();
        assertThat(order.getItem()).hasSize(2);
    }

}
