package servicosgerais.api.repository;

import org.springframework.stereotype.Repository;

import servicosgerais.api.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	public Cliente findById(int id);
}
