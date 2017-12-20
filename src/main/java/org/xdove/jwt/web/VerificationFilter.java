package main.java.org.xdove.jwt.web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Servlet Filter implementation class VerificationFilter
 */
@WebFilter(urlPatterns="/service-test")
public class VerificationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public VerificationFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("auth start.");
		//step 1 : 获取authorization头的jwt
		String auth = ((HttpServletRequest) request).getHeader("Authorization");
		if (auth == null || auth.equals("")) {
			response.getWriter().write("please set request header authorization.");
			return;
		}
		String[] authArr = auth.split(" ");
		if (!authArr[ 0 ].equals("Bearer")) {
			response.getWriter().write("unsupport token type.");
			return;
		}
			
		String jwt = authArr[1];
		System.out.println("request jwt:" + jwt);
			
		//step 2 : 解密
//		try {
//
//		    Jwts.parser()
//		    	.setSigningKey(Config.key)
//		    	.parseClaimsJws(jwt);
//
//		    chain.doFilter(request, response);
//		} catch (SignatureException e) {
//			response.getWriter().write(e.getLocalizedMessage());
//			return;
//		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
