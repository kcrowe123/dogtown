<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/commonStyle.css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/js/dogtown.js"></script>
<title><tiles:insertAttribute name="title" ignore="true"/></title>
</head>
<body>
<div id="allContent">
		<div id="header"><tiles:insertAttribute name="header" /></div>
		<div id="leftcol"><tiles:insertAttribute name="menu" /></div>
		<div id="layoutContent"><tiles:insertAttribute name="body" /></div>
		<div id="footer"><tiles:insertAttribute name="footer" /></div>
</div>
</body>
</html>