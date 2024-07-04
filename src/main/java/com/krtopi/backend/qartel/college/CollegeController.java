package com.krtopi.backend.qartel.college;

import com.krtopi.backend.qartel.chat.ChatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/api/colleges")
public class CollegeController {
    private CollegeService collegeService;

    public CollegeController(CollegeService collegeService){
        this.collegeService = collegeService;
    }
    // GET /api/colleges?city={userCity}
    @GetMapping("/api/colleges")
    public List<CollegeEntity> getCollegesByCity(@RequestParam String city) {
        return collegeService.getCollegesByCity(city);
    }
}
