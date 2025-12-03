package com.PrProcessFlow.PrProcessFlow.Services;


import com.PrProcessFlow.PrProcessFlow.Entity.Pr;
import com.PrProcessFlow.PrProcessFlow.Entity.WorkCategory;
import com.PrProcessFlow.PrProcessFlow.Repository.PrRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.awt.print.Pageable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PrServices {

    @Autowired
    private PrRepo prRepo;

    public String addPr(Pr pr){

//        System.out.println(pr);

        for (WorkCategory category : pr.getWorkCategory()) {

            System.out.println(category.getCategoryName());
            Pr newPr = new Pr();
            newPr.setRequestedBy(pr.getRequestedBy());
            newPr.setRequestedEmail(pr.getRequestedEmail());
            newPr.setRequestedDate(pr.getRequestedDate());
            newPr.setState(pr.getState());
            newPr.setCityName(pr.getCityName());
            newPr.setStoreType(pr.getStoreType());
            newPr.setProjectStoreId(pr.getProjectStoreId());
            newPr.setStoreName(pr.getStoreName());
            newPr.setPrWorkCategory(category.getCategoryName()); // save only category name
            newPr.setRequestId(pr.getRequestId());
            newPr.setLayoutApprovalDate(pr.getLayoutApprovalDate());
            newPr.setPrStatus("Pending");
            newPr.setDepartment(pr.getDepartment());
            newPr.setRemarks1(pr.getRemarks1());
            newPr.setMailSubject(pr.getMailSubject());
            newPr.setSubCategory(pr.getSubCategory());
            this.prRepo.save(newPr);


        }
        return "PR created successfully with Request ID: " + pr.getRequestId();
    }


    public List<Pr> getPendingPr(){
        List<Pr> allPr = this.prRepo.findAllByOrderByIdDesc();
        List<Pr> pendingPr = new ArrayList<>();
        if(allPr.isEmpty()){
            return null;
        }
        else {
            for(Pr pr : allPr){
                if(pr.getPrStatus().equals("Pending")){
                    pendingPr.add(pr);
                }
            }
            return pendingPr;
        }

    }

    public List<Pr> getRaisedPr(int page, int size){
        List<String> statuses = List.of("Raised", "Cancelled", "Rejected","Withdrawn");
        return prRepo.findByPrStatusInOrderByIdDesc(statuses, PageRequest.of(page, size))
                .getContent();
    }

    public List<Pr> getRaisedPrForTeam(){
        List<String> statuses = List.of("Raised", "Cancelled", "Rejected", "Withdrawn");
        return prRepo.findByPrStatusInOrderByIdDesc(statuses);
    }

    public String raisePr(Pr pr){
        if(pr == null){
            return "Please enter the pr details ";
        }

            int raisePrId = pr.getId();
        System.out.println(raisePrId);

            Pr updatedPr = prRepo.findById(raisePrId);
        System.out.println(updatedPr);
            int currentPrId = updatedPr.getId();
            if(currentPrId ==  raisePrId){

                updatedPr.setPrStatus("Raised");
                updatedPr.setPrCreator(pr.getPrCreator());
                updatedPr.setPrCreationDate(pr.getPrCreationDate());
                updatedPr.setVendorName(pr.getVendorName());
                updatedPr.setIsPrRejected(pr.getIsPrRejected());
                updatedPr.setRejectedReason(pr.getRejectedReason());
                updatedPr.setIsPrWithdraw(pr.getIsPrWithdraw());
                updatedPr.setWithdrawReason(pr.getWithdrawReason());
                updatedPr.setOldPrNo(pr.getOldPrNo());
                updatedPr.setRemarks1(pr.getRemarks1());
                updatedPr.setRemarks2(pr.getRemarks2());
                updatedPr.setPrNo(pr.getPrNo());
                updatedPr.setPrCreationReportDate(new Date());
                prRepo.save(updatedPr);
                return "PR updated successfully with Request ID: " + pr.getId();

            }
            return "PR Updation Failed ::: ";


    }

    public String updatePr(Pr pr){
        Pr updatedPr = prRepo.findById(pr.getId());
        System.out.println(updatedPr);
        if(updatedPr.getId() == pr.getId()){
            System.out.println(pr);
            updatedPr.setPrNo(pr.getPrNo());
            updatedPr.setPrCreator(pr.getPrCreator());
            updatedPr.setPrCreationDate(pr.getPrCreationDate());
            updatedPr.setVendorName(pr.getVendorName());
            updatedPr.setIsPrRejected(pr.getIsPrRejected());
            updatedPr.setRejectedReason(pr.getRejectedReason());
            updatedPr.setIsPrWithdraw(pr.getIsPrWithdraw());
            updatedPr.setWithdrawReason(pr.getWithdrawReason());
            updatedPr.setOldPrNo(pr.getOldPrNo());
            updatedPr.setRemarks1(pr.getRemarks1());
            updatedPr.setRemarks2(pr.getRemarks2());
            updatedPr.setPrStatus(pr.getPrStatus());
            updatedPr.setCancelReason(pr.getCancelReason());


            this.prRepo.save(updatedPr);
            return "PR updated successfully with Request ID: " + pr.getId();
        }
        return "PR Updation Failed ::: ";
    }



    public List<Pr> getAllPr (){
        return this.prRepo.findAll();
    }

    public List<Pr> getPrByDate(String fromDate, String toDate){
        List<Pr> allPr = prRepo.findAllByOrderByIdDesc();
        if (fromDate != null && toDate != null) {
            return allPr.stream()
                    .filter(pr -> pr.getPrCreationDate() != null &&
                            pr.getPrCreationDate().compareTo(fromDate) >= 0 &&
                            pr.getPrCreationDate().compareTo(toDate) <= 0)
                    .collect(Collectors.toList());
        }

        return allPr;

    }

    public String deletePr (int id ){
        Pr pr = prRepo.findById(id);
        if(pr != null){
            this.prRepo.delete(pr);
            return "PR deleted successfully with Request ID: " + pr.getRequestId();
        }
        else {
            return "PR Deletion Failed ::: ";
        }
    }





    



}
