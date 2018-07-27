package cn.canos.kanban.auth;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author canos
 */
public class AuthorizeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        boolean hasPermission = true;
        if (hasPermission) {
            chain.doFilter(request, response);
        } else {
            httpServletResponse.sendError(401);
        }
    }

    @Override
    public void destroy() {

    }
}
