
/**
 * 교수가 학생의 성적 정보를 직접 입력하고 관리할 수 있는 성적 처리 프로그램.
 *
 * @author (2025320031 김단이, 2025320016 정한비, 2025320020 송영재)
 * @version (2026.05.12)
 */
public class Student
{
    private String name; // 학생 이름을 저장하는 변수
    private int studentId; // 학생 학번
    private String[] subjects = new String[100]; // 과목 이름 저장
    private int[] scores = new int[100]; //과목별 점수
    private Grade[] grades = new Grade[100]; //과목별 등급 학점
    private int count = 0; //입력된 과목 개수
    static int totalStudents = 0;
    
    int totalScore = 0;
    int subjectsStudentCount = 0;
    
    
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
    public int getSubjectCount(){
        return count;
    }
    
    public String getSubject(int index){
        return subjects[index];
    }
    public int getScore(int index){
        return scores[index];
    }
    public String getName(){
        return name;
    }
}