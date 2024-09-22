// Kibitkin Ilya IT3-2307
public class Staff extends Person {
    private String school;
    private double pay;

    public Staff(String name, String address, String school, double pay) {
        super(name, address);
        this.school = school;
        this.pay = pay;
    }

    public String getSchool(String school) {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public double getPay(double pay) {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    @Override
    public String toString() {
        return "Staff[" + super.toString() + "], school=" + school + ", pay=" + pay + "]";
    }
    public static void main(String[] args) {
        Staff staff = new Staff("Dobriy", "008", "1", 118.3);
        System.out.println(staff);
    }
}
