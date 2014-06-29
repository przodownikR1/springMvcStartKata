<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ page isErrorPage="true"%>
<%@page import="java.io.*"%>
<html>
<body>

<h2/> error</h2>
<p/>

<%
try {
        // The Servlet spec guarantees this attribute will be available
        Throwable exception1 = (Throwable) request.getAttribute("javax.servlet.error.exception");

        if (exception1 != null) {
                if (exception1 instanceof ServletException) {
                        // It's a ServletException: we should extract the root cause
                        ServletException sex = (ServletException) exception1;
                        Throwable rootCause = sex.getRootCause();
                        if (rootCause == null)
                                rootCause = sex;
                        out.println("** Root cause is: "+ rootCause.getMessage());
                        rootCause.printStackTrace(new java.io.PrintWriter(out));
                }
                else {
                        // It's not a ServletException, so we'll just show it
                        exception1.printStackTrace(new java.io.PrintWriter(out));
                }
        }
        else  {
        out.println("No error information available");
        }

        // Display cookies
        out.println("\nCookies:\n");
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
                out.println(cookies[i].getName() + "=[" + cookies[i].getValue() + "]");
                }
        }

} catch (Exception ex) {
        ex.printStackTrace(new java.io.PrintWriter(out));
}
%>


</body>
</html>