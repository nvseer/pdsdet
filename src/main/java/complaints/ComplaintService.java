package complaints;

import data.Scraping;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintService {

    public List<Complaint> getAllComplaints()
    {
        return new Scraping().scrapeSiteForAllComplaints();
    }

    public List<Complaint> getComplaintsByAreaCode(String areaCode){
        return new Scraping().scrapeSiteForComplaintsWithAreaCode(areaCode);
    }
}
