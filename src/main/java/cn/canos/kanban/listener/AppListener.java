package cn.canos.kanban.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * @author canos
 */
@WebListener
public class AppListener implements ServletContextListener {

    private final String BASIC_PROPERTIES_CLASSPATH = "/META-INF/basic.properties";

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        try {
            sce.getServletContext().setAttribute("__contextPath", sce.getServletContext().getContextPath());

            Properties properties = loadProperties();
            sce.getServletContext().setAttribute("releaseNo", properties.getProperty("releaseNo", "20180605"));

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    private Properties loadProperties() throws IOException {

        InputStream inputStream = AppListener.class.getResourceAsStream(BASIC_PROPERTIES_CLASSPATH);

        Properties properties = new Properties();

        properties.load(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

        return properties;
    }
}
