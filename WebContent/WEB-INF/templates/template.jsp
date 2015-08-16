<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<tiles:importAttribute name="cssList" />
<c:forEach var="css" items="${cssList}">
    <link rel="stylesheet" href='<spring:url value="${css}" />'>
</c:forEach>
<title><tiles:getAsString name="title" /></title>
</head>
<body>
    <tiles:insertAttribute name="header" />
    <tiles:insertAttribute name="content" />
    <tiles:insertAttribute name="footer" />

    <tiles:importAttribute name="jsList" />
    <c:forEach var="js" items="${jsList}">
        <script src='<spring:url value="${js}" />'></script>
    </c:forEach>

</body>
</html>