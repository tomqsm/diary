package biz.letsweb.diary.pricePicker.picker;

import biz.letsweb.diary.config.Configuration;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by toks on 14.02.17.
 */
public class DecimalFormatFactoryTest {

    private final Logger LOG = LoggerFactory.getLogger(DecimalFormatFactoryTest.class);

    @Test
    public void testElse() throws ConfigurationException {
        Configuration c = Configuration.SYS_USER_HOME;
        Configuration c1 = Configuration.ENV_JAVA_HOME;
        LOG.info("{} {}",c, c1);
//        c.setValue("yellow");
//        LOG.info("{}",c);
    }


}