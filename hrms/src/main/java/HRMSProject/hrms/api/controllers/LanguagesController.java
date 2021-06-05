package HRMSProject.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HRMSProject.hrms.business.abstracts.LanguageService;
import HRMSProject.hrms.entities.concretes.Language;

@RestController
@RequestMapping("/api/language")
public class LanguagesController {
	
	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	@Transactional
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(languageService.getAll());
	}
	
	@Transactional
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<?> getById(@PathVariable int id){
		return ResponseEntity.ok(languageService.getById(id));
	}
	
	@Transactional
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Language language){
		return ResponseEntity.ok(languageService.add(language));
	}
	
	@Transactional
	@PostMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){
		return ResponseEntity.ok(languageService.delete(id));
	}
	
	@Transactional
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody Language language){
		return ResponseEntity.ok(languageService.update(language));
	}
}
