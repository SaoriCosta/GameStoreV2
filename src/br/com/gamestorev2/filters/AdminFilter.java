package br.com.gamestorev2.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.gamestorev2.beans.LoginBean;

/**
 * Servlet Filter implementation class AdminFilter
 */

@WebFilter("/admin/*")
public class AdminFilter implements Filter {

    public AdminFilter() {
        // TODO Auto-generated constructor stub
    }
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		
		
		HttpSession session = ((HttpServletRequest) request).getSession();
		LoginBean loginBean = (LoginBean) session.getAttribute("loginBean");
		if (loginBean != null && loginBean.getUsuario() != null) {
			if(loginBean.getUsuario().isAdmin()){
			System.out.println("Autorizado para: " + loginBean.getUsuario());
			chain.doFilter(request, response);
			}else{
				System.out.println("N�o autorizado");
				request.getRequestDispatcher("/access-denied.jsf").forward(request, response);
			}
		} else {
			
		}
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}