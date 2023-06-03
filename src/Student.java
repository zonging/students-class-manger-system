import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Student implements Serializable {
    private String name;
    private int age;
    private String gender;
    private String studentId;
    private String className;
    private List<RewardPunishment> rewardPunishments;

    public Student(String name, int age, String gender, String studentId, String className) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.studentId = studentId;
        this.className = className;
        this.rewardPunishments = new ArrayList<>();
    }

    public Student(String name, int age, String gender) {
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.rewardPunishments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getClassName() {
        return className;
    }

    public List<RewardPunishment> getRewardPunishments() {
        return rewardPunishments;
    }

    public void addRewardPunishment(String rewardType, String reason, String date) {
        RewardPunishment rewardPunishment = new RewardPunishment(rewardType, reason, date);
        rewardPunishments.add(rewardPunishment);
    }
}

// 示例用法
//public class Main {
//    public static void main(String[] args) {
//        // 创建学生对象
//        Student student = new Student("Alice", 18, "Female", "001", "Class A");
//
//        // 添加奖惩信息
//        student.addRewardPunishment("奖励", "优秀表现", "2023-05-01");
//        student.addRewardPunishment("惩罚", "迟到", "2023-05-02");
//
//        // 打印学生信息和奖惩信息
//        System.out.println("Name: " + student.getName());
//        System.out.println("Age: " + student.getAge());
//        System.out.println("Gender: " + student.getGender());
//        System.out.println("Student ID: " + student.getStudentId());
//        System.out.println("Class: " + student.getClassName());
//        System.out.println("Reward/Punishment Information:");
//        for (RewardPunishment rewardPunishment : student.getRewardPunishments()) {
//            System.out.println(rewardPunishment.getRewardType() + " " +
//                    rewardPunishment.getReason() + " " +
//                    rewardPunishment.getDate());
//        }
//    }
//}
