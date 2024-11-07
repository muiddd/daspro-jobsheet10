import java.util.Scanner;

public class BioskopWithScanner01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int baris,kolom;
        String nama,next;

        String[][] penonton = new String[4][2];

        while (true){
            System.out.println("===== SELAMAT DATANG DI BIOSKOP =====");
            System.out.println("1. Masukkan data penonton");
            System.out.println("2. Daftar penonton");
            System.out.println("3. Keluar");
            System.out.print("Silahkan masukkan pilihan (1-3): ");
            int pilihan = sc.nextInt();
            sc.nextLine();
        
            switch (pilihan) {
                case 1:
                    while(true){
                        System.out.print("Masukkan nama: ");
                        nama = sc.nextLine();
                        System.out.print("Masukkan baris (1-4): ");
                        baris = sc.nextInt();
                        System.out.print("Masukkan kolom (1-2): ");
                        kolom = sc.nextInt();
                        sc.nextLine();

                        if(baris > penonton.length || kolom > penonton[0].length || baris <= 0 || kolom <= 0){
                            System.out.println("Baris/kolom tidak yang anda pilih tidak tersedia. Silahkan input ulang dengan format yang tersedia");
                            break;
                        }
                        if(penonton[(baris-1)][(kolom-1)]!= null){
                            System.out.println("Kursi sudah terisi. Silahkan input ulang ");
                            break;
                        }

                        penonton[baris-1][kolom-1] = nama;

                        System.out.print("Input penonton lainnya? (y/n): ");
                        next = sc.nextLine();

                        if (next.equalsIgnoreCase("n")) {
                            break;
                        }
                    }
                break;
                case 2:
                    System.out.println("Daftar Penonton: ");
                    for (int i = 0; i < penonton.length; i++) {
                        System.out.print("Penonton pada baris ke-" + (i + 1) + ": " + String.join(", ", penonton[i]) + "\n");
                    }
                    for (String[] barisPenonton : penonton) {
                        for (int j = 0; j < barisPenonton.length; j++) {
                            if (barisPenonton[j] == null) {
                                barisPenonton[j] = "***";
                            }
                        }
                    }
                break;
                case 3:
                    System.out.println("Terima kasih sudah mengunjungi bioskop");
                return;
                default:
            }
        }
    }
}