import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class ClassInfo implements Serializable {
    private String className;
    private int numberOfStudents;
    private List<String> activities;
    private List<Double> expenses;
    private List<String> attendanceList;
    private List<String> timetable; // 新增课表列表属性

    public ClassInfo() {
        activities = new ArrayList<>();
        expenses = new ArrayList<>();
        attendanceList = new ArrayList<>();
        timetable = new ArrayList<>(); // 初始化课表列表
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public void addActivity(String activity) {
        activities.add(activity);
    }

    public void addExpense(double expense) {
        expenses.add(expense);
    }

    public List<String> getAttendanceList() {
        return attendanceList;
    }

    public void addTimetableEntry(String entry) {
        timetable.add(entry);
    }

    public List<String> getTimetable() {
        return timetable;
    }
}
