package biz.letsweb.diary.config;

import org.apache.commons.configuration2.event.ConfigurationEvent;
import org.apache.commons.configuration2.event.EventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by toks on 15.02.17.
 */
public class ConfigurationLogListener implements EventListener<ConfigurationEvent> {
    public static final Logger LOGGER = LoggerFactory.getLogger(ConfigurationLogListener.class);

    @Override
    public void onEvent(ConfigurationEvent event) {
        LOGGER.info("{}", event.getPropertyName());
    }
}
