//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.Box;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Notepad extends JFrame implements ActionListener {
    JTextArea area;
    JScrollPane scrollPane;
    String text;
    public String currentFont = "";

    Notepad() {
        this.setBounds(0, 0, 1000, 555);
        this.area = new JTextArea();
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem newDoc = new JMenuItem("New");
        newDoc.setAccelerator(KeyStroke.getKeyStroke(78, InputEvent.CTRL_DOWN_MASK));
        newDoc.addActionListener(this);
        JMenuItem open = new JMenuItem("Open");
        open.setAccelerator(KeyStroke.getKeyStroke(79, InputEvent.CTRL_DOWN_MASK));
        open.addActionListener(this);
        JMenuItem save = new JMenuItem("Save");
        save.setAccelerator(KeyStroke.getKeyStroke(83, InputEvent.CTRL_DOWN_MASK));
        save.addActionListener(this);
        JMenuItem print = new JMenuItem("Print");
        print.setAccelerator(KeyStroke.getKeyStroke(80, InputEvent.CTRL_DOWN_MASK));
        print.addActionListener(this);
        JMenuItem exit = new JMenuItem("Exit");
        exit.setAccelerator(KeyStroke.getKeyStroke(27, 0));
        exit.addActionListener(this);
        file.add(newDoc);
        file.add(open);
        file.add(save);
        file.add(print);
        file.add(exit);
        JMenu edit = new JMenu("Edit");
        JMenuItem copy = new JMenuItem("Copy");
        copy.setAccelerator(KeyStroke.getKeyStroke(67, InputEvent.CTRL_DOWN_MASK));
        copy.addActionListener(this);
        JMenuItem paste = new JMenuItem("Paste");
        paste.setAccelerator(KeyStroke.getKeyStroke(86, InputEvent.CTRL_DOWN_MASK));
        paste.addActionListener(this);
        JMenuItem cut = new JMenuItem("Cut");
        cut.setAccelerator(KeyStroke.getKeyStroke(88, InputEvent.CTRL_DOWN_MASK));
        cut.addActionListener(this);
        JMenuItem selectAll = new JMenuItem("SelectAll");
        selectAll.setAccelerator(KeyStroke.getKeyStroke(65, InputEvent.CTRL_DOWN_MASK));
        selectAll.addActionListener(this);
        edit.add(copy);
        edit.add(paste);
        edit.add(cut);
        edit.add(selectAll);
        JMenu font = new JMenu("Font style");
        JMenuItem bold = new JMenuItem("Bold");
        bold.addActionListener(this);
        JMenuItem italic = new JMenuItem("Italic");
        italic.addActionListener(this);
        JMenuItem plain = new JMenuItem("Plain");
        plain.addActionListener(this);
        JMenuItem bold1 = new JMenuItem("Bold+Italic");
        bold1.addActionListener(this);
        font.add(plain);
        font.add(bold);
        font.add(italic);
        font.add(bold1);
        JMenu color = new JMenu("Color");
        JMenuItem colour = new JMenuItem("Choose color");
        color.add(colour);
        colour.addActionListener(this);
        JMenu theme = new JMenu("Theme");
        JMenuItem dark = new JMenuItem("Dark");
        dark.addActionListener(this);
        JMenuItem light = new JMenuItem("Light");
        light.addActionListener(this);
        JMenuItem cyan = new JMenuItem("Cyan");
        cyan.addActionListener(this);
        JMenuItem blue = new JMenuItem("Blue");
        blue.addActionListener(this);
        JMenuItem green = new JMenuItem("Green");
        green.addActionListener(this);
        theme.add(dark);
        theme.add(light);
        theme.add(cyan);
        theme.add(blue);
        theme.add(green);
        JMenu size = new JMenu("size");
        JMenuItem size_14 = new JMenuItem("14");
        size_14.addActionListener(this);
        JMenuItem size_16 = new JMenuItem("16");
        size_16.addActionListener(this);
        JMenuItem size_20 = new JMenuItem("20");
        size_20.addActionListener(this);
        JMenuItem size_24 = new JMenuItem("24");
        size_24.addActionListener(this);
        JMenuItem size_28 = new JMenuItem("28");
        size_28.addActionListener(this);
        JMenuItem size_32 = new JMenuItem("32");
        size_32.addActionListener(this);
        JMenuItem size_36 = new JMenuItem("36");
        size_36.addActionListener(this);
        size.add(size_14);
        size.add(size_16);
        size.add(size_20);
        size.add(size_24);
        size.add(size_28);
        size.add(size_32);
        size.add(size_36);
        Box theBox = Box.createHorizontalBox();
        String[] fontTypes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        JComboBox<String> fontList = new JComboBox<>(fontTypes);
        theBox.add(fontList);
        JMenu help = new JMenu("Help");
        JMenuItem about = new JMenuItem("About Notepad");
        about.addActionListener(this);
        help.add(about);
        this.setJMenuBar(menuBar);
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(size);
        menuBar.add(color);
        menuBar.add(font);
        menuBar.add(theme);
        menuBar.add(theBox);
        menuBar.add(help);
        this.area.setFont(new Font("TIMES_NEW_ROMAN", Font.PLAIN, 20));
        this.area.setLineWrap(true);
        this.area.setWrapStyleWord(true);
        this.add(this.area);
        this.scrollPane = new JScrollPane(this.area);
        this.scrollPane.setPreferredSize(new Dimension(450, 450));
        this.scrollPane.setVerticalScrollBarPolicy(22);
        this.add(this.scrollPane);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        fontList.addActionListener((e1) -> {
            JComboBox comboBox = (JComboBox)e1.getSource();
            this.currentFont = (String)comboBox.getSelectedItem();
            this.area.setFont(new Font(this.currentFont, Font.PLAIN, 20));
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("New")) {
            this.newFile();
        } else if (e.getActionCommand().equals("Open")) {
            this.open();
        } else if (e.getActionCommand().equals("Save")) {
            this.save();
        } else if (e.getActionCommand().equals("Print")) {
            this.printFile();
        } else if (e.getActionCommand().equals("Exit")) {
            this.exit();
        } else if (e.getActionCommand().equals("Copy")) {
            this.copy();
        } else if (e.getActionCommand().equals("Cut")) {
            this.cut();
        } else if (e.getActionCommand().equals("Paste")) {
            this.paste();
        } else if (e.getActionCommand().equals("SelectAll")) {
            this.selectAll();
        } else if (e.getActionCommand().equals("About Notepad")) {
            this.aboutNotepad();
        } else if (e.getActionCommand().equals("14")) {
            this.area.setFont(new Font("TIMES_NEW_ROMAN", Font.PLAIN, 14));
        } else if (e.getActionCommand().equals("16")) {
            this.area.setFont(new Font("TIMES_NEW_ROMAN", Font.PLAIN, 16));
        } else if (e.getActionCommand().equals("20")) {
            this.area.setFont(new Font("TIMES_NEW_ROMAN", Font.PLAIN, 20));
        } else if (e.getActionCommand().equals("24")) {
            this.area.setFont(new Font("TIMES_NEW_ROMAN", Font.PLAIN, 24));
        } else if (e.getActionCommand().equals("28")) {
            this.area.setFont(new Font("TIMES_NEW_ROMAN", Font.PLAIN, 28));
        } else if (e.getActionCommand().equals("32")) {
            this.area.setFont(new Font("TIMES_NEW_ROMAN", Font.PLAIN, 32));
        } else if (e.getActionCommand().equals("36")) {
            this.area.setFont(new Font("TIMES_NEW_ROMAN", Font.PLAIN, 36));
        } else if (e.getActionCommand().equals("Dark")) {
            this.area.setBackground(Color.BLACK);
            this.area.setForeground(Color.lightGray);
        } else if (e.getActionCommand().equals("Light")) {
            this.area.setBackground(Color.WHITE);
            this.area.setForeground(Color.BLACK);
        } else if (e.getActionCommand().equals("Blue")) {
            this.area.setBackground(Color.BLUE);
            this.area.setForeground(Color.BLACK);
        } else if (e.getActionCommand().equals("Cyan")) {
            this.area.setBackground(Color.CYAN);
            this.area.setForeground(Color.RED);
        } else if (e.getActionCommand().equals("Green")) {
            this.area.setBackground(Color.GREEN);
            this.area.setForeground(Color.RED);
        } else if (e.getActionCommand().equals("Plain")) {
            this.area.setFont(this.area.getFont().deriveFont(Font.PLAIN));
        } else if (e.getActionCommand().equals("Bold")) {
            this.area.setFont(this.area.getFont().deriveFont(Font.BOLD));
        } else if (e.getActionCommand().equals("Italic")) {
            this.area.setFont(this.area.getFont().deriveFont(Font.ITALIC));
        } else if (e.getActionCommand().equals("Bold+Italic")) {
            this.area.setFont(this.area.getFont().deriveFont(Font.BOLD | Font.ITALIC));
        } else if (e.getActionCommand().equals("Choose color")) {
            new JColorChooser();
            Color color = JColorChooser.showDialog(null, "choose color", Color.black);
            this.area.setForeground(color);
        }

    }

    public static void main(String[] args) {
        (new Notepad()).setVisible(true);
    }

    void exit() {
        System.exit(1);
    }

    void save() {
        JFileChooser save = new JFileChooser();
        save.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter restrict = new FileNameExtensionFilter("only  .txt files", ".txt");
        save.addChoosableFileFilter(restrict);
        save.setApproveButtonText("Save");
        int action = save.showOpenDialog(this);
        if (action == 0) {
            File file = new File(save.getSelectedFile() + ".txt");
            BufferedWriter outFile;

            try {
                outFile = new BufferedWriter(new FileWriter(file));
                this.area.write(outFile);
            } catch (IOException var7) {
                var7.printStackTrace();
            }

        }
    }

    void open() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter restrict = new FileNameExtensionFilter("only  .txt files", ".txt");
        chooser.addChoosableFileFilter(restrict);
        int action = chooser.showOpenDialog(this);
        if (action == 0) {
            File file = chooser.getSelectedFile();

            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                this.area.read(reader, null);
            } catch (Exception ignored) {
            }

        }
    }

    void newFile() {
        this.area.setText("");
    }

    void printFile() {
        try {
            this.area.print();
        } catch (Exception ignored) {
        }

    }

    void copy() {
        this.text = this.area.getSelectedText();
    }

    void paste() {
        this.area.insert(this.text, this.area.getCaretPosition());
    }

    void cut() {
        this.text = this.area.getSelectedText();
        this.area.replaceRange("", this.area.getSelectionStart(), this.area.getSelectionEnd());
    }

    void selectAll() {
        this.area.selectAll();
    }

    void aboutNotepad() {
        (new About()).setVisible(true);
    }
}
