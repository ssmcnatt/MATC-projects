package com.stevemcnatt.customtags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * This class contains code that will run when the custom tag "Hello"
 * is called within a jsp.
 */
public class HelloWorldTag extends SimpleTagSupport {

    /**
     * doTag() override method used by the custom tag "Hello"
     *
     * @throws JspException
     * @throws IOException
     */
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspWriter out = getJspContext().getOut();
        out.println("Hello Enterprise Java Class!");
    }
}
