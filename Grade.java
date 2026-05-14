
/**
 * 교수가 학생의 성적 정보를 직접 입력하고 관리할 수 있는 성적 처리 프로그램.
 *
 * @author (2025320031 김단이, 2025320016 정한비, 2025320020 송영재)
 * @version (2026.05.12)
 */
public class Grade{
    private final String strGPA;
    private final double numGPA;
    
    Grade(String strGPA, double numGPA){
        this.strGPA = strGPA;
        this.numGPA = numGPA;
    }
    
    public String getStrGPA(){
        return strGPA;
    }
    
    public double getNumGPA(){
        return numGPA;
    }
    
    public static Grade scoreToGPA(int score){
        switch (score / 10){
            case 10:
            case 9: return (score >= 95) ? new Grade("A+",4.5) : new Grade("A",4.0);
            case 8: return (score >= 85) ? new Grade("B+",3.5) : new Grade("B",3.0);
            case 7: return (score >= 75) ? new Grade("C+",2.5) : new Grade("C",2.0);
            case 6: return (score >= 65) ? new Grade("D+",1.5) : new Grade("D",1.0);
            default: return new Grade("F", 0.0);
        }
    }
}