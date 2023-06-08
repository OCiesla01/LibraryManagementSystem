package com.oc01.springbootlibrarymanagementsystem.controller;

import com.oc01.springbootlibrarymanagementsystem.entity.Award;
import com.oc01.springbootlibrarymanagementsystem.service.AwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/awards")
public class AwardController {

    private AwardService awardService;

    @Autowired
    private AwardController(AwardService awardService) {
        this.awardService = awardService;
    }

    @GetMapping("/list")
    private String awardsList(Model model) {
        List<Award> awards = awardService.findAll();
        model.addAttribute("awards", awards);

        return "award/awards-list";
    }

    @GetMapping("/update-award")
    private String updateAward(@RequestParam("awardId") int awardId, Model model) {
        Award award = awardService.findById(awardId);
        model.addAttribute("award", award);

        return "award/award-form";
    }

    @GetMapping("/delete")
    private String deleteAward(@RequestParam("awardId") int awardId) {
        awardService.deleteById(awardId);

        return "redirect:/awards/list";
    }

    @PostMapping("/save")
    private String saveAward(@ModelAttribute("award") Award award) {
        awardService.save(award);

        return "redirect:/awards/list";
    }
}
