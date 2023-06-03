import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DiskIO {
    private static final String STUDENTS_FILE_PATH = "students.dat";
    private static final String TEACHERS_FILE_PATH = "teachers.dat";
    private static final String CLASSINFO_FILE_PATH = "classinfo.dat";

    public static void writeStudents(List<Student> students) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(STUDENTS_FILE_PATH))) {
            outputStream.writeObject(students);
            System.out.println("学生数据写入成功！");
        } catch (IOException e) {
            System.out.println("写入学生数据时出现错误：" + e.getMessage());
        }
    }

    public static List<Student> readStudents() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(STUDENTS_FILE_PATH))) {
            List<Student> students = (List<Student>) inputStream.readObject();
            System.out.println("学生数据读取成功！");
            return students;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("读取学生数据时出现错误：" + e.getMessage());
        }
        return new ArrayList<>(); // 返回一个空列表作为默认值
    }

    public static void writeTeachers(List<Teacher> teachers) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(TEACHERS_FILE_PATH))) {
            outputStream.writeObject(teachers);
            System.out.println("教师数据写入成功！");
        } catch (IOException e) {
            System.out.println("写入教师数据时出现错误：" + e.getMessage());
        }
    }

    public static List<Teacher> readTeachers() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(TEACHERS_FILE_PATH))) {
            List<Teacher> teachers = (List<Teacher>) inputStream.readObject();
            System.out.println("教师数据读取成功！");
            return teachers;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("读取教师数据时出现错误：" + e.getMessage());
        }
        return new ArrayList<>(); // 返回一个空列表作为默认值
    }

    public static void writeClassInfo(ClassInfo classInfo) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(CLASSINFO_FILE_PATH))) {
            outputStream.writeObject(classInfo);
            System.out.println("班级信息写入成功！");
        } catch (IOException e) {
            System.out.println("写入班级信息时出现错误：" + e.getMessage());
        }
    }

    public static ClassInfo readClassInfo() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(CLASSINFO_FILE_PATH))) {
            ClassInfo classInfo = (ClassInfo) inputStream.readObject();
            System.out.println("班级信息读取成功！");
            return classInfo;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("读取班级信息时出现错误：" + e.getMessage());
        }
        return null; // 返回null作为默认值
    }
}
