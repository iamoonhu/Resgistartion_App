import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/hello")
public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String course = request.getParameter("course");
        String year = request.getParameter("year");
        String rollNo = request.getParameter("rollNo");
        String guardian = request.getParameter("guardian");
        String guardianPhone = request.getParameter("guardianPhone");
        String password = request.getParameter("password");
        String terms = request.getParameter("terms");


        //providing values to out Model.java
        Model model = new Model();

        //setting values
        model.setFirstName(firstName);
        model.setLastName(lastName);
        model.setDob(dob);
        model.setGender(gender);
        model.setEmail(email);
        model.setPhone(phone);
        model.setAddress(address);
        model.setCity(city);
        model.setState(state);
        model.setCourse(course);
        model.setYearOfStudy(year);
        model.setRollNo(rollNo);
        model.setGuardianName(guardian);
        model.setGuardianPhone(guardianPhone);
        model.setPassword(password);
        model.setTermsAccepted(terms);

        int rows= 0;  // it will give me the number of rows affected
        try {
            rows = model.registor();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        HttpSession session= request.getSession();
        session.setAttribute("name",firstName);
        if (rows==0){
            response.sendRedirect(request.getContextPath() + "/failure.jsp");
        }else{
            response.sendRedirect(request.getContextPath() + "/Success.jsp");
        }

    }
}
