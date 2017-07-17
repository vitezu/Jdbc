

import java.util.List;

/**
 * Created by Pavel on 12.07.2017.
 */
public interface DaoClas {

        void add(Clas clas);
         List<Clas> getAll();
         Clas getById(int idClass);
         void update(Clas clas);
         void delete(Clas clas);
         void getJoin();
    }


