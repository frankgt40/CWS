<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CWS Search engine</title>
</head>
<body>
<h2>Welcome to use our little search engine!</h2>
<form:form method="POST" action="/CWS/search">
<form:label path="query">Query </form:label>
<form:input path="query" />
<br/>
<input type="submit" value="Search"/>
</form:form>
</body>
</html>