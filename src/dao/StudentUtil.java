package dao;

import conn.JdbcConnec;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentUtil {

    private static Connection connectToDb() {
        return JdbcConnec.getInstance().getConn();
    }

    public static boolean createStudentTable() throws SQLException {
        Statement stmt = connectToDb().createStatement();
        return !stmt.execute(
                "CREATE TABLE if not exists Student(stu_id int primary key auto_increment, Stud_Name varchar(20) not null, Stud_course varchar(15), Stu_age tinyint);");
    }

    public static boolean insertStudent(int id, String name, String course, byte age) throws SQLException {
        Statement stmt = connectToDb().createStatement();
        String query = String.format("INSERT INTO Student VALUES (%d, '%s', '%s', %d)", id, name, course, age);
        return stmt.executeUpdate(query) > 0;
    }

    public static boolean updateStudent(int id, String name, String course, byte age) throws SQLException {
        Statement stmt = connectToDb().createStatement();
        String query = String.format("UPDATE Student SET Stud_Name='%s', Stud_course='%s', Stu_age=%d WHERE stu_id=%d",
                name, course, age, id);
        return stmt.executeUpdate(query) > 0;
    }

    public static boolean deleteStudent(int id) throws SQLException {
        Statement stmt = connectToDb().createStatement();
        String query = String.format("DELETE FROM Student WHERE stu_id=%d", id);
        return stmt.executeUpdate(query) > 0;
    }

    public static ResultSet searchStudentById(int id) throws SQLException {
        Statement stmt = connectToDb().createStatement();
        String query = String.format("SELECT * FROM Student WHERE stu_id=%d", id);
        return stmt.executeQuery(query);
    }
}