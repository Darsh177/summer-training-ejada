import java.util.Scanner;

class Student{
    private String name;
    private int englishGrade;
    private int mathGrade;
    private int computerGrade;
    private double totalPercentage;
    private String Status;

    public Student(String name, int englishGrade, int mathGrade, int computerGrade) {
        this.name = name;
        this.englishGrade = englishGrade;
        this.mathGrade = mathGrade;
        this.computerGrade = computerGrade;
        calculatePercentageAndRating();
    }
    public void calculatePercentageAndRating(){
        this.totalPercentage=(mathGrade + englishGrade + computerGrade)/3.0;

        int rating = (int) totalPercentage/10;
        switch (rating){
            case 10:
                Status="Excellent";
                break;
            case 9:
                Status="Excellent";
                break;
            case 8:
                Status="very good";
                break;
            case 7:
                Status="good";
                break;
            case 6:
                Status="pass";
                break;
            default:
                if(totalPercentage > 60){
                    Status="Pass";
                }
                else {
                    Status = "Faill";
                }
                break;
        }
    }

    public void displayresult(){
        System.out.println("student name is : " + name);
        System.out.println("student percentage is : " + totalPercentage + "%");
        System.out.println("student raring is : " + Status);
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner scanner =new Scanner(System.in);
        System.out.println("how many student you will enter");
        int studentNum = scanner.nextInt();
        scanner.nextLine();
        Student[] students = new Student[studentNum];

        for (int i =0 ; i<studentNum ; i++){

            System.out.print("\n \n new student \n\n ");

            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter English Grade : ");
            int english = scanner.nextInt();

            System.out.print("Enter Math Grade : ");
            int math = scanner.nextInt();

            System.out.print("Enter Computer Grade : ");
            int computer = scanner.nextInt();
            scanner.nextLine();

            students[i] = new Student(name , english , math , computer);
        }

        System.out.println("          ALL STUDENTS RESULTS          ");
        for (Student student : students){
            student.displayresult();
        }
        scanner.close();
    }
}