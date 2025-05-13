package Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/todo")
public class TodoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<String> todoList = (List<String>) session.getAttribute("todoList");
        if (todoList == null) {
            todoList = new ArrayList<>();
            session.setAttribute("todoList", todoList);
        }

        String action = request.getParameter("action");
        if ("add".equals(action)) {
            String task = request.getParameter("task");
            if (task != null && !task.trim().isEmpty()) {
                todoList.add(task);
            }
        } else if ("delete".equals(action)) {
            String taskIndex = request.getParameter("taskIndex");
            if (taskIndex != null) {
                try {
                    int index = Integer.parseInt(taskIndex);
                    if (index >= 0 && index < todoList.size()) {
                        todoList.remove(index);
                    }
                } catch (NumberFormatException e) {
                    // Ignore invalid index
                }
            }
        }

        response.sendRedirect("todo.jsp");
    }
}