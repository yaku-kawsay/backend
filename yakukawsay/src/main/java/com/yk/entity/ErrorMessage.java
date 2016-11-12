/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yk.entity;

/**
 *
 * @author ubuntu
 */
public class ErrorMessage {

    private String errorMessage;
    private String errorCode;
    private String documentation = "";

    public ErrorMessage() {
    }

    public ErrorMessage(String errorCode, String documentation) {
        this(errorCode, null, documentation);
    }

    public ErrorMessage(final String errorCode, final String language, final String documentation) {
        this(errorCode, language, null, documentation);
    }

    public ErrorMessage(final String errorCode, final String language, final String country, final String documentation) {
        this.errorCode = errorCode;
        this.documentation = documentation;
        // this.errorMessage = Internationalization.getInstance(language, country).getValue(errorCode);
        this.errorMessage = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(final String errorCode) {
        this.errorCode = errorCode;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(final String documentation) {
        this.documentation = documentation;
    }

}

