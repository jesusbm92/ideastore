<%--
 * header.jsp
 *
 * Copyright (C) 2014 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<div id="head">
	<img src="images/logoidea.png" alt="Idea Store" /><br/>
	<p> Uplifting your ideas to the next level!!! </p>
</div>

<div>
	<ul id="jMenu">
		<!-- Do not forget the "fNiv" class for the first level links !! -->
		<security:authorize access="hasRole('ADMIN')">
			<li class="startSpace"> </li>	
			<li><a class="fNiv"><spring:message	code="master.page.administrator" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="administrator/action-1.do"><spring:message code="master.page.administrator.action.1" /></a></li>
					<li><a href="administrator/action-2.do"><spring:message code="master.page.administrator.action.2" /></a></li>					
				</ul>
			</li>
		</security:authorize>
		
		<security:authorize access="hasRole('CUSTOMER')">
			<li class="startSpace"> </li>						
			<li><a class="fNiv"><spring:message	code="master.page.customer" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="idea/list.do"><spring:message code="master.page.customer.action.1" /></a></li>
					<li><a href="customer/action-2.do"><spring:message code="master.page.customer.action.2" /></a></li>					
				</ul>
			</li>
		</security:authorize>
		
		<security:authorize access="isAnonymous()">
			<li class="startSpace"> </li>						
			<li><a class="fNiv"><spring:message	code="master.page.customer" /></a>
				<ul>
					<li class="arrow"></li>
					<li><a href="idea/list.do"><spring:message code="master.page.customer.action.1" /></a></li>
					<li><a href="customer/action-2.do"><spring:message code="master.page.customer.action.2" /></a></li>					
				</ul>
			</li>
		</security:authorize>
		
		<security:authorize access="isAnonymous()">
			<li class="startSpace"> </li>	
		
			<li class="login-li"><a class="fNiv" href="security/login.do"><spring:message code="master.page.login" /></a></li>
			<li class="sls"> <a href="#">/</a> </li>		
			<li class="register-li"><a class="fNiv" href="security/register.do"><spring:message code="master.page.register" /></a></li>
			
			<li class="midSpace"> </li>		
		
			<li class="home"><a class="fNiv" href=""><spring:message code="master.page.home" /></a></li>
			<li class="services"><a class="fNiv" href="#"><spring:message code="master.page.ourServices" /></a></li>
			<li class="contact"><a class="fNiv" href="#"><spring:message code="master.page.contact" /></a></li>

			<li class=midSpace2> </li>		

			
			<li class="engLang"><a class="fNiv" href="?language=en"></a></li>
			<li class="esLang"><a class="fNiv" href="?language=es"></a></li>
			
			<li class="endSpace"> </li>	
			
		</security:authorize>
		
		<security:authorize access="isAuthenticated()">
			<li>
				<a class="fNiv"> 
					<spring:message code="master.page.profile" /> 
			        (<security:authentication property="principal.username" />)
				</a>
				<ul>
					<li class="arrow"></li>
					<li><a href="profile/action-1.do"><spring:message code="master.page.profile.action.1" /></a></li>
					<li><a href="profile/action-2.do"><spring:message code="master.page.profile.action.2" /></a></li>
					<li><a href="profile/action-3.do"><spring:message code="master.page.profile.action.3" /></a></li>					
					<li><a href="j_spring_security_logout"><spring:message code="master.page.logout" /> </a></li>
				</ul>
			</li>
			<li class="endSpace"> </li>
		</security:authorize>
	</ul>
</div>
<!--  
<div>
	<a href="?language=en">en</a> | <a href="?language=es">es</a>
</div>
-->
