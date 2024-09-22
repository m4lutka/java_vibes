// Kibitkin Ilya IT3-2307
public class MyDate {
    private int day;
    private int month;
    private int year;

    public static String[] MONTHS = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
    public static String[] DAYS = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
    public static int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static boolean isValidDate(int year, int month, int day) {
        if (year < 1 || year > 9999) {
            return false;
        }

        if (month < 1 || month > 12) {
            return false;
        }

        int[] daysInMonth = { 31, isLeapYear(year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        return day >= 1 && day <= daysInMonth[month - 1];
    }

    public static int getDayOfWeek(int year, int month, int day) {
        int[] sequence = { 4, 2, 0, 6 };
        int century = (year / 100) + 1;
        int index = (century - 17) % 4 - 1;

        if (index < 0) {
            index += 4;
        }

        int[] monthOffsets = isLeapYear(year)
                ? new int[] { 6, 2, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5 }
                : new int[] { 0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5 };

        return (sequence[index] + (year % 100) + ((year % 100) / 4) + monthOffsets[month - 1] + day) % 7;
    }

    public MyDate(int year, int month, int day) {
        if (!isValidDate(year, month, day)) {}
        else {
            this.year = year;
            this.month = month;
            this.day = day;
        }
    }

    public void setDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        if (!isValidDate(year, month, day)) {
            return "Invalid date!";
        }
        return DAYS[getDayOfWeek(year, month, day)] + " " + day + " " + MONTHS[month - 1] + " " + year;
    }

    public MyDate nextDay() {
        this.day++;

        int[] daysInMonth = { 31, isLeapYear(year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if (this.day > daysInMonth[month - 1]) {
            this.month++;
            this.day = 1;
        }

        if (this.month > 12) {
            this.year++;
            this.month = 1;
        }

        return new MyDate(this.year, this.month, this.day);
    }

    public MyDate nextMonth() {
        this.month++;

        int[] daysInMonth = { 31, isLeapYear(year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if (this.day > daysInMonth[this.month - 1]) {
            this.day = daysInMonth[this.month - 1];
        }

        if (this.month > 12) {
            this.year++;
            this.month = 1;
        }

        return new MyDate(this.year, this.month, this.day);
    }

    public MyDate nextYear() {
        this.year++;

        int[] daysInMonth = { 31, isLeapYear(this.year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if (this.day > daysInMonth[this.month - 1]) {
            this.day = daysInMonth[this.month - 1];
        }

        return new MyDate(this.year, this.month, this.day);
    }

    public MyDate previousDay() {
        this.day--;

        int[] daysInMonth = { 31, isLeapYear(year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if (this.day <= 0) {
            this.month--;
        }

        if (this.month <= 0) {
            this.year--;
            this.month = 12;
        }

        this.day = daysInMonth[month];


        return new MyDate(this.year, this.month, this.day);
    }

    public MyDate previousMonth() {
        this.month--;

        int[] daysInMonth = { 31, isLeapYear(year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if (this.month <= 0) {
            this.month = 12;
            this.year--;
        }

        if (this.day > daysInMonth[this.month - 1]) {
            this.day = daysInMonth[this.month - 1];
        }

        return new MyDate(this.year, this.month, this.day);
    }

    public MyDate previousYear() {
        this.year--;

        int[] daysInMonth = { 31, isLeapYear(this.year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if (this.day > daysInMonth[this.month - 1]) {
            this.day = daysInMonth[this.month - 1];
        }

        return new MyDate(this.year, this.month, this.day);
    }

    public static void main(String[] args) {
        MyDate d1 = new MyDate(2012, 2, 28);
        System.out.println(d1); // Tuesday 28 Feb 2012
        System.out.println(d1.nextDay()); // Wednesday 29 Feb 2012
        System.out.println(d1.nextDay()); // Thursday 1 Mar 2012
        System.out.println(d1.nextMonth()); // Sunday 1 Apr 2012
        System.out.println(d1.nextYear()); // Monday 1 Apr 2013

        MyDate d2 = new MyDate(2012, 1, 2);
        System.out.println(d2); // Monday 2 Jan 2012
        System.out.println(d2.previousDay()); // Sunday 1 Jan 2012
        System.out.println(d2.previousDay()); // Saturday 31 Dec 2011
        System.out.println(d2.previousMonth()); // Wednesday 30 Nov 2011
        System.out.println(d2.previousYear()); // Tuesday 30 Nov 2010

        MyDate d3 = new MyDate(2012, 2, 29);
        System.out.println(d3.previousYear()); // Monday 28 Feb 2011

        MyDate d4 = new MyDate(2099, 11, 31); // Invalid year, month, or day!
        MyDate d5 = new MyDate(2011, 2, 29); // Invalid year, month, or day
        System.out.println(d4);
        System.out.println(d5);

    }
}
