package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.repository.UserRepository;

@RestController
@RequestMapping("/api/items")
public class ItemController {

	@Autowired
	private UserRepository userRepository;

	
	// create user
	@PostMapping
	public User createUser(@RequestBody User user) {
		return this.userRepository.save(user);
	}
	
	
	
	// delete user by id
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable ("id") long userId){
		 User existingUser = this.userRepository.findById(userId)
					.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
		 this.userRepository.delete(existingUser);
		 return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable ("id") long userId){
		 User existingUser = this.userRepository.findById(userId)
					.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
		 this.userRepository.delete(existingUser);
		 return ResponseEntity.ok().body(existingUser);
	}
	
	
	@GetMapping("/list")
	public List<User> getAllUsers(){
		return userRepository.findAll();
		
	}
	
	@PutMapping("/id")
	public User userUpdate(@RequestBody User user,@PathVariable("id") long userId) {
		User existingUser=this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException(" User not found with id "+userId));	
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		return this.userRepository.save(existingUser);
	}
	
}
