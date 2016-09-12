package com.boot.sample.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.sample.model.entity.Role;

@Transactional
@RestController
@RequestMapping("/rest/roles")
public class RoleController {

	@Autowired
	private EntityManager em;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Role get(@PathVariable("id") String id) {
		return em.find(Role.class, id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void save(@RequestBody Role role) {
		em.persist(role);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") String id) {
		em.remove(this.get(id));
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.GET)
	public List<Role> search(@RequestParam("name") String name) {
		Query query = em.createNativeQuery("select * from roles r where role_name like '%' || :name || '%'");
		query.setParameter("name", name);
		return  query.getResultList();
	}
}