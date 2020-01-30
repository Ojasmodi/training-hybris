<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="cart" tagdir="/WEB-INF/tags/responsive/cart"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<style>


.offers_list {
	margin: 20px 0;
	padding: 5px;
	border: 1px dotted #000;
}

.offers_list_element {
	vertical-align: top;
	border-bottom: 1px dotted #a5a5a5;
	padding: 20px 0 0 0;
}
</style>
<spring:htmlEscape defaultHtmlEscape="true" />

<template:page pageTitle="${pageTitle}">

	<cart:cartValidation />
	<cart:cartPickupValidation />

	<div class="cart-top-bar">
		<div class="text-right">
			<spring:theme var="textHelpHtml" code="text.help" />
			<a href="" class="help js-cart-help"
				data-help="${fn:escapeXml(textHelpHtml)}">${textHelpHtml} <span
				class="glyphicon glyphicon-info-sign"></span>
			</a>
			<div class="help-popup-content-holder js-help-popup-content">
				<div class="help-popup-content">
					<strong>${fn:escapeXml(cartData.code)}</strong>
					<spring:theme var="cartHelpContentVar"
						code="basket.page.cartHelpContent" htmlEscape="false" />
					<c:set var="cartHelpContentVarSanitized"
						value="${ycommerce:sanitizeHTML(cartHelpContentVar)}" />
					<div>${cartHelpContentVarSanitized}</div>
				</div>
			</div>
		</div>
	</div>

	<!--  	   My custom component -->

	<%--  <div class="welcomeInfo">
		<cms:pageSlot position="giftWrapSlotName" var="feature">
			<cms:component component="${feature}" element="div" />
		</cms:pageSlot>
	</div> --%> 
	
<!-- 	<div class="customOffersComponent"> -->
<%-- 		<cms:pageSlot position="giftWrapSlotName" var="feature"> --%>
<%-- 			<cart:giftwrap component="${feature}" element="div" /> --%>
<%-- 		</cms:pageSlot> --%>
<!-- 	</div> -->

	<cms:pageSlot position="giftWrapSlotName" var="component">
		<cms:component component="${component}"/>
	</cms:pageSlot> 
	 

	<!--    End of my custom component -->

	<div>
		<div>
			<cms:pageSlot position="TopContent" var="feature">
				<cms:component component="${feature}" element="div"
					class="yComponentWrapper" />
			</cms:pageSlot>
		</div>

		<c:if test="${not empty cartData.rootGroups}">
			<cms:pageSlot position="CenterLeftContentSlot" var="feature">
				<cms:component component="${feature}" element="div"
					class="yComponentWrapper" />
			</cms:pageSlot>
		</c:if>

		<c:if test="${not empty cartData.rootGroups}">
			<cms:pageSlot position="CenterRightContentSlot" var="feature">
				<cms:component component="${feature}" element="div"
					class="yComponentWrapper" />
			</cms:pageSlot>
			<cms:pageSlot position="BottomContentSlot" var="feature">
				<cms:component component="${feature}" element="div"
					class="yComponentWrapper" />
			</cms:pageSlot>
		</c:if>

		<c:if test="${empty cartData.rootGroups}">
			<cms:pageSlot position="EmptyCartMiddleContent" var="feature">
				<cms:component component="${feature}" element="div"
					class="yComponentWrapper content__empty" />
			</cms:pageSlot>
		</c:if>
	</div>
</template:page>
