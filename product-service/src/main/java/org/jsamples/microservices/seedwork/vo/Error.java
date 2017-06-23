package org.jsamples.microservices.seedwork.vo;

import java.io.Serializable;

public class Error implements Serializable {
    private static final long serialVersionUID = -7690169208790790368L;
    private String code;
    private String message;

    public Error() {}

    public static Error of(String code, String message) {
        Error error = new Error();
        error.setCode(code);
        error.setMessage(message);
        return error;
    }

    //<editor-fold desc="Encapsulation">
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    //</editor-fold>
}
