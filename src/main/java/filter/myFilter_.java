package filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.mysql.jdbc.StringUtils;

public class myFilter_ extends UsernamePasswordAuthenticationFilter{
	  private boolean postOnly = true;
	  @Override
	  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException  {
	        if (postOnly && !request.getMethod().equals("POST")) {
	            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
	        }
	        String username = obtainUsername(request);
	        String password = obtainPassword(request);
	        System.out.println("进入自定义拦截器");
	        if(StringUtils.isNullOrEmpty(username)||StringUtils.isNullOrEmpty(password)){
					throw new MyRuntimeException("用户");
	        }
	        if (username == null) {
	            username = "";
	        }
	        if (password == null) {
	            password = "";
	        }
	        username = username.trim();
	        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
	        // Allow subclasses to set the "details" property
	        setDetails(request, authRequest);
	        return this.getAuthenticationManager().authenticate(authRequest);
	    }
}
