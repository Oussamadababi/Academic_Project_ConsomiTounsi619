package tn.esprit.spring.Model.Stock;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import tn.esprit.spring.Model.Produit.Produit;
@Entity
public class Stock implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long idstock;
	private String nom_stock;
	private int quantite;
	@Temporal (TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date validite;
	private float remise;
	
    @ManyToOne
	private Produit idProduit;
    
    

	public Long getIdstock() {
		return idstock;
	}

	public void setIdstock(Long idstock) {
		this.idstock = idstock;
	}

	public String getNom_stock() {
		return nom_stock;
	}

	public void setNom_stock(String nom_stock) {
		this.nom_stock = nom_stock;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}



	public Produit getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Produit idProduit) {
		this.idProduit = idProduit;
	}

	public Stock() {
		super();
	}

	public Stock(Long idstock, String nom_stock, int quantite) {
		super();
		this.idstock = idstock;
		this.nom_stock = nom_stock;
		this.quantite = quantite;
	}

	
	
	
	
	
	
	
}