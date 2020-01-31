
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="cart" tagdir="/WEB-INF/tags/responsive/cart"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>

<div class="container">
	<table class="">
		<tr>
			<th>Code</th>
			<th>Description</th>
			<th>Cost</th>
			<th>Gift Wrap type</th>
			<th>GiftWrap Image</th>
		</tr>

		<c:forEach items="${component.listOfGiftWraps}" var="giftWrap">
			<tr>
				<th>${giftWrap.code}</th>
				<th>${giftWrap.description}</th>
				<th>${giftWrap.cost}</th>
				<th>${giftWrap.giftWrapType}</th>
				<th><img src="${giftWrapImage.url}" height="150px"
					width="150px"></th>
			</tr>
		</c:forEach>
	</table>
</div>



