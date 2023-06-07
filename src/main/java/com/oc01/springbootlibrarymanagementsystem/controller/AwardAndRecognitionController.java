package com.oc01.springbootlibrarymanagementsystem.controller;

import com.oc01.springbootlibrarymanagementsystem.entity.AwardAndRecognition;
import com.oc01.springbootlibrarymanagementsystem.service.AwardAndRecognitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/awards-and-recognitions")
public class AwardAndRecognitionController {

    private AwardAndRecognitionService awardAndRecognitionService;

    @Autowired
    private AwardAndRecognitionController(AwardAndRecognitionService awardAndRecognitionService) {
        this.awardAndRecognitionService = awardAndRecognitionService;
    }

    @GetMapping("/list")
    private String awardsAndRecognitionsList(Model model) {
        List<AwardAndRecognition> awardsAndRecognitions = awardAndRecognitionService.findAll();
        model.addAttribute("awardsAndRecognitions", awardsAndRecognitions);

        return "awardAndRecognition/awardsAndRecognitions-list";
    }

    @GetMapping("/create-award-and-recognition-form")
    private String createAwardAndRecognitionForm(Model model) {
        AwardAndRecognition awardAndRecognition = new AwardAndRecognition();
        model.addAttribute("awardAndRecognition", awardAndRecognition);

        return "awardAndRecognition/awardAndRecognition-form";
    }

    @GetMapping("/update-award-and-recognition-from")
    private String updateAwardAndRecognitionForm(
            @RequestParam("awardAndRecognitionId") int awardAndRecognitionId, Model model) {
        AwardAndRecognition awardAndRecognition = awardAndRecognitionService.findById(awardAndRecognitionId);
        model.addAttribute("awardAndRecognition", awardAndRecognition);

        return "awardAndRecognition/awardAndRecognition-form";
    }

    @GetMapping("/delete")
    private String deleteAwardAndRecognition(
            @RequestParam("awardAndRecognitionId") int awardAndRecognitionId) {
        awardAndRecognitionService.deleteById(awardAndRecognitionId);

        return "redirect:/awards-and-recognitions/list";
    }

    @PostMapping("/save")
    private String saveAwardAndRecognition(
            @ModelAttribute("awardAndRecognition") AwardAndRecognition awardAndRecognition) {
        awardAndRecognitionService.save(awardAndRecognition);

        return "redirect:/awards-and-recognitions/list";
    }
}
