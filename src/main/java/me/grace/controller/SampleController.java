package me.grace.controller;

import lombok.extern.log4j.Log4j;
import me.grace.domain.SampleDto;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

@Controller
@Log4j
public class SampleController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(LocalDateTime.class, new CustomDateEditor(dateFormat,false));
    }

    @PostMapping("/sample")
    public String sample(SampleDto dto) {
        log.info(dto);
        return "sample";
    }
}
