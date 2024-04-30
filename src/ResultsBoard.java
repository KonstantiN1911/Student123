
import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

class ResultsBoard {
    TreeSet<Student> students = new TreeSet<>();


    public ResultsBoard() {

    }

    Student addStudent(String name, Float score) {
        Student student = new Student(name, score);
        students.add(student);
        return student;
    }

    List<String> top3(Student student) {

        NavigableSet<Student> taislSet = students.tailSet(student, true);
        List<String> result = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            if (!taislSet.isEmpty()) {
                result.add(String.valueOf(taislSet.pollFirst()));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ResultsBoard resultsBoard = new ResultsBoard();
        Student student = resultsBoard.addStudent("????", 11.1f);

        resultsBoard.addStudent("??????", 9.1f);
        resultsBoard.addStudent("??????", 25.12f);
        resultsBoard.addStudent("????????", 98.78f);
        resultsBoard.addStudent("????", 43.11f);
        resultsBoard.addStudent("????", 78.47f);
        System.out.println(resultsBoard.top3(student));
    }
}

class Student implements Comparable<Student> {
    String name;
    Float number;

    public Student(String name, Float number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public int compareTo(Student o) {
        if (name.equals(o.name)) {
            return Float.compare(number, o.number);
        } else {
            return CharSequence.compare(name, o.name);
        }
    }

    @Override
    public String toString() {
        return "[ " + name + " - " + number + " ]";
    }

}