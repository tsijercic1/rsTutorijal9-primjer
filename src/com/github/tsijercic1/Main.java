package com.github.tsijercic1;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayList<User> users = readFile("Korisnici.txt");
        System.out.println(users);
        users = readXmlFile("users.xml");
        System.out.println(users);
    }

    public static ArrayList<User> readXmlFile(String filename){
        ArrayList<User> users = new ArrayList<>();
        try {
            XMLParser xmlParser = new XMLParser(filename);
            Node root = xmlParser.getDocumentRootNode();
            ArrayList<Node> userNodes = root.getChildNodes("user");
            for (Node userNode : userNodes) {
                String name = userNode.getAttributes().get("name");
                String phoneNumber = userNode.getAttributes().get("phoneNumber");
                Node birthdayNode = userNode.getChildNode("birthday");
                LocalDate birthday = LocalDate.parse(
                        birthdayNode.getContent(),
                        DateTimeFormatter.ofPattern(birthdayNode.getAttributes().get("format"))
                );
                users.add(new User(name, birthday, phoneNumber));
            }
        } catch (IOException | InvalidXMLException e) {

        }
        return users;
    }

    public static ArrayList<User> readFile(String filename) {
        ArrayList<User> users = new ArrayList<>();
        File file = new File(filename);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bufferedReader.readLine())!=null) {
                // Name, birthday, phoneNUmber
                String[] data = line.split(",");
                if (data.length == 3) {
                    String name = data[0];
                    String date = data[1];
                    date = date.trim();
                    LocalDate birthday = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                    String phoneNumber = data[2];
                    users.add(new User(name, birthday, phoneNumber));
                } else {
                    throw new IllegalArgumentException("File format not ok!");
                }
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
        return users;
    }
}
