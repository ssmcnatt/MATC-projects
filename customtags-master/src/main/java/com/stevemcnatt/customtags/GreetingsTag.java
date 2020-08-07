package com.stevemcnatt.customtags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Calendar;

/**
 * This class contains code that will run when the custom tag "Greetings"
 * is called within a jsp.
 */
public class GreetingsTag extends SimpleTagSupport {

    /**
     * doTag() override method used by the custom tag "Greetings".
     * Outputs a different message based on the time of day.
     *
     * @throws JspException
     * @throws IOException
     */
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspWriter out = getJspContext().getOut();

        Calendar curDate = Calendar.getInstance();
        int hour = curDate.get(Calendar.HOUR_OF_DAY);
        if (hour < 5) {
            out.println("What are you doing up so late!");
        } else if (hour < 12) {
            out.println("Good morning!");
        } else if (hour < 16) {
            out.println("Good afternoon!");
        } else {
            out.println("Good evening!");
        }
    }
}
