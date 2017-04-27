package complaints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;

@RestController
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @RequestMapping("/complaints")
    public List<Complaint> getComplaints(@RequestParam(value = "areaCode", required = false)String areaCode)
    {
        if(areaCode == null)
            return complaintService.getAllComplaints();
        else
            return complaintService.getComplaintsByAreaCode(areaCode);
    }


}
