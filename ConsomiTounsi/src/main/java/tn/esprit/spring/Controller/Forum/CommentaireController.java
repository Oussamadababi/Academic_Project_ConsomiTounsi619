package tn.esprit.spring.Controller.Forum;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Model.Forum.Commentaire;
import tn.esprit.spring.Service.Forum.ICommentaireService;


@RestController
@RequestMapping("/commentaire")
public class CommentaireController  {
@Autowired
ICommentaireService icommentaireService;
	
	//http://localhost:8081/commentaire/ajouter/7/1
	//{ "description": "bon bad badwords bads zeda "}
@PostMapping("/ajouter/{sujetId}/{userId}")
public ResponseEntity<?>ajouterCommentaire( @PathVariable(value = "sujetId") Long sujetid,
        @PathVariable(value = "userId") Long userid,
        @Valid @RequestBody Commentaire c){
	icommentaireService.ajouterCommentaire(c, sujetid, userid);
	return 	ResponseEntity.ok().body(c);
}

@GetMapping("/afficher/{sujetId}")
public ResponseEntity<?> afficherCommentaireOfSujet(@PathVariable(value = "sujetId") Long sujetId) {
	List<Commentaire> com=new ArrayList<>();
	com =icommentaireService.getCommentaireOfSujet(sujetId);
	return 	ResponseEntity.ok().body(com);
}

@GetMapping("/afficherNom/{comId}")
 public ResponseEntity<?> findNamebyCommentaire(@PathVariable(value = "comId")Long comId){
return ResponseEntity.ok().body(icommentaireService.findNamebyCommentaire(comId));
}

@GetMapping("/afficher/{userId}/{sujetId}")
 public ResponseEntity<?> findCommentairebySujetAndUser(@PathVariable(value = "userId") Long userid,
		 												@PathVariable(value = "sujetId") Long sujetId){
	List<Commentaire> com=new ArrayList<>();
	com=icommentaireService.getCommentaire(sujetId, userid);
return ResponseEntity.ok().body(com);
} 

@DeleteMapping("/delete/{comId}/{userId}/{sujetId}")
public ResponseEntity<?> DeleteCommentaire(@PathVariable(value = "comId") Long id,
										   @PathVariable(value = "userId") Long userid,
										   @PathVariable(value = "sujetId") Long sujetId){
	if(icommentaireService.deletecommentairevoteById(id, userid, sujetId)==0)
	return ResponseEntity.notFound().build();
return ResponseEntity.ok().build();
}

@PutMapping("/edit/{desc}/{comId}")
@ResponseBody
public ResponseEntity<?> ModifierCommentaire(@PathVariable("desc") String desc,
											@PathVariable("comId") Long id) {
	icommentaireService.modifierCommentaire(desc, id);
	return ResponseEntity.ok().build();
}

@GetMapping("/afficherNbcomment/{sujetId}")
public ResponseEntity<?> afficherNbCommentaireOfSujet(@PathVariable(value = "sujetId") Long sujetId) {
	int com =icommentaireService.countNbcommentaire(sujetId);
	return 	ResponseEntity.ok().body(com);
}


}
