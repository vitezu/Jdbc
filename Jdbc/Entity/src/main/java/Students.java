/**
 * Created by Pavel on 10.07.2017.
 */
public class Students {
    private int idStudents;
    private String FirstName;
    private String LastName;
    private int Age;
    private String Birth;
    private int Phone;
    private int ClassId;

    public Students() {
    }

    public int getIdStudents() {
        return idStudents;
    }

    public void setIdStudents(int idStudents) {
        this.idStudents = idStudents;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getBirth() {
        return Birth;
    }

    public void setBirth(String birth) {
        Birth = birth;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int phone) {
        Phone = phone;
    }

    public int getClassId() {
        return ClassId;
    }

    public void setClassId(int classId) {
        ClassId = classId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Students students = (Students) o;

        if (idStudents != students.idStudents) return false;
        if (Age != students.Age) return false;
        if (Phone != students.Phone) return false;
        if (ClassId != students.ClassId) return false;
        if (FirstName != null ? !FirstName.equals(students.FirstName) : students.FirstName != null) return false;
        if (LastName != null ? !LastName.equals(students.LastName) : students.LastName != null) return false;
        return Birth != null ? Birth.equals(students.Birth) : students.Birth == null;
    }

    @Override
    public String toString() {
        return "Students{" +
                "idStudents=" + idStudents +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Age=" + Age +
                ", Birth='" + Birth + '\'' +
                ", Phone=" + Phone +
                ", ClassId=" + ClassId +
                '}';
    }
}