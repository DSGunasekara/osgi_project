package airservicepublisher;

import java.util.Scanner;

public class ServicePublishImpl implements ServicePublish{

	Scanner input = new Scanner(System.in);
	String [] locations = {"Galle", "Kandy", "Colombo", "Jaffna"};
	int [][] distance = {{0, 220, 120, 500}, {220, 0, 120, 320}, {120, 120, 0, 360}, {500, 320, 360, 0}};
	String [] classes = {"Economy Class", "Business Class", "First Class"};
	
	@Override
	public String publishService() {
		return "Execute the publish service";
	}

	@Override
	public void clientDetails() {
		System.out.println("---------Welcome to Air Service---------\n");
		System.out.print("Enter your name: ");
		String userName = input.next();
		System.out.println("\nHello " + userName);
		airports();
	}

	public void airports() {
		System.out.println("Select your Location");
		for(int i = 0; i < locations.length; i++) {
			System.out.println(i+1 + " " + locations[i]);
		}
		System.out.print("\nLocation: ");
		int location = input.nextInt();
		destination(location);
	}

	public void destination(int boradingLocation) {
		System.out.println("\nSelect your Destination");
		int count = 1;
		for(int i = 0; i < locations.length; i++) {
			if(boradingLocation != i+1) {
				System.out.println(count++ + " " + locations[i]);
			}
		}
		System.out.print("\nDestination: ");
		int location = input.nextInt();
		if(location >= boradingLocation) {
			location++;
		}
		System.out.print("\nFrom: " + locations[boradingLocation - 1] + " To: " + locations[location -1]);
		int dis = distance[boradingLocation - 1][location -1];
		System.out.println("\nDistance: " + dis + "km");
		classes(dis);
	}
	
	public void classes(int dis) {
		System.out.println("\nSelect your Fare Class");
		for(int i = 0; i < classes.length; i++) {
			System.out.println(i+1 + " " + classes[i]);
		}
		int fare = 0;
		System.out.print("\nClass: ");
		int fareClass = input.nextInt();
		
		System.out.print("\nNo of Tickets: ");
		int tickets = input.nextInt();
		
		switch(fareClass) {
			case 1:
				fare = dis * 20;
				break;
			case 2:
				fare = dis * 50;
				break;
			case 3:
				fare = dis * 100;
		}
		System.out.println("\nTicket Price: Rs " + fare);
		System.out.println("\nFare: Rs " + fare * tickets);
		boolean conf = true;
		while(conf) {
			System.out.println("\nDo you want to continue? (Y/N)");
			String confirm = input.next();
			if(confirm.equalsIgnoreCase("Y")) {
				airports();
				conf = false;
			}else if(confirm.equalsIgnoreCase("N")) {
				conf = false;
			}
		}
		
	}

}
