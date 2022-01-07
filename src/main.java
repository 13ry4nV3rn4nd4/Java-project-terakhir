import java.util.ArrayList;
import java.util.Scanner;

public class main {
	
	Scanner scan = new Scanner(System.in);
	int count1 = 0, count2 = 0, count3 = 0;
	ArrayList<String> stringList = new ArrayList<>();
	ArrayList<String> stringList1 = new ArrayList<>();
	ArrayList<String> stringList2 = new ArrayList<>();
	ArrayList<String> stringList3 = new ArrayList<>();
	ArrayList<Integer> gaji = new ArrayList<>();
	ArrayList<String> copyList = new ArrayList<>();

	public main() {
		// TODO Auto-generated constructor stub
		int menu = 0;
		String nama, jenisKelamin, jabatan, id;
		
		do {
			System.out.print("Selamat datang di aplikasi penyimpan data karyawan PT Mentol!\n");
			System.out.print("Silahkan pilih menu yang tersedia:\n");
			System.out.print("1. Insert Data\n");
			System.out.print("2. View Data\n");
			System.out.print("3. Update Data\n");
			System.out.print("4. Delete Data\n");
			System.out.print("5. EXIT\n");
			System.out.print(">> ");
			
			try {
				menu = scan.nextInt();
				scan.nextLine();
			} catch (Exception e) {
				menu = 0;
				System.out.println("Input hanya boleh angka!");
				scan.nextLine();
				System.out.print("ENTER to return");
				scan.nextLine();
			}

			for (int j = 0; j < 30; j++) {
				System.out.println();
			}

			switch (menu) {
			case 1:
				boolean pass = false;
				do {
					System.out.print("Input nama karyawan [>=3]: ");
					nama = scan.nextLine();
					boolean tesT = stringList.isEmpty();
					
					if (tesT == false) {
						for (String str : stringList) {
							if (str.equalsIgnoreCase(nama)) {
								System.out.print("Sudah terdapat nama yang sama di database, mohon untuk menginput nama yang berbeda!\n");
								System.out.print("ENTER to return");
								scan.nextLine();
								pass = false;
								for (int j = 0; j < 30; j++) {
									System.out.println();
								}
								break;
							}else {
								pass = true;
							}
						}
					}else {
						pass = true;
					}
					
					if (nama.length() >= 3 && pass == true) {
						stringList.add(nama);
						copyList.add(nama);
					}
					
				} while (nama.length() < 3 || pass == false);

				do {
					System.out.print("Input jenis kelamin [Laki-Laki | Perempuan] (Case Sensitive): ");
					jenisKelamin = scan.nextLine();
					if (jenisKelamin.equals("Laki-Laki") || jenisKelamin.equals("Perempuan")) {
						stringList1.add(jenisKelamin);
					}
				} while (!(jenisKelamin.equals("Laki-Laki") || jenisKelamin.equals("Perempuan")));
				
				boolean uManager = false;
				boolean uSup = false;
				boolean uAdmin = false;

				do {
					System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
					jabatan = scan.nextLine();
					if (jabatan.equals("Manager") || jabatan.equals("Supervisor") || jabatan.equals("Admin")) {
						stringList2.add(jabatan);
					}

					if (jabatan.equals("Manager")) {
						count1++;
						uManager = true;
						gaji.add(8000000);
					} else if (jabatan.equals("Supervisor")) {
						count2++;
						uSup = true;
						gaji.add(6000000);
					} else if (jabatan.equals("Admin")) {
						count3++;
						uAdmin = true;
						gaji.add(4000000);
					}

				} while (!(jabatan.equals("Manager") || jabatan.equals("Supervisor") || jabatan.equals("Admin")));

				char huruf = (char) ('A' + Math.random() * ('Z' - 'A' + 1));
				char huruf1 = (char) ('A' + Math.random() * ('Z' - 'A' + 1));
				int random = (int) ((Math.random()*8999)+1000);
				id = new StringBuilder().append(huruf).append(huruf1)+"-"+random;
				int banding = 0;
				boolean tahu = stringList3.isEmpty();

				do {
					if (tahu == false) {
						for (String str : stringList3) {
							if (str.equals(id)) {
								String id1 = new StringBuilder().append(huruf).append(huruf1) + "-" + random;
								id = id1;
								banding = 0;
								break;
							} else {
								banding = 1;
							}
						}
					} else {
						banding = 1;
					}
				} while (banding == 0);

				System.out.print("Berhasil menambahkan karyawan dengan id " + id + "\n");
				stringList3.add(id);

				if ((count1 - 1) % 3 == 0 && uManager == true) {
					if (count1 - 1 != 0) {
						System.out.print("Bonus sebesar 10% telah diberikan kepada karyawan dengan id");
						loopz(stringList2, stringList3, count1, "Manager", gaji);
						System.out.println();
					}
				}

				if ((count2 - 1) % 3 == 0 && uSup == true) {
					if (count2 - 1 != 0) {
						System.out.print("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id");
						loopz(stringList2, stringList3, count2, "Supervisor", gaji);
						System.out.println();
					}
				}

				if ((count3 - 1) % 3 == 0 && uAdmin == true) {
					if (count3 - 1 != 0) {
						System.out.print("Bonus sebesar 5% telah diberikan kepada karyawan dengan id");
						loopz(stringList2, stringList3, count3, "Admin", gaji);
						System.out.println();
					}
				}

				System.out.print("ENTER to return");
				scan.nextLine();

				for (int j = 0; j < 30; j++) {
					System.out.println();
				}
				break;

			case 2:
				printOut();
				System.out.print("ENTER to return");
				scan.nextLine();

				for (int j = 0; j < 30; j++) {
					System.out.println();
				}
				break;

			case 3:
				int up = 0;
				int gaji1 = 0;
				String nama1, jenisKelamin1, jabatan1, id2;
				printOut();
				boolean status = stringList3.isEmpty();
				if(status == true) {
					System.out.print("ENTER to return");
					scan.nextLine();
					
					for (int j = 0; j < 30; j++) {
						System.out.println();
					}
					break;
				}
				
				do {
					System.out.print("Silahkan input angka dari list data yang ingin di update!\n");
					System.out.print(">> ");
					
					try {
						up = scan.nextInt();
						scan.nextLine();
					} catch (Exception e) {
						up = 0;
						System.out.println("Input hanya boleh angka!");
						scan.nextLine();
						System.out.print("ENTER to return");
						scan.nextLine();
						System.out.println();
					}
					
				} while (up>stringList.size()||up<=0);
				
				for (int j = 0; j < 30; j++) {
					System.out.println();
				}
				
				boolean passed = false;
				
				int banget = 1;
				String bentar = null;
				for(int e = 0; e<copyList.size(); e++) {
					if(banget == up) {
						bentar = copyList.get(e);
						break;
					}
					banget++;
				}
				
				do {
					System.out.print("Input nama karyawan [>=3]: ");
					nama1 = scan.nextLine();
					
					boolean tesT1 = stringList.isEmpty();
					
					if (tesT1 == false) {
						for (String str : stringList) {
							if (str.equalsIgnoreCase(nama1) && !(str.equalsIgnoreCase(bentar))) {
								System.out.print("Sudah terdapat nama yang sama di database, mohon untuk menginput nama yang berbeda!\n");
								System.out.print("ENTER to return");
								scan.nextLine();
								passed = false;
								for (int j = 0; j < 30; j++) {
									System.out.println();
								}
								break;
							}else {
								passed = true;
							}
						}
					}else {
						passed = true;
					}
					
				} while (nama1.length() < 3 || passed == false);
				
				do {
					System.out.print("Input jenis kelamin [Laki-Laki | Perempuan] (Case Sensitive): ");
					jenisKelamin1 = scan.nextLine();
				} while (!(jenisKelamin1.equals("Laki-Laki") || jenisKelamin1.equals("Perempuan")));

				do {
					System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
					jabatan1 = scan.nextLine();
					
					if (jabatan1.equals("Manager")) {
						gaji1 = 8000000;
					} else if (jabatan1.equals("Supervisor")) {
						gaji1 = 6000000;
					} else if (jabatan1.equals("Admin")) {
						gaji1 = 4000000;
					}
					
				} while (!(jabatan1.equals("Manager") || jabatan1.equals("Supervisor") || jabatan1.equals("Admin")));
				
				char huruf2 = (char) ('A' + Math.random() * ('Z' - 'A' + 1));
				char huruf3 = (char) ('A' + Math.random() * ('Z' - 'A' + 1));
				int random1 = (int) ((Math.random()*8999)+1000);
				id2 = new StringBuilder().append(huruf2).append(huruf3)+"-"+random1;
				
				int banding1 = 0;
				boolean tahu1 = stringList3.isEmpty();

				do {
					if (tahu1 == false) {
						for (String str : stringList3) {
							if (str.equals(id2)) {
								String id3 = new StringBuilder().append(huruf2).append(huruf3) + "-" + random1;
								id2 = id3;
								banding1 = 0;
								break;
							} else {
								banding1 = 1;
							}
						}
					} else {
						banding1 = 1;
					}
				} while (banding1 == 0);

				System.out.print("Berhasil mengupdate karyawan dengan id baru " + id2 + "\n");
				
				int number = 1;
				for(int q = 0; q<copyList.size(); q++) {
					for(int w = 0; w<stringList.size(); w++) {
						if(number == up) {
							if(copyList.get(q).equals(stringList.get(w))) {
								if(jabatan1.equals(stringList2.get(w))) {
									stringList.set(w, nama1);
									stringList1.set(w, jenisKelamin1);
									stringList3.set(w, id2);
									copyList.set(q, nama1);
								}else {
									stringList.remove(w);
									stringList1.remove(w);
									stringList2.remove(w);
									stringList3.remove(w);
									gaji.remove(w);
									copyList.remove(q);
									
									stringList.add(nama1);
									stringList1.add(jenisKelamin1);
									stringList2.add(jabatan1);
									stringList3.add(id2);
									gaji.add(gaji1);
									copyList.add(nama1);
									hitungUlang();
								}
								bSort(copyList);
								break;
							}
						}else {
							break;
						}
					}
					number++;
				}
				
				System.out.print("ENTER to return");
				scan.nextLine();

				for (int j = 0; j < 30; j++) {
					System.out.println();
				}
				
				break;

			case 4:
				printOut();
				int del = 0;
				
				boolean status1 = stringList3.isEmpty();
				if(status1 == true) {
					System.out.print("ENTER to return");
					scan.nextLine();
					
					for (int j = 0; j < 30; j++) {
						System.out.println();
					}
					break;
				}
				
				do {
					System.out.print("Silahkan input angka dari list data yang ingin di delete!\n");
					System.out.print(">> ");
					
					try {
						del = scan.nextInt();
						scan.nextLine();
					} catch (Exception e) {
						del = 0;
						System.out.println("Input hanya boleh angka!");
						scan.nextLine();
						System.out.print("ENTER to return");
						scan.nextLine();
						System.out.println();
					}
					
				} while (del>stringList.size()||del<=0);
				
				int number1 = 1;
				for(int q = 0; q<copyList.size(); q++) {
					for(int w = 0; w<stringList.size(); w++) {
						if(number1 == del) {
							if(copyList.get(q).equals(stringList.get(w))) {
								stringList.remove(w);
								stringList1.remove(w);
								stringList2.remove(w);
								stringList3.remove(w);
								gaji.remove(w);
								copyList.remove(q);
								hitungUlang();
								bSort(copyList);
								break;
							}
						}else {
							break;
						}
					}
					number1++;
				}
				
				System.out.print("Data karyawan telah berhasil di delete!\n");
				
				System.out.print("ENTER to return");
				scan.nextLine();

				for (int j = 0; j < 30; j++) {
					System.out.println();
				}
				
				break;
			}
		} while (menu != 5);
		
		System.out.print("Data karyawan PT Mentol sudah tersimpan, terima kasih!");
	}
	
