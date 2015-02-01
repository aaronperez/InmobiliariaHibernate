/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtro;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 *
 * @author AngelakaMogu
 */
@WebFilter(filterName = "FiltroUTF", urlPatterns = {"/hola.jsp"})
public class FiltroUTF implements Filter {
private String encoding;
@Override
public void init(FilterConfig config) throws ServletException {
encoding = config.getInitParameter("requestEncoding");
if (encoding == null) {
encoding = "UTF-8";
}
}
@Override
public void doFilter(ServletRequest request, ServletResponse response,
FilterChain next) throws IOException, ServletException {
if (null == request.getCharacterEncoding()) {
request.setCharacterEncoding(encoding);
}
response.setContentType("text/html; charset=UTF-8");
response.setCharacterEncoding("UTF-8");
next.doFilter(request, response);
}
@Override
public void destroy() {
}
}
