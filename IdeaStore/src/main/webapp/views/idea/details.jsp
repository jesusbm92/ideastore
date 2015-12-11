<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<div class="container">
	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<div class="well well-sm">
				<form:form class="form-horizontal" action="idea/details.do"
					modelAttribute="idea" enctype="multipart/form-data">

					<form:hidden path="id" />
					<form:hidden path="version" />

					<fieldset>
					<!-- Form actions -->
						<div class="form-group">
							<a href="idea/list.do"><input type="button"
								class="btn btn-primary btn-lg"
								value="<spring:message code="idea.back"/>" id="back" name="back"
								onclick="self.location.href = idea/list.do" />
							</a>


							
							<a href="idea/edit.do?ideaId=${idea.id}"><input type="button"
								class="btn btn-primary btn-lg"
								value="<spring:message code="idea.editIdea"/>" 
								onclick="self.location.href = idea/edit.do?ideaId=$(idea.id}" />
							</a>
							<a href="idea/delete.do?ideaId=${idea.id}"><input type="button"
								class="btn btn-primary btn-lg"
								value="<spring:message code="idea.delete"/>" 
								onclick="self.location.href = idea/delete.do?ideaId=$(idea.id}" />
							</a>
							
							<a href="label/create.do?ideaId=${idea.id}"><input type="button"
								class="btn btn-primary btn-lg"
								value="<spring:message code="idea.createlabel"/>" 
								onclick="self.location.href = label/create.do?ideaId=$(idea.id}" />
							</a>						
							
							<a href="comment/create.do?ideaId=${idea.id}"><input type="button"
								class="btn btn-default"
								value="<spring:message code="idea.createcomment"/>"
								onclick="self.location.href = comment/create.do" />
							</a>						
						</div>
						<!-- Name -->
						<div class="col-md-6">
							<h2>
								<!-- <spring:message code="idea.name" />-->
								${idea.name }
							</h2>
						</div>

						<!-- Description -->
						<div class="col-md-6">
							<p>
								<!-- <spring:message code="idea.description" />
								: ${idea.description }-->
								${idea.description }
							</p>
						</div>

						<h2><spring:message code="idea.labels" /> </h2>
						<jstl:forEach items="${idea.labels }" var="label" varStatus="loop">
							<div class="col-md-6">
								<p>
 									<!--<spring:message code="idea.label" /> ${loop.index +1}
									: ${label.description } -->
									${label.description }
								</p>
								<a href="label/delete.do?labelId=${label.id}"><input type="button"
								id="deletebtn" class="btn btn-primary btn-lg"
								value="<spring:message code="idea.deletelabel"/>" 
								onclick="self.location.href = label/delete.do?labelId=$(label.id}" />
							</a>
							</div>
						</jstl:forEach>

						<h2><spring:message code="idea.comments" /> </h2>
						<jstl:forEach items="${idea.comments }" var="comment" varStatus="loop">
							<div class="col-md-6">
								<p>
									<!--<spring:message code="idea.comment" /> ${loop.index +1}
									: ${comment.content }-->
									${comment.content }
								</p>
								<hr/>
							</div>
						</jstl:forEach>
					</fieldset>
				</form:form>
			</div>

		</div>
	</div>
</div>
