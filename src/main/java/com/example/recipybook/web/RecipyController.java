package com.example.recipybook.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.recipybook.domain.CategoryRepository;
import com.example.recipybook.domain.Recipy;
import com.example.recipybook.domain.RecipyRepository;

@Controller
public class RecipyController {
	@Autowired
	private RecipyRepository repository;
	
	@Autowired
	private CategoryRepository crepository;
	
	// Show all students
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
	
	@RequestMapping(value = "/recipyList", method = RequestMethod.GET)
	public String recipyList(Model model) {
		model.addAttribute("recipies", repository.findAll());
		return "recipyList";

	}
	
	@RequestMapping(value="/recipies", method = RequestMethod.GET)
	public @ResponseBody List<Recipy> recipyListRest(){
		return (List<Recipy>) repository.findAll();
	} 
	
	@RequestMapping(value="/recipy/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Recipy> findRecipyRest(@PathVariable("id") Long recipyId) {	
    	return repository.findById(recipyId);
    }
	
	
	@RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("recipy", new Recipy());
    	model.addAttribute("categories", crepository.findAll());
        return "addRecipy";
    }     
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Recipy recipy){
        repository.save(recipy);
        return "redirect:recipyList";
    }    

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteRecipy(@PathVariable("id") Long recipyId, Model model) {
    	repository.deleteById(recipyId);
        return "redirect:../recipyList";
    } 
    
    @RequestMapping(value = "/edit/{id}")
    public String editRecipy(@PathVariable("id") Long recipyId, Model model) {
    	model.addAttribute("recipy", repository.findById(recipyId));
    	model.addAttribute("categories", crepository.findAll());
    	return "editRecipy";
    } 

}