	void loopz(ArrayList<String> arr, ArrayList<String> arr1, int counting, String kata, ArrayList<Integer> arr2) {
		int temp = counting-1;
		int tampung = 0;
		for(int i = 0; i<arr.size(); i++) {
			if(arr.get(i).equals(kata)) {
				tampung++;
				System.out.print(" " + arr1.get(i));
				if(kata.equals("Manager")) {
					arr2.set(i, arr2.get(i)+(arr2.get(i)/10));
				}else if(kata.equals("Supervisor")) {
					arr2.set(i, arr2.get(i)+((arr2.get(i)*3)/40));
				}else if(kata.equals("Admin")) {
					arr2.set(i, arr2.get(i)+(arr2.get(i)/20));
				}
				if(tampung == temp) {
					break;
				}
			}
		}
	}
	
	void loopzHitung(ArrayList<String> arr, int counting, String kata, ArrayList<Integer> arr2) {
		int temp = counting-1;
		int tampung = 0;
		for(int i = 0; i<arr.size(); i++) {
			if(arr.get(i).equals(kata)) {
				tampung++;
				if(kata.equals("Manager")) {
					arr2.set(i, arr2.get(i)+(arr2.get(i)/10));
				}else if(kata.equals("Supervisor")) {
					arr2.set(i, arr2.get(i)+((arr2.get(i)*3)/40));
				}else if(kata.equals("Admin")) {
					arr2.set(i, arr2.get(i)+(arr2.get(i)/20));
				}
				if(tampung == temp) {
					break;
				}
			}
		}
	}
	
