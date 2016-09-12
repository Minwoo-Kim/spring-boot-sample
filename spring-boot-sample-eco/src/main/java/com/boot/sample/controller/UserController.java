package com.boot.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.sample.model.entity.User;
import com.boot.sample.model.repository.UserRepository;

@Transactional
@RestController
@RequestMapping("/rest/users")
public class UserController {

	@Autowired
	private UserRepository rep;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User get(@PathVariable("id") String id) {
		return rep.findOne(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public User create(@RequestBody User user) {
		return rep.save(user);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public User update(@RequestBody User user) {
		return rep.save(user);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") String id) {
		rep.delete(id);
	}

	@Cacheable(value = "basic")
	@RequestMapping(method = RequestMethod.GET)
	public List<User> findAll() {
		return rep.findAll();
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<User> findByName(@RequestParam("name") String name) {
		return rep.findByNameLike("%" + name + "%");
	}
}