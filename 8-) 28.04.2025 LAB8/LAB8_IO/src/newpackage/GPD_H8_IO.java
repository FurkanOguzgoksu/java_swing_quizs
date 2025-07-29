package newpackage;

import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;

public class GPD_H8_IO extends javax.swing.JFrame {

    String hafizaHarf = ""; 
    String hafizaSayi = "";

    // Sabit diziler oluşturuldu
    String[] sayi_dizisi = {"0","1","2","3","4","5","6","7","8","9"};
    String[] harf_dizisi = {
        "Q","W","E","R","T","Y","U","I","O","P",
        "A","S","D","F","G","H","J","K","L",
        "Z","X","C","V","B","N","M",
        "q","w","e","r","t","y","u","i","o","p",
        "a","s","d","f","g","h","j","k","l",
        "z","x","c","v","b","n","m"
    };

    public GPD_H8_IO() {
        initComponents();
        setTitle("231220000");

        String klavye = "";
        try {
            BufferedReader in = new BufferedReader(new FileReader("klavye.txt"));
            klavye = in.readLine();
            in.close();
        } catch (IOException e) {
            System.out.println("Dosya okuma hatası!!!");
        }

        FlowLayout myLayout = new FlowLayout();
        myLayout.setAlignment(FlowLayout.CENTER);
        setSize(900,200);
        setLayout(myLayout);

        String[] dizi = klavye.split(",");

        for (int i = 0; i < dizi.length; i++) {
            JButton myButton = new JButton(dizi[i]);
            add(myButton);

            myButton.addActionListener(e -> {
                String btnText = myButton.getText();

                if (btnText.equals("ctrl")) { 
                    if (!hafizaHarf.isEmpty()) {
                        System.out.println("Harfler: " + hafizaHarf);
                        hafizaHarf = "";  
                    }
                }
                else if (btnText.equals("tab")) { 
                    if (!hafizaSayi.isEmpty()) {
                        System.out.println("Sayilar: " + hafizaSayi);
                        hafizaSayi = "";  
                    }
                }
                else if (diziIceriyorMu(sayi_dizisi, btnText)) {
                    hafizaSayi += btnText;  
                }
                else if (diziIceriyorMu(harf_dizisi, btnText)) {
                    hafizaHarf += btnText;  
                }
            });
        }       
    }

    // Dizide eleman var mı kontrol eden basit metod
    private boolean diziIceriyorMu(String[] dizi, String aranan) {
        for (int i = 0; i < dizi.length; i++) {
            if (dizi[i].equals(aranan)) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new GPD_H8_IO().setVisible(true);
        });
    }
}
