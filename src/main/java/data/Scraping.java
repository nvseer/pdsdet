package data;


import complaints.Complaint;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Scraping {

    public Scraping() {
    }

    public List<Complaint> scrapeSiteForAllComplaints(){
        List<Complaint> complaintList = new ArrayList<>();
        try {
            Document document = Jsoup.connect("https://s3.us-east-2.amazonaws.com/gsd-auth-callinfo/callnotes.html").get();
            Elements complaintItems = document.getElementsByAttributeValue("contextmenu","menu_open");
            for(Element item : complaintItems)
            {
                String areaCode             = item.getElementsByAttributeValueContaining("href","AreaCode.aspx").text().replaceAll("[^0-9]","");
                String phoneNumber          = item.getElementsByAttributeValueContaining("href","Phone.aspx").text().replaceAll("[)(]","");
                String numberOfComments     = item.getElementsByClass("postCount").text();
                String comment              = item.getElementsByClass("oos_previewBody").text();

                Complaint complaint = new Complaint();
                complaint.setAreaCode(areaCode);
                complaint.setPhoneNumber(phoneNumber);
                complaint.setNumberOfComments(numberOfComments);
                complaint.setComment(comment);
                complaintList.add(complaint);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return complaintList;
    }

    public List<Complaint> scrapeSiteForComplaintsWithAreaCode(String areaCode){
        List<Complaint> complaintList = scrapeSiteForAllComplaints();
        return complaintList.stream().filter(item -> item.getAreaCode().equals(areaCode)).collect(Collectors.toList());
    }
}
