//To play the game with icons set, see line 157
//Osasikemwen Ogieva

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ThirdMaze extends JFrame implements FinalProjectMazes{
    Container contentPane3;
    private Step3[][] steps3;
    private int countPressed;
    private final ArrayList<ThirdMaze.Step3> pressed = new ArrayList<>();

/*
     0 - space
     1 = red plus                7 = yellow plus
     2 = red star                8 = yellow star
     3 = red diamond             9 = yellow diamond
     4 = red flower              10 = yellow flower

     5 = blue diamond            11 = green plus
     6 = blue flower             12 = green star
                                 13 = green flower
*/


    private final int[][] maze = {
            {0, 0, 11, 0, 0, 0},
            {1, 2, 9, 5, 3, 9},
            {8, 9, 2, 11, 12, 13},
            {4, 1, 12, 6, 9, 7},
            {12, 3, 7, 3, 13, 6},
            {0, 10, 0, 0, 0, 0}
    };

    public static void main(String[] args) {  //Might be useless af
        ThirdMaze thirdMaze = new ThirdMaze();
        thirdMaze.SetUp();
        thirdMaze.pack();
        thirdMaze.setVisible(true);
        thirdMaze.setSize(new Dimension(400, 400));
    }

    public void SetUp() {
        //creates container
        contentPane3 = this.getContentPane();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane3.setLayout(new GridLayout(maze.length + 1, maze[0].length));

        steps3 = new Step3[maze.length][maze.length];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                steps3[i][j] = new ThirdMaze.Step3(i, j, maze[i][j]);
                contentPane3.add(steps3[i][j]);
            }
        }
        executeAddTransitions();
        Panel();
    }

    public void executeAddTransitions() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                steps3[i][j].addTransitions(i, j);
            }
        }
    }

    public void Panel() {
        JPanel panel = new JPanel();
        panel.setSize(400, 40);
        panel.setLayout(new FlowLayout());
        contentPane3.add(panel);

        JButton button = new JButton("Switch Game");
        panel.add(button);
        SwitchHandler h = new SwitchHandler();
        button.addActionListener(h);

        JButton button1 = new JButton("See Solution");
        panel.add(button1);
        SolutionHandler3 s = new SolutionHandler3(this);
        button1.addActionListener(s);
    }

    public ThirdMaze.Step3 getButton(int a, int b) {
        return steps3[a][b];
    }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    class Step3 extends JButton implements ActionListener {
        private final int ii; //number of rows
        private final int jj; // and columns
        private final int type;
        private final ArrayList<ThirdMaze.Step3> transitions = new ArrayList<>();
        private boolean enabled;

        public Step3(int i, int j, int t) {
            super();
            ii = i;
            jj = j;
            type = t;
            this.addActionListener(this);
            if (type == 10) {  //set the start button enabled
                setEnabled(true);
                enabled = true;
            } else {
                setEnabled(false);  //set everything else disabled
            }
        }

        public int getIi() {
            return ii;
        }

        public int getJj() {
            return jj;
        }

        public int getType() {
            return type;
        }

        public ArrayList<ThirdMaze.Step3> getTransitions (){
            return transitions;
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(pickColor(ii, jj));

            //To play the game with pictures...
            //Comment out this line
            setText(pickShape(ii, jj));

            //UN-Comment these lines
//            String filename = pickShape(ii, jj);
//            ImageIcon icon = new ImageIcon(filename);
//            Image image = icon.getImage();
//            Image newimg = image.getScaledInstance(120, 120,  Image.SCALE_AREA_AVERAGING);
//            icon = new ImageIcon(newimg);
//            setIcon(icon);
        }

        public Color pickColor(int i, int j) {
            int typ = steps3[i][j].getType();

            if ((typ == 6) || (typ == 5)) return Color.BLUE;

            if ((typ == 1) || (typ == 2) || (typ == 3) || (typ == 4)) return Color.RED;

            if ((typ == 7) || (typ == 8) || (typ == 9) || (typ == 10)) return Color.YELLOW;

            if ((typ == 11) || (typ == 12) || (typ == 13)) return Color.green;

            else return Color.white;
        }

        public String pickShape(int i, int j) {
            int typ = steps3[i][j].getType();

            if ((typ == 1) || (typ == 7) || (typ == 11)) return "plus.png";

            if ((typ == 2) || (typ == 8) || (typ == 12)) return "star.png";

            if ((typ == 3) || (typ == 5) || (typ == 9)) return "diamond.png";

            if ((typ == 4) || (typ == 6) || (typ == 10) || (typ == 13)) return "flower.png";

            else return "";
        }

        public void addTransitions(int a, int b) {
            String match = pickShape(a, b);
            Color same = pickColor(a, b);

            for (int i = 0; i < maze.length; i++) {
                for (int j = 0; j < maze[0].length; j++) {
                    if ((steps3[i][j].getIi() == a) || (steps3[i][j].getJj() == b)) {
                        if ((pickColor(i, j).equals(same)) || pickShape(i, j).equals(match)) {
                            transitions.add(steps3[i][j]);
                        }
                    }
                }
            }
        }

        public ArrayList makeInformation() {
            int size = pressed.size();
            Step3 second = pressed.get(size - 1);
            Step3 first = pressed.get(size - 2);
            ArrayList<Step3> forbid = new ArrayList<>();
            forbid.add(steps3[0][0]);

            if (first.getIi() == second.getIi()) { //when the two last buttons pressed are within the same row
                if (first.jj < second.jj) {  //if the first is before the second
                    for (int c = 0; c <= second.jj; c++) { //run through all the buttons between them, add to forbid
                        forbid.add(steps3[first.ii][c]);
                    }
                }
                if (first.jj > second.jj) {  //if the first is after the second
                    for (int c = second.jj; c < maze.length; c++) { //run through all the buttons between them, add to forbid
                        forbid.add(steps3[first.ii][c]);
                    }
                }
            }

            if (first.getJj() == second.getJj()) { //if the first pressed and second pressed are on the same column
                if (first.ii < second.ii) {  //if the first is lower than the second
                    for (int c = 0; c <= second.ii; c++) { //run through all the buttons between them, add to forbid
                        forbid.add(steps3[c][first.jj]);
                    }
                }
                if (first.ii > second.ii) {  //if the first is higher than the second
                    for (int c = second.ii; c < maze.length; c++) { //run through all the buttons between them, add to forbid
                        forbid.add(steps3[c][first.jj]);
                    }
                }
            }
            return forbid;
        }

        public void actionPerformed(ActionEvent e) {
            countPressed++;
            pressed.add(this);
            enabled = true;
            setBackground(Color.DARK_GRAY);

            if (enabled) {
                for (int i = 0; i < maze.length; i++) {
                    for (int j = 0; j < maze[0].length; j++) {
                        steps3[i][j].setEnabled(false);
                        enabled = false;
                        steps3[i][j].setBackground(null);
                    }
                }
                enabled = true;

                for (Step3 transition : transitions) {
                    transition.setEnabled(true);
                    transition.setBackground(null);
                    transition.enabled = true;
                }

                if (countPressed >= 2) {
                    Step3 temp;
                    for (int i = 0; i < makeInformation().size(); i++) {
                        temp = (Step3) makeInformation().get(i);
                        steps3[temp.ii][temp.jj].setEnabled(false);
                        steps3[temp.ii][temp.jj].enabled = false;
                    }
                }
            }
        }
    }
}