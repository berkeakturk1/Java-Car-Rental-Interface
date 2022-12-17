import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Container; // awt: abstract windowing toolkit
import java.awt.FlowLayout;
import java.awt.event.*;
import java.awt.*;
import java.util.InputMismatchException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class SelectionGUI implements ActionListener{
    private JLabel pickL, dropL, pDate, dDate, priceL;
    DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    //DateFormatter df = new DateFormatter(format);
    private JCheckBox  weekend, auto, mnl, roofrack , trailer, snowchains, navigation, child_seats;
    private JCheckBox [] box = {  weekend, auto, mnl, roofrack , trailer, snowchains, navigation, child_seats};
    private int [] amount = {-50, 0, 0, 10, 15, 10, 10, 15};
    private String [] box_name = { "I will rent only for the weekend", " I want an automatic", "I want a manual", "I need a roof rack" , "I need a trailer", "I need snow chains", "I want a satnav", "I need child seats"};
    private JFormattedTextField pickTf, dropTf;
    private JButton rentB, exitB;
    private JFrame gui;
    private JPanel panel;
    private String image;
    private int price;
    public SelectionGUI(int price, String image){
        this.price = price;
        this.image = image;

        pickL = new JLabel("Pickup Location");
        dropL = new JLabel("Drop-off Location");
        pDate = new JLabel("Pickup Date");
        dDate = new JLabel("Drop-Off Date");
        for (int i = 0; i < box.length; i++)
             box[i] = new JCheckBox(box_name[i]);
        rentB = new JButton("Rent");
        exitB = new JButton("Exit");
        panel = new JPanel();
        gui = new JFrame();
        pickTf = new JFormattedTextField(format);
        pickTf.setPreferredSize(new Dimension(100,20));
        dropTf = new JFormattedTextField(format);
        dropTf.setPreferredSize(new Dimension(100,20));

        String[] pChoices = { "CHOICE 1","CHOICE 2", "CHOICE 3","CHOICE 4","CHOICE 5","CHOICE 6"};
        String[] dChoices = { "CHOICE 1","CHOICE 2", "CHOICE 3","CHOICE 4","CHOICE 5","CHOICE 6"};

        final JComboBox<String> pC = new JComboBox<String>(pChoices);
        final JComboBox<String> dC = new JComboBox<String>(dChoices);

        JLabel label = new JLabel(); //JLabel Creation
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("C:\\Users\\aktrk\\IdeaProjects\\oophw\\src\\assets\\Punch-600X500.png").getImage().getScaledInstance(600, 500, Image.SCALE_DEFAULT));
        label.setIcon(imageIcon);
         //Sets the image to be displayed as an icon
        //Dimension size = label.getPreferredSize(); //Gets the size of the image
        label.setBounds(50, 30, 5,  5);

        pC.setVisible(true);

        //changed();
        exitB.addActionListener(this);
        rentB.addActionListener(this);
        for (int i = 0; i < box.length; i++)
            box[i].addActionListener(this);

        pickTf.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') ||
                        (c == KeyEvent.VK_BACK_SPACE) ||
                        (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SLASH)))
                {
                    JOptionPane.showMessageDialog(null, "Please Enter a Valid Date");
                    e.consume();
                }
            }
        });
        dropTf.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') ||
                        (c == KeyEvent.VK_BACK_SPACE) ||
                        (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SLASH)))
                {
                    JOptionPane.showMessageDialog(null, "Please Enter Valid");
                    e.consume();
                }
            }
        });

        gui.setTitle("Rent window");
        gui.setSize(1000, 800);
        gui.setVisible(true);
        gui.setResizable(true);

        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = gui.getContentPane();
        Container middle = new Container();
        Container left = new Container();
        Container right = new Container();
        Container down = new Container();
        down.setLayout(new FlowLayout(FlowLayout.CENTER));
        right.setLayout(new GridLayout(4, 2));
        right.setSize(100,200);
        left.setLayout(new GridLayout(4, 2));
        left.setSize(100,200);
        middle.setLayout(new BoxLayout(middle, BoxLayout.Y_AXIS));
        c.setLayout(new BorderLayout(20, 75));
        middle.add(label);
        middle.add(pickL);
        middle.add(pC);
        middle.add(dropL);
        middle.add(dC);
        middle.add(pDate);
        middle.add(pickTf);
        middle.add(dDate);
        middle.add(dropTf );

        c.add(middle, BorderLayout.CENTER);
        for (int i = 0; i < box.length / 2; i++)
            left.add(box[i]);
        for (int i = box.length / 2; i < box.length; i++)
            right.add(box[i]);
        c.add(left, BorderLayout.WEST);
        c.add(right, BorderLayout.EAST);
        down.add(rentB);
        down.add(exitB);
        c.add(down, BorderLayout.SOUTH);
    }


    public void actionPerformed(ActionEvent e){
        String pLoc, dLoc;

        if (e.getSource() == exitB){
            System.exit(0);
        }
        if(e.getSource() == rentB){
           if (Objects.equals(pickTf.getText(), "")|| Objects.equals(dropTf.getText(), "") ){
               JOptionPane.showMessageDialog(null,"Please fill in the correct dates.");
               return;
           }
           price = 1000;
           for ( int i= 0; i <box.length; i++){
               if (box[i].isSelected()){
                    price += amount[i];
               }
           }
            int a=JOptionPane.showConfirmDialog(null,"The amount will be " + Integer.toString(price) + "$ are you sure?");
            if (a == 0){
                JOptionPane.showMessageDialog(null,"The car selected has been rented for " + Integer.toString(price) + "$");
            }
        }

    }

}
