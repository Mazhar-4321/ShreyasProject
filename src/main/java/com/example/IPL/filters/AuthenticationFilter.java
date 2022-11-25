package com.example.IPL.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Slf4j
public class AuthenticationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        System.out.println(request);
//        if(request.getSession().isNew())
//        {
//            log.info("new");
//            request.getSession().setAttribute(request.toString(),new Date().getTime());
//        }
//        else
//        {
//            //log.info("{}",request.getSession(). getAttribute("session"));
//            if(request.getSession(). getAttribute("session")!=null) {
//                //log.info("{}",request.getSession().getAttribute("session"));
//                long time = (new Date().getTime());
//                long ptime = (Long) (request.getSession().getAttribute("session"));
//                if (time - ptime > 60000) {
//                    log.info("session expired");
//                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
//                    return;
//                }
//            }
//        }
        System.out.println(request.hashCode());
        filterChain.doFilter(request,response);
    }
}
