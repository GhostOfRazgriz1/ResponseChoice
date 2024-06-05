package org.zcyj.responsechoice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zcyj.responsechoice.service.ResponseService;

import java.util.Map;

@RestController
public class ResponseController {
    @Autowired
    private ResponseService responseService;

    @PostMapping("/responseChoice")
    public String getResponseChoice(@RequestBody Map<String, Integer> params) {
        try {
            System.out.println(params.toString());
            return responseService.getResponseChoice(params);
        }catch (Exception e) {
            return e.getMessage();
        }
    }

    @PostMapping("/invitationChoice")
    public String getInvitationChoice(@RequestBody Map<String, Integer> params) {
        try {
            System.out.println(params.toString());
            return responseService.getInvitationChoice(params);
        }catch (Exception e) {
            return e.getMessage();
        }
    }
}
