package newpackage;

import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;

public class GPD_H8_NO extends javax.swing.JFrame {

    String islem = "";

    public GPD_H8_NO() {
        initComponents();
        
        setTitle("231213000");
        
        int col=0,row=0;
        String[] dizi; 
        String hesapMakinesi = null;
        try {
            BufferedReader in = new BufferedReader(new FileReader("hesap_makinesi.txt"));

            row = Integer.parseInt(in.readLine());
            col = Integer.parseInt(in.readLine());
            hesapMakinesi = in.readLine();
            
            in.close();
        } catch (IOException e) {
            System.out.println("Dosya okuma hatası!!!");
        }
        
        this.setLayout(new GridLayout(row,col,3,3));
        setSize(400,170);
        
        dizi = hesapMakinesi.split(",");
        
        for (String dizi1 : dizi) {
            JButton myButton = new JButton(dizi1);
            add(myButton);

            // Butonlara tıklama özelliği ekleniyor
            myButton.addActionListener(e -> {
                String btnText = myButton.getText();
                
                if (btnText.equals("=")) {
                    hesapla(); // '=' tıklanırsa işlem konsolda hesaplanır
                } else {
                    islem += btnText; // butonun içeriğini işleme ekle
                    System.out.println("Girilen: " + btnText);
                }
            });
        }
        
    }

    // Konsolda işlem yapan temel hesaplama fonksiyonu
    private void hesapla() {
       
            String operator = "";
            int sonuc = 0;

            if (islem.contains("*")) {
                operator = "\\*";
            } else if (islem.contains("/")) {
                operator = "\\/";
            } 

            String[] sayilar = islem.split(operator);
            int sayi1 = Integer.parseInt(sayilar[0]);
            int sayi2 = Integer.parseInt(sayilar[1]);

            if (operator.equals("\\*")) {
                sonuc = sayi1 * sayi2;
            } else if (operator.equals("\\/")) {
                sonuc = sayi1 / sayi2;
            } 

            System.out.println("Sonuç: " + sonuc);
            islem = "";  // İşlemi sıfırla

    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new GPD_H8_NO().setVisible(true);
        });
    }
}
