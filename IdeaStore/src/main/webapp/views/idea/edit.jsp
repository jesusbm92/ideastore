<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@page import="domain.Idea"%>

<div class="container">
	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<div class="well well-sm">
				<form:form class="form-horizontal" action="idea/edit.do"
					modelAttribute="idea" >


					<form:hidden path="id" />
					<form:hidden path="version" />

					<fieldset>
	
					<div class="form-group">
					
							<div class="col-md-10">
							<spring:message code="idea.name" />:
								<form:input path="name" id="name" name="name" type="text"
									class="form-control" maxlength="255" size="100"/>
							</div>
							
							<div class="col-md-30">
							<spring:message code="idea.description" />:
								<form:input path="description" id="description" name="description" type="text"
									class="form-control" maxlength="255" size="100"/>
							</div>
						 
					</div>
					</fieldset>
					
					
					<input type="submit" name="save" class="btn btn-primary btn-lg"
									value="<spring:message code="idea.save" />" />
							<a href="idea/list.do"><input type="button"
								class="btn btn-primary btn-lg"
								value="<spring:message code="idea.back"/>" id="back" name="back"
								onclick="self.location.href = idea/list.do" /></a>
				</form:form>
			</div>

		</div>
	</div>
</div>
