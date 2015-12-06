<%--
 * action-1.jsp
 *
 * Copyright (C) 2013 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@page import="domain.Idea"%>

<h1 class="text-center">
	<spring:message code="idea.ideas" />
</h1>

<div class="container">
	<display:table uid="ideaListTable" keepStatus="false" name="ideas"
		pagesize="5" class="table table-hover" requestURI="${requestURI}"
		id="row">
		<display:column property="name" titleKey="idea.name" sortable="true" />
		<display:column property="description" titleKey="idea.description"
			sortable="true" />
		<display:column>
			<a href="idea/view.do?ideaId=${row.id}"><input
				class="btn btn-default" type="button"
				value="<spring:message code="idea.view"/>"
				onclick="self.location.href = idea/view.do?ideaId=${row.id}" /></a>
		</display:column>
		<display:column>
			<a href="idea/edit.do?ideaId=${row.id}"><input
				class="btn btn-default" type="button"
				value="<spring:message code="idea.edit"/>"
				onclick="self.location.href = idea/edit.do?ideaId=${row.id}" /></a>
		</display:column>
		<display:column>
			<a href="comment/list.do?ideaId=${row.id}"><input
				class="btn btn-default" type="button"
				value="<spring:message code="comment.list"/>"
				onclick="self.location.href = comment/list.do?ideaId=${row.id}" /></a>
		</display:column>
		<display:column>
			<a href="idea/delete.do?ideaId=${row.id}"><input
				class="btn btn-default" type="button"
				value="<spring:message code="idea.delete"/>"
				onclick="self.location.href = idea/delete.do?ideaId=${row.id}" /></a>
		</display:column>
	</display:table>
	<a href="idea/create.do"><input
		class="btn btn-default" type="button"
		value="<spring:message code="idea.create"/>"
		onclick="self.location.href = idea/create.do" /></a>
	<!-- 		<a -->
	<!-- 		href="diet/administrator/list.do"><input type="button" -->
	<%-- 		class="btn btn-default" value="<spring:message code="diet.back"/>" --%>
	<!-- 		onclick="self.location.href = diet/administrator/list.do" /></a> -->
</div>
