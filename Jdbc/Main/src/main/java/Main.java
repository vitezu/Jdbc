

import java.util.List;

/**
 * Created by Pavel on 09.07.2017.
 */
public class Main {

    public static void main(String[] args) {

        ServiceStudents serviceStudents = new ServiceStudents();
        ServiceClas serviceClas = new ServiceClas();

        //Add
        Students    students = new Students();
        students.setIdStudents(6);
        students.setFirstName("Alesya");
        students.setLastName("Ivanova");
        students.setAge(11);
        students.setBirth("2007.04.10");
        students.setPhone(2958457);
        students.setClassId(3);

        Clas clas = new Clas();
        clas.setIdClass(6);
        clas.setNameClass("3V");
        clas.setTeacher("Potapova");
        clas.setClassRoom(505);
        clas.setSpecialSubj("Fisics");
        clas.setCounStud(29);

        serviceStudents.add(students);
        serviceClas.add(clas);


        //Get All
        List<Students> studentList = serviceStudents.getAll();
        for (Students a: studentList){
            System.out.println(a);
        }
        System.out.println();

        List<Clas> clasList = serviceClas.getAll();
        for (Clas a: clasList){
            System.out.println(a);
        }
        System.out.println();

        //Update
        Students    students2 = new Students();
        students2.setIdStudents(1);
        students2.setFirstName("Veronika");
        students2.setLastName("Ivanova");
        students2.setAge(11);
        students2.setBirth("2007.04.10");
        students2.setPhone(29586666);
        students2.setClassId(3);


        Clas clas2 = new Clas();
        clas2.setIdClass(1);
        clas2.setNameClass("3D");
        clas2.setTeacher("Potapkina");
        clas2.setClassRoom(705);
        clas2.setSpecialSubj("Fisics");
        clas2.setCounStud(24);

        serviceStudents.update(students2);
        serviceClas.update(clas2);

        //Inner Join
        serviceStudents.getJoin();
        serviceClas.getJoin();

        //Delete
        Students student3 = new Students();
        student3.setIdStudents(2);
        serviceStudents.delete(student3);

        Clas clas3 = new Clas();
        clas3.setIdClass(2);
        serviceClas.delete(clas3);

//      Get byID
        serviceStudents.getById(3);
        serviceClas.getById(3);
    }
}
