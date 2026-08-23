package com.foxinsurance.training.lesson9;

import jakarta.persistence.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class JpaPolicyRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public PolicyEntity save(PolicyEntity p) {
		entityManager.persist(p);
		return p;
	}

	@Transactional(readOnly = true)
	public PolicyEntity find(long id) {
		return entityManager.find(PolicyEntity.class, id);
	}

	@Transactional(readOnly = true)
	public List<PolicyEntity> findAll() {
		return entityManager.createQuery("select p from PolicyEntity p order by p.id", PolicyEntity.class)
				.getResultList();
	}

	@Transactional
	public void changeStatus(long id, String status) {
		var p = entityManager.find(PolicyEntity.class, id);
		p.setStatus(status);
	}
}
