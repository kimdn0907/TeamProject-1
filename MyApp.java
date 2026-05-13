import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * 교수가 학생의 성적 정보를 직접 입력하고 관리할 수 있는 성적 처리 프로그램.
 *
 * @author (2025320031 김단이, 2025320016 정한비, 2025320020 송영재)
 * @version (2026.05.13)
 */
public class MyApp
{
    public static void printAll(Student[] studentList, int studentCount){
        for (int i = 0; i < studentCount; i++){
            studentList[i].displayResult();
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        Student[] studentList = new Student[100];
        int studentCount = 0;
        
        while (true){
            //학생 정보를 입력받을지 물어보기 -> 0입력 시 성적 처리 프로그램 종료 후 전체 결과 출력
            System.out.println("===== 성적 처리 프로그램 =====");
            System.out.print("학생 정보를 입력하시겠습니까? (1: 예 / 0: 종료) : ");
            int addStudent = sc.nextInt();
            
            if (addStudent == 0)
                break;
            else if (addStudent == 1){
                sc.nextLine();
                
                //학생 이름 입력받기
                System.out.print("학생 이름을 입력해주세요 : ");
                String studentName = sc.nextLine();
                
                //학번 입력받기 (문자 입력 시 오류메세지 출력하고 다시 입력하게 하기)
                int studentId;
                while (true){
                    System.out.print("학번을 입력해주세요 : ");
                    studentId = 0;
                    try {
                        studentId = sc.nextInt();
                        sc.nextLine();
                        break;
                    }
                    catch (InputMismatchException e){
                        System.out.println("학번은 숫자로만 입력해주세요!");
                        sc.nextLine();
                    }
                }
                
                Student student = new Student(studentName, studentId);
                studentList[studentCount] = student;
                studentCount++;
                
                //과목 입력 받기 -> 0입력 시 과목 입력 받는 것을 종료하고 학생 정보 입력으로 돌아감
                while (true){
                    System.out.print("과목을 입력하시겠습니까? (1: 예 / 0: 종료) :");
                    int addSubject = sc.nextInt();
                    if (addSubject == 0)
                        break;
                    else if (addSubject == 1){
                        sc.nextLine();
                        
                        //과목 이름 입력받기
                        System.out.print("과목 이름을 입력해주세요 : ");
                        String subjectName = sc.nextLine();
                        
                        //과목에 대한 점수 입력받기 (0~100 사이의 입력을 벗어나면 오류메세지 출력 / 숫자가 아닌 입력을 받으면 오류메세지 출력)
                        while (true){
                            try {
                                System.out.print("점수를 입력해 주세요 : ");
                                int score = sc.nextInt();
                                sc.nextLine();
                                if (score >= 0 && score <= 100){
                                    student.addSubject(subjectName, score);
                                    break;
                                }
                                else {
                                    System.out.println("0~100 사이의 점수를 입력해주세요!");
                                }
                            }
                            catch (InputMismatchException e){
                                System.out.println("점수는 숫자로만 입력해주세요!");
                                sc.nextLine();
                            }
                        }
                    }
                }
                //한 학명의 정보 입력이 끝날 때마다 학생 성적 출력
                System.out.println();
                student.displayResult();
            }
        }
        //전체 학생 성적 출력 후 전체 학생 수 출력 -> 전체 석차, 최고/최저, 평균점수 출력에 사용
        printAll(studentList, studentCount);
        System.out.println("전체 학생 수는 " + Student.totalStudents + "명 입니다.");
        
        //더 이상 입력받을 것이 없으면 Scanner 종료하기
        sc.close();
    }
}