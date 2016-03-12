<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="<c:url value="/resources/bootstrap-3.3.6-dist/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<title>CWS Search engine</title>
</head>
<body>
	<div class="site-wrapper">

		<div class="site-wrapper-inner">

			<div class="cover-container">

				<div class="masthead clearfix">
					<div class="inner">
						<h3 class="masthead-brand">CWS Search engine</h3>
						<nav>
						<ul class="nav masthead-nav">
							<li class="active"><a href="#">Home</a></li>
							<li><a href="http://frankgt40.com">Contact us</a></li>
						</ul>
						</nav>
					</div>
				</div>

				<div class="inner cover">
					<h1 class="cover-heading">CWS Search engine.</h1>
					<p class="lead">This is our little search engine, written for
						the course ICS221 Information Retrival at UC Irvine. Please enter your query in the input box below and click on the Search button, and enjoy
						it!</p>
						<form:form method="POST" action="/CWS/search">
						
					<p class="lead black-color">
							<form:label path="query"> </form:label>
							<form:input path="query" />
							
					</p>
							<p>Improved version (or not):
							<input type="checkbox" name="improvedVersion">
							</p>
					<p class="lead">
							<input type="submit" value="Search" class="btn btn-lg btn-default"/>
							</p>
						</form:form>
				</div>

				<div class="mastfoot">
					<div class="inner">
						<p>
							Authors are <a href="http://frankgt40.com">Cheng Cai(95164901)</a>,
							<a href="http://secret-sharing.com/resumes/wbj.html">Bojun Wang(58203736)</a>, and
							<a href="#">Shenghui Shao(30842617)</a>.
						</p>
					</div>
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