

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class JsonRedactor extends JFrame {
    private JPanel mainPanel;
    private JButton openButton;
    private JButton saveButton;
    private JEditorPane jsonPole;
    private JButton addButton;

    public JsonRedactor(){
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setVisible(true);
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String soderjimoe =new String (Files.readAllBytes(Paths.get("fruit.json")));
                    jsonPole.setText(soderjimoe);
                } catch (IOException e1) {
                    System.out.println("Произошла ошибка при открытии");
                }
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String izpolia = jsonPole.getText();
                    Writer writer = new FileWriter("fruit.json", false);
                    writer.write(izpolia);
                    writer.flush();
                } catch (IOException e1) {
                    System.out.println("Произошла ошибка при сохранении");
                }
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JSONObject jo = new JSONObject();
                jo.put("fruit", "pineaple");
                jo.put("size", "Medium");
                jo.put("colour", "non");
                jo.put("weight", 900);
                jsonPole.setText(jo.toJSONString());
                JSONArray ja = new JSONArray();
                jo = new JSONObject();
                jo.put("fruit", "Melon");
                jo.put("size", "Large");
                jo.put("colour", "Yellow");
                jo.put("weight", 2300);
                ja.add(jo);
                jo = new JSONObject();
                jo.put("fruits",ja);
            }
         });
        }
    }



