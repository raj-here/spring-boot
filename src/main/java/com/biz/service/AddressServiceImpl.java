package com.biz.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.bean.Address;
import com.biz.repository.AddressRepository;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public void save(Address address) {
		addressRepository.save(address);

	}

	@Override
	public List<Address> getAll() {
		return addressRepository.findAll();
	}

}
