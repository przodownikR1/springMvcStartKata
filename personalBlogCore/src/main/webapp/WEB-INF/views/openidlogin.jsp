<%@ include file="/WEB-INF/views/includes.jsp"%>
<head>
    <title>OpenID Login</title>

    <link rel="stylesheet" href="<c:url value='/css/openid.css'/>" />
    <script type="text/javascript" src="<c:url value='/js/openid-jquery.js'/>"></script>

    <script type="text/javascript">
    $(document).ready(function() {
        openid.init('openid_identifier');
     //   openid.setDemoMode(true); Stops form submission for client javascript-only test purposes
    });
    </script>

    <style type="text/css">
        /* Basic page formatting. */
        body {
            font-family:"Helvetica Neue", Helvetica, Arial, sans-serif;
        }
    </style>
</head>

<body>

<c:if test="${not empty param.login_error}">
  <font color="red">
    Your login attempt was not successful, try again.<br/><br/>
    Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
  </font>
</c:if>

<!-- Simple OpenID Selector -->
<form action="<c:url value='j_spring_openid_security_check'/>" method="post" id="openid_form">
    <input type="hidden" name="action" value="verify" />

    <fieldset>
            <legend>Sign-in or Create New Account</legend>

            <div id="openid_choice">
                <p>Please click your account provider:</p>
                <div id="openid_btns"></div>

            </div>

            <div id="openid_input_area">
                <input id="openid_identifier" name="openid_identifier" type="text" value="http://" />
                <input id="openid_submit" type="submit" value="Sign-In"/>
            </div>
            <noscript>
            <p>OpenID is a service that allows you to log-on to many different websites using a single identity.
            Find out <a href="http://openid.net/what/">more about OpenID</a> and <a href="http://openid.net/get/">how to get an OpenID enabled account</a>.</p>
            </noscript>
    </fieldset>
</form>


</body>
</html>
