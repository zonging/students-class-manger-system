import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassManagementSystem {
    private static List<Student> students = new ArrayList<>();
    private static List<Teacher> teachers = new ArrayList<>();
    private static ClassInfo classInfo;

    public static void main(String[] args) {
        //boolean ReadFromFiles=false;
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;

        System.out.println("Do you want to Read from Files?(Y/N)");
        String readfilestr= scanner.next();
        if(readfilestr.toLowerCase().equals("y")) {
            classInfo = DiskIO.readClassInfo();
            students = DiskIO.readStudents();
            teachers = DiskIO.readTeachers();
        }

        while (true) {
            System.out.println("===== 班级事务管理系统 =====");
            System.out.println("1. 用户登录");
            System.out.println("2. 退出系统");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 读取换行符

            switch (choice) {
                case 1:
                    if (!loggedIn) {
                        loggedIn = login(scanner);
                    } else {
                        System.out.println("您已登录！");
                    }
                    break;
                case 2:
                    System.out.println("已退出系统。");
                    return;
                default:
                    System.out.println("无效的选项，请重新输入。");
                    break;
            }
        }
    }

    private static boolean login(Scanner scanner) {
        System.out.println("请输入用户名：");
        String username = scanner.nextLine();
        System.out.println("请输入密码：");
        String password = scanner.nextLine();

        // TODO: 进行用户名和密码的验证逻辑

        if (isValidUser(username, password)) {
            System.out.println("登录成功！");
            showMainMenu(scanner);
            return true;
        } else {
            System.out.println("用户名或密码错误！");
            return false;
        }
    }

    private static boolean isValidUser(String username, String password) {
        // 假设只有一个固定的用户名和密码是有效的
        String validUsername = "admin";
        String validPassword = "password";

        return username.equals(validUsername) && password.equals(validPassword);
    }


    private static void showMainMenu(Scanner scanner) {
        while (true) {
            System.out.println("===== 主菜单 =====");
            System.out.println("1. 学生管理");
            System.out.println("2. 班级管理");
            System.out.println("3. 教师管理");
            System.out.println("4. 系统管理");
            System.out.println("6.写入数据");
            System.out.println("7.考试管理");
            System.out.println("5. 返回上一级菜单");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 读取换行符

            switch (choice) {
                case 1:
                    showStudentMenu(scanner);
                    break;
                case 2:
                    showClassMenu(scanner);
                    break;
                case 3:
                    showTeacherMenu(scanner);
                    break;
                case 4:
                    showSystemMenu(scanner);
                    break;
                case 5:
                    return;
                case 6:
                    writeData();
                    break;
                case 7:
                    ExamManagementSystem examManagementSystem=new ExamManagementSystem();
                    break;
                default:
                    System.out.println("无效的选项，请重新输入。");
                    break;
            }
        }
    }

    private static void writeData() {
        DiskIO.writeTeachers(teachers);
        DiskIO.writeStudents(students);
        DiskIO.writeClassInfo(classInfo);
    }

    private static void showStudentMenu(Scanner scanner) {
        while (true) {
            System.out.println("===== 学生管理 =====");
            System.out.println("1. 添加学生");
            System.out.println("2. 删除学生");
            System.out.println("3. 查看学生列表");
            System.out.println("4. 返回上一级菜单");
            System.out.println("5.添加奖惩信息");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 读取换行符

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    removeStudent(scanner);
                    break;
                case 3:
                    displayStudentList();
                    break;
                case 4:
                    return;
                case 5:
                    addRewardPunishment(scanner);
                    break;
                default:
                    System.out.println("无效的选项，请重新输入。");
                    break;
            }
        }
    }

    private static void addStudent(Scanner scanner) {
        System.out.println("请输入学生姓名：");
        String name = scanner.nextLine();
        System.out.println("请输入学生年龄：");
        int age = scanner.nextInt();
        scanner.nextLine(); // 读取换行符
        System.out.println("请输入学生性别：");
        String gender = scanner.nextLine();

        Student student = new Student(name, age, gender);
        students.add(student);

        System.out.println("学生添加成功！");
    }
    private static void addRewardPunishment(Scanner scanner) {
        System.out.println("请输入学生姓名：");
        String name = scanner.nextLine();

        // 在学生列表中查找对应姓名的学生对象
        Student student = findStudentByName(name);
        if (student == null) {
            System.out.println("找不到该学生！");
            return;
        }

        System.out.println("请输入奖惩类型：");
        String rewardType = scanner.nextLine();
        System.out.println("请输入奖惩原因：");
        String reason = scanner.nextLine();
        System.out.println("请输入奖惩日期：");
        String date = scanner.nextLine();

        // 添加奖惩信息
        student.addRewardPunishment(rewardType, reason, date);

        System.out.println("奖惩信息添加成功！");
    }

    // 辅助方法：根据学生姓名查找学生对象
    private static Student findStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }


    private static void removeStudent(Scanner scanner) {
        System.out.println("请输入要删除的学生姓名：");
        String name = scanner.nextLine();

        for (Student student : students) {
            if (student.getName().equals(name)) {
                students.remove(student);
                System.out.println("学生删除成功！");
                return;
            }
        }

        System.out.println("未找到该学生！");
    }

    private static void displayStudentList() {
        System.out.println("===== 学生列表 =====");

        for (Student student : students) {
            System.out.println("姓名：" + student.getName());
            System.out.println("年龄：" + student.getAge());
            System.out.println("性别：" + student.getGender());
            System.out.println("---------------");
            System.out.println("Reward/Punishment Information:");
            try {
                for (RewardPunishment rewardPunishment : student.getRewardPunishments()) {
                    System.out.println(rewardPunishment.getRewardType() + " " +
                            rewardPunishment.getReason() + " " +
                            rewardPunishment.getDate());
                }
            }catch (NullPointerException e){

            }
        }
    }

    private static void showClassMenu(Scanner scanner) {
        while (true) {
            System.out.println("===== 班级管理 =====");
            System.out.println("1. 查看班级信息");
            System.out.println("2. 添加班级活动");
            System.out.println("3. 添加班级开支");
            System.out.println("4. 查看班级考勤");
            System.out.println("5. 设置班级信息");
            System.out.println("6. 查看班级课表");
            System.out.println("7. 添加班级课表");
            System.out.println("8. 返回上一级菜单");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 读取换行符

            switch (choice) {
                case 1:
                    displayClassInfo();
                    break;
                case 2:
                    addClassActivity(scanner);
                    break;
                case 3:
                    addClassExpense(scanner);
                    break;
                case 4:
                    displayClassAttendance();
                    break;
                case 5:
                    setClassInfo(scanner);
                    break;
                case 6:
                    displayClassTimeTable();
                    break;
                case 7:
                    addClassTimeTable();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("无效的选项，请重新输入。");
                    break;
            }
        }
    }

    private static void setClassInfo(Scanner scanner) {
        System.out.println("===== 设置班级信息 =====");
        System.out.println("请输入班级名称：");
        String className = scanner.nextLine();

        System.out.println("请输入班级人数：");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine(); // 读取换行符

        classInfo.setClassName(className);
        classInfo.setNumberOfStudents(numberOfStudents);

        System.out.println("班级信息设置成功！");
    }
