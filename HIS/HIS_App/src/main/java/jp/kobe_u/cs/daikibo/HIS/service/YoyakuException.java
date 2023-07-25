package jp.kobe_u.cs.daikibo.HIS.service;

public class YoyakuException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public YoyakuException(String message) {
        super(message);
    }
}