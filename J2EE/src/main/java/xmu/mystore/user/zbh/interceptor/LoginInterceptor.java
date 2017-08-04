package xmu.mystore.user.zbh.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{

	private static final String LOGIN_URL = "/login";
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		if(request.getRequestURI().indexOf("css")!=-1){
			return true;
		}
		if(request.getRequestURI().indexOf("js")!=-1){
			return true;
		}
		HttpSession session = request.getSession(true);
		Object obj = session.getAttribute("userId");
		if(obj==null||"".equals(obj.toString())){
			//只允许记录一次
			if(session.getAttribute("path")==null){
				String path = request.getServletPath();
				session.setAttribute("path",path);
			}
			
			response.sendRedirect(request.getSession().getServletContext().getContextPath()+LOGIN_URL);
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
