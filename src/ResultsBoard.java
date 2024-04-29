import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

class ResultsBoard {
    TreeSet<Event> events = new TreeSet<>();


    public ResultsBoard(){

    }
    void addStudent(String name, Float score) {
        Event event = new Event();
        event.name = name;
        event.number = score;
        events.add(event);
    }
    List<String> top3 (String name) {
    Event o = new Event();
        o.name = name;

        NavigableSet<Event> taislSet = events.tailSet(o, true);
        List<String> result = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
        if(!taislSet.isEmpty()){
            result.add(String.valueOf(taislSet.pollFirst()));
        }
        }
        return result;
    }

    public static void main(String[] args) {
        ResultsBoard resultsBoard = new ResultsBoard();
        resultsBoard.addStudent("����", 11.1f);
        resultsBoard.addStudent("������", 9.1f);
        resultsBoard.addStudent("������", 25.12f);
        resultsBoard.addStudent("��������", 98.78f);
        resultsBoard.addStudent("����", 43.11f);
        resultsBoard.addStudent("����", 78.47f);
        Event event = new Event();
        System.out.println(resultsBoard.top3("����"));
    }
}
class Event implements Comparable<Event>{
String name;
Float number;

    @Override
    public int compareTo(Event o) {
        if(name.equals(o.name)){
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