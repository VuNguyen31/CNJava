<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Kết quả đăng nhập</title>
</head>
<body>
    <c:choose>
        <c:when test="${requestScope.message eq 'Đăng nhập thành công!'}">
            <h3 style="color:green"><c:out value="${requestScope.message}" /></h3>
        </c:when>
        <c:otherwise>
            <h3 style="color:red"><c:out value="${requestScope.message}" /></h3>
        </c:otherwise>
    </c:choose>
</body>
</html>
