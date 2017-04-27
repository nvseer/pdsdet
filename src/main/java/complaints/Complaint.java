package complaints;


public class Complaint {

    private String areaCode;
    private String phoneNumber;
    private String numberOfComments;
    private String comment;

    public Complaint()
    {
    }

    public Complaint(String areaCode, String phoneNumber, String numberOfComments, String comment) {
        this.areaCode = areaCode;
        this.phoneNumber = phoneNumber;
        this.numberOfComments = numberOfComments;
        this.comment = comment;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNumberOfComments() {
        return numberOfComments;
    }

    public void setNumberOfComments(String numberOfComments) {
        this.numberOfComments = numberOfComments;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
