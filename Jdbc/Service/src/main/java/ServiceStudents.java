
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel on 11.07.2017.
 */
public class ServiceStudents implements DaoStudents {
    private final Logger logger = Logger.getLogger(ServiceStudents.class);
    Connection conn = DBConnection.getDBConnection();

    public void add(Students students) {
        PreparedStatement prst = null;
        String query1 = "INSERT INTO students (IdStudents, FirstName, LastName, Age, Birth, Phone, ClassId) VALUES (?,?,?,?,?,?,?)";
        try {
            prst = conn.prepareStatement(query1);
            conn.setAutoCommit(false);
            prst.setInt(1, students.getIdStudents());
            prst.setString(2, students.getFirstName());
            prst.setString(3, students.getLastName());
            prst.setInt(4, students.getAge());
            prst.setString(5, students.getBirth());
            prst.setInt(6, students.getPhone());
            prst.setInt(7, students.getClassId());
            prst.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            logger.error("Error query1", e);
        } finally {
            if(prst!=null){
                try {
                    prst.close();
                } catch (SQLException e) {
                    System.out.println("Error finally");
                }
            }
        }
    }

    public List<Students> getAll() {
        List<Students> studentsList = new ArrayList<Students>();
        Statement st = null;
        String query2 = "Select idStudents, FirstName, LastName, Age, Birth, Phone, ClassId from Students ";
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query2);
            while (rs.next()) {
                Students students = new Students();
                students.setIdStudents(rs.getInt("idStudents"));
                students.setFirstName(rs.getString("FirstName"));
                students.setLastName(rs.getString("LastName"));
                students.setAge(rs.getInt("Age"));
                students.setBirth(rs.getString("Birth"));
                students.setPhone(rs.getInt("Phone"));
                students.setClassId(rs.getInt("ClassId"));
                studentsList.add(students);
            }

        } catch (SQLException e) {
            logger.error("Error query2", e);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    System.out.println("Error finally");
                }
            }
            return studentsList;
        }
    }

    public Students getById(int idStudents) {
        PreparedStatement prst = null;
        String query3 = "SELECT * FROM Students where idStudents=?";
        Students students = new Students();

        try {
            prst = conn.prepareStatement(query3);
            prst.setInt(1, idStudents);
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                students.setIdStudents(rs.getInt("idStudents"));
                students.setFirstName(rs.getString("FirstName"));
                students.setLastName(rs.getString("LastName"));
                students.setAge(rs.getInt("Age"));
                students.setBirth(rs.getString("Birth"));
                students.setPhone(rs.getInt("Phone"));
                students.setClassId(rs.getInt("ClassId"));
                System.out.println(students);
            }
          } catch (SQLException e) {
            logger.error("Error query3", e);
    } finally {
        if (prst != null) {
            try {
                prst.close();
            } catch (SQLException e) {
                System.out.println("Error finally");
            }
        }
    }
        return students;
    }


    public void update(Students students) {

        PreparedStatement prst = null;
        String query4 = "UPDATE Students SET  FirstName=?, LastName=?, Age=?, Birth=?, Phone=?, ClassId=? where idStudents=?";
        try {
            prst = conn.prepareStatement(query4);
            conn.setAutoCommit(false);
            prst.setString(1, students.getFirstName());
            prst.setString(2, students.getLastName());
            prst.setInt(3, students.getAge());
            prst.setString(4, students.getBirth());
            prst.setInt(5, students.getPhone());
            prst.setInt(6, students.getClassId());
            prst.setInt(7, students.getIdStudents());
            prst.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            logger.error("Error query4", e);
        } finally {
            if (prst != null) {
                try {
                    prst.close();
                } catch (SQLException e) {
                    System.out.println("Error finally");
                }
            }
        }
    }



    public void delete(Students students) {
        PreparedStatement prst = null;
        String query5 = "DELETE FROM Students where idStudents=?";
        try {
            prst = conn.prepareStatement(query5);
            conn.setAutoCommit(false);
            prst.setInt(1, students.getIdStudents());
            prst.executeUpdate();
            conn.commit();

        } catch (SQLException e) {
            logger.error("Error query5", e);
        }finally {
            if (prst != null) {
                try {
                    prst.close();
                } catch (SQLException e) {
                    System.out.println("Error finally");
                }
            }
        }
    }

    public void getJoin() {
        Statement statement = null;
        try {
            statement = conn.createStatement();
            String query6 = "SELECT STUDENTS.FirstName, students.LastName, CLAS.NameClass, CLAS.Teacher FROM students inner join CLAS ON STUDENTS.ClassId = CLAS.idClass";
            ResultSet rs = statement.executeQuery(query6);
        while (rs.next()){
            System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+
            " "+rs.getString(4));
        }
        }catch (SQLException e) {
            logger.error("Error query6", e);
        }
        System.out.println();
    }
}


