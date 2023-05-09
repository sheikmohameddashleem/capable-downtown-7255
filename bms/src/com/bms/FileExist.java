package com.bms;

import java.util.*;
import java.io.*;
public class FileExist {
 
	@SuppressWarnings("unchecked")
	public static Map<Integer,Batch>batch(){
		Map<Integer,Batch> bfile=null;
		File f=new File("btch.ser");
//		System.out.println(f.exists());
		boolean flag=false;
		try {
			if(!f.exists()) {
				f.createNewFile();
				flag=true;
			}
			if(flag) {
				
				bfile=new HashMap<Integer,Batch>();
				try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("btch.ser"))) {
					oos.writeObject(bfile);
				}
				
				return bfile;
			}
		   if(flag==false){
				
				try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
					bfile=(Map<Integer,Batch>)ois.readObject();
				}
             
                return bfile;
			}
		}catch(IOException | ClassNotFoundException e) {
			
			System.out.println(e.getMessage());
		}
		return bfile;
	}
    @SuppressWarnings("unchecked")
	public static Map<Integer, Faculty> faculty(){
    	Map<Integer, Faculty> bfile=null;
		File f=new File("Fact.ser");
		boolean flag=false;
		try {
			if(!f.exists()) {
				f.createNewFile();
				flag=true;
			}
			if(flag) {
				bfile=new HashMap<Integer,Faculty>();
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
				oos.writeObject(bfile);
				
				return bfile;
			}
			if(flag==false) {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
                bfile=(Map<Integer, Faculty>)ois.readObject();
           
                return bfile;
			}
		}catch(IOException | ClassNotFoundException e) {
			
			System.out.println(e.getMessage());
		}
		
		return bfile;
	}
	@SuppressWarnings("unchecked")
	public static Map<Integer, Batch> allotment() {
		
		Map<Integer,Batch> afile=null;
		File f=new File("alot.ser");
		boolean flag=false;
		try {
			if(!f.exists()) {
				f.createNewFile();
				flag=true;
			}
			if(flag) {
				afile=new HashMap<Integer,Batch>();
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
				oos.writeObject(afile);
			
				return afile;
			}
			if(flag==false){
				
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				
                afile=(Map<Integer,Batch>)ois.readObject();
              
           
                return afile;
			}
		}catch(IOException | ClassNotFoundException e) {
		
			System.out.println(e.getMessage());
		}
		
		return afile;
	}
	@SuppressWarnings("unchecked")
	public static List<Batch> batchId() {
		// TODO Auto-generated method stub
		List<Batch> a=null;
		File f=new File("bid.ser");
		boolean flag=false;
		try {
			if(!f.exists()) {
				f.createNewFile();
				flag=true;
			}
			if(flag) {
				a=new ArrayList<>();
				ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream(f));
			    oos.writeObject(a);
			  
			    return a;
			}
			else if (flag==false){
				ObjectInputStream ois=new ObjectInputStream(new FileInputStream(f));
				a=(List<Batch>)ois.readObject();
			
				return a;
			}
		}
		catch(IOException | ClassNotFoundException e) {
			System.out.println(4);
			System.out.println(e.getMessage());
		}
		return a;
	}
	@SuppressWarnings("unchecked")
	public static List<Faculty> FacultyId() {
		List<Faculty> a=new ArrayList<>();
		File f=new File("fid.ser");
		boolean flag=false;
		try {
			if(!f.exists()) {
				f.createNewFile();
				flag=true;
			}
			if(flag) {
				a=new ArrayList<>();
				ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream(f));
			    oos.writeObject(a);
				return a;
			}
			else if(flag==false){
				ObjectInputStream ois=new ObjectInputStream(new FileInputStream(f));
				a=(List<Faculty>)ois.readObject();
			
				return a;
			}
		}
		catch(IOException | ClassNotFoundException e) {
			
			System.out.println(e.getMessage());
		}
		return a;
	}
	public static Map<Integer, Integer> bf() {
		// TODO Auto-generated method stub
		Map<Integer,Integer> afile=null;
		File f=new File("alot.ser");
		boolean flag=false;
		try {
			if(!f.exists()) {
				f.createNewFile();
				flag=true;
			}
			if(flag) {
				afile=new HashMap<Integer,Integer>();
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
				oos.writeObject(afile);
			
				return afile;
			}
			if(flag==false){
				
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				
                afile=(Map<Integer,Integer>)ois.readObject();
              
           
                return afile;
			}
		}catch(IOException | ClassNotFoundException e) {
		
			System.out.println(e.getMessage());
		}
		
		return afile;
	}
	public static Map<Faculty, Batch> FB() {
		// TODO Auto-generated method stub
		Map<Faculty,Batch> afile=null;
		File f=new File("FB.ser");
		boolean flag=false;
		try {
			if(!f.exists()) {
				f.createNewFile();
				flag=true;
			}
			if(flag) {
				afile=new HashMap<Faculty,Batch>();
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
				oos.writeObject(afile);
			
				return afile;
			}
			if(flag==false){
				
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
				
                afile=(Map<Faculty,Batch>)ois.readObject();
                
           
                return afile;
			}
		}catch(IOException | ClassNotFoundException e) {
		
			System.out.println(e.getMessage());
		}
		
		return afile;
	}
}
