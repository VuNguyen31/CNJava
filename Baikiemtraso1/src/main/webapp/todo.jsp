<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>To-Do List</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .task { margin: 5px 0; }
        .error { color: red; }
    </style>
</head>
<body>
    <h2>To-Do List</h2>
    
    <!-- Form to add a new task -->
    <form action="todo" method="post">
        <input type="hidden" name="action" value="add">
        <input type="text" name="task" placeholder="Enter a new task" required>
        <input type="submit" value="Add Task">
    </form>

    <!-- Display tasks -->
    <h3>Tasks</h3>
    <c:choose>
        <c:when test="${empty sessionScope.todoList}">
            <p>No tasks available.</p>
        </c:when>
        <c:otherwise>
            <c:forEach var="task" items="${sessionScope.todoList}" varStatus="loop">
                <div class="task">
                    ${loop.index + 1}. ${task}
                    <form action="todo" method="post" style="display:inline;">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="taskIndex" value="${loop.index}">
                        <input type="submit" value="Delete">
                    </form>
                </div>
            </c:forEach>
        </c:otherwise>
    </c:choose>

    <!-- Logout link (simulated) -->
    <p><a href="logout">Logout</a></p>
</body>
</html>