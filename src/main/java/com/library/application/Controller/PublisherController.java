package com.library.application.Controller;

import com.library.application.model.Publisher;
import com.library.application.repository.PublisherRepository;
import com.library.application.service.PublisherService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
@AllArgsConstructor
@Slf4j
public class PublisherController {

    private final PublisherService publisherService;

    @GetMapping("/publishers")
    public String index(Model model){
        model.addAttribute("publishers",publisherService.findAll());
        return "publishers";
    }
    @PostMapping("/create/publisher")
    public String createPublisher(@Valid Publisher publisher, BindingResult result, Model model){

        publisherService.save(publisher);
        return "redirect:/publishers";
    }
    @GetMapping("/delete/publisher/{id}")
    public String deletePublisher(@PathVariable("id") long id){
        //log.info(String.valueOf(id));
        publisherService.delete(id);
        return "redirect:/publishers";
    }
    @PostMapping("/update/publisher")
    public String updatePublisher(@Valid Publisher publisher, BindingResult result, Model model){

        publisherService.save(publisher);
        return "redirect:/publishers";
    }



    }

