package com.blackfat.rule.engine.core.exception;

/**
 * @author wangfeiyang
 * @Description
 * @create 2019-12-06 15:19
 * @since 1.0-SNAPSHOT
 */
public class EngineRuntimeException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private String message;

    public EngineRuntimeException() {
        super();
    }

    public EngineRuntimeException(String message) {
        super(message);
        this.message = message;
    }

    public EngineRuntimeException(Throwable t) {
        super(t);
    }

    public EngineRuntimeException(String message, Throwable t) {
        super(message, t);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
