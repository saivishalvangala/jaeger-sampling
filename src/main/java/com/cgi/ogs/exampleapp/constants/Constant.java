/*******************************************************************************
 * © 2020 CGI OpenGrid360. All rights are reserved.
 ******************************************************************************/
package com.cgi.ogs.exampleapp.constants;

/**
 * The Class Constant.
 *
 * @author kiranmayee.kona
 */
public class Constant
{

    /**
     * Instantiates a new constant.
     */
    private Constant()
    {
        throw new IllegalStateException("Constants class");
    }

    /** The Constant NULL. */
    public static final String NULL = "NULL";

    /** The Constant MOUNTPATH_NULL. */
    public static final String MOUNTPATH_NULL = "Mountpath to read the template from PV-storage is not configured in the ConfigMap";

    /** The Constant EC_MOUNTPATH_NULL. */
    public static final String EC_MOUNTPATH_NULL = "APP-OGS-EMAIL_102";

    /** The Constant APPSTARTED. */
    public static final String APPSTARTED = "APP-OGS-EMAIL application started";

    /** The Constant APPSTOPPED. */
    public static final String APPSTOPPED = "APP-OGS-EMAIL application stopped";

    /** The Constant OK. */
    public static final String OK = "200 OK";

    /** The Constant ERROR. */
    public static final String ERROR = "400";

    /** The Constant ERRORINRETRIEVINGPROPERTIES. */
    public static final String ERRORINRETRIEVINGPROPERTIES = "error retrieving the properties";

    /** The Constant ERRORINRETRIEVINGPROPERTIES. */
    public static final String PROPERTIESSHOULDNOTBENULL = "configaration properties should not be null";

    /** The Constant JSONSERIALIZER. */
    public static final String JSONSERIALIZER = "com.cgi.ogs.cpf.util.kafka.serializer.JsonSerializer";

    /** The Constant JSONDESERIALIZER. */
    public static final String JSONDESERIALIZER = "com.cgi.ogs.cpf.util.kafka.serializer.JsonDeserializer";

    /** The Constant KEYDESERIALIZER. */
    public static final String KEYDESERIALIZER = "org.apache.kafka.common.serialization.StringSerializer";

    /** The Constant KEYSERIALIZER. */
    public static final String KEYSERIALIZER = "org.apache.kafka.common.serialization.StringSerializer";

    /** The Constant MAILSENT. */
    public static final String MAILSENT = "Successfully sent a mail with the subject ";

    /** The Constant MAILSENT. */
    public static final String MAILSENTTOTOPIC = "Mail details posted to the topic with the subject ";

    /** The Constant MAILNOTSENT. */
    public static final String MAILNOTSENT = "Error sending the mail";

    /** The Constant APPNAME. */
    public static final String APPNAME = "APP-OGS-EMAIL";

    /** The Constant EC_FAILURE. */
    public static final String EC_FAILURE = "APP-OGS-EMAIL_101";

    /** The Constant EC_SUCCESS. */
    public static final String EC_SUCCESS = "APP-OGS-EMAIL_000";

    /** The Constant BREAK_LINE. */
    public static final String BREAK_LINE = "<br>";

    /** The Constant EMAIL_NOT_SENT. */
    public static final String EMAIL_NOT_SENT = " .Email is not sent with tempalteName:";

    /** The Constant MANDATORY_KEYS. */
    public static final String MANDATORY_KEYS = "Mandatory keys are:";

    /** The Constant FILE_NOT_FOUND. */
    public static final String FILE_NOT_FOUND = "The file is not found in the given path: ";

    /** The Constant FILE_IS_EMPTY. */
    public static final String FILE_IS_EMPTY = "The template file is Empty or not in correct format. Error occured while reading file:";

    /** The Constant EMAIL_MODEL_IS_FROM_REQUEST. */
    public static final String EMAIL_MODEL_IS_FROM_REQUEST = "All to,from,cc,bcc,subject,body are taken from Request to send E-mail ";

    /** The Constant EMAIL_ID. */
    public static final String EMAIL_ID = "To-address:";

    /** The Constant TEMPLATE_NAME. */
    public static final String TEMPLATE_NAME = "TEMPLATE_NAME:";

    /** The Constant MANDATORY_KEYS_NOT_FOUND. */
    public static final String MANDATORY_KEYS_NOT_FOUND = "The following mandatory keys mentioned in template are not given in request. MISSING-KEYS: ";

    /** The Constant EXTENSION_NOT_SUPPORTED. */
    public static final String EXTENSION_NOT_SUPPORTED = "Only .txt files are supported. The Extension of given file is not supported: ";

    /** The Constant DOT. */
    public static final String DOT = ".";

    /** The Constant SEMICOLON. */
    public static final String SEMICOLON = ";";

    /** The Constant COLON. */
    public static final String COLON = ":";

    /** The Constant COMMA. */
    public static final String COMMA = ",";

    /** The Constant FILE_EXTENSION. */
    public static final String FILE_EXTENSION = ".txt";
    public static final String OPENING_BRACKET = "{$";

    public static final String CLOSING_BRACKET = "}";

}
