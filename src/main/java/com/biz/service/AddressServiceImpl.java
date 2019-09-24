package com.biz.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.biz.bean.Address;
import com.biz.repository.AddressRepository;

public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public void save(Address address) {
		addressRepository.save(address);

	}

}
