package Day_18;

// Q3: Student interface -> CollegeStudent implements -> study()

interface Student {
    void study();
}

class CollegeStudent implements Student {
    private String name;
    private String course;

    CollegeStudent(String name, String course) {
        this.name = name;
        this.course = course;
    }

    @Override
    public void study() {
        System.out.println(name + " is studying " + course + ".");
    }
}

public class practical_183 {
    public static void main(String[] args) {
        Student student = new CollegeStudent("Rahul", "Computer Science");
        student.study();
    }
}
