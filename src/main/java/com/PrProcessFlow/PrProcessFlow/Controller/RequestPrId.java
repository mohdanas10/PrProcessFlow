package com.PrProcessFlow.PrProcessFlow.Controller;

import com.PrProcessFlow.PrProcessFlow.Repository.PrRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@CrossOrigin(originPatterns = "*")
public class RequestPrId {

    @Autowired
    private PrRepo prRepo;

    @GetMapping("/get-request-id")
    private String generateRequestId() {
        Date now = new Date();
        String month = new SimpleDateFormat("MMM").format(now).toUpperCase(); // AUG
        String year = new SimpleDateFormat("yy").format(now); // 25

        long count = prRepo.countCurrentMonthEntries() + 1;
        String sequence = String.format("%03d", count);
        return String.format("REQ/%s%s/%s", month, year, sequence);
    }

}
