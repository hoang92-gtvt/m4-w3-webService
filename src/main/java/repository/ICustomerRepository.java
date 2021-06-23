package repository;

import model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer,Long> {
    void delete(Optional<Customer> customer);
}
