<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>CWS Search engine</title>
</head>
<body>
<h2>Query result:</h2>
<c:forEach var="rsl" items="${rslList}">
<h2><a href="<c:out value="${rsl.getUrl()}"></c:out>"><c:out value="${rsl.getTitle()}"></c:out></a>(Rank: <c:out value="${rsl.getRank()}"></c:out>)</h2>
<p><c:out value="${rsl.getParagraph()}"></c:out></p>
</c:forEach>
</body>
</html>