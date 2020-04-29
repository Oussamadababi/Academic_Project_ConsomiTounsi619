package tn.esprit.spring.Controller.Produit;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.Model.Produit.Produit;
import tn.esprit.spring.Service.Produit.IProduitService;

@Controller(value = "ControllerProduit")
@ELBeanName(value = "ControllerProduit")
public class ControllerProduit {
	@Autowired
	IProduitService iproduitService;
	private Long id;
	private String nomProduit;
	private float prix;
	private String description;
	private Long barcode;
	private float poids;
	private float prixAchat;
	private int filtrageProduit;
	private Long idFiltrageProduit;
	
	public List<Produit> getProduitsByCategorie(Long idCategorie){
		return iproduitService.findProduitCategorie(idCategorie);
	}
	
	public List<Produit> getProduitsBySCategorie(Long idSCategorie){
		return iproduitService.findProduitSCategorie(idSCategorie);
	}
	public List<Produit> getProduitsBySsCategorie(Long idSsCategorie){
		return iproduitService.findProduitSsCategorie(idSsCategorie); 
	}


	public List<Produit> getProduits(){
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		setFiltrageProfuit(Integer.parseInt(params.get("filtrageProduit")));
		setIdFiltrageProfuit(Long.parseLong(params.get("idRecherhceProduit")));
		if(filtrageProduit==0){
			return iproduitService.findProduitCategorie(idFiltrageProduit);}
		else if(filtrageProduit==1){
			return iproduitService.findProduitSCategorie(idFiltrageProduit);}
		else if(filtrageProduit==2){
			return iproduitService.findProduitSsCategorie(idFiltrageProduit);}
		else return null;
	}
	
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getBarcode() {
		return barcode;
	}

	public void setBarcode(Long barcode) {
		this.barcode = barcode;
	}

	public float getPoids() {
		return poids;
	}

	public void setPoids(float poids) {
		this.poids = poids;
	}

	public float getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(float prixAchat) {
		this.prixAchat = prixAchat;
	}

	public int getFiltrageProfuit() {
		return filtrageProduit;
	}

	public void setFiltrageProfuit(int filtrageProduit) {
		this.filtrageProduit = filtrageProduit;
	}

	public Long getIdFiltrageProfuit() {
		return idFiltrageProduit;
	}

	public void setIdFiltrageProfuit(Long idFiltrageProduit) {
		this.idFiltrageProduit = idFiltrageProduit;
	}
	
	
}
