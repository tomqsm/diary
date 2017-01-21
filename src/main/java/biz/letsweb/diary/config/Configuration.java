package biz.letsweb.diary.config;


import java.util.List;

import org.apache.commons.configuration2.HierarchicalConfiguration;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.tree.ImmutableNode;

/**
 * @author Tomasz
 */
public enum Configuration {

    COLOR {
        @Override
        public String toString() {
            HierarchicalConfiguration hc = getPropertiesTags().get(FIRST);
            return hc.getString(super.name().toLowerCase());
        }

        @Override
        public void setValue(final String value) throws ConfigurationException {
            XML_CONFIG.setProperty("properties.color", value);
        }
    },
    TIME {
        @Override
        public String toString() {
            HierarchicalConfiguration hc = getPropertiesTags().get(FIRST);
            return hc.getString(super.name().toLowerCase());
        }

        @Override
        public void setValue(String value) throws ConfigurationException {
            XML_CONFIG.setProperty("properties/time", value);
        }

    },
    USER_HOME {
        @Override
        public String toString() {
            HierarchicalConfiguration hc = getPropertiesTags().get(FIRST);
            return hc.getString(super.name().toLowerCase());
        }

        @Override
        public void setValue(String value) throws ConfigurationException {
            throw new UnsupportedOperationException();
        }

    },
    HOST_IP {
        @Override
        public String toString() {
            HierarchicalConfiguration hc = getPropertiesTags().get(FIRST);
            return hc.getString(super.name().toLowerCase());
        }

        @Override
        public void setValue(String value) throws ConfigurationException {
            throw new UnsupportedOperationException();
        }

    },
    HOST_NAME {
        @Override
        public String toString() {
            HierarchicalConfiguration hc = getPropertiesTags().get(FIRST);
            return hc.getString(super.name().toLowerCase());
        }

        @Override
        public void setValue(String value) throws ConfigurationException {
            throw new UnsupportedOperationException();
        }

    },
    CONST_CLASS {
        @Override
        public String toString() {
            HierarchicalConfiguration hc = getPropertiesTags().get(FIRST);
            return hc.getString(super.name().toLowerCase());
        }

        @Override
        public void setValue(String value) throws ConfigurationException {
            throw new UnsupportedOperationException();
        }

    },
    DECIMAL_SEPARATOR {
        @Override
        public String toString() {
            HierarchicalConfiguration hc = getPropertiesTags().get(FIRST);
            return hc.getString(super.name().toLowerCase());
        }

        @Override
        public void setValue(String value) throws ConfigurationException {
            XML_CONFIG.setProperty("properties/decimal_separator", value);
        }

    }, ENV_JAVA_HOME {
        @Override
        public String toString() {
            HierarchicalConfiguration hc = getPropertiesTags().get(FIRST);
            return hc.getString(super.name().toLowerCase());
        }

        @Override
        public void setValue(String value) throws ConfigurationException {
            XML_CONFIG.setProperty("properties/env_java_home", value);
        }

    }, SYS_USER_HOME {
        @Override
        public String toString() {
            HierarchicalConfiguration hc = getPropertiesTags().get(FIRST);
            return hc.getString(super.name().toLowerCase());
        }

        @Override
        public void setValue(String value) throws ConfigurationException {
            throw new UnsupportedOperationException();
        }

    };

    static {
        ConfigProvider configProvider = new ConfigProvider();
        configProvider.initialiseXMLConfiguration("config/configuration.xml");
        XML_CONFIG = configProvider.getXMLConfiguration();
    }

    private static XMLConfiguration XML_CONFIG;
    private static final int FIRST = 0;

    public abstract void setValue(final String value) throws ConfigurationException;

    public static List<HierarchicalConfiguration<ImmutableNode>> getPropertiesTags() {
        final List<HierarchicalConfiguration<ImmutableNode>> properties = XML_CONFIG.configurationsAt("properties");
        return properties;
    }

}
