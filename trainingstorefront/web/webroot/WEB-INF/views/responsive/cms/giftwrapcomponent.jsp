
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="cart" tagdir="/WEB-INF/tags/responsive/cart"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">


<!-- <style>
.welcomeInfo {
	font-weight: bold;
	margin-right: 5px;
	color: #0000ff;
}

.customOffersComponent {
	border: 1px dotted #a5a5a5;
	border-width: 1px 0;
	position: relative;
}

.offers_list {
	margin: 20px 0;
	padding: 5px;
	border: 1px dotted #000;
}

.offers_list_element {
	vertical-align: top;
	border-bottom: 1px dotted #a5a5a5;
	padding: 20px 0 0 0;
} -->
<!-- </style> -->


<div class="container">

	<div class="row">
	<c:forEach items="${component.listOfGiftWraps}" var="giftWrap">
		<div class="col">
			${giftWrap.code}
			<br>${giftWrap.giftWrapType}<br>
			${giftWrap.cost}
			
		</div>
		</c:forEach>
	</div>
</div>




<%-- <ul class="offers_list">
	<c:forEach items="${component.listOfGiftWraps}" var="giftWrap">
		<br>${giftWrap.code}
    <br>${giftWrap.giftWrapType}
    <br>${giftWrap.cost}
	</c:forEach>
</ul> --%>