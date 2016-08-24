package filter;

import org.springframework.security.core.AuthenticationException;

public class MyRuntimeException extends AuthenticationException {

	public MyRuntimeException(String msg) {
		super(msg);
	}
	
}
