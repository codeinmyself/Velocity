package xmu.mystore.config.yzh;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

// 这个类是当直接使用url访问页面却没有足够权限时的重定向处理
public class AccessDeniedServletHandler implements AccessDeniedHandler {


	private static final String DEF_ERROR_PAGE_PATH="/MallMgt/403";
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {

        response.setStatus(HttpServletResponse.SC_FORBIDDEN);  
 
        RequestDispatcher dispatcher = request.getRequestDispatcher(DEF_ERROR_PAGE_PATH);  
        dispatcher.forward(request, response);  
	}

}
