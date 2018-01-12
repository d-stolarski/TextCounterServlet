import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/textarea")
public class TextServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String text = request.getParameter("usertext");
        String[] words = text.split(" ");
        int numberOfCharactersWithoutSpaces = text.replace(" ", "").length();

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println(text);
        writer.println("<h2>Ilość słów: " + words.length + "</h2>");
        writer.println("<h2>Ilość znaków: " + text.length() + "</h2>");
        writer.println("<h2>Ilość znaków (bez spacji): " + numberOfCharactersWithoutSpaces + "</h2>");
        writer.println("<h2>Palindrom: " + isPalindrom(text) + "</h2>");
    }

    private boolean isPalindrom(String text) {
        String reverseText = "";
        int length = text.length();
        for (int i = length - 1; i >= 0; i--) {
            reverseText = reverseText + text.charAt(i);
        }
        if (text.equals(reverseText)) {
            return true;
        } else {
            return false;
        }
    }
}
