package entities0804;

public class Teacher {
    private int teacherId;
    private String teacherName;
    private String teacherExperience;
    private String teacherQual;
    private Student studentId;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId ;
    }

    public String getTeacherName() {
        return teacherName;
    }
    public void setTeacherName(String teacherNameName) {
        this.teacherName = teacherName;
    }

    public String getTeacherQual() {
        return teacherQual;
    }
    public void setTeacherQual(String teacherQual) {
        this.teacherQual = teacherQual;
    }

    public String getTeacherExperience() {
        return teacherExperience;
    }

    public void setTeacherExperience(String teacherExperience) {
        this.teacherExperience = teacherExperience;
    }


    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName +
                ", teacherQual=" + teacherQual +
                ", teacherExperience=" +teacherExperience +
                ", studentId = " + studentId +
        '\'' +
                '}';
    }
}

