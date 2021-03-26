package com.wit.calculator.business.exception;

/*
 * Class that handles the exception to prettier messages
 */
public class BusinessException extends RuntimeException {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 118044130682394328L;

	public BusinessException() {
		super();
	}

	public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

}
