import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Model {
    protected String firstName;
    protected String lastName;
    protected String dob;
    protected String gender;
    protected String email;
    protected String phone;
    protected String address;
    protected String city;
    protected String state;
    protected String course;
    protected String yearOfStudy;
    protected String rollNo;
    protected String guardianName;
    protected String guardianPhone;
    protected String password;
    protected String termsAccepted;
    protected Connection connect;
    protected PreparedStatement psmt;
    int rowsInserted;

    //setter for the all the variable
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName; }
    public void setDob(String dob) { this.dob = dob; }
    public void setGender(String gender) {this.gender = gender;}
    public void setEmail(String email) {this.email = email;}
    public void setPhone(String phone) {this.phone = phone;}
    public void setAddress(String address) {this.address = address;}
    public void setCity(String city) {this.city = city;}
    public void setState(String state) {this.state = state;}
    public void setCourse(String course) {this.course = course;}
    public void setYearOfStudy(String yearOfStudy) {this.yearOfStudy = yearOfStudy;}
    public void setRollNo(String rollNo) {this.rollNo = rollNo;}
    public void setGuardianName(String guardianName) {this.guardianName = guardianName;}
    public void setGuardianPhone(String guardianPhone) {this.guardianPhone = guardianPhone;}
    public void setPassword(String password) {this.password = password;}
    public void setTermsAccepted(String termsAccepted) {this.termsAccepted = termsAccepted;}

    //getter for the variable
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public String getDob() {return dob;}
    public String getGender() {return gender;}
    public String getEmail() {return email;}
    public String getPhone() {return phone;}
    public String getAddress() {return address;}
    public String getCity() {return city;}
    public String getState() {return state;}
    public String getCourse() {return course;}
    public String getYearOfStudy() {return yearOfStudy;}
    public String getRollNo() {return rollNo;}
    public String getGuardianName() {return guardianName;}
    public String getGuardianPhone() {return guardianPhone;}
    public String getPassword() {return password;}
    public String getTermsAccepted() {return termsAccepted;}

    public int registor() throws SQLException {

        try {
             connect = JDBCutil.getConnection();
             //Sql query
            String sql = "INSERT INTO students (first_name, last_name, dob, gender, email, phone, address, city, state, course, year_of_study, roll_no, guardian_name, guardian_phone, password, terms_accepted) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            psmt= connect.prepareStatement(sql);
            psmt.setString(1, firstName);
            psmt.setString(2, lastName);
            psmt.setString(3, dob);
            psmt.setString(4, gender);
            psmt.setString(5, email);
            psmt.setString(6, phone);
            psmt.setString(7, address);
            psmt.setString(8, city);
            psmt.setString(9, state);
            psmt.setString(10, course);
            psmt.setString(11, yearOfStudy);
            psmt.setString(12, rollNo);
            psmt.setString(13, guardianName);
            psmt.setString(14, guardianPhone);
            psmt.setString(15, password);
            psmt.setString(16, termsAccepted);

             rowsInserted = psmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCutil.closeResouce(connect,psmt);
        }

        return rowsInserted;

    }
}
