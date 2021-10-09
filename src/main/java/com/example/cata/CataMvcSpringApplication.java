package com.example.cata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.example.cata.entitis.Produit;
import com.example.cata.dao.ProduitRepository;

@SpringBootApplication
public class CataMvcSpringApplication {

	public static void main(String[] args) {
	 /*ApplicationContext	ctx =*/ 
		SpringApplication.run(CataMvcSpringApplication.class, args);
	 /*ProduitRepository prodRepo = ctx.getBean(ProduitRepository.class);	
	 prodRepo.save(new Produit("HP 2500", 1500, 101));
	 prodRepo.save(new Produit("Azus 4500", 2500, 95));
	 prodRepo.save(new Produit("MacBook 1500", 5000, 70));
	 prodRepo.save(new Produit("Acer 1012", 2520, 100));
	 
	 prodRepo.findAll().forEach(p->System.out.println(p.getDesignation()));*/
	}

}
