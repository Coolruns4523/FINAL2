package com.example.demo.Controller;

import com.example.demo.Class.Journal;
import com.example.demo.Repositories.CategoryRepository;
import com.example.demo.Repositories.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/journals")
public class JournalController {
    @Autowired
    JournalRepository journalRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping("/list")
    public String listJournals (Model model)
    {
        model.addAttribute("journals", journalRepository.findAll());
        return "listjournals";
    }

    @GetMapping("/add")
    public String addJournal(Model model)
    {
        model.addAttribute("journal", new Journal());
        return "journalForm";
    }

    @PostMapping("/add")
    public String processJournal(@ModelAttribute Journal journal, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
        {
            return "journalForm";
        }
        journalRepository.save(journal);
        return "redirect:/journal/list";
    }

    @RequestMapping("/edit/{id}")
    public String editJournal(@PathVariable("id")long id,Model model)
    {


        model.addAttribute("aJournal", journalRepository.findJournalById(id));
        return "journalForm";

    }

    @RequestMapping("/delete/{id}")
    public String delJournal(@PathVariable("id")long id, Model model)
    {
        {
            journalRepository.deleteById(id);
            return "redirect:/";
        }
    }

}
