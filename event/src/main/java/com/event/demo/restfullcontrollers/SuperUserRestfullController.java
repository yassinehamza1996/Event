package com.event.demo.restfullcontrollers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.event.demo.error.ErrorMessage;
import com.event.demo.exceptions.MessagesException;
import com.event.demo.exceptions.SuperUserAlreadyExistException;
import com.event.demo.exceptions.SuperUserException;
import com.event.demo.exceptions.SuperUserNotFoundException;
import com.event.demo.models.SuperUser;
import com.event.demo.repositories.SuperUserRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("Suser")
public class SuperUserRestfullController {

	private final SuperUserRepository superUserRepository;
	
	@Autowired
	public SuperUserRestfullController(SuperUserRepository superUserRepository) {
		this.superUserRepository=superUserRepository;
	}
	
	 @PostMapping("/saveSuser")
	 public SuperUser addNewShoppingItem(@RequestBody  SuperUser item) throws SuperUserAlreadyExistException, SuperUserException {
		 SuperUser foundedUser = superUserRepository.findSuperUserByEmail(item.getEmail());
		 System.out.println("NAME ==========>"+item.getFirstname());
		 if(item.getFirstname().isEmpty()||item.getFirstname()==null||item.getFirstname().isBlank()) {
			 throw new SuperUserException(MessagesException.USER_FIRST_NAME_IS_REQUIRED);
		 }
		 if(foundedUser!=null) {
			 throw new SuperUserAlreadyExistException(MessagesException.USER_ALREADY_EXIST);
		 }else {
			return superUserRepository.save(item);
		 }
	 }
	 @GetMapping("/getuserslist")
	 public Collection<SuperUser> getAllShoppingItem(){
		 return (Collection<SuperUser>) superUserRepository.findAll();
	 }
	 @GetMapping("/getuserbyemail/{mail}")
	 public SuperUser getUserBymail(@PathVariable("mail") String mail) throws SuperUserNotFoundException {
		 SuperUser superUser=null;
		  superUser = superUserRepository.findSuperUserByEmail(mail);
		 if(superUser!=null) {
			 return superUser;
		 }else {
			 throw new SuperUserNotFoundException(MessagesException.USER_NOT_FOUND_EXCEPTION);
		 }
	 }
	 @PutMapping("/edituser")
	 public SuperUser edituser(@RequestBody SuperUser user) throws SuperUserNotFoundException {
		 SuperUser foundedUser = null;
		 if(user!=null) {
			 String email = user.getEmail();
			 
			 foundedUser = (SuperUser) superUserRepository.findSuperUserByEmail(email);
			 if(foundedUser!=null) {
				 foundedUser.setCin(user.getCin());
				 foundedUser.setFirstname(user.getFirstname());
				 foundedUser.setInscriptionDate(user.getInscriptionDate());
				 foundedUser.setLastname(user.getLastname());
				 foundedUser.setPhoneNumber(user.getPhoneNumber());
			 }else {
				 foundedUser=null;
				 throw new SuperUserNotFoundException(MessagesException.USER_NOT_FOUND_EXCEPTION);
				 
			 }
			
			
			  
			 
		 }
		 return foundedUser;
	 }
	 
}