//    private static void showClassMenu(Scanner scanner) {
//        while (true) {
//            System.out.println("===== 班级管理 =====");
//            System.out.println("1. 查看班级信息");
//            System.out.println("2. 添加班级活动");
//            System.out.println("3. 添加班级开支");
//            System.out.println("4. 查看班级考勤");
//            System.out.println("6.查看班级课表");
//            System.out.println("7.添加班级课表");
//            System.out.println("5. 返回上一级菜单");
//
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // 读取换行符
//
//            switch (choice) {
//                case 1:
//                    displayClassInfo();
//                    break;
//                case 2:
//                    addClassActivity(scanner);
//                    break;
//                case 3:
//                    addClassExpense(scanner);
//                    break;
//                case 4:
//                    displayClassAttendance();
//                    break;
//                case 5:
//                    return;
//                case 6:
//                    displayClassTimeTable();
//                    break;
//                case 7:
//                    addClassTimeTable();
//                    break;
//                default:
//                    System.out.println("无效的选项，请重新输入。");
//                    break;
//            }
//        }
//    }

    private static void displayClassTimeTable(){
        if(classInfo== null){

        }else{
            System.out.println(classInfo.getTimetable());
        }
    }
    private static void addClassTimeTable(){
        if(classInfo==null){

        }else{
            Scanner scanner=new Scanner(System.in);
            classInfo.addTimetableEntry(scanner.nextLine());
        }
    }

    private static void displayClassInfo() {
        System.out.println("===== 班级信息 =====");
        if (classInfo == null) {
            System.out.println("班级信息未设置！");
        } else {
            System.out.println("班级名称：" + classInfo.getClassName());
            System.out.println("班级人数：" + classInfo.getNumberOfStudents());
        }
    }

    private static void addClassActivity(Scanner scanner) {
        System.out.println("请输入班级活动：");
        String activity = scanner.nextLine();

        if (classInfo == null) {
            classInfo = new ClassInfo();
        }

        classInfo.addActivity(activity);

        System.out.println("班级活动添加成功！");
    }

    private static void addClassExpense(Scanner scanner) {
        System.out.println("请输入班级开支：");
        double expense = scanner.nextDouble();
        scanner.nextLine(); // 读取换行符

        if (classInfo ==
                null) {
            classInfo = new ClassInfo();
        }

        classInfo.addExpense(expense);

        System.out.println("班级开支添加成功！");
    }

    private static void displayClassAttendance() {
        System.out.println("===== 班级考勤 =====");

        if (classInfo == null) {
            System.out.println("班级信息未设置！");
        } else {
            List<String> attendanceList = classInfo.getAttendanceList();

            if (attendanceList.isEmpty()) {
                System.out.println("暂无考勤记录！");
            } else {
                for (String attendance : attendanceList) {
                    System.out.println(attendance);
                }
            }
        }
    }

    private static void showTeacherMenu(Scanner scanner) {
        while (true) {
            System.out.println("===== 教师管理 =====");
            System.out.println("1. 添加教师");
            System.out.println("2. 删除教师");
            System.out.println("3. 查看教师列表");
            System.out.println("4. 返回上一级菜单");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 读取换行符

            switch (choice) {
                case 1:
                    addTeacher(scanner);
                    break;
                case 2:
                    removeTeacher(scanner);
                    break;
                case 3:
                    displayTeacherList();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("无效的选项，请重新输入。");
                    break;
            }
        }
    }

    private static void addTeacher(Scanner scanner) {
        System.out.println("请输入教师姓名：");
        String name = scanner.nextLine();
        System.out.println("请输入教师年龄：");
        int age = scanner.nextInt();
        scanner.nextLine(); // 读取换行符
        System.out.println("请输入教师性别：");
        String gender = scanner.nextLine();

        Teacher teacher = new Teacher(name, age, gender);
        teachers.add(teacher);

        System.out.println("教师添加成功！");
    }

    private static void removeTeacher(Scanner scanner) {
        System.out.println("请输入要删除的教师姓名：");
        String name = scanner.nextLine();

        for (Teacher teacher : teachers) {
            if (teacher.getName().equals(name)) {
                teachers.remove(teacher);
                System.out.println("教师删除成功！");
                return;
            }
        }

        System.out.println("未找到该教师！");
    }

    private static void displayTeacherList() {
        System.out.println("===== 教师列表 =====");

        for (Teacher teacher : teachers) {
            System.out.println("姓名：" + teacher.getName());
            System.out.println("年龄：" + teacher.getAge());
            System.out.println("性别：" + teacher.getGender());
            System.out.println("---------------");
        }
    }

    private static void showSystemMenu(Scanner scanner) {
        while (true) {
            System.out.println("===== 系统管理 =====");
            System.out.println("1. 修改密码");
            System.out.println("2. 返回上一级菜单");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 读取换行符

            switch (choice) {
                case 1:
                    changePassword(scanner);
                    break;
                case 2:
                    return;
                default:
                    System.out.println("无效的选项，请重新输入。");
                    break;
            }
        }
    }

    private static void changePassword(Scanner scanner) {
        System.out.println("请输入旧密码：");
        String oldPassword = scanner.nextLine();

        // TODO: 根据实际需求进行密码验证逻辑

        System.out.println("请输入新密码：");
        String newPassword = scanner.nextLine();

        // TODO: 根据实际需求进行密码修改逻辑

        System.out.println("密码修改成功！");
    }
}

