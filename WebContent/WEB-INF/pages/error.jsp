<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<c:if test="${mess.message != null}">
	<div class="msg">test1: ${mess.message.age}</div>
</c:if>
<div class="msg">test5: ${mess.message.age}</div>