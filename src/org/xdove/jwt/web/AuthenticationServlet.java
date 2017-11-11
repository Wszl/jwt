package org.xdove.jwt.web;

import org.xdove.jwt.entity.JWT;
import org.xdove.jwt.utils.SignatureAlgorithm;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Json Web Token (JWT)
 * JWT签发Servlet
 */
@WebServlet(urlPatterns="/authentication")
public class AuthenticationServlet extends javax.servlet.http.HttpServlet {

	private static final long serialVersionUID = 1L;

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
        String jwt = JWT.construct()
                .setAlg(SignatureAlgorithm.HS256.name())
                .setTyp("jwt")
                .build(SignatureAlgorithm.HS256, Config.key)
                .compact();
        
        System.out.println("jwt:" + jwt);


        //step 3 : 返回
        response.getWriter().write(jwt);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.getWriter().write("Json Web Token.");
    }
}
