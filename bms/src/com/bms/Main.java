package com.bms;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) {
		List<Batch> batchId = FileExist.batchId();
		List<Faculty> FacultyId = FileExist.FacultyId();
		Map<Integer, Batch> batches = FileExist.batch();
		Map<Integer, Faculty> Faculties = FileExist.faculty();
		Map<Integer, Batch> alloted = FileExist.allotment();
		Map<Integer, Integer> bf = FileExist.bf();
		Map<Faculty, Batch> FB = FileExist.FB();
		Scanner sc = new Scanner(System.in);
		System.out.println("                                                      ======================================================");
		System.out.println("                                                        Welcome to Anna University Batch monitoring system");
		System.out.println("                                                      ======================================================");
		try {
			int preference = 0;
			do {
				System.out.println("                        ==============  ================ ===================    =======");
				System.out.println("please Enter preference Admin Login|1  ,Faculty Login|2 ,Faculty Register|3  or Exit|0 ");
				System.out.println("                        ==============  ================ ===================    =======");
				preference = sc.nextInt();

				switch (preference) {
				case 1:
					AdminFunctionality(sc, batches, Faculties, alloted, batchId, FacultyId, bf, FB);
					break;
				case 2:
					FacultyFunctionality(sc, alloted, FacultyId, Faculties, bf);
					break;
				case 3:
					FacultyRegister(sc, Faculties, FacultyId);
					break;
				case 0:
					System.out.println("*|Successfully Exited the System|*");
					break;

				default:
					throw new InvalidDataException("Invalid Input");
				}

			} while (preference != 0);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				ObjectOutputStream bId = new ObjectOutputStream(new FileOutputStream("bid.ser"));
				bId.writeObject(batchId);
				
				ObjectOutputStream fId = new ObjectOutputStream(new FileOutputStream("fid.ser"));
				fId.writeObject(FacultyId);
			
				ObjectOutputStream btch = new ObjectOutputStream(new FileOutputStream("btch.ser"));
				btch.writeObject(batches);
			
				ObjectOutputStream Fact = new ObjectOutputStream(new FileOutputStream("Fact.ser"));
				Fact.writeObject(Faculties);
			
				ObjectOutputStream alot = new ObjectOutputStream(new FileOutputStream("alot.ser"));
				alot.writeObject(alloted);

				ObjectOutputStream FBo = new ObjectOutputStream(new FileOutputStream("FB.ser"));
				FBo.writeObject(alloted);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}
    
	private static void FacultyRegister(Scanner sc, Map<Integer, Faculty> faculties, List<Faculty> facultyId) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Faculty Registration");
		System.out.println("-------------------------------");
		System.out.println("Enter Your name");
		String name = sc.next();
		System.out.println("Enter Your Username");
		String usname = sc.next();
		System.out.println("Enter your Password");
		String pass = sc.next();
		int id = BatchID.idGeneratorf();
		Faculty f = new Faculty(id, name, usname, pass);
		faculties.put(id, f);
		facultyId.add(f);
		System.out.println("Registered Successfully &  Your Faculty Id " + id);

	}

	private static void FacultyFunctionality(Scanner sc, Map<Integer, Batch> alloted, List<Faculty> facultyId,
			Map<Integer, Faculty> faculties, Map<Integer, Integer> bf) throws InvalidDataException {
		// TODO Auto-generated method stub
		int id = facultyLogin(sc, facultyId, faculties);
		try {
			int preference = 0;
			do {
				System.out.println("What would you like to perform");
				System.out.println("1 look over the batches assigned");
				System.out.println("2 delete my account");
				System.out.println("3 exit");
				preference = sc.nextInt();
				switch (preference) {
				case 1:
					BatchesAssigned(id, alloted);
					break;
				case 2:
					DeleteAccount(id, alloted, facultyId, faculties);
					break;
				case 0:
					System.out.println("Successfully Logged out");
					break;
				}

			} while (preference != 0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void BatchesAssigned(int id, Map<Integer, Batch> alloted) {
		// TODO Auto-generated method stub
		Batch alot = alloted.get(id);
		if(alot!=null) {
			System.out.println(alot.getCourseName()+" "+alot.getBatchID());
		}
		else {
			System.out.println("Not assigned yet");
		}
		
	}

	private static void DeleteAccount(int id, Map<Integer, Batch> alloted, List<Faculty> facultyId,
			Map<Integer, Faculty> faculties) throws InvalidDataException {
		// TODO Auto-generated method stub
		alloted.remove(id);
		faculties.remove(id);
		int a=0;
		int ans=0;
	    for(Faculty i:facultyId) {
	    	
	    	if(i.getFacultyId()==id) {
	    		ans=a;
	    	}
	    	a++;
	    }
	    facultyId.remove(ans);
	    throw new InvalidDataException("Account deleted Successfully");
//		System.out.println("Account deleted Successfully");
	}

	private static int facultyLogin(Scanner sc, List<Faculty> facultyId, Map<Integer, Faculty> faculties)
			throws InvalidDataException {
		// TODO Auto-generated method stub
//		System.out.println(facultyId.toString());
		System.out.println("Welcome to Faculty login panel");
		
		System.out.println("Enter Your FacultyId");
		int fId = sc.nextInt();
		System.out.println("Enter your Username");
		String uname = sc.next();
		System.out.println("Enter Your Password");
		String Pass = sc.next();

		Faculty fa = faculties.get(fId);
		if (fa != null && fa.getUsername().equals(uname) && fa.getPassword().equals(Pass)) {
			System.out.println("Logged In Succesfully");
			return fId;
		} else {
			throw new InvalidDataException("Wrong username or Password");
		}

	}

	private static void AdminFunctionality(Scanner sc, Map<Integer, Batch> batches, Map<Integer, Faculty> faculties,
			Map<Integer, Batch> allotted, List<Batch> batchId, List<Faculty> facultyId, Map<Integer, Integer> bf,
			Map<Faculty, Batch> fB) throws InvalidDataException {
		// TODO Auto-generated method stub

		Adminlogin(sc);

		int preference = 0;

		try {
			do {
				System.out.println("What Functionality you like to perform?");
				System.out.println("1-Create Batch");
				System.out.println("2-Update Batch");
				System.out.println("3-Assign Faculty");
				System.out.println("4-View Batch By Faculty");
				System.out.println("5-View Batch By BatchID");
				System.out.println("6-View All Batch");
				System.out.println("7-Delete Batch");
				System.out.println("8-Exit");
				preference = sc.nextInt();

				switch (preference) {
				case 1:
					createBatch(sc, batches, batchId);
					break;
				case 2:
					updateBatch(sc, batches, batchId, bf, allotted);
					break;
				case 3:
					assignFaculty(sc, batches, allotted, bf, batchId, fB, facultyId);
					break;
				case 4:
					viewBatchByFaculty(sc, allotted, facultyId, fB);
					break;
				case 5:
					viewBatchByBatchId(sc, batches);
					break;
				case 6:
					viewAllBatch(batchId);
					break;
				case 7:
					deleteBatch(sc, batches, allotted, bf, batchId);
					break;
				case 8:
					System.out.println("Admin successfully logged out");
					break;
				default:
					throw new InvalidDataException("Invalid Input");
				}
			}

			while (preference <= 7);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void Adminlogin(Scanner sc) throws InvalidDataException {
		// TODO Auto-generated method stub
		System.out.println("Enter UserName");
		String username = sc.next();
		System.out.println("Enter Password");
		int pass = sc.nextInt();

		if (username.equals(Administrator.username) && pass == Administrator.password) {
			System.out.println("Successfully Logged In");
		} else {
			throw new InvalidDataException("Wrong UserName Or Password");
		}
	}

	private static void deleteBatch(Scanner sc, Map<Integer, Batch> batches, Map<Integer, Batch> allotted,
			Map<Integer, Integer> bf, List<Batch> batchId) {
		// TODO Auto-generated method stub
		System.out.println("Please Enter the Batch ID");
		for(Batch i:batchId) {
			System.out.println(i.getBatchID()+" "+i.getCourseName());
		}
		int batch = sc.nextInt();
		batches.remove(batch);
		int fac = bf.get(batch);
		allotted.put(fac, null);
		bf.remove(batch);
		for (Batch i : batchId) {
			if (i.getBatchID() == batch) {
				batchId.remove(i);
			}
		}
		System.out.println("Successfully removed the batch");
	}

	private static void viewAllBatch(List<Batch> batchId) {
		// TODO Auto-generated method stub
		System.out.println("Name"+"           "+"Seats"+"           "+"Duration"+"           "+"StartDate");
		for (Batch i : batchId) {
			System.out.println(
					i.getCourseName() + "           " + i.getSeats() + "           " + i.getDuration() + "           " + i.getStartDate());
		}
//		System.out.println(batchId.toString());
	}

	private static void viewBatchByBatchId(Scanner sc, Map<Integer, Batch> batches) {
		// TODO Auto-generated method stub
		System.out.println("Enter the respective Batch id to view Batch");
		int n = sc.nextInt();
		Batch a = batches.get(n);
		System.out.println("BatchId"+"               "+"course"+"               "+"duration"+"               "+"Seats"+"               "+"StartDate");
		System.out.println(a.getBatchID()+"               "+a.getCourseName()+"               "+a.getDuration()+"               "+a.getSeats()+"        "+a.getStartDate());
	}

	private static void viewBatchByFaculty(Scanner sc, Map<Integer, Batch> allotted, List<Faculty> facultyId,
			Map<Faculty, Batch> fB) {
		// TODO Auto-generated method stub
		System.out.println("FacultyName"+"            "+"CourseName");
		for (Entry<Faculty, Batch> i : fB.entrySet()) {
			Faculty Faculty = i.getKey();
			Batch course = i.getValue();

			System.out.println(Faculty.getName() + "                  " + course.getCourseName());
		}

	}

	private static void assignFaculty(Scanner sc, Map<Integer, Batch> batches, Map<Integer, Batch> allotted,
			Map<Integer, Integer> bf, List<Batch> batchId2, Map<Faculty, Batch> fB, List<Faculty> facultyId) {
		// TODO Auto-generated method stub
		System.out.println("Enter the faculty Id to assign");
		for(Faculty i:facultyId) {
			System.out.println(i.getFacultyId()+"-->"+i.getName());
		}
		int fac = sc.nextInt();
		System.out.println("Enter the Batch Id to be assigned");
		for (Batch i : batchId2) {

			System.out.println(i.getBatchID() +"-->"+ i.getCourseName());
		}
		int batchId = sc.nextInt();
		Batch a = batches.get(batchId);
		allotted.put(fac, a);
		bf.put(batchId, fac);
		for (Faculty j : facultyId) {
			if (j.getFacultyId() == fac) {
				fB.put(j, a);
			}
		}

		System.out.println("Faculty assigned to the batch");
	}

	private static void updateBatch(Scanner sc, Map<Integer, Batch> batches, List<Batch> batchId2,
			Map<Integer, Integer> bf, Map<Integer, Batch> allotted) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		System.out.println("Enter the BatchID");
		int batchId = sc.nextInt();
		try {
			int preference = 0;
			do {
				System.out.println("Select Updating fields");
				System.out.println("1 course name");
				System.out.println("2 Seats");
				System.out.println("3 Start date");
				System.out.println("4 Enter Duration");
				System.out.println("5 Exit");
				preference = sc.nextInt();
				switch (preference) {
				case 1:
					Batch a = batches.get(batchId);
					String name = sc.next();
					a.setCourseName(name);
					for (Batch i : batchId2) {
						if (i.BatchID == batchId) {
							i.setCourseName(name);
						}
					}
					int facid = bf.get(batchId);
					Batch btch = allotted.get(facid);
					btch.setCourseName(name);
					break;
				case 2:
					Batch a1 = batches.get(batchId);
					String seats = sc.next();
					a1.setCourseName(seats);
					for (Batch i : batchId2) {
						if (i.BatchID == batchId) {
							i.setCourseName(seats);
						}
					}
					int fac2 = bf.get(batchId);
					Batch btch2 = allotted.get(fac2);
					btch2.setCourseName(seats);
					break;
				case 3:
					Batch a3 = batches.get(batchId);
					String StartDate = sc.next();
					a3.setCourseName(StartDate);
					for (Batch i : batchId2) {
						if (i.BatchID == batchId) {
							i.setCourseName(StartDate);
						}
					}
					int fac3 = bf.get(batchId);
					Batch btch3 = allotted.get(fac3);
					btch3.setCourseName(StartDate);
					break;
				case 4:
					Batch a4 = batches.get(batchId);
					String duration = sc.next();
					a4.setCourseName(duration);
					for (Batch i : batchId2) {
						if (i.BatchID == batchId) {
							i.setCourseName(duration);
						}
					}
					int fac4 = bf.get(batchId);
					Batch btch4 = allotted.get(fac4);
					btch4.setCourseName(duration);
					break;
				case 5:
					System.out.println("Successfully Exited");
					break;
				default:
					throw new InvalidDataException("invalid input");
				}
			} while (preference <= 4);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void createBatch(Scanner sc, Map<Integer, Batch> batches, List<Batch> batchId2)
			throws IOException, ClassNotFoundException {

		System.out.println("Enter the course name");
		String course = sc.next();
		System.out.println("Enter Number of Seats");
		int seats = sc.nextInt();
		System.out.println("Enter Start date");
		String start = sc.next();
		System.out.println("Enter Duration");
		String duration = sc.next();
		int batchID = BatchID.idGenerator();
		Batch batch = new Batch(batchID, course, seats, start, duration);
		batchId2.add(batch);
		batches.put(batchID, batch);
//		System.out.println(batches.toString() + " " + batchId2.toString());

		System.out.println("Added Successfully");
		System.out.println();
	}
}
