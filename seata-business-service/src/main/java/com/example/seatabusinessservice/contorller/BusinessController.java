package com.example.seatabusinessservice.contorller;

import com.example.seatabusinessservice.service.BusinessService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/business")
@RestController
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @RequestMapping("/purchase/commit")
    public boolean purchaseCommit(HttpServletRequest request) {
        businessService.purchase("1001", "2001", 1);
        return true;
    }

    @RequestMapping("/purchase/rollback")
    public boolean purchaseRollBack() {

        try {
            businessService.purchase("1002", "2001", 1);
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }

        return true;
    }
}
