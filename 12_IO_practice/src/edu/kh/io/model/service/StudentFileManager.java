package edu.kh.io.model.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StudentFileManager {

	private FileWriter fw = null;
	private BufferedWriter bw = null;

	private FileReader fr = null;
	private BufferedReader br = null;

	private FileInputStream fis = null;
	private FileOutputStream fos = null;

	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;

	public StudentFileManager() {

	}

	public void writeFile() {

		try {

			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("==== 학생 정보 입력 ====");

			while (true) {

				System.out.print("이름 입력 : ");
				String name = br.readLine();

				System.out.print("나이 입력 : ");
				String age = br.readLine();

				System.out.print("전공 입력 : ");
				String major = br.readLine();
				
				System.out.print("추가 입력? (y/n): ");
				String answer = br.readLine();
				
				if(answer.toUpperCase().equals("N")) return;
					
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();
				if (bw != null)
					bw.close();

			} catch (Exception e) {

				e.printStackTrace();

			}

		}

	}

}
