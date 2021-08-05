package business.entities;


public class Booking {
    int bookingID;
    String bookingDate;
    int days;
    String comment;
    String bookingStatus;
    int studentId;
    String itemId;

    public Booking(int bookingID, String bookingDate, int days, String comment, String bookingStatus, int studentId, String itemId){
        this.bookingID = bookingID;
        this.bookingDate = bookingDate;
        this.days = days;
        this.comment = comment;
        this.bookingStatus = bookingStatus;
        this.studentId = studentId;
        this.itemId = itemId;
    }

    public int getBookingID() {
        return bookingID;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public int getDays() {
        return days;
    }

    public String getComment() {
        return comment;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
