import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

class Exam implements Serializable {
    private String examName;
    private Map<String, Double> studentScores; // 学生和对应的分数

    public Exam(String examName) {
        this.examName = examName;
        studentScores = new HashMap<>();
    }

    public String getExamName() {
        return examName;
    }

    public void addStudentScore(String studentId, double score) {
        studentScores.put(studentId, score);
    }

    public double getStudentScore(String studentId) {
        return studentScores.getOrDefault(studentId, 0.0);
    }

    public Map<String, Double> getStudentScores() {
        return studentScores;
    }
}
