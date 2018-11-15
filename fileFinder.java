import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;


public class fileFinder extends JFrame{

        private JFrame frame;
        private JButton buttonAccessFile, buttonSearch;
        private JLabel labelEnterText, labelFileStatus, labelFileName, labelFileLength, labelFileSize, labelSearchFile, labelFoundWord, labelFoundWordCount;
        private JTextField textField1, textFieldSearch;


        private String fileName = "/home/noroff-experis-23/IdeaProjects/DailyTasks/src/file.txt";
        private Path path = Paths.get(fileName);
        private Long filebyte = Files.size(path);
        private ArrayList<String> wordList;
        private String [] splitted = null;

        private byte[] bytes = Files.readAllBytes(path);
        private List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);




        public fileFinder() throws IOException {
        this.wordList = new ArrayList<String>();

            this.frame = new JFrame("Access the File App");

            this.labelEnterText = new JLabel("Find file :");
            labelEnterText.setBounds(10, 10, 100, 100);

            this.textField1 = new JTextField();
            textField1.setBounds(110, 50, 130, 30);

            this.buttonAccessFile = new JButton("Search");
            buttonAccessFile.setBounds(100,100,140, 40);

            this.labelFileStatus = new JLabel();
            labelFileStatus.setBounds(20, 110, 200, 100);

            this.labelFileName = new JLabel();
            labelFileName.setBounds(20, 160, 200, 100);

            this.labelFileLength = new JLabel();
            labelFileLength.setBounds(20, 180, 200, 100);

            this.labelFileSize = new JLabel();
            labelFileSize.setBounds(20, 200, 200, 100);

            this.labelSearchFile = new JLabel("Search file :");
            labelSearchFile.setBounds(20, 240, 100, 100);

            this.textFieldSearch = new JTextField();
            textFieldSearch.setBounds(140, 275, 130, 30);

            this.buttonSearch = new JButton("Search");
            buttonSearch.setBounds(100, 320, 140, 40);

            this.labelFoundWord = new JLabel();
            labelFoundWord.setBounds(20, 400, 200,100);

            this.labelFoundWordCount = new JLabel();
            labelFoundWordCount.setBounds(20, 420, 400, 100);

            frame.add(textField1);
            frame.add(buttonAccessFile);
            frame.add(labelEnterText);
            frame.add(labelFileStatus);
            frame.add(labelFileName);
            frame.add(labelFileLength);
            frame.add(labelFileSize);
            frame.add(textFieldSearch);
            frame.add(labelSearchFile);
            frame.add(labelFoundWord);
            frame.add(labelFoundWordCount);
            frame.add(buttonSearch);

            labelSearchFile.setVisible(false);
            textFieldSearch.setVisible(false);
            buttonSearch.setVisible(false);

            frame.setSize(350,600);
            frame.setLayout(null);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }

        public void processFile(){
            buttonAccessFile.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    String stringTextField1 = textField1.getText();


                    for(String line : allLines){
                        splitted = line.split("\\s+");
                        for(int i = 0; i < splitted.length; i++){
                            wordList.add(splitted[i]);
                        }
                    }


                    if(stringTextField1.equals("file.txt")){
                        int lines = 0;
                        for(String line : allLines){
                            lines++;
                        }

                        textFieldSearch.setVisible(true);
                        labelSearchFile.setVisible(true);
                        buttonSearch.setVisible(true);

                        labelFileName.setText("File name: " + path.getFileName() + ".");
                        labelFileSize.setText("File size: " + filebyte + " bytes.");
                        labelFileLength.setText("Lines: " + lines + ".");


                        buttonSearch.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent actionEvent) {
                                int foundWordCount = 0;

                                for(String word : wordList){
                                        if(word.toLowerCase().equals(textFieldSearch.getText())){
                                            labelFoundWord.setText("The word exists!");
                                            foundWordCount++;
                                        }
                                        labelFoundWordCount.setText(foundWordCount + " instances of the word was found.");
                                }
                            }
                        });{
                        }

                    }else{
                        labelFileStatus.setText("File not found!");
                    }

                }
            });{

            }
        }

    public static void main (String[] args) throws IOException {

        fileFinder ex = new fileFinder();
        ex.setVisible(true);
        ex.processFile();
    }

}