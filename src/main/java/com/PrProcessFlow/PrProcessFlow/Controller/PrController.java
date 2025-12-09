package com.PrProcessFlow.PrProcessFlow.Controller;
import com.PrProcessFlow.PrProcessFlow.Entity.Pr;
import com.PrProcessFlow.PrProcessFlow.Repository.PrRepo;
import com.PrProcessFlow.PrProcessFlow.Services.PrServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(originPatterns = "*")
public class PrController {

    @Autowired
    private PrServices prServices;

    @PostMapping("/add-pr-request")
    public String addPr(@RequestBody Pr pr){
        System.out.println(pr.getLayoutApprovalDate());
        return  this.prServices.addPr(pr);
    }

    @GetMapping("/get-pending-pr")
    public List<Pr> getPendingPr(){
        return this.prServices.getPendingPr();
    }

    @GetMapping("/get-raise-pr-for-team")
    public List<Pr> getRaisePrForTeam(){
        return this.prServices.getRaisedPrForTeam();
    }

    @GetMapping("/get-raised-pr")
    public List<Pr> getRaisedPr(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "100") int size) {
        return prServices.getRaisedPr(page, size);
    }

    @PostMapping("/raise-pr")
    public String raisePr(@RequestBody Pr pr){
        return this.prServices.raisePr(pr);
    }

    @PutMapping("/update-pr")
    public String updatePr(@RequestBody Pr pr){
        System.out.println(pr);
        return this.prServices.updatePr(pr);
    }

    @GetMapping("/get-all-pr")
    public List<Pr> getAllPr(){
        return this.prServices.getAllPr();
    }

    @GetMapping("/get-pr-by-date")
    public List<Pr> getPrByDate(@RequestParam(required = false , name = "from") String fromDate, @RequestParam(required = false, name = "to") String toDate){
        System.out.println(fromDate);
        System.out.println(toDate);
        return this.prServices.getPrByDate(fromDate, toDate);
    }

    @DeleteMapping("/delete-pr/{id}")
    public String deletePr(@PathVariable int id){
        return this.prServices.deletePr(id);
    }

    @GetMapping("/get-five-pr")
    public List<Pr> getFivePr(){
        return this.prServices.getFivePr();
    }


}
