

import java.util.List;

/**
 * Created by Pavel on 11.07.2017.
 */
public interface   DaoStudents {
   void add(Students students);
   List<Students> getAll();
   Students getById(int idStudents);
   void update(Students students);
   void delete(Students students);
   void getJoin();

}
