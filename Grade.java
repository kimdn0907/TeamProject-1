
/**
 * Grade 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
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
            case 9:return (score >= 95)? new Grade("A+",4.5) : new Grade("A",4.0);
            case 8:return (score >= 85)? new Grade("B+",3.5) : new Grade("A",3.0);
            case 7:return (score >= 75)? new Grade("C+",2.5) : new Grade("A",2.0);
            case 6:return (score >= 65)? new Grade("D+",1.5) : new Grade("A",1.0);

            default:
                return new Grade("F",0.0);
        }
    }
}