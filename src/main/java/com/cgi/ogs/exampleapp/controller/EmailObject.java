package com.cgi.ogs.exampleapp.controller;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class EmailObject.
 */
public class EmailObject
{

    /** The template name. */
    @JsonProperty("TemplateName")
    String templateName;

    /** The template map. */
    @JsonProperty("TemplateValue")
    Map<String, String> templateMap;
    /** The from address. */
    private String fromAddress;

    /** The to address. */
    private String toAddress;

    /** The cc address. */
    private String ccAddress;

    /** The bcc address. */
    private String bccAddress;

    /** The body. */
    private String body;

    /** The subject. */
    private String subject;

    private Header header;

    public Header getHeader()
    {
        return header;
    }

    public void setHeader(final Header header)
    {
        this.header = header;
    }

    /**
     * Gets the from address.
     *
     * @return the from address
     */
    public String getFromAddress()
    {
        return fromAddress;
    }

    /**
     * Sets the from address.
     *
     * @param fromAddress
     *            the new from address
     */
    public void setFromAddress(final String fromAddress)
    {
        this.fromAddress = fromAddress;
    }

    /**
     * Gets the to address.
     *
     * @return the to address
     */
    public String getToAddress()
    {
        return toAddress;
    }

    /**
     * Sets the to address.
     *
     * @param toAddress
     *            the new to address
     */
    public void setToAddress(final String toAddress)
    {
        this.toAddress = toAddress;
    }

    /**
     * Gets the cc address.
     *
     * @return the cc address
     */
    public String getCcAddress()
    {
        return ccAddress;
    }

    /**
     * Sets the cc address.
     *
     * @param ccAddress
     *            the new cc address
     */
    public void setCcAddress(final String ccAddress)
    {
        this.ccAddress = ccAddress;
    }

    /**
     * Gets the bcc address.
     *
     * @return the bcc address
     */
    public String getBccAddress()
    {
        return bccAddress;
    }

    /**
     * Sets the bcc address.
     *
     * @param bccAddress
     *            the new bcc address
     */
    public void setBccAddress(final String bccAddress)
    {
        this.bccAddress = bccAddress;
    }

    /**
     * Gets the body.
     *
     * @return the body
     */
    public String getBody()
    {
        return body;
    }

    /**
     * Sets the body.
     *
     * @param body
     *            the new body
     */
    public void setBody(final String body)
    {
        this.body = body;
    }

    /**
     * Gets the subject.
     *
     * @return the subject
     */
    public String getSubject()
    {
        return subject;
    }

    /**
     * Sets the subject.
     *
     * @param subject
     *            the new subject
     */
    public void setSubject(final String subject)
    {
        this.subject = subject;
    }

    /**
     * Gets the template name.
     *
     * @return the template name
     */
    public String getTemplateName()
    {
        return templateName;
    }

    /**
     * Sets the template name.
     *
     * @param templateName
     *            the new template name
     */
    public void setTemplateName(final String templateName)
    {
        this.templateName = templateName;
    }

    /**
     * Gets the template map.
     *
     * @return the template map
     */
    public Map<String, String> getTemplateMap()
    {
        return templateMap;
    }

    /**
     * Sets the template map.
     *
     * @param templateMap
     *            the template map
     */
    public void setTemplateMap(final Map<String, String> templateMap)
    {
        this.templateMap = templateMap;
    }

}
