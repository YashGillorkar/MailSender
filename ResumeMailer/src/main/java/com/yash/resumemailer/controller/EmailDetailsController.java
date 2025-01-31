package com.yash.resumemailer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yash.resumemailer.model.ApiResponse;
import com.yash.resumemailer.service.EmailDetailsServiceI;

@RestController
@RequestMapping("/api")
public class EmailDetailsController {

    @Autowired
    private EmailDetailsServiceI detailsServiceI;

    @GetMapping("/sendtoall")
    public ResponseEntity<ApiResponse<Void>> sendEmailToAll() {
        try {
            detailsServiceI.send();
            ApiResponse<Void> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                "Emails sent successfully to all recruiters.",
                null
            );
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            ApiResponse<Void> errorResponse = new ApiResponse<>(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Failed to send emails. Check logs for more details.",
                e.getMessage()
            );
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
