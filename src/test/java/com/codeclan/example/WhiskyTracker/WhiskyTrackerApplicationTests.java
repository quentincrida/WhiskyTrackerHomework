package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepositoryCustom;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepositoryCustom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest

public class WhiskyTrackerApplicationTests {

	@Autowired
	private WhiskyRepository whiskyRepository;

	@Autowired
	private DistilleryRepository distilleryRepository;



	@Test
	public void contextLoads() {
	}

//	@Test
//	public void canCreateAndSaveAWhiskyObject() {
//
//		Distillery distilleryA = new Distillery("Dalwhinnie", "Speyside");
//		distilleryRepository.save(distilleryA);
//
//		Whisky whiskyA = new Whisky("Smokey", 12, 2018, distilleryA);
//		whiskyRepository.save(whiskyA);
//	}

	@Test
	public void canCreateAndSaveADistilleryObject(){

		Distillery distilleryB = new Distillery("Laphy", "Islay");
		distilleryRepository.save(distilleryB);

		Whisky whiskyB = new Whisky("Peaty", 10, 2000, distilleryB);
		whiskyRepository.save(whiskyB);

	}
	@Test
	public void canGetAllWhiskiesFrom2018(){
		List<Whisky> found = whiskyRepository.findByYear(2018);
		assertEquals(2, found.size());
	}
	}



