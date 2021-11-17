package projectjava;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;


public class Project1 {

	static Vector<Pack> pack = new Vector<>();
	static Random rand = new Random();
	static Scanner sc = new Scanner(System.in);
	static Vector<bio> bio = new Vector<>(); 
	
	private static void baca() {
		if(bio.size() == 0) {
			System.out.println("Empty");
			System.out.println("====================================================");
		}else {
			for(int i = 0; i < bio.size(); i++) {
				System.out.println("====================================================");
				System.out.println("Bionic Name : " + bio.get(i).name);
				System.out.println("Bionic Type : " + bio.get(i).type);
				System.out.println("Durability Class: " + bio.get(i).durable);
				System.out.println("Date Created : " + bio.get(i).date + " " + bio.get(i).month + " " + bio.get(i).year);
				System.out.println("Status : " + bio.get(i).status);
				System.out.println("====================================================");
			}
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		String month = "september", type, durable, name, newname, newdur, newname2, status = "need for test", testname;
		int t, ans = 0, date = 24, year = 2021, mon, mon2 = 9, worker = 1, time = 0;
		do {
			baca();
			System.out.println("Current date: " + date + " "+ month + " "+ year);
			System.out.println("1. Build Bionic");
			System.out.println("2. Manage Bionic");
			System.out.println("3. Manage Worker");
			System.out.println("4. Sort by Type");
			System.out.println("5. Sort by Durability");
			System.out.println("6. Sort by Date Created");
			System.out.println("7. Next Day");
			System.out.println("8. Exit");
			System.out.printf(">> ");
			t = sc.nextInt();sc.nextLine();
			switch(t) {
				case 1:{
					int skip = 0, skip1 = 0;
					System.out.printf("Bionic Name: [min 5 characters & unique]: ");
					name = sc.nextLine();
					while(name.length() < 5 || !name.matches(".*\\d.*")) {
						System.out.printf("Bionic Name: [min 5 characters & unique]: ");
						name = sc.nextLine();
					}
					System.out.printf("Bionic Type [Eye, Arm, Leg]: ");
					type = sc.nextLine();
					if(type.equals("Eye") || type.equals("Arm") || type.equals("Leg")) {
						skip++;
					}
					if(skip != 1) {
						while(!type.equals("Eye") || !type.equals("Arm") || !type.equals("Leg")) {
							if(type.equals("Eye") || type.equals("Arm") || type.equals("Leg")) {
								break;
							}
							System.out.printf("Bionic Type [Eye, Arm, Leg]: ");
							type = sc.nextLine();
						}					
					}
					System.out.printf("Bionic Durability Class [A, B, C, D, E]: ");
					durable = sc.nextLine();
					if(durable.equals("A") || durable.equals("B") ||durable.equals("C") ||durable.equals("D") ||durable.equals("E")) {
						skip1++;
					}
					if(skip1 != 1) {
						while(!durable.equals("A") || !durable.equals("B") ||!durable.equals("C") ||!durable.equals("D") ||!durable.equals("E")) {
							if(durable.equals("A") || durable.equals("B") ||durable.equals("C") ||durable.equals("D") ||durable.equals("E")) {
								break;
							}
							System.out.printf("Bionic Durability Class [A, B, C, D, E]: ");
							durable = sc.nextLine();
						}		
					}
					System.out.printf("Total months estimated until bionic is done [min 5] (ex.8): ");
					mon = sc.nextInt();sc.nextLine();
					while(mon < 5) {
						System.out.printf("Total months estimated until bionic is done [min 5] (ex.8): ");
						mon = sc.nextInt();sc.nextLine();
					}
					int rand = (mon - (ThreadLocalRandom.current().nextInt() % 2)) / worker;
					System.out.println("Build started for bionic: " + name);
					System.out.println("Bionic Type             : " + type);
					System.out.println("Bionic durability class : " + durable);
					System.out.println("Estimated done in       : " + rand);
					for(int i = rand; i >= 0; i--) {
						System.out.println("Building... " + (rand - i) + " month(s) [" + 100/(i+1) + "%]");
						TimeUnit.SECONDS.sleep(1);
					}
					System.out.println("Start Date = " + date + " "+ month + " "+ year);
					mon2 += rand;
					ans = mon2 % 12;
					if(mon2 > 12) {
						year += mon2/12;
						mon2 %= 12;
					}
					
				   if(ans == 1) {
					   month = "January";
				   }else if(ans == 2) {
					   month = "February";
				   }else if(ans == 3) {
					   month = "March";
				   }else if(ans == 4) {
					   month = "April";
				   }else if(ans == 5) {
					   month = "May";
				   }else if(ans == 6) {
					   month = "June";
				   }else if(ans == 7) {
					   month = "July";
				   }else if(ans == 8) {
					   month = "August";
				   }else if(ans == 9) {
					   month = "September";
				   }else if(ans == 10) {
					   month = "October";
				   }else if(ans == 11) {
					   month = "November";
				   }else if(ans == 12) {
					   month = "Desember";
				   }
				   System.out.println("Finish Date = " + date + " "+ month + " "+ year);
				   bio.add(new bio(name, type, durable, date, month, year, mon, ans, status, time));		
					break;
				}
				case 2:{
					 int s;
					   do {
					   baca();
					   System.out.println("1. Update Bionic");
					   System.out.println("2. Remove Bionic");
					   System.out.println("3. Test Bionic");
					   System.out.println("4. Show Test History");
					   System.out.println("5. Back");
					   System.out.printf(">> ");
					   s = sc.nextInt();sc.nextLine();
					   switch(s) {
							   case 1:{
								   int skip3 = 0, skip4 = 0, i;
								   baca();
									if(bio.size() == 0) {
										break;
									}
									System.out.println("Input bionic name to update ['cancel' to go back]: ");
									newname = sc.nextLine();
									if(newname.equals("cancel")) {
										break;
									}
									for(i = 0; i < bio.size(); i++) {
										if(newname.equals(bio.get(i).name)){
											skip3++;
											break;
										}
									}
									while(skip3 != 1) {
										System.out.println("Input bionic name to update ['cancel' to go back]: ");
										newname = sc.nextLine();
										if(newname.equals("cancel")) {
											continue;
										}
										for(i = 0; i < bio.size(); i++) {
											if(newname.equals(bio.get(i).name)){
												skip3++;
												break;
											}
										}
									}
									if(newname.equals("cancel")) {
										break;
									}
									System.out.printf("New bionic name [min 5 characters & unique]: ");
									newname2 = sc.nextLine();
									while(newname2.length() < 5 || !newname2.matches(".*\\d.*")) {
										System.out.printf("New nionic Name: [min 5 characters & unique]: ");
										newname2 = sc.nextLine();
									}
									System.out.printf("New bionic name [A, B, C, D, E]: ");
									newdur = sc.nextLine();
									if(newdur.equals("A") || newdur.equals("B") ||newdur.equals("C") ||newdur.equals("D") ||newdur.equals("E")) {
										skip4++;
									}
									if(skip4 != 1) {
										while(!newdur.equals("A") || !newdur.equals("B") ||!newdur.equals("C") ||!newdur.equals("D") ||!newdur.equals("E")) {
											if(newdur.equals("A") || newdur.equals("B") ||newdur.equals("C") ||newdur.equals("D") || newdur.equals("E")) {
												break;
											}
											System.out.printf("Bionic Durability Class [A, B, C, D, E]: ");
											newdur = sc.nextLine();
										}		
									}
									bio.get(i).name = newname2;
									bio.get(i).durable = newdur;
									
								   break;
							   }
							   case 2:{
								 int skip5 = 0, i;
								 String rem;
									   baca();
									   if(bio.size() == 0) {
										   break;
									   }
										System.out.printf("Input bionic name to remove [ 'cancel' to go back]: ");
										rem = sc.nextLine();
										if(rem.equals("cancel")) {
											break;
										}
										for(i = 0; i < bio.size(); i++) {
											if(rem.equals(bio.get(i).name)) {
												bio.remove(i);
												System.out.println("Remove Successfully");
												skip5++;
												break;
												}
											}				
										while(skip5 != 1) {
											System.out.printf("Input bionic name to remove [ 'cancel' to go back]: ");
											rem = sc.nextLine();
											if(rem.equals("cancel")) {
												continue;
											}
											for(i = 0; i < bio.size(); i++) {
												if(rem.equals(bio.get(i).name)) {
													bio.remove(i);
													System.out.println("Remove Successfully");
													skip5++;
													break;
												}			
											}
										}
								   break;
							   }
							   case 3:{
								   baca();
								   int skip3 = 0, i, test, suc = 0;
									if(bio.size() == 0) {
										break;
									}
									System.out.println("Input bionic name to update ['cancel' to go back]: ");
									testname = sc.nextLine();
									if(testname.equals("cancel")) {
										break;
									}
									for(i = 0; i < bio.size(); i++) {
										if(testname.equals(bio.get(i).name)){
											skip3++;
											break;
										}
									}
									while(skip3 != 1) {
										System.out.println("Input bionic name to update ['cancel' to go back]: ");
										testname = sc.nextLine();
										if(testname.equals("cancel")) {
											continue;
										}
										for(i = 0; i < bio.size(); i++) {
											if(testname.equals(bio.get(i).name)){
												skip3++;
												break;
											}
										}
									}
									if(bio.get(i).status.equals("PASSED") ||bio.get(i).status.equals("FAILED")) {
										System.out.println("Already Test");
										break;
									}
									if(bio.get(i).mon >= 20) {
										suc = 70 + ThreadLocalRandom.current().nextInt() % 30 + 1;
										if(suc < 0) {
											suc *= -1;
										}
										
									}else if(bio.get(i).mon >= 12) {
										suc = 30 + ThreadLocalRandom.current().nextInt() % 40 + 1;
										if(suc < 0) {
											suc *= -1;
										}
									}else if(bio.get(i).mon >= 3) {
										suc = ThreadLocalRandom.current().nextInt() % 30 + 1;
										if(suc < 0) {
											suc *= -1;
										}
									}
									System.out.println("Running bionic test on bionic '" + bio.get(i).name +"'");
									System.out.println("Bionic build time: " + bio.get(i).mon);
									System.out.println("Test started with " + suc + "% success rate.");
									for(int j = 5; j >= 1; j--) {
										System.out.println("Test begin in " + j);
										TimeUnit.SECONDS.sleep(1);
									}
									time = 7 + ThreadLocalRandom.current().nextInt() % 6 + 1;
									for(int k = 0; k < time; k++) {
										System.out.println("Testing bionic... [" + 100/(time - k) + "% ]");
										TimeUnit.SECONDS.sleep(1);
									}
									test = ThreadLocalRandom.current().nextInt() % 100 + 1; 
									
										if(test >= 100 - suc) {
											bio.get(i).status = "PASSED";
											System.out.println("Bionic Test Result: " + bio.get(i).status);
										}else {
											bio.get(i).status = "FAILED";
											System.out.println("Bionic Test Result: " + bio.get(i).status);
											System.out.println("Bionic will not last for a long time");
										}
								   break;
							   }
							   case 4:{
								 String temp;
								 int temp2;
								 for(int i = 0; i < bio.size(); i++) {
									 if(bio.get(i).status.equals("PASSED") || bio.get(i).status.equals("FAILED")) {
										 for(int j = 0; j < bio.size(); j++) {
											 for(int k = j + 1; k < bio.size(); k++) {
												 if(bio.get(j).status.compareTo(bio.get(k).status) > 0) {
													 	temp = bio.get(k).name;
														bio.get(k).name = bio.get(j).name;
														bio.get(j).name = temp;
														temp = bio.get(k).type;
														bio.get(k).type = bio.get(j).type;
														bio.get(j).type = temp;
														temp2 = bio.get(k).mon;
														bio.get(k).mon = bio.get(j).mon;
														bio.get(j).mon = temp2;
														temp2 = bio.get(k).time;
														bio.get(k).time = bio.get(j).time;
														bio.get(j).time = temp2;
														temp = bio.get(k).status;
														bio.get(k).status = bio.get(j).status;
														bio.get(j).status = temp;
												 }
											 }
										 }
										 System.out.println("====================================================");
										 System.out.println("Bionic Name : " + bio.get(i).name);
										 System.out.println("Bionic Type : " + bio.get(i).type);
										 System.out.println("Build time : " + bio.get(i).mon);
										 System.out.println("Test Duration : " + bio.get(i).time);
										 System.out.println("Status : " + bio.get(i).status);
										 System.out.println("====================================================");
									 }
									 TimeUnit.SECONDS.sleep(3);
								 }
								   break;
							   }
							   case 5:{
								   break;
							   }
					   }	
					   }while(s != 5);
					break;
				}
				case 3:{
					int r, hire;
					do {
					System.out.println("Current Worker: " + worker + " worker(s)");
					System.out.println("1. Hire new worker");
					System.out.println("2. Fire Worker");
					System.out.println("3. Back");
					System.out.printf(">> ");
					r = sc.nextInt();sc.nextLine();
					switch(r){
						case 1:{
							System.out.println("Input number of worker you want to hire: ");
							hire = sc.nextInt();sc.nextLine();
							while(hire < 1) {
								System.out.println("Input number of worker you want to hire: ");
								hire = sc.nextInt();sc.nextLine();
							}
							worker += hire;
							System.out.println("Worked Hired !!");
							break;
						}
						case 2:{
							int fire;
							System.out.printf("Input number of worker you want to fire [max  + %d +  candidate(s)]: ", worker - 1);
							fire = sc.nextInt();sc.nextLine();
							while(fire > worker - 1) {
								System.out.printf("Input number of worker you want to fire [max  + %d +  candidate(s)]: ", worker - 1);
								fire = sc.nextInt();sc.nextLine();
							}
							worker -= fire;
							break;
						}
						case 3:{
							
							break;
						}
					}
					}while(r != 3);
					break;
				}
				case 4:{
					String temp;
					int temp2;
					for(int i = 0; i < bio.size(); i++) {
						for(int j = i + 1; j < bio.size(); j++) {
							if(bio.get(i).type.compareTo(bio.get(j).type) > 0) {
								temp = bio.get(i).name;
								bio.get(i).name = bio.get(j).name;
								bio.get(j).name = temp;
								temp = bio.get(i).type;
								bio.get(i).type = bio.get(j).type;
								bio.get(j).type = temp;
								temp = bio.get(i).durable;
								bio.get(i).durable = bio.get(j).durable;
								bio.get(j).durable = temp;
								temp2 = bio.get(i).date;
								bio.get(i).date = bio.get(j).date;
								bio.get(j).date = temp2;
								temp = bio.get(i).month;
								bio.get(i).month = bio.get(j).month;
								bio.get(j).month = temp;
								temp2 = bio.get(i).year;
								bio.get(i).year= bio.get(j).year;
								bio.get(j).year = temp2;
								temp = bio.get(i).status;
								bio.get(i).status = bio.get(j).status;
								bio.get(j).status = temp;
							}
						}
					}
					
					break;
				}
				case 5:{
					String temp;
					int temp2;
					for(int i = 0; i < bio.size(); i++) {
						for(int j = i + 1; j < bio.size(); j++) {
							if(bio.get(i).durable.compareTo(bio.get(j).durable) > 0) {
								temp = bio.get(i).name;
								bio.get(i).name = bio.get(j).name;
								bio.get(j).name = temp;
								temp = bio.get(i).type;
								bio.get(i).type = bio.get(j).type;
								bio.get(j).type = temp;
								temp = bio.get(i).durable;
								bio.get(i).durable = bio.get(j).durable;
								bio.get(j).durable = temp;
								temp2 = bio.get(i).date;
								bio.get(i).date = bio.get(j).date;
								bio.get(j).date = temp2;
								temp = bio.get(i).month;
								bio.get(i).month = bio.get(j).month;
								bio.get(j).month = temp;
								temp2 = bio.get(i).year;
								bio.get(i).year= bio.get(j).year;
								bio.get(j).year = temp2;
								temp = bio.get(i).status;
								bio.get(i).status = bio.get(j).status;
								bio.get(j).status = temp;
							}
						}
					}
					break;
				}
				case 6:{
					String temp;
					int temp2;
					for(int i = 0; i < bio.size(); i++) {
						for(int j = i + 1; j < bio.size(); j++) {
							if(bio.get(i).year > bio.get(j).year) {
								temp = bio.get(i).name;
								bio.get(i).name = bio.get(j).name;
								bio.get(j).name = temp;
								temp = bio.get(i).type;
								bio.get(i).type = bio.get(j).type;
								bio.get(j).type = temp;
								temp = bio.get(i).durable;
								bio.get(i).durable = bio.get(j).durable;
								bio.get(j).durable = temp;
								temp2 = bio.get(i).date;
								bio.get(i).date = bio.get(j).date;
								bio.get(j).date = temp2;
								temp = bio.get(i).month;
								bio.get(i).month = bio.get(j).month;
								bio.get(j).month = temp;
								temp2 = bio.get(i).year;
								bio.get(i).year= bio.get(j).year;
								bio.get(j).year = temp2;
								temp = bio.get(i).status;
								bio.get(i).status = bio.get(j).status;
								bio.get(j).status = temp;
							}else if(bio.get(i).ans > bio.get(j).ans) {
									temp = bio.get(i).name;
									bio.get(i).name = bio.get(j).name;
									bio.get(j).name = temp;
									temp = bio.get(i).type;
									bio.get(i).type = bio.get(j).type;
									bio.get(j).type = temp;
									temp = bio.get(i).durable;
									bio.get(i).durable = bio.get(j).durable;
									bio.get(j).durable = temp;
									temp2 = bio.get(i).date;
									bio.get(i).date = bio.get(j).date;
									bio.get(j).date = temp2;
									temp = bio.get(i).month;
									bio.get(i).month = bio.get(j).month;
									bio.get(j).month = temp;
									temp2 = bio.get(i).year;
									bio.get(i).year= bio.get(j).year;
									bio.get(j).year = temp2;
									temp = bio.get(i).status;
									bio.get(i).status = bio.get(j).status;
									bio.get(j).status = temp;
								} else	if(bio.get(i).date > bio.get(j).date) {
										temp = bio.get(i).name;
										bio.get(i).name = bio.get(j).name;
										bio.get(j).name = temp;
										temp = bio.get(i).type;
										bio.get(i).type = bio.get(j).type;
										bio.get(j).type = temp;
										temp = bio.get(i).durable;
										bio.get(i).durable = bio.get(j).durable;
										bio.get(j).durable = temp;
										temp2 = bio.get(i).date;
										bio.get(i).date = bio.get(j).date;
										bio.get(j).date = temp2;
										temp = bio.get(i).month;
										bio.get(i).month = bio.get(j).month;
										bio.get(j).month = temp;
										temp2 = bio.get(i).year;
										bio.get(i).year= bio.get(j).year;
										bio.get(j).year = temp2;
										temp = bio.get(i).status;
										bio.get(i).status = bio.get(j).status;
										bio.get(j).status = temp;
									}
						
						}
					}
					
					break;
				}
				case 7:{
					date++;
					if(mon2 > 12) {
						year++;
						mon2 /= 12;
					}
					if(date == 28) {
						if(mon2 == 2) {
							mon2 = mon2 + 1;
							date /= 28;
						}
					}else if(date == 30) {
						if(mon2 % 2 == 0) {
							mon2 = mon2 + 1;
							date /= 30;
						}
					}else if(date == 31) {
						if(mon2 % 2 == 1) {
							mon2 = mon2 + 1;
							date /= 31;
						}
					}
					ans = mon2 % 12;
					if(ans == 1) {
						   month = "January";
					   }else if(ans == 2) {
						   month = "February";
					   }else if(ans == 3) {
						   month = "March";
					   }else if(ans == 4) {
						   month = "April";
					   }else if(ans == 5) {
						   month = "May";
					   }else if(ans == 6) {
						   month = "June";
					   }else if(ans == 7) {
						   month = "July";
					   }else if(ans == 8) {
						   month = "August";
					   }else if(ans == 9) {
						   month = "September";
					   }else if(ans == 10) {
						   month = "October";
					   }else if(ans == 11) {
						   month = "November";
					   }else if(ans == 12) {
						   month = "Desember";
					   }
					break;
				}
				case 8:{
					break;
				}

			}
		}while(t != 8);
		

	}

}
