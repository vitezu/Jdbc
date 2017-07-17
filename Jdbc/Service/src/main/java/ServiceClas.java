
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel on 12.07.2017.
 */
public class ServiceClas implements DaoClas {
    private final Logger logger = Logger.getLogger(ServiceClas.class);
    Connection conn = DBConnection.getDBConnection();

    public void add(Clas clas) {
        PreparedStatement prst = null;
        String query1 = "INSERT INTO CLAS (IdClass, NameClass, Teacher, ClassRoom, SpecialSubj, CounStud) VALUES (?,?,?,?,?,?)";
        try {
            prst = conn.prepareStatement(query1);
            conn.setAutoCommit(false);
            prst.setInt(1, clas.getIdClass());
            prst.setString(2, clas.getNameClass());
            prst.setString(3, clas.getTeacher());
            prst.setInt(4, clas.getClassRoom());
            prst.setString(5, clas.getSpecialSubj());
            prst.setInt(6, clas.getCounStud());
            prst.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            logger.error("Error query1", e);

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

    public List<Clas> getAll() {
        List<Clas> clasList = new ArrayList<Clas>();
        Statement st = null;
        String query2 = "Select idClass, NameClass, Teacher, ClassRoom, SpecialSubj, CounStud from Clas ";
        ResultSet rs = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query2);
            while (rs.next()) {
                Clas clas = new Clas();
                clas.setIdClass(rs.getInt("idClass"));
                clas.setNameClass(rs.getString("NameClass"));
                clas.setTeacher(rs.getString("Teacher"));
                clas.setClassRoom(rs.getInt("ClassRoom"));
                clas.setSpecialSubj(rs.getString("SpecialSubj"));
                clas.setCounStud(rs.getInt("CounStud"));
                clasList.add(clas);
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
            return clasList;
        }
    }

    public Clas getById(int idClass) {
        PreparedStatement prst = null;
        String query3 = "SELECT idClass, NameClass, Teacher, ClassRoom, SpecialSubj, CounStud FROM Clas where idClass=?";
        Clas clas = new Clas();
        try {
            prst = conn.prepareStatement(query3);
            prst.setInt(1, idClass);
            ResultSet rs = prst.executeQuery();
while (rs.next()){
            clas.setIdClass(rs.getInt("idClass"));
            clas.setNameClass(rs.getString("NameClass"));
            clas.setTeacher(rs.getString("Teacher"));
            clas.setClassRoom(rs.getInt("ClassRoom"));
            clas.setSpecialSubj(rs.getString("SpecialSubj"));
            clas.setCounStud(rs.getInt("CounStud"));
            System.out.println(clas);
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
        return clas;
    }

    public void update(Clas clas) {
        PreparedStatement prst = null;
        String query4 = "UPDATE Clas SET  NameClass=?, Teacher=?, ClassRoom=?, SpecialSubj=?, CounStud=? where idClass=?";
        try {
            prst = conn.prepareStatement(query4);
            conn.setAutoCommit(false);
            prst.setString(1, clas.getNameClass());
            prst.setString(2, clas.getTeacher());
            prst.setInt(3, clas.getClassRoom());
            prst.setString(4, clas.getSpecialSubj());
            prst.setInt(5, clas.getCounStud());
            prst.setInt(6, clas.getIdClass());
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

    public void delete(Clas clas) {
        PreparedStatement prst = null;
        String query5 = "DELETE FROM Clas where idClass=?";
        try {
            prst = conn.prepareStatement(query5);
            conn.setAutoCommit(false);
            prst.setInt(1, clas.getIdClass());
            prst.executeUpdate();
            conn.commit();

        } catch (SQLException e) {
            logger.error("Error query5", e);
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

    public void getJoin() {
        Statement statement = null;
        try {
            statement = conn.createStatement();
            String query6 = "SELECT CLAS.Teacher, CLAS.NameClass, students.LastName, students.Age FROM students inner join CLAS ON STUDENTS.ClassId = CLAS.idClass";
            ResultSet rs = statement.executeQuery(query6);
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) +
                        " " + rs.getString(4));
            }

        } catch (SQLException e) {
            logger.error("Error query6", e);
        }
        System.out.println("");
    }
}