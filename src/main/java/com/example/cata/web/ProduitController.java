package com.example.cata.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.cata.dao.ProduitRepository;
import com.example.cata.entitis.Produit;

@Controller
public class ProduitController {
	@Autowired
	private ProduitRepository prodRepo;
	
	@RequestMapping(value="/index")
	public String index(Model model, 
						@RequestParam(name="page", defaultValue="0") int p, 
						@RequestParam(name="size", defaultValue="3") int s,
						@RequestParam(name="mc", defaultValue="") String mc) {
		Page<Produit> pageProduits = prodRepo.chercher("%"+mc+"%", PageRequest.of(p, s));
		model.addAttribute("listProduits",pageProduits.getContent());
		
		int[] pages = new int[pageProduits.getTotalPages()];
		model.addAttribute("pages", pages);
		model.addAttribute("size", s);
		model.addAttribute("pageCourante", p);
		model.addAttribute("mc", mc);
		
		return "produits";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String  delete(Long id) {
		prodRepo.deleteById(id);
		return "redirect:/index";
	}
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String formProduit(Model model) {
		model.addAttribute("produit", new Produit());
		
		return "FormProduit";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(Model model, @Validated Produit prod) {
		
		prodRepo.save(prod);
		
		return "Confirmation";
	}
	
	@RequestMapping(value="/")
	public String home() {
		
		return "redirect:/index";
	}
	
	@RequestMapping(value="/403")
	public String AccessDenied() {
		
		return "403";
	}
}	

