package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.Model.LigneCommande;
import tn.esprit.spring.Model.lignecommandeproduit;







@Repository

public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Long> {

	@Query(value = "SELECT  NEW tn.esprit.spring.Model.lignecommandeproduit(p.NomProduit,l.quantity,p.Prix,l.quantity*p.Prix) FROM LigneCommande l join l.commande c  join l.produit p   WHERE c.idUser.id=:idc and c.status='en cours'")
	public List<lignecommandeproduit> panierParIdclient(@Param("idc")long i);
	@Query(value = "SELECT * FROM ligne_commande l JOIN commande c on l.commande_id=c.id  WHERE l.produit_id=?1 AND c.id_user=?2 AND l.status='en cours' ", nativeQuery = true)
	public LigneCommande findLigneCommande(Long idProduit,Long idClient);

}
