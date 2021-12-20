package com.noob.liveasy.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.noob.liveasy.model.Load;
import com.noob.liveasy.repository.LoadRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/")
public class LoadController {

	@Autowired
	LoadRepository loadRepository;
	@GetMapping("/load")
	public ResponseEntity<List<Load>> getAllLoads(@RequestParam(required = false) String title) {
		try {
			List<Load> load = new ArrayList<Load>();

			if (title == null)
				loadRepository.findAll().forEach(load::add);
			else
				loadRepository.findByshipperIdContaining(title).forEach(load::add);

			if (load.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(load, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/load/{id}")
	public ResponseEntity<Load> getLoadById(@PathVariable("id") long id) {
		Optional<Load> loadData = loadRepository.findById(id);

		if (loadData.isPresent()) {
			return new ResponseEntity<>(loadData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/load")
	public ResponseEntity<Load> createLoad(@RequestBody Load load) {
		try {
			Load _load = loadRepository
					.save(new Load(load.getloadingPoint(), load.getunloadingPoint (), load.getproductType (), load.gettruckType (), load.getnoOfTrucks (), load.getweight (), load.getcomment (), load.getshipperId (), load.getDate ()));
			return new ResponseEntity<>(_load, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/load/{id}")
	public ResponseEntity<Load> updateLoad(@PathVariable("id") long id, @RequestBody Load load) {
		Optional<Load> loadData = loadRepository.findById(id);

		if (loadData.isPresent()) {
			Load _load = loadData.get();
			_load.setloadingPoint(load.getloadingPoint());
			_load.setunloadingPoint(load.getunloadingPoint());
			_load.setproductType(load.getproductType());
			_load.settruckType(load.gettruckType());
			_load.setnoOfTrucks(load.getnoOfTrucks());
			_load.setweight(load.getweight());
			_load.setcomment(load.getcomment());
			_load.setshipperId(load.getshipperId());
			_load.setDate(load.getDate());
			return new ResponseEntity<>(loadRepository.save(_load), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/load/{id}")
	public ResponseEntity<HttpStatus> deleteLoad(@PathVariable("id") long id) {
		try {
			loadRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