	void bSort(ArrayList<String> arr) {
		String temp = "";
		for(int i = 0; i<arr.size(); i++) {
			for(int j = 1; j<arr.size()-i; j++) {
				if(arr.get(j-1).compareTo(arr.get(j))>0) {
					temp = arr.get(j-1);
					arr.set(j-1, arr.get(j));
					arr.set(j, temp);
				}
			}
		}
	}
	
	void printOut() {
		boolean cek = stringList3.isEmpty();
		
		if(cek == true) {
			System.out.print("Tidak ada data karyawan disini, mohon untuk menginput data karyawan terlebih dahulu!\n");
			return;
		}
			
		System.out.print("|----|-----------------|------------------------------|---------------|--------------|-------------|\n");
		System.out.print("|No  |Kode Karyawan    |Nama Karyawan                 |Jenis Kelamin  |Jabatan       |Gaji Karyawan|\n");
		System.out.print("|----|-----------------|------------------------------|---------------|--------------|-------------|\n");
		bSort(copyList);
		int num = 1;
		for (int p = 0; p < copyList.size(); p++) {
			for (int u = 0; u < stringList.size(); u++) {
				if (copyList.get(p).equals(stringList.get(u))) {
					System.out.printf("|%4d|%17s|%30s|%15s|%14s|%13s|\n", num, stringList3.get(u), stringList.get(u), stringList1.get(u), stringList2.get(u), gaji.get(u));
					break;
				}
			}
			num++;
		}
		System.out.print("|----|-----------------|------------------------------|---------------|--------------|-------------|\n");
	}
	
