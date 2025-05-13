package Controller;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class SessionAttributeListener implements HttpSessionAttributeListener {
    private static final Logger LOGGER = Logger.getLogger(SessionAttributeListener.class.getName());

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        if ("todoList".equals(event.getName())) {
            LOGGER.info("TodoList added to session: " + event.getValue());
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        if ("todoList".equals(event.getName())) {
            LOGGER.info("TodoList removed from session: " + event.getValue());
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        if ("todoList".equals(event.getName())) {
            LOGGER.info("TodoList updated in session: " + event.getValue());
        }
    }
}