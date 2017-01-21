package biz.letsweb.diary.config;

import biz.letsweb.diary.AppException;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.ReloadingFileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.event.ConfigurationEvent;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.interpol.ConfigurationInterpolator;
import org.apache.commons.configuration2.interpol.ExprLookup;
import org.apache.commons.configuration2.interpol.Lookup;
import org.apache.commons.configuration2.reloading.PeriodicReloadingTrigger;
import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlContext;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Tomasz
 */
public class ConfigProvider {

    private final Logger LOG = LoggerFactory.getLogger(ConfigProvider.class);

    private XMLConfiguration config;

    public ConfigProvider() {
    }

    public final void initialiseXMLConfiguration(String fileName) {
        try {
            Parameters params = new Parameters();
            final Map<String, Lookup> lookups = new HashMap<>(ConfigurationInterpolator.getDefaultPrefixLookups());
            ExprLookup.Variables vars = new ExprLookup.Variables();
            vars.add(new ExprLookup.Variable("System", "Class:java.lang.System"));
            vars.add(new ExprLookup.Variable("net", "Class:java.net.InetAddress"));
            Lookup lookup = new MyExpr(vars);
            lookups.put("expr", lookup);

            ReloadingFileBasedConfigurationBuilder<XMLConfiguration> builder
                    = new ReloadingFileBasedConfigurationBuilder<XMLConfiguration>(XMLConfiguration.class)
                    .configure(params.xml()
                            .setFileName(fileName)
                            .setPrefixLookups(lookups)
                            .setValidating(false));
            builder.setAutoSave(true);
            PeriodicReloadingTrigger trigger = new PeriodicReloadingTrigger(builder.getReloadingController(), null, 2, TimeUnit.SECONDS);
            config = builder.getConfiguration();
            config.addEventListener(ConfigurationEvent.ANY, new ConfigurationLogListener());
            trigger.start();
        } catch (ConfigurationException ex) {
            throw new AppException(ex.getMessage(), ex);
        }
    }

    public XMLConfiguration getXMLConfiguration() {
        return config;
    }

    class MyExpr implements Lookup{
        private final ExprLookup.Variables vars;
        private final JexlEngine engine;

        public MyExpr(ExprLookup.Variables vars) {
            this.vars = vars;
            this.engine = new JexlEngine();
        }

        @Override
        public Object lookup(String s) {
            String result = s;
            Expression e = this.engine.createExpression(result);
            result = (String)e.evaluate(this.createContext());
            return result;
        }
        private JexlContext createContext() {
            MapContext ctx = new MapContext();
            this.loadVariablesInContext(ctx);
            return ctx;
        }

        private void loadVariablesInContext(JexlContext ctx) {
            Iterator var2 = this.vars.iterator();

            while(var2.hasNext()) {
                ExprLookup.Variable var = (ExprLookup.Variable)var2.next();
                ctx.set(var.getName(), var.getValue());
            }

        }
    }

}
