package org.twspring.exercisejparelationi.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.twspring.exercisejparelationi.Model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    Address findAddressById(Integer id);
}