	void hitungUlang() {
		int baru1 = 0, baru2 = 0, baru3 = 0;
		for(int k = 0; k<stringList2.size(); k++) {
			if(stringList2.get(k).equals("Manager")) {
				gaji.set(k, 8000000);
			}else if(stringList2.get(k).equals("Supervisor")) {
				gaji.set(k, 6000000);
			}else if(stringList2.get(k).equals("Admin")) {
				gaji.set(k, 4000000);
			}
		}
		
		for(int k = 0; k<stringList2.size(); k++) {
			if(stringList2.get(k).equals("Manager")) {
				baru1++;
				if ((baru1 - 1) % 3 == 0) {
					if (baru1 - 1 != 0) {
						loopzHitung(stringList2, baru1, "Manager", gaji);
					}
				}
			}else if(stringList2.get(k).equals("Supervisor")) {
				baru2++;
				if ((baru2 - 1) % 3 == 0) {
					if (baru2 - 1 != 0) {
						loopzHitung(stringList2, baru2, "Supervisor", gaji);
					}
				}
			}else if(stringList2.get(k).equals("Admin")) {
				baru3++;
				if ((baru3 - 1) % 3 == 0) {
					if (baru3 - 1 != 0) {
						loopzHitung(stringList2, baru3, "Admin", gaji);
					}
				}
			}
		}
		count1 = baru1;
		count2 = baru2;
		count3 = baru3;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new main();
	}

}
