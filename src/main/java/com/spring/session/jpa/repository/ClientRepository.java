package com.spring.session.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.spring.session.pojo.Customer;


@RepositoryRestResource(collectionResourceRel = "customer", path = "customers")
public interface ClientRepository extends JpaRepository<Customer, Long> {
	/**
	 * * Method that returns a lista of clients doing a search by the passed
	 * name parameter. * * @param name * @return list of clients
	 */
	//List<Customer> findByName(@Param("name") String name);

	/**
	 * * Method that returns a client with only its name doing a search by the
	 * passed id parameter. * * @param id * @return client of the id passed as
	 * parameter.
	 */
//	@Query("SELECT c.Name FROM Customer c where c.id = :id")
//	Customer findNameById(@Param("id") Long id);

	/**
	 * * Method that returns a list of clients doing a search by the passed name
	 * parameter and sorting them by the name. * * @param name * @return list of
	 * clients
	 */
//	List<Customer> findByNameOrderByName(@Param("name") String name);

}
