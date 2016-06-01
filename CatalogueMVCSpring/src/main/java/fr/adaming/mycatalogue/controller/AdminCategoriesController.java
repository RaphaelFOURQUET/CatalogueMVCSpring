package fr.adaming.mycatalogue.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import fr.adaming.mycatalogue.entity.Categorie;
import fr.adaming.mycatalogue.metier.IAdminCategoriesMetier;

@Controller
@RequestMapping("/adminCat")
@SessionAttributes({"editedCat","categorie","categories"})
public class AdminCategoriesController {

	@Autowired
	private IAdminCategoriesMetier metier;

	@RequestMapping("/index")
	public String index(Model model){
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", metier.listCategories());
		return "categories";
	}

	@RequestMapping("/saveCat")
	public String saveCat(@Valid Categorie c,BindingResult bindingResult,
			Model model,MultipartFile file) throws Exception {
//		Categorie c = (Categorie) model.asMap().get("categorie");	//MODIF
		if(bindingResult.hasErrors()) {
			model.addAttribute("categories", metier.listCategories());
			return "categories";
		}
		if(!file.isEmpty()){c.setPhoto(file.getBytes());}
		else{
			if(c.getIdCategorie()!=null){	//TODO est ce que id dans URL ? 
				Categorie cat=(Categorie) model.asMap().get("editedCat");
				c.setPhoto(cat.getPhoto());
			}
		}
		if(c.getIdCategorie()==null) 
			metier.ajouterCategorie(c);
		else metier.modifierCategorie(c);
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", metier.listCategories());
		return "categories";
	}

	@RequestMapping(value="/photoCat",produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getPhoto(Long idCat) throws IOException{
		Categorie c=metier.getCategorie(idCat);
		if(c.getPhoto()==null) 
			return new byte[0];
		else return IOUtils.toByteArray(new ByteArrayInputStream(c.getPhoto()));
	}

	@RequestMapping(value="/suppCat")
	public String suppCat(Long idCat,Model model){
		metier.supprimerCategorie(idCat);
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", metier.listCategories());
		return "categories";
	}

	@RequestMapping(value="/editCat")
	public String editCat(Long idCat,Model model){
		Categorie c=metier.getCategorie(idCat);
		model.addAttribute("editedCat", c);
		model.addAttribute("categorie", c);
		model.addAttribute("categories", metier.listCategories());
		return "categories";
	}

}