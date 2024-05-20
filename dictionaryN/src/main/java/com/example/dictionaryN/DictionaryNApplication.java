package com.example.dictionaryN;

import com.example.dictionaryN.Controller.DicController;
import com.example.dictionaryN.Entity.DictionaryEntity;
import com.example.dictionaryN.Repo.DicRepo;
import com.example.dictionaryN.Service.DicService;
import com.example.dictionaryN.ServiceImp.DicServiceImp;
import com.example.newVersion.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@SpringBootApplication
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)


public class DictionaryNApplication extends JFrame {


	@Autowired
	DicService dicService;

	private JPanel contentPane;
	private JTextField searchWord;
	static List<DictionaryEntity> wordList = new ArrayList<DictionaryEntity>();
	List<String> historySearch = new ArrayList<>();
	static String url ="D:/OOP_Folder/dictionaryN/src/main/java/com/example/dictionaryN/hello.txt";
	private static JTable tableSearch = new JTable();

	public DictionaryNApplication() {
		wordList = dicService.getAll();
		historySearch = History.history(url);
		String [][] listHistory = new String[historySearch.size()][1];
		int count = 0;
		for(int i = historySearch.size()-1; i >=0; i--) {
			listHistory[count][0] = historySearch.get(i);
			count++;
		}
		getContentPane().setFont(new Font("Segoe UI Variable", Font.PLAIN, 22));
		getContentPane().setBackground(new Color(166, 255, 210));
		setTitle("Dictionary");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(850,600);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(41, 43, 276, 498);
		getContentPane().add(panel);
		panel.setLayout(null);
		panel.setBorder(null);

		searchWord = new JTextField();
		searchWord.setBounds(0, 0, 276, 51);
		panel.add(searchWord);
		searchWord.setColumns(10);

		JScrollPane scrollSearch = new JScrollPane();
		scrollSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scrollSearch.setBounds(0, 91, 276, 408);
		panel.add(scrollSearch);

		String [] col = {"History"};
		tableSearch = new JTable(listHistory,col);
		tableSearch.setRowHeight(25);
		tableSearch.setFont(new Font("Segoe UI Variable", Font.PLAIN, 16));
		scrollSearch.setViewportView(tableSearch);



		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBorder(null);
		panel_1.setBounds(335, 43, 467, 499);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JButton transBtn = new JButton("Add");


		transBtn.setFont(new Font("Segoe UI Variable", Font.BOLD, 16));
		transBtn.setBounds(0, 0, 114, 51);
		panel_1.add(transBtn);

		JButton voiceBtn = new JButton("Voice");
		voiceBtn.setFont(new Font("Segoe UI Variable", Font.BOLD, 16));
		voiceBtn.setBounds(148, 0, 114, 51);
		panel_1.add(voiceBtn);

		JTextArea meaningWord = new JTextArea();
		meaningWord.setBorder(new LineBorder(new Color(192, 192, 192)));
		meaningWord.setFont(new Font("Segoe UI Variable", Font.PLAIN, 18));
		meaningWord.setBounds(0, 91, 467, 408);
		meaningWord.setLineWrap(true);
		meaningWord.setWrapStyleWord(true);
		panel_1.add(meaningWord);

		JButton ggBtn = new JButton("Google translate");
		ggBtn.setFont(new Font("Segoe UI Variable", Font.BOLD, 16));
		ggBtn.setBounds(282, 0, 185, 51);
		panel_1.add(ggBtn);


		transBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!searchWord.getText().equalsIgnoreCase("")){
					historySearch.add(searchWord.getText());
					BufferedWriter bf = null;
					try {
						bf = new BufferedWriter(new FileWriter(new File(url)));
						for(String s: historySearch){
							bf.write(s);
							bf.newLine();
						}
						String[] data = new String[1];
						data[0] = searchWord.getText();
						searchWord.setText("");
						bf.close();
						historySearch = History.history(url);
						String [][] temp = new String[historySearch.size()][1];
						int count = 0;
						for(int i = historySearch.size()-1; i >= 0; i--) {
							temp[count][0] = historySearch.get(i);
							count++;
						}
						DefaultTableModel defaultTableModel = new DefaultTableModel(temp,col);
						tableSearch.setModel(defaultTableModel);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {}
			}
		});
		tableSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				int row = tableSearch.rowAtPoint(evt.getPoint());
				if (row >= 0) {
					String s = (String) tableSearch.getValueAt(row,0);
					searchWord.setText(s);
				}
			}
		});



		searchWord.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

			}
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					if(!searchWord.getText().equalsIgnoreCase("")){
						historySearch.add(searchWord.getText());
						BufferedWriter bf = null;
						try {
							bf = new BufferedWriter(new FileWriter(new File(url)));
							for(String s: historySearch){
								bf.write(s);
								bf.newLine();
							}
							String[] data = new String[1];
							data[0] = searchWord.getText();
							searchWord.setText("");
							bf.close();
							historySearch = History.history(url);
							String [][] temp = new String[historySearch.size()][1];
							int count = 0;
							for(int i = historySearch.size()-1; i >= 0; i--) {
								temp[count][0] = historySearch.get(i);
								count++;
							}
							DefaultTableModel defaultTableModel = new DefaultTableModel(temp,col);
							tableSearch.setModel(defaultTableModel);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else {}

				}
			}
		});

	}






	public static void main(String[] args) {

//		SpringApplication.run(DictionaryNApplication.class, args);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpringApplication.run(DictionaryNApplication.class, args);

//					DictionaryNApplication frame = new DictionaryNApplication();
//					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}


}
