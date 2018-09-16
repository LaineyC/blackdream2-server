package pers.laineyc.blackdream.configuration.config;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author LaineyC
 */
public class CorsFilter implements Filter{

    public static final String DEFAULT_ALLOWED_ORIGINS = "*";

    public static final String DEFAULT_ALLOWED_HTTP_METHODS = "GET,POST,HEAD,OPTIONS";

    public static final String DEFAULT_PREFLIGHT_MAXAGE = "1800";

    public static final String DEFAULT_SUPPORTS_CREDENTIALS = "true";

    public static final String DEFAULT_ALLOWED_HTTP_HEADERS = "Origin,Accept,X-Requested-With,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers";

    public static final String DEFAULT_EXPOSEd_HTTP_HEADERS = "Content-Disposition,Date";

    private boolean anyOriginAllowed;

    private boolean supportsCredentials;

    private Collection<String> allowedOrigins = new HashSet<>();

    private Collection<String> allowedHttpMethods = new HashSet<>();

    private Collection<String> allowedHttpHeaders = new HashSet<>();

    private Collection<String> exposedHttpHeaders = new HashSet<>();

    private long preflightMaxAge;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        parseAndStore(DEFAULT_ALLOWED_ORIGINS, DEFAULT_ALLOWED_HTTP_METHODS, DEFAULT_ALLOWED_HTTP_HEADERS, DEFAULT_SUPPORTS_CREDENTIALS, DEFAULT_PREFLIGHT_MAXAGE, DEFAULT_EXPOSEd_HTTP_HEADERS);
        if (filterConfig != null) {
            String configAllowedOrigins = filterConfig.getInitParameter("cors.allowed.origins");
            String configAllowedHttpMethods = filterConfig.getInitParameter("cors.allowed.methods");
            String configAllowedHttpHeaders = filterConfig.getInitParameter("cors.allowed.headers");
            String configSupportsCredentials = filterConfig.getInitParameter("cors.support.credentials");
            String configPreflightMaxAge = filterConfig.getInitParameter("cors.preflight.maxage");
            String configExposedHttpHeaders = filterConfig.getInitParameter("cors.exposed.headers");
            parseAndStore(configAllowedOrigins, configAllowedHttpMethods, configAllowedHttpHeaders, configSupportsCredentials, configPreflightMaxAge, configExposedHttpHeaders);
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        String origin = request.getHeader("Origin");
        String method = request.getMethod();
        if (!isOriginAllowed(origin)) {
            handleInvalidCORS(request, response, filterChain);
            return;
        }
        if (!allowedHttpMethods.contains(method)) {
            handleInvalidCORS(request, response, filterChain);
            return;
        }
        if (supportsCredentials) {
            response.addHeader("Access-Control-Allow-Credentials", "true");
        }
        //response.addHeader("Access-Control-Allow-Origin", anyOriginAllowed ? "*" : origin);
        response.addHeader("Access-Control-Allow-Origin", origin);
        response.addHeader("Access-Control-Max-Age", String.valueOf(preflightMaxAge));
        response.addHeader("Access-Control-Allow-Methods", join(allowedHttpMethods, ","));
        response.addHeader("Access-Control-Allow-Headers", join(allowedHttpHeaders, ","));
        response.addHeader("Access-Control-Expose-Headers ", join(exposedHttpHeaders, ","));

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

    private void parseAndStore(String allowedOrigins, String allowedHttpMethods, String allowedHttpHeaders, String supportsCredentials, String preflightMaxAge, String exposedHttpHeaders) throws ServletException {
        if (allowedOrigins != null) {
            if (allowedOrigins.trim().equals("*")) {
                this.anyOriginAllowed = true;
            }
            else {
                this.anyOriginAllowed = false;
                Set<String> setAllowedOrigins = parseStringToSet(allowedOrigins);
                this.allowedOrigins.clear();
                this.allowedOrigins.addAll(setAllowedOrigins);
            }
        }

        if (allowedHttpMethods != null) {
            Set<String> setAllowedHttpMethods = parseStringToSet(allowedHttpMethods);
            this.allowedHttpMethods.clear();
            this.allowedHttpMethods.addAll(setAllowedHttpMethods);
        }

        if (allowedHttpHeaders != null) {
            Set<String> setAllowedHttpHeaders = parseStringToSet(allowedHttpHeaders);
            Set<String> lowerCaseHeaders = new HashSet<>();
            for (String header : setAllowedHttpHeaders) {
                String lowerCase = header.toLowerCase();
                lowerCaseHeaders.add(lowerCase);
            }
            this.allowedHttpHeaders.clear();
            this.allowedHttpHeaders.addAll(lowerCaseHeaders);
        }

        if (supportsCredentials != null) {
            this.supportsCredentials = Boolean.parseBoolean(supportsCredentials);
        }

        if (preflightMaxAge != null) {
            try {
                if (!preflightMaxAge.isEmpty()) {
                    this.preflightMaxAge = Long.parseLong(preflightMaxAge);
                }
                else {
                    this.preflightMaxAge = 0L;
                }
            }
            catch (NumberFormatException e) {
                throw new ServletException("Unable to parse preflightMaxAge", e);
            }
        }

        if (exposedHttpHeaders != null) {
            Set<String> setExposedHttpHeaders = parseStringToSet(exposedHttpHeaders);
            Set<String> lowerCaseHeaders = new HashSet<>();
            for (String header : setExposedHttpHeaders) {
                String lowerCase = header.toLowerCase();
                lowerCaseHeaders.add(lowerCase);
            }
            this.exposedHttpHeaders.clear();
            this.exposedHttpHeaders.addAll(lowerCaseHeaders);
        }

    }

    private Set<String> parseStringToSet(String data) {
        String[] splits;

        if (data != null && data.length() > 0) {
            splits = data.split(",");
        }
        else {
            splits = new String[] {};
        }

        Set<String> set = new HashSet<>();
        if (splits.length > 0) {
            for (String split : splits) {
                set.add(split.trim());
            }
        }

        return set;
    }

    protected static String join(Collection<String> elements, String joinSeparator) {
        String separator = ",";
        if (elements == null) {
            return null;
        }
        if (joinSeparator != null) {
            separator = joinSeparator;
        }
        StringBuilder buffer = new StringBuilder();
        boolean isFirst = true;
        for (String element : elements) {
            if (!isFirst) {
                buffer.append(separator);
            }
            else {
                isFirst = false;
            }

            if (element != null) {
                buffer.append(element);
            }
        }

        return buffer.toString();
    }

    private void handleInvalidCORS(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {
        response.setContentType("text/plain");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.resetBuffer();
    }

    private boolean isOriginAllowed(final String origin) {
        if (anyOriginAllowed) {
            return true;
        }

        return allowedOrigins.contains(origin);
    }

}