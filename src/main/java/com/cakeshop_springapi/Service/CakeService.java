package com.cakeshop_springapi.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cakeshop_springapi.dao.CakeRepository;
import com.cakeshop_springapi.model.ListOfCakes;

@Service
public class CakeService {
	@Autowired
	CakeRepository cakeRepository;
	 public void save (ListOfCakes cake) throws Exception {
		 try {
			 cakeRepository.save(cake);
		 }catch (Exception e) {
			 throw new Exception (e.getMessage());
		 }
	 }
	 public List<ListOfCakes>findAll() throws Exception{
		 List<ListOfCakes>listcakes=null;
		 try {
			 listcakes = cakeRepository.findAll();
		 } catch (Exception e) {
			 throw new Exception(e.getMessage());
		 }
		 return listcakes;
	 }
	 public void deleteById(Integer id) throws Exception {
			try {
				cakeRepository.deleteById(id);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
		public void update(Integer id, ListOfCakes cake) throws Exception {
			try {
				cake.setId(id);
				cakeRepository.save(cake);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
		public ListOfCakes findById(Integer id) {
			Optional<ListOfCakes> cake = cakeRepository.findById(id);
			if (cake.isPresent()) {
				ListOfCakes cakeObj = cake.get();
				return cakeObj;
			} else {
				return null;
			}
		}

}
