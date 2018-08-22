package com.test.service;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    private String characterEncoding;
    private boolean enabled;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        characterEncoding = filterConfig.getInitParameter("characterEncoding");
        enabled = "true".equalsIgnoreCase(filterConfig.getInitParameter("enabled").trim());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (enabled && characterEncoding != null) {
            servletRequest.setCharacterEncoding(characterEncoding);
            servletResponse.setCharacterEncoding(characterEncoding);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        characterEncoding = null;
    }
}
