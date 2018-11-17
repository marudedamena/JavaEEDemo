package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

//@WebServlet("/LoginCL")
public class LoginCLServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginCLServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        // 接收用户提交的用户名和密码
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        //创建用户
        User user = new User(account, password);

        try {
            if (user.isExist()) {	//判断用户是否存在
                response.sendRedirect("/Welcome");	// 跳转到登录成功页面
            } else {
                response.sendRedirect("/Error");		// 跳转到登录失败页面
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
