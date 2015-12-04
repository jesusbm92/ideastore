<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<div class="container">
	<display:table uid="commentListTable" keepStatus="false"
		name="comments" pagesize="5" class="table table-hover"
		requestURI="${requestURI}" id="row">
		<display:column property="content" titleKey="comment.content"
			sortable="true" />
		<display:column property="idea.name" titleKey="comment.name"
			sortable="true" />
			
		<display:column property="user.name" titleKey="comment.user"
			sortable="true" />
		
	</display:table>
	
	<a href="comment/create.do?ideaId=${idea.id}"><input type="button"
		class="btn btn-default"
		value="<spring:message code="comment.create"/>"
		onclick="self.location.href = comment/create.do" /></a>
<!-- 
	<security:authorize access="hasRole('CUSTOMER')">
		<a href="idea/customer/list.do"><input type="button"
			class="btn btn-default"
			value="<spring:message code="comment.cancel"/>"
			onclick="self.location.href = idea/customer/list.do" /></a>
	</security:authorize>
	
	<security:authorize access="hasRole('ADMIN')">
		<a href="plan/administrator/list.do"><input type="button"
			class="btn btn-default"
			value="<spring:message code="comment.cancel"/>"
			onclick="self.location.href = plan/administrator/list.do" /></a>
	</security:authorize>
	 -->
</div>
