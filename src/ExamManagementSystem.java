import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExamManagementSystem {
    private static Map<String, Exam> exams = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("请选择操作：");
            System.out.println("1. 添加考试");
            System.out.println("2. 删除考试");
            System.out.println("3. 更新考试分数");
            System.out.println("4. 查看考试分数");
            System.out.println("0. 退出");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 读取换行符

            switch (choice) {
                case 1:
                    addExam(scanner);
                    break;
                case 2:
                    deleteExam(scanner);
                    break;
                case 3:
                    updateExamScore(scanner);
                    break;
                case 4:
                    viewExamScore(scanner);
                    break;
                case 0:
                    System.out.println("谢谢使用！");
                    return;
                default:
                    System.out.println("无效的选择，请重新输入！");
            }
        }
    }

    private static void addExam(Scanner scanner) {
        System.out.println("请输入考试名称：");
        String examName = scanner.nextLine();

        if (exams.containsKey(examName)) {
            System.out.println("该考试已存在！");
            return;
        }

        Exam exam = new Exam(examName);
        exams.put(examName, exam);
        System.out.println("考试添加成功！");
    }

    private static void deleteExam(Scanner scanner) {
        System.out.println("请输入要删除的考试名称：");
        String examName = scanner.nextLine();

        if (exams.containsKey(examName)) {
            exams.remove(examName);
            System.out.println("考试删除成功！");
        } else {
            System.out.println("找不到该考试！");
        }
    }

    private static void updateExamScore(Scanner scanner) {
        System.out.println("请输入考试名称：");
        String examName = scanner.nextLine();

        if (!exams.containsKey(examName)) {
            System.out.println("找不到该考试！");
            return;
        }

        Exam exam = exams.get(examName);

        System.out.println("请输入学生学号：");
        String studentId = scanner.nextLine();

        System.out.println("请输入分数：");
        double score = scanner.nextDouble();
        scanner.nextLine(); // 读取换行符

        exam.addStudentScore(studentId, score);
        System.out.println("分数更新成功！");
    }

    private static void viewExamScore(Scanner scanner) {
        System.out.println("请输入考试名称：");
        String examName = scanner.nextLine();

        if (!exams.containsKey(examName)) {
            System.out.println("找不到该考试！");
            return;
        }

        Exam exam = exams.get(examName);

        System.out.println("请输入学生学号：");
        String studentId = scanner.nextLine();

        double score = exam.getStudentScore(studentId);
        System.out.println("学生 " + studentId + " 的考试分数为：" + score);
    }
}
