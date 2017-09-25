package cn.csbe.web.cms.auth.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;



public class AuthInterceptor implements HandlerInterceptor {

	private List<String> excludedUrls;

    public void setExcludedUrls(List<String> excludedUrls) {
        this.excludedUrls = excludedUrls;
    }
    
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		String requestUri = request.getRequestURI();
        for (String url : excludedUrls) {
            if (requestUri.endsWith(url)) {
                return true;
            }
        }

        // intercept
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
        	//response.setStatus(403);
        	response.sendRedirect("login");
        	return false;
        } else {
            return true;
        }
	}

}
