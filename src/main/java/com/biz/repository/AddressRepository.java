package com.biz.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.biz.bean.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}