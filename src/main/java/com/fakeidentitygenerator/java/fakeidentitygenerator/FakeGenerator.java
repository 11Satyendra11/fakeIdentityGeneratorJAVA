package com.fakeidentitygenerator.java.fakeidentitygenerator;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeListener;
import org.apache.commons.io.FileUtils;
import javax.swing.event.ChangeEvent;
import java.awt.Font;

public class FakeGenerator  {

  private JFrame frame;
  static JTextField textField;
  static JComboBox comboBox = null;
  /**
   * Launch the application.
   */
  
   static String HowManyUsers = null;
   static String is_Datatype = null;
   static String serviceValue = null;
  //String is_JSON = null;
  String json = null;
  JTextPane textPane_12 = null;
  
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          FakeGenerator window = new FakeGenerator();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public FakeGenerator() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   * @throws IOException 
   */
  private void initialize()  {
    frame = new JFrame();
    frame.getContentPane().setForeground(Color.WHITE);
    frame.setBounds(100, 100, 919, 737);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    
    JPanel panel = new JPanel();
    panel.setBackground(Color.BLUE);
    panel.setForeground(Color.WHITE);
    panel.setBounds(12, 0, 896, 677);
    frame.getContentPane().add(panel);
    panel.setLayout(null);
    
    JPanel panel_1 = new JPanel();
    panel_1.setBackground(Color.GREEN);
    panel_1.setBounds(49, 23, 292, 76);
    panel.add(panel_1);
    panel_1.setLayout(null);
    
    JPanel panel_2 = new JPanel();
    panel_2.setBounds(49, 111, 384, 348);
    panel.add(panel_2);
    panel_2.setLayout(null);
    
    
    //how many users 
    JLabel lblNewLabel = new JLabel("How Many users data do you want?");
    lblNewLabel.setBounds(54, 12, 193, 24);
    panel_2.add(lblNewLabel);
    
    //how many users text field
    textField = new JTextField();
    
        textField.setText("1");
       
    
    
    textField.setForeground(Color.WHITE);
    textField.setBackground(Color.BLACK);
  
    textField.setBounds(227, 31, 114, 21);
    textField.setColumns(10);
    panel_2.add(textField);
    
    
    
    
    
    
    
   
    
    
    
    
    //what is the data format
    JLabel lblNewLabel_1 = new JLabel("What is the format of the Data do you want?");
    lblNewLabel_1.setBounds(43, 68, 298, 24);
    panel_2.add(lblNewLabel_1);
    
    //what is the dataformat combobox
    String FormatsUsed[]={"xml","json"};  
    comboBox = new JComboBox(FormatsUsed);
    comboBox.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        is_Datatype = comboBox.getSelectedItem().toString() ; 
        System.out.println("is_Datatype" + is_Datatype);
        }
    });
    comboBox.setBounds(123, 104, 91, 26);
    panel_2.add(comboBox);
    
    
   
    
    
    
    JButton btnNewButton = new JButton("FETCH");
    
    btnNewButton.setBounds(142, 281, 105, 27);
    panel_2.add(btnNewButton);
    
    String CategoryUsed[]={"users","addresses","banks","appliances","beers","blood_types","credit_cards"}; 
    JComboBox comboBox_1 = new JComboBox(CategoryUsed);
    comboBox_1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        serviceValue = comboBox_1.getSelectedItem().toString() ; 
        System.out.println("serviceValue" + serviceValue);
        }
    });
    
    comboBox_1.setBounds(96, 28, 91, 24);
    panel_2.add(comboBox_1);
    
    JLabel lblNewLabel_2 = new JLabel("");
    lblNewLabel_2.setIcon(new ImageIcon("/home/satyendra/Documents/eclipse EE workspace/fakeIdentitygenerator/fakeidentitygenerator/resources/loading.gif"));
    lblNewLabel_2.setBounds(32, 126, 324, 114);
    panel_2.add(lblNewLabel_2);
    
    
    
    
    JPanel panel_3 = new JPanel();
    panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
    panel_3.setBounds(445, 65, 430, 534);
    panel.add(panel_3);
    panel_3.setLayout(null);
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(12, 45, 320, 383);
    panel_3.add(scrollPane);
    
    JTextPane textPane = new JTextPane();
    textPane.setFont(new Font("JetBrains Mono", Font.PLAIN, 13));
    textPane.setForeground(Color.GREEN);
    textPane.setText("You Will get the result here!!");
    scrollPane.setViewportView(textPane);
    textPane.setBackground(Color.BLACK);
    
    JButton btnNewButton_1 = new JButton("COPY");
    btnNewButton_1.setBounds(168, 455, 105, 27);
    panel_3.add(btnNewButton_1);
   

    
    if(comboBox.getSelectedItem() == "xml" && comboBox.getSelectedItem() != null) {
      is_Datatype = "xml";
      
    }else if (comboBox.getSelectedItem() == "json" && comboBox.getSelectedItem() != null) {
      is_Datatype = "json";
    }
    else {
      Exception e;
     
    }
    
    
    //users","addresses","banks","appliances","beers","blood_types","credit_cards"
    
    if(comboBox_1.getSelectedItem() == "users" && comboBox_1.getSelectedItem() != null) {
     serviceValue = "users";
      
    }else if (comboBox.getSelectedItem() == "addresses" && comboBox_1.getSelectedItem() != null) {
      serviceValue = "addresses";
    }else if (comboBox.getSelectedItem() == "banks" && comboBox_1.getSelectedItem() != null) {
      serviceValue = "banks";
    }else if (comboBox.getSelectedItem() == "appliances" && comboBox_1.getSelectedItem() != null) {
      serviceValue = "appliances";
    }else if (comboBox.getSelectedItem() == "beers" && comboBox_1.getSelectedItem() != null) {
      serviceValue = "beers";
    }else if (comboBox.getSelectedItem() == "blood_types" && comboBox_1.getSelectedItem() != null) {
      serviceValue = "blood_types";
    }else if (comboBox.getSelectedItem() == "credit_cards" && comboBox_1.getSelectedItem() != null) {
      serviceValue = "credit_cards";
    }
    else {
      Exception e;
     
    }
    
    
    
    btnNewButton.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e){  
                
       try {
         System.out.println(textField.getText());
         HowManyUsers =  textField.getText();
         System.out.println("HowManyUsers" + HowManyUsers);
         textPane.setText(JSONResult1());
         
         
         
         
         
         
         
         
      } catch (IOException | InterruptedException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
       
     

        
       
 }} );  
  
    
    
    btnNewButton_1.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e){  
                
        String str =textPane.getText();
        System.out.println("The str is " + str);
        Clipboard clip = Toolkit.getDefaultToolkit()
                             .getSystemClipboard();
        StringSelection strse1 = new StringSelection(str);
        clip.setContents(strse1, strse1);
        JOptionPane.showMessageDialog(frame,"IP COPIED!");
      

        
       
 }} );  
    
    
  
  }
  
  
  
  public String JSONResult1() throws IOException, InterruptedException{    

    System.out.println(is_Datatype);
if(is_Datatype.equalsIgnoreCase("json"))
{
  URL url = new URL("https://random-data-api.com/api/v2/"+serviceValue+"?size="+HowManyUsers+"&response_type=" + is_Datatype);
  
  HttpClient httpclient = HttpClient.newHttpClient();
  

  HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url.toString())).build();
  System.out.println("json uri" + url.toString());
  HttpResponse<String> response = httpclient.send(httpRequest,
      HttpResponse.BodyHandlers.ofString()); 
  System.out.println(response.body());
  String city = response.body();

  System.out.println("This is in the city string " + city);
  ObjectMapper objectMapper = new ObjectMapper();
   //json = objectMapper.writeValueAsString(city);
  //System.out.println("This is json " + json);
  
  Object jsonObject = objectMapper.readValue(city, Object.class);
  String prettyJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
System.out.println("This is json " + prettyJson);
  
  return prettyJson;
}else if (is_Datatype.equalsIgnoreCase("xml")) {
  

  URL url = new URL("https://random-data-api.com/api/v2/"+serviceValue+"?size="+HowManyUsers+"&response_type=" + is_Datatype);
  HttpClient httpclient = HttpClient.newHttpClient();
  

  HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url.toString())).build();
  System.out.println("xml url: " + url.toString());
  HttpResponse<String> response = httpclient.send(httpRequest,
      HttpResponse.BodyHandlers.ofString()); 
  System.out.println(response.body());
  String city = response.body();

  System.out.println("This is in the city string " + city);
  //ObjectMapper objectMapper = new ObjectMapper();
   //json = objectMapper.writeValueAsString(city);
  //System.out.println("This is json " + json);
  
  //Object jsonObject = objectMapper.readValue(city, Object.class);
  //String prettyJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
System.out.println("This is XML " + city);
  
  return city;
  
  
}else {
  return "no value";
}




   
    
  }




}


  

 

