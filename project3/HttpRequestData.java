package java112.project3;


import java.io.*;
import java.util.*;


/**
 * @author Your Name Here
 * class HttpRequestData
 */
public class HttpRequestData {

    private String requestRemoteComputer;
    private String requestRemoteAddress;
    private String requestHttpMethod;
    private String requestUri;
    private StringBuffer requestUrl;
    private String requestProtocol;
    private String serverName;
    private int serverPortNumber;
    private Locale serverCurrentLocale;
    private String queryString;
    private String queryParameterValue;
    private String userAgentValue;


    /**
     * Empty constructor for HttpRequestData
     */
    public HttpRequestData() {
    }


    /**
     * Returns the value of requestRemoteComputer.
     *
     * @return requestRemoteComputer the remote computer name
     */
    public String getRequestRemoteComputer() {
        return requestRemoteComputer;
    }


    /**
     * Sets the value of requestRemoteComputer.
     *
     * @param requestRemoteComputer The value to assign requestRemoteComputer.
     */
    public void setRequestRemoteComputer(String requestRemoteComputer) {
        this.requestRemoteComputer = requestRemoteComputer;
    }


    /**
     * Returns the value of requestRemoteAddress.
     *
     * @return requestRemoteAddress the remote address
     */
    public String getRequestRemoteAddress() {
        return requestRemoteAddress;
    }


    /**
     * Sets the value of requestRemoteAddress.
     *
     * @param requestRemoteAddress The value to assign requestRemoteAddress.
     */
    public void setRequestRemoteAddress(String requestRemoteAddress) {
        this.requestRemoteAddress = requestRemoteAddress;
    }


    /**
     * Returns the value of requestHttpMethod.
     *
     * @return requestHttpMethod the request HTTP method
     */
    public String getRequestHttpMethod() {
        return requestHttpMethod;
    }


    /**
     * Sets the value of requestHttpMethod.
     *
     * @param requestHttpMethod The value to assign requestHttpMethod.
     */
    public void setRequestHttpMethod(String requestHttpMethod) {
        this.requestHttpMethod = requestHttpMethod;
    }


    /**
     * Returns the value of requestUri.
     *
     * @return requestUri the request URI
     */
    public String getRequestUri() {
        return requestUri;
    }


    /**
     * Sets the value of requestUri.
     *
     * @param requestUri The value to assign requestUri.
     */
    public void setRequestUri(String requestUri) {
        this.requestUri = requestUri;
    }


    /**
     * Returns the value of requestUrl.
     *
     * @return requestUrl the request URL
     */
    public StringBuffer getRequestUrl() {
        return requestUrl;
    }


    /**
     * Sets the value of requestUrl.
     *
     * @param requestUrl The value to assign requestUrl.
     */
    public void setRequestUrl(StringBuffer requestUrl) {
        this.requestUrl = requestUrl;
    }


    /**
     * Returns the value of requestProtocol.
     *
     * @return requestProtocol the request protocol
     */
    public String getRequestProtocol() {
        return requestProtocol;
    }


    /**
     * Sets the value of requestProtocol.
     *
     * @param requestProtocol The value to assign requestProtocol.
     */
    public void setRequestProtocol(String requestProtocol) {
        this.requestProtocol = requestProtocol;
    }


    /**
     * Returns the value of serverName.
     *
     * @return serverName the server name
     */
    public String getServerName() {
        return serverName;
    }


    /**
     * Sets the value of serverName.
     *
     * @param serverName The value to assign serverName.
     */
    public void setServerName(String serverName) {
        this.serverName = serverName;
    }


    /**
     * Returns the value of serverPortNumber.
     *
     * @return serverPortNumber the server port number
     */
    public int getServerPortNumber() {
        return serverPortNumber;
    }


    /**
     * Sets the value of serverPortNumber.
     *
     * @param serverPortNumber The value to assign serverPortNumber.
     */
    public void setServerPortNumber(int serverPortNumber) {
        this.serverPortNumber = serverPortNumber;
    }


    /**
     * Returns the value of serverCurrentLocale.
     *
     * @return serverCurrentLocale the current server locale
     */
    public Locale getServerCurrentLocale() {
        return serverCurrentLocale;
    }


    /**
     * Sets the value of serverCurrentLocale.
     *
     * @param serverCurrentLocale The value to assign serverCurrentLocale.
     */
    public void setServerCurrentLocale(Locale serverCurrentLocale) {
        this.serverCurrentLocale = serverCurrentLocale;
    }


    /**
     * Returns the value of queryString.
     *
     * @return queryString the full query string
     */
    public String getQueryString() {
        return queryString;
    }


    /**
     * Sets the value of queryString.
     *
     * @param queryString The value to assign queryString.
     */
    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }


    /**
     * Returns the value of queryParameterValue.
     *
     * @return queryParameterValue the value of queryParameter
     */
    public String getQueryParameterValue() {
        return queryParameterValue;
    }


    /**
     * Sets the value of queryParameterValue.
     *
     * @param queryParameterValue The value to assign queryParameterValue.
     */
    public void setQueryParameterValue(String queryParameterValue) {
        this.queryParameterValue = queryParameterValue;
    }


    /**
     * Returns the value of userAgentValue.
     *
     * @return userAgentValue the value of User-Agent
     */
    public String getUserAgentValue() {
        return userAgentValue;
    }


    /**
     * Sets the value of userAgentValue.
     *
     * @param userAgentValue The value to assign userAgentValue.
     */
    public void setUserAgentValue(String userAgentValue) {
        this.userAgentValue = userAgentValue;
    }
}

