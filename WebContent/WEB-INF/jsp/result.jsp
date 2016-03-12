<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link
	href="<c:url value="/resources/bootstrap-3.3.6-dist/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<title>CWS Search engine</title>
</head>
<body>
	<div class="site-wrapper">

		<div class="site-wrapper-inner">
			<h2>CWS Search Result</h2>
			<c:forEach var="rsl" items="${rslList}">
				<c:choose>
					<c:when test="${rsl.isNotFind() }">
					We skipped <span id="skippedToken">"${rsl.getTitle() }"</span>
				</c:when>
					<c:otherwise>
						<h3>
							<a class="myA" href="<c:out value="${rsl.getUrl()}"></c:out>"><c:out
									value="${rsl.getTitle()}"></c:out></a>(Rank:
							<c:out value="${rsl.getRank()}"></c:out>
							)
						</h3>
						<p>
							<c:out value="${rsl.getParagraph()}"></c:out>
						</p>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<div class="mastfoot">
				<div class="inner">
					<p>
						Authors are <a href="http://frankgt40.com">Cheng Cai(95164901)</a>,
						<a href="http://secret-sharing.com/resumes/wbj.html">Bojun
							Wang(58203736)</a>, and <a href="#">Shenghui Shao(30842617)</a>.
					</p>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="<c:url value="/resources/bootstrap-3.3.6-dist/js/bootstrap.min.js" />"></script>
</body>
</html>