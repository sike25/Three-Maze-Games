//Osasikemwen Ogieva

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class Menu extends JFrame {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.go();
        menu.pack();
        menu.setVisible(true);
        menu.setSize(new Dimension(500,500));
    }

    public void go(){
        Container conP = this.getContentPane();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        conP.setLayout(new FlowLayout());
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(2,1));
        conP.add(jp);

        JButton menu_button = new JButton("Pick a game");
        jp.add(menu_button);
        ButtonToMenuListener fl = new ButtonToMenuListener(menu_button); //call button to menu listener
        menu_button.addActionListener(fl);
    }
}



//Action Listener Class Begins Here.
class ButtonToMenuListener implements ActionListener {
    private final JButton myButton;
    JPopupMenu menu;

    public ButtonToMenuListener(JButton clicker) {
        myButton = clicker;
        menu = new JPopupMenu("Mazes:");
        GameChangeListener gcl = new GameChangeListener(menu, myButton);

        JMenuItem a = new JMenuItem("Numbers Maze");
        menu.add(a);
        a.addActionListener(gcl);

        JMenuItem b = new JMenuItem("Color Maze");
        menu.add(b);
        b.addActionListener(gcl);

        JMenuItem c = new JMenuItem("Pattern Maze");
        menu.add(c);
        c.addActionListener(gcl);

        menu.add(new JMenuItem("Never Mind"));
    }

    public void actionPerformed(ActionEvent e) {
        menu.show (myButton,myButton.getWidth(),myButton.getHeight());
    }
}



//Game Changer
class GameChangeListener implements ActionListener {
    JPopupMenu menu;
    JButton button;

    public GameChangeListener (JPopupMenu m, JButton b) {
        menu = m;
        button = b;
    }

    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand(); //gets the selected option from the user
        switch (action) {
            case "Numbers Maze" -> {
                FirstMaze thisOne = new FirstMaze();
                thisOne.setTitle("Numbers Maze");
                thisOne.SetUp();
                thisOne.pack();
                thisOne.setVisible(true);
                thisOne.setSize(new Dimension(400, 400));
            }
            case "Color Maze" -> {
                SecondMaze thisTwo = new SecondMaze();
                thisTwo.SetUp();
                thisTwo.pack();
                thisTwo.setVisible(true);
                thisTwo.setSize(new Dimension(27 * 30, 27 * 30));
                thisTwo.setTitle("Color Maze");
            }
            case "Pattern Maze" -> {
                ThirdMaze thirdMaze = new ThirdMaze();
                thirdMaze.SetUp();
                thirdMaze.pack();
                thirdMaze.setVisible(true);
                thirdMaze.setSize(new Dimension(400, 400));
                thirdMaze.setTitle("Pattern Maze");
            }
        }
    }
}


