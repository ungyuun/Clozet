package com.clozet.repository;

import com.clozet.model.entity.Option;
import com.clozet.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptionRepository extends JpaRepository<Option,Long> {

    List<Option> findAllByProduct(Product product);

}
