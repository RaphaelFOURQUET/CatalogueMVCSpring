package fr.adaming.mycatalogue.controller;

import java.io.File;
import java.io.FileInputStream;
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

import fr.adaming.mycatalogue.entity.Panier;
import fr.adaming.mycatalogue.entity.Produit;
import fr.adaming.mycatalogue.metier.IInternauteBoutiqueMetier;

@Controller
@RequestMapping(value="/produits")
@SessionAttributes("panier")
public class UserController {
	
	@Autowired
	private IInternauteBoutiqueMetier metier;
	
	@RequestMapping(value="/index")
	public String index(Model model){
		model.addAttribute("produit",new Produit());
		model.addAttribute("produits",metier.listproduits());
		model.addAttribute("categories", metier.listCategories());
		return "boutique";
	}
	
	@RequestMapping(value="photoProd",produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photCat(Long idProd) throws IOException{
		Produit p=metier.getProduit(idProd);
		File f=new
				File(System.getProperty("java.io.tmpdir")+"/PROD_"+idProd+"_"+p.getPhoto(
						));
		return IOUtils.toByteArray(new FileInputStream(f));
	}
	
	@RequestMapping(value="/savePanier")
	public String savePanier(@Valid Panier p,BindingResult bindingResult,
			Model model) {
		//TODO
		model.addAttribute("produit",new Produit());
		model.addAttribute("produits",metier.listproduits());
		model.addAttribute("categories", metier.listCategories());
		return "boutique";
	}
	
	@RequestMapping(value="/addPanier")
	public String addPanier(@Valid Panier p,BindingResult bindingResult,
			Model model) {
		//TODO
		model.addAttribute("produit",new Produit());
		model.addAttribute("produits",metier.listproduits());
		model.addAttribute("categories", metier.listCategories());
		return "boutique";
	}

}
