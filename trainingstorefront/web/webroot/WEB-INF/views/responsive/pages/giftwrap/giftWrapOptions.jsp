<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div class="container">

    <c:url value="/giftwrap/add" var="addGiftWrap"/>

	<form:form action="${addGiftWrap}" method="post">
		<table>
			<tr>
				<th>Select</th>
				<th>Description</th>
				<th>Cost</th>
				<th>Gift Wrap type</th>
				<th>GiftWrap Image</th>
			</tr>

			<c:forEach items="${listOfGiftWraps}" var="giftWrap">
				<tr>
					<th><input type="radio" name="giftWrapCode" value="${giftWrap.giftWrapType}"></th>
					<th>${giftWrap.description}</th>
					<th>${giftWrap.cost}</th>
					<th>${giftWrap.giftWrapType}</th>
					<th><img src="${giftWrap.giftWrapImage.url}" height="150px"
						width="150px"></th>
				</tr>
			</c:forEach>
		</table>
		<input type="hidden" name="orderEntryPk" value="${orderEntryPk}"/>
		<button type="submit"  >Save</button>
	</form:form>
</div>



