<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Giải phương trình bậc hai</title>
</head>
<body>
    <h1>Giải phương trình ax² + bx + c = 0</h1>
    
    <form method="post">
        a: <input type="text" name="a"><br>
        b: <input type="text" name="b"><br>
        c: <input type="text" name="c"><br>
        <input type="submit" value="Giải">
    </form>

    <hr>

    <%
        String sa = request.getParameter("a");
        String sb = request.getParameter("b");
        String sc = request.getParameter("c");

        if (sa != null && sb != null && sc != null) {
            try {
                double a = Double.parseDouble(sa);
                double b = Double.parseDouble(sb);
                double c = Double.parseDouble(sc);

                if (a == 0) {
                    out.println("Không phải phương trình bậc hai.");
                } else {
                    double delta = b * b - 4 * a * c;
                    if (delta > 0) {
                        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                        double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                        out.println("2 nghiệm: x1 = " + x1 + ", x2 = " + x2);
                    } else if (delta == 0) {
                        double x = -b / (2 * a);
                        out.println("Nghiệm kép: x = " + x);
                    } else {
                        out.println("Vô nghiệm.");
                    }
                }
            } catch (Exception ex) {
                out.println("Lỗi: Nhập số không hợp lệ.");
            }
        }
    %>
</body>
</html>
