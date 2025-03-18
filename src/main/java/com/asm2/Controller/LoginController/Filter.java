package com.asm2.Controller.LoginController;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//@WebFilter(filterName = "Filter")
@WebFilter(filterName = "Filter", urlPatterns = "/filterInput")
public class Filter implements jakarta.servlet.Filter {

    private static final Map<String, Set<String>> ROLE_PERMISSIONS = new HashMap<>();
    public void init(FilterConfig config) throws ServletException {

        Set<String> khachHangPages = new HashSet<>();
        khachHangPages.add("/ban-hang");

        Set<String> nhanVienPages = new HashSet<>();
        nhanVienPages.add("/ban-hang");
        nhanVienPages.add("/san-pham");
        nhanVienPages.add("/voucher");
        nhanVienPages.add("/khuyen-mai");

        Set<String> quanLyPages = new HashSet<>();

        ROLE_PERMISSIONS.put("Khách Hàng", khachHangPages);
        ROLE_PERMISSIONS.put("Nhân Viên", nhanVienPages);
        ROLE_PERMISSIONS.put("Quản Lý", quanLyPages);
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("chucVu") == null) {
            res.sendRedirect("/ASM2/hien-thi");
            return;
        }

        String chucVu = (String) session.getAttribute("chucVu");
        String uri = req.getRequestURI();

        if ("Quản Lý".equals(chucVu)) {
            chain.doFilter(request, response);
            return;
        }

        Set<String> allowedPaths = ROLE_PERMISSIONS.get(chucVu);
        if (allowedPaths != null && allowedPaths.stream().noneMatch(uri::startsWith)) {
            res.sendRedirect("/error/403");
            return;
        }

        chain.doFilter(request, response);
    }
    }
