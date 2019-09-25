package com.biz.service;

import java.util.List;

import com.biz.bean.Address;

public interface AddressService {

	public void save(Address address);
	
	public List<Address> getAll();

}