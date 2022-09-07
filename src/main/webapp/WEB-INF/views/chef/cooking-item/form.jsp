<%@page language="java"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
	<acme:input-textbox code="chef.cookingItem.form.label.name" path="name" readonly="true"/>
	<acme:input-textbox code="chef.cookingItem.form.label.code" path="code" readonly="true"/>
	<acme:input-textbox code="chef.cookingItem.form.label.description" path="description" readonly="true"/>
	<acme:input-money code="chef.cookingItem.form.label.retailPrice" path="retailPrice" readonly="true"/>
	<acme:input-url code="chef.cookingItem.form.label.link" path="link" readonly="true"/>
	<acme:input-textbox code="chef.cookingItem.form.label.type" path="type" readonly="true"/>
	
</acme:form>