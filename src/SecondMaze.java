//Osasikemwen Ogieva

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.*;
import javax.swing.JButton;

public class SecondMaze extends JFrame implements FinalProjectMazes{
    private Step2 [][] steps2;
    Container contentPane2;
    private final ArrayList<SecondMaze.Step2> pressed = new ArrayList<>();
    private String lastP = "red";

    /*
        21 rows * 21 columns
        1 = wall   (black)
        2 = red
        3 = blue
        4 = yellow
        5 = space  (white)
        0 = target (grey)
     */

    private final int [][] maze = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},

            {1, 2, 2, 2, 1, 4, 4, 4, 1, 3, 3, 3, 3, 3, 3, 3, 1, 4, 4, 4, 1},
            {1, 2, 1, 2, 1, 4, 1, 4, 1, 3, 1, 1, 1, 1, 1, 3, 1, 4, 1, 4, 1},

            {1, 2, 1, 5, 5, 5, 1, 4, 4, 5, 5, 5, 2, 2, 2, 5, 5, 5, 1, 4, 1},
            {1, 2, 1, 5, 5, 5, 1, 1, 1, 5, 5, 5, 1, 1, 1, 5, 5, 5, 1, 4, 1},
            {1, 2, 1, 5, 5, 5, 3, 3, 3, 5, 5, 5, 1, 4, 4, 5, 5, 5, 1, 4, 1},

            {1, 2, 1, 3, 1, 4, 1, 1, 1, 1, 1, 4, 1, 4, 1, 1, 1, 2, 1, 4, 1},
            {1, 2, 1, 3, 1, 4, 1, 4, 4, 4, 4, 4, 1, 4, 1, 2, 2, 2, 1, 4, 1},
            {1, 2, 1, 3, 1, 4, 1, 4, 1, 1, 1, 1, 1, 4, 1, 2, 1, 1, 1, 4, 1},

            {1, 2, 2, 5, 5, 5, 1, 4, 1, 0, 0, 0, 1, 4, 1, 5, 5, 5, 4, 4, 1},
            {1, 1, 1, 5, 5, 5, 1, 4, 1, 0, 0, 0, 1, 4, 1, 5, 5, 5, 1, 1, 1},
            {1, 4, 4, 5, 5, 5, 4, 4, 1, 0, 0, 0, 4, 4, 1, 5, 5, 5, 3, 3, 1},

            {1, 4, 1, 2, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 1, 3, 1},
            {1, 4, 1, 2, 1, 3, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 4, 1, 3, 1},
            {1, 4, 1, 2, 1, 3, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 4, 1, 3, 1},

            {1, 4, 1, 5, 5, 5, 2, 2, 1, 5, 5, 5, 4, 4, 4, 5, 5, 5, 1, 3, 1},
            {1, 4, 1, 5, 5, 5, 1, 1, 1, 5, 5, 5, 1, 1, 1, 5, 5, 5, 1, 3, 1},
            {1, 4, 1, 5, 5, 5, 1, 3, 3, 5, 5, 5, 3, 3, 3, 5, 5, 5, 1, 3, 1},

            {1, 4, 1, 4, 1, 3, 1, 3, 1, 2, 1, 2, 1, 1, 1, 2, 1, 3, 1, 3, 1},
            {1, 4, 4, 4, 1, 3, 3, 3, 1, 2, 1, 2, 2, 2, 2, 2, 1, 3, 3, 3, 1},

            {1, 1, 1, 1, 1, 1, 1, 1, 1, 6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}

    };

    public void SetUp() {
        //sets up container and sets layout grid
        contentPane2 = this.getContentPane();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int buttonCount2 = 21;
        contentPane2.setLayout(new GridLayout(buttonCount2 + 1, buttonCount2));
        contentPane2.setSize(buttonCount2 *30, buttonCount2 *30);


        steps2 = new SecondMaze.Step2[buttonCount2][buttonCount2];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {

                if (maze[i][j] == 1) {
                    steps2[i][j] = new SecondMaze.Step2(i, j, "wall");
                    contentPane2.add(steps2[i][j]);
                }
                else if (maze[i][j] == 2) {
                    steps2[i][j] = new SecondMaze.Step2(i, j, "red");
                    contentPane2.add(steps2[i][j]);
                }
                else if (maze[i][j] == 3) {
                    steps2[i][j] = new SecondMaze.Step2(i, j, "blue");
                    contentPane2.add(steps2[i][j]);
                }
                else if (maze[i][j] == 4) {
                    steps2[i][j] = new SecondMaze.Step2(i, j, "yellow");
                    contentPane2.add(steps2[i][j]);
                }
                else if (maze[i][j] == 5) {
                    steps2[i][j] = new SecondMaze.Step2(i, j, "space");
                    contentPane2.add(steps2[i][j]);
                }
                else if (maze[i][j] == 6) {
                    steps2[i][j] = new SecondMaze.Step2(i, j, "start");
                    contentPane2.add(steps2[i][j]);
                }
                else if (maze[i][j] == 0) {
                    steps2[i][j] = new SecondMaze.Step2(i, j, "goal");
                    contentPane2.add(steps2[i][j]);
                }
                else {
                    steps2[i][j] = new SecondMaze.Step2(i, j, "space");
                    contentPane2.add(steps2[i][j]);
                }
            }
        }
        executeAddTransitions();
        pressed.add(steps2[0][0]);
        Panel();
    }

    public void Panel() {
        JPanel panel = new JPanel();
        panel.setSize(400, 40);
        panel.setLayout(new GridLayout(2, 2));
        contentPane2.add(panel);

        JButton button = new JButton("Switch Game");
        panel.add(button);
        SwitchHandler h = new SwitchHandler();
        button.addActionListener(h);

        JButton button1 = new JButton("See Solution");
        panel.add(button1);
        SolutionHandler2 s = new SolutionHandler2(this);
        button1.addActionListener(s);
    }

    public void executeAddTransitions() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                steps2[i][j].addTransitions(i, j);
            }
        }
    }

    public SecondMaze.Step2 getButton(int a, int b) {
        return steps2[a][b];
    }


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Button Class: Creates each button.
// Location Class.
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    class Step2 extends JButton implements ActionListener {
        private final int ii; //number of rows
        private final int jj; // and columns
        private final String type;
        private final ArrayList<SecondMaze.Step2> transitions = new ArrayList<>();
        private boolean enabled;

        public Step2(int i, int j, String t) {
            super();
            ii = i;
            jj = j;
            type = t;
            this.addActionListener(this);
            if (type.equals("start")) {  //set the start button enabled
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

        public ArrayList<SecondMaze.Step2> getTransitions (){
            return transitions;
        }

        public void paint(Graphics g) {
            super.paint(g);
            g.translate(50, 50);
            for (int row = 0; row < maze.length; row++) {
                for (int col = 0; col < maze[0].length; col++) {
                    setBackground(pickColor());
                    setHorizontalAlignment(0);
                    setSize(37, 37);
                }
            }
        }

        public Color pickColor() {
            if (Objects.equals(type, "wall")) {
                return Color.BLACK;
            }
            if (Objects.equals(type, "red")) {
                return Color.RED;
            }
            if (Objects.equals(type, "blue")) {
                return Color.BLUE;
            }
            if (Objects.equals(type, "yellow")) {
                return Color.YELLOW;
            }
            if (Objects.equals(type, "goal")) {
                return Color.GRAY;
            } else {
                return Color.white;
            }
        }

        public void addTransitions(int a, int b) {
            if (a + 1 < maze.length && !steps2[a + 1][b].type.equals("wall"))
                transitions.add(steps2[a + 1][b]);
            if (a - 1 >= 0 && !steps2[a - 1][b].type.equals("wall"))
                transitions.add(steps2[a - 1][b]);
            if (b + 1 < maze.length && !steps2[a][b + 1].type.equals("wall"))
                transitions.add(steps2[a][b + 1]);
            if (b - 1 >= 0 && !steps2[a][b - 1].type.equals("wall"))
                transitions.add(steps2[a][b - 1]);
        }

        public ArrayList<Step2> makeInformation() {
            ArrayList<SecondMaze.Step2> forbid = new ArrayList<>();
            forbid.add(steps2[0][0]);

            if (lastP.equals("red")) {
                for (int i = 0; i < maze.length; i++) {
                    for (int j = 0; j < maze[0].length; j++) {
                        if (steps2[i][j].type.equals("yellow")) {
                            forbid.add(steps2[i][j]);
                        }
                    }
                }
            }

            if (lastP.equals("blue")) {
                for (int i = 0; i < maze.length; i++) {
                    for (int j = 0; j < maze[0].length; j++) {
                        if (steps2[i][j].type.equals("red")) {
                            forbid.add(steps2[i][j]);
                        }
                    }
                }
            }

            if (lastP.equals("yellow")) {
                for (int i = 0; i < maze.length; i++) {
                    for (int j = 0; j < maze[0].length; j++) {
                        if (steps2[i][j].type.equals("blue")) {
                            forbid.add(steps2[i][j]);
                        }
                    }
                }
            }
            return forbid;
        }

        public boolean infoForbids(int a, int b) {
            boolean temp = false;
            for (int i = 0; i < makeInformation().size(); i++) {
                if (steps2[a][b].equals(makeInformation().get(i)))
                    temp = true;
            }
            return temp;
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            if (!type.equals("space")) lastP = type;
            setBackground(Color.DARK_GRAY);
            pressed.add(this);

            if (enabled) {
                for (int i = 0; i < maze.length; i++) {
                    for (int j = 0; j < maze[0].length; j++) {
                        steps2[i][j].setEnabled(false);
                        enabled = false;
                        //steps2[i][j].setBackground(null);
                    }
                }
                enabled = true;

                for (Step2 transition : transitions) {
                    if (!infoForbids(transition.ii, transition.jj)) {
                        transition.setEnabled(true);
                        transition.setBackground(Color.BLACK);
                        transition.enabled = true;
                    }
                }
                System.out.println(pressed.size() + " " + (pressed.size() - 2));

                pressed.get(pressed.size() - 2).setEnabled(false); //disable the last button
                pressed.get(pressed.size() - 2).enabled = false;
                int a = pressed.get(pressed.size() - 2).ii;
                int b = pressed.get(pressed.size() - 2).jj;
                System.out.println(a + " " + b);
            }
        }
    }
}
