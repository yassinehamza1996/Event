package com.event.demo.restfullcontrollers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.event.demo.models.Evenement;
import com.event.demo.repositories.EvenementRepository;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("Event")
public class EvenementRestfullController {


	private final EvenementRepository eventRepository;
	
	@Autowired
	 EvenementRestfullController(EvenementRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
	
	 @PostMapping("/saveEvent")
	 public Evenement addNewShoppingItem(@RequestBody  Evenement event) {
		return eventRepository.save(event);
	 }
	 
	 @GetMapping("/getEventList")
	 public Collection<Evenement> getAllShoppingItem(){
		 return (Collection<Evenement>) eventRepository.findAll();
	 }
	 
	 @PutMapping("/editEvent")
	 public Evenement editEvent(@RequestBody Evenement event) {
		 Evenement foundedEvent = null;
		 if(event!=null) {
			 int id = event.geteventCode();
			 try {
			 foundedEvent = (Evenement) eventRepository.findByeventCode(id);
			 foundedEvent.setendDate(event.getendDate());
			 foundedEvent.setstartDate(event.getstartDate());
			 foundedEvent.setLatitude(event.getLatitude());
			 foundedEvent.setLongitude(event.getLongitude());
			 foundedEvent.setLogo(event.getLogo());
			 foundedEvent.setStatus(event.getStatus());
			 foundedEvent.setTitle(event.getTitle());
			 }catch(Exception e) {
			  String errorMessage =  e.toString();
			  e.printStackTrace();
			  foundedEvent=null;
			 }
		 }
		 return foundedEvent;
	 }
	 @DeleteMapping("/deleteEvent/{id}")
	 public void deleteShoppingItem(@PathVariable int id) {
		  eventRepository.deleteById(id);
	 }
	 @DeleteMapping("/deleteEvent")
	 public void deleteShoppingItem(@RequestBody Evenement event) {
		  eventRepository.deleteEventByeventCode(event.geteventCode());
	 }
}
