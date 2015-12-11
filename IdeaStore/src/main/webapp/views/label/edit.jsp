
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<%@page import="domain.Label"%>

<style>
body {
	padding-top: 20px;
}
</style>

<div class="container">
	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<div class="well well-sm">
				<form:form class="form-horizontal"
					action="label/edit.do" modelAttribute="label">

					<form:hidden path="id" />
					<form:hidden path="version" />
					<form:hidden path="idea" />
					
					<fieldset>

						<!-- Description input-->
						<p>Insert a label for the idea</p>
						<div class="form-group">
							<div class="col-md-6">
								<form:input path="description" id="description" name="description" type="text"
									class="form-control" maxlength="255" size="100"/>
							</div>

						</div>


						<!-- Form actions -->
						<div class="form-group">
							<div class="col-md-12 text-center">
								<a href="idea/list.do"><input type="button"
									class="btn btn-primary btn-lg"
									value="<spring:message code="label.cancel"/>" id="cancelar"
									name="cancelar"
									onclick="self.location.href = idea/list.do" /></a>
								<input type="submit" name="save" class="btn btn-primary btn-lg"
									value="<spring:message code="label.save" />" />
								<!-- <a href="label/delete.do?labelId=262147"><input type="button"
									class="btn btn-primary btn-lg"
									value="<spring:message code="label.delete"/>" id="delete"
									name="delete"
									onclick="self.location.href = label/delete.do?labelId=262147" /></a>
								 -->
							</div>
						</div>
					</fieldset>
				</form:form>
			</div>
		</div>
	</div>
</div>