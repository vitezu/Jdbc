/**
 * Created by Pavel on 10.07.2017.
 */
public class Clas {

    private int idClass;
    private String NameClass;
    private String Teacher;
    private int ClassRoom;
    private String SpecialSubj;
    private int CounStud;

    public Clas(){

    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public String getNameClass() {
        return NameClass;
    }

    public void setNameClass(String nameClass) {
        NameClass = nameClass;
    }

    public String getTeacher() {
        return Teacher;
    }

    public void setTeacher(String teacher) {
        Teacher = teacher;
    }

    public int getClassRoom() {
        return ClassRoom;
    }

    public void setClassRoom(int classRoom) {
        ClassRoom = classRoom;
    }

    public String getSpecialSubj() {
        return SpecialSubj;
    }

    public void setSpecialSubj(String specialSubj) {
        SpecialSubj = specialSubj;
    }

    public int getCounStud() {
        return CounStud;
    }

    public void setCounStud(int counStud) {
        CounStud = counStud;
    }


    @Override
    public String toString() {
        return "Class{" +
                "idClass=" + idClass +
                ", NameClass='" + NameClass + '\'' +
                ", Teacher='" + Teacher + '\'' +
                ", ClassRoom=" + ClassRoom +
                ", SpecialSubj='" + SpecialSubj + '\'' +
                ", CounStud=" + CounStud +
                '}';
    }
}
