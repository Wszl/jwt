package org.xdove.jwt.web;


import org.xdove.jwt.JWTBuilder;
import org.xdove.jwt.entity.common.JWT;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.Date;

/**
 * Json Web Token (JWT)
 * JWT签发Servlet
 */
@WebServlet(urlPatterns="/authentication")
public class AuthenticationServlet extends javax.servlet.http.HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //step 1 : 获取用户名密码并校验是否为合法用户
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null || !username.equals(Config.username)) {
           response.getWriter().write("not found username.");
            return;
        }

        if (password == null || !password.trim().equals(Config.password)) {
            response.getWriter().write("the password does not match username.");
            return;
        }

        //step 2 : 生成JWT
        JWT jwt = new JWT();
        jwt.setIat(new Date());
        JWTBuilder jb = JWTBuilder.construct();

        jb.setKey("233".getBytes());

        String jwtStr = jb.compact();

        
        System.out.println("jwt:" + jwt);


        //step 3 : 返回
        response.getWriter().write(jwtStr);
    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.getWriter().write("Json Web Token.");
    }
}
