
/**
 * 교수가 학생의 성적 정보를 직접 입력하고 관리할 수 있는 성적 처리 프로그램.
 *
 * @author (2025320031 김단이, 2025320016 정한비, 2025320020 송영재)
 * @version (2026.05.12)
 */
public class Student
{
    private String name;
    private int studentId;
    private String[] subjects = new String[100];
    private int[] scores = new int[100];
    private Grade[] grades = new Grade[100];
    private int count = 0;
    static int totalStudents = 0;
    
    
    
    public Student(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
        totalStudents++;
    }
    
    public Student(String name) {
        this(name, 0);
    }
    
    public Student(int studentId) {
        this(" ", studentId);
    }
    
    public void addSubject(String subjectName, int score) {
        subjects[count] = subjectName;
        scores[count] = score;
        grades[count] = Grade.scoreToGPA(score);
        count++;
    }
    
    public double getGPA() {
        if (count == 0)
            return 0.0;
        double total = 0.0;
        for (int i = 0; i < count; i++) {
            total += grades[i].getNumGPA();
        }
        return total / count;
    }
    
    public void displayResult() {
        System.out.println("===== 결과 =====");
        System.out.println("이름 : " + name);
        System.out.println("학번 : " + studentId);
        System.out.println();
        for (int i = 0; i < count; i++) {
            System.out.println(subjects[i] + " : " + grades[i].getStrGPA() + ", " + scores[i] + "점");
        }
        
        System.out.println();
        double gpa = getGPA();
        gpa = (int)(gpa * 100) / 100.0;
        System.out.println("최종 학점 : " + gpa);
        System.out.println();
    }
}