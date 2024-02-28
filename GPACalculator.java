import java.util.ArrayList;

public class GPACalculator {
    private ArrayList<Course> courses;

    public GPACalculator() {
        this.courses = new ArrayList<>();
    }

    public void addCourse(String grade, int credits) {
        courses.add(new Course(grade, credits));
    }

    public double calculateGPA() {
        double totalCredits = 0;
        double totalPoints = 0;

        for (Course course : courses) {
            totalCredits += course.getCredits();
            totalPoints += getPointsForGrade(course.getGrade()) * course.getCredits();
        }

        return totalPoints / totalCredits;
    }

    private double getPointsForGrade(String grade) {
        switch (grade) {
            case "A":
                return 4.0;
            case "A-":
                return 3.75;
            case "B+":
                return 3.25;
            case "B":
                return 3.0;
            case "B-":
                return 2.75;
            case "C+":
                return 2.25;
            case "C":
                return 2.0;
            case "C-":
                return 1.75;
            case "D+":
                return 1.25;
            case "D":
                return 1.0;
            default:
                return 0.0;
        }
    }

    private class Course {
        private String grade;
        private int credits;

        public Course(String grade, int credits) {
            this.grade = grade;
            this.credits = credits;
        }

        public String getGrade() {
            return grade;
        }

        public int getCredits() {
            return credits;
        }
    }
}
