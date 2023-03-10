package com.project.boxinator;

import com.project.boxinator.enums.ShipmentStatus;
import com.project.boxinator.enums.TypeOfUser;
import com.project.boxinator.enums.WeightOption;
import com.project.boxinator.models.Shipment;
import com.project.boxinator.models.ShipmentStatusHistory;
import com.project.boxinator.models.User;
import com.project.boxinator.repositories.SSHRepository;
import com.project.boxinator.repositories.ShipmentRepository;
import com.project.boxinator.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;

@SpringBootApplication
public class BoxinatorApplication implements ApplicationRunner {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ShipmentRepository shipmentRepository;
	@Autowired
	private SSHRepository sshRepository;

	public static void main(String[] args) {
		SpringApplication.run(BoxinatorApplication.class, args);
	}


	@Override
	public void run(ApplicationArguments args) throws Exception {



		User Milla = new User(1,"Milovan", "Glisovic", "abc@dfg.com", "kpr",
				"1999-09-15", "Sweden", 21231, "0743-23", TypeOfUser.Guest, new HashSet<>());
		User Seth = new User(2,"Seth", "Öberg", "abc@dfg.com", "kpr",
				"1998-09-15", "Sweden", 21231, "0743-23", TypeOfUser.Registered, new HashSet<>());

		userRepository.save(Milla);
		userRepository.save(Seth);

		Shipment blueBox = new Shipment(1, "Greger", WeightOption.PREMIUM, "blue",
				"Norway",  new HashSet<>());
		Shipment redBox = new Shipment(2, "Greger", WeightOption.HUMBLE,"red",
				"Denmark",  new HashSet<>());
		Shipment yellowBox = new Shipment(3, "Mike", WeightOption.BASIC,"yellow",
				"Denmark",  new HashSet<>());

		shipmentRepository.save(blueBox);
		shipmentRepository.save(redBox);
		shipmentRepository.save(yellowBox);

		ShipmentStatusHistory SSH1 = new ShipmentStatusHistory(ShipmentStatus.COMPLETED, yellowBox);
		ShipmentStatusHistory SSH2 = new ShipmentStatusHistory(ShipmentStatus.RECIEVED, yellowBox);

		sshRepository.save(SSH1);
		sshRepository.save(SSH2);


//		yellowBox.addSSHToShipment(SSH1);
//		yellowBox.addSSHToShipment(SSH2);









	}
}
