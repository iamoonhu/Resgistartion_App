import java.sql.*;

public class JDBCutil {

    private static final String URL = "jdbc:mysql://localhost:3306/student_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "R9v#K2m@L7q!X4t$";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found.", e);
        }
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    //mthod for closing the connection
    public static void closeResouce(Connection conn, PreparedStatement stmt) throws  SQLException{

          if(conn!=null){
              conn.close();
          }
          if(stmt!=null){
              stmt.close();
          }
    }
}
