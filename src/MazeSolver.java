//Osasikemwen Ogieva

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public class MazeSolver {
    private final ArrayList<FirstMaze.Step> path = new ArrayList<>();
    private final ArrayList<FirstMaze.Step> toVisit = new ArrayList<>();
    private final ArrayList<FirstMaze.Step> Visited = new ArrayList<>();
    private FirstMaze.Step goal;
    private FirstMaze.Step start;

    public void go(FirstMaze fm) {
        goal = fm.getButton(6, 6);
        start = fm.getButton(0, 0);
        solve(start);
    }

    public void solve(FirstMaze.Step start) {
        HashMap<FirstMaze.Step, FirstMaze.Step> backTrack = new HashMap<>();
        backTrack.put(start, null);
        toVisit.add(start);
        Visited.add(start);

        while (!toVisit.isEmpty()) {
            FirstMaze.Step temp = toVisit.remove(0);

            //if temp is the destination, execute reconstructPath
            if (temp.equals(goal)) {
                printPath(reconstructPath(backTrack, temp));
            }

            else {
                ArrayList<FirstMaze.Step> nextSteps = temp.getTransitions();

                for (FirstMaze.Step nextStep : nextSteps) {
                    if (!inVisited(nextStep)) {
                        Visited.add(nextStep);
                        backTrack.put(nextStep, temp);
                        toVisit.add(nextStep);
                    }
                }
            }
        }
    }

    public boolean inVisited(FirstMaze.Step x) {
        for (FirstMaze.Step step : Visited) {
            if (step.equals(x)) return true;
        }
        return false;
    }

    public ArrayList<FirstMaze.Step> reconstructPath(HashMap<FirstMaze.Step, FirstMaze.Step> b, FirstMaze.Step goal) {
        path.add(goal);
        while (!b.get(goal).equals(start)) {
            path.add(b.get(goal));
            goal = b.get(goal);
        }
        path.add(start);
        return path;
    }

    public void printPath(ArrayList<FirstMaze.Step> path) {
        for (FirstMaze.Step step : path) {
            System.out.print(step.getIi() + " " + step.getJj() + " then ");
            
        }
    }

    public ArrayList<FirstMaze.Step> getPath(){
        return path;
    }
}

























///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

class MazeSolver2 {
    ArrayList<SecondMaze.Step2> path = new ArrayList<>();
    private final ArrayList<SecondMaze.Step2> toVisit = new ArrayList<>();
    private final ArrayList<SecondMaze.Step2> Visited = new ArrayList<>();
    SecondMaze.Step2 goal2;
    SecondMaze.Step2 start2;

    public void go(SecondMaze sm) {
        goal2 = sm.getButton(11, 11);
        start2 = sm.getButton(20, 9);
        solve(start2);
    }

    public void solve(SecondMaze.Step2 start) {
        HashMap<SecondMaze.Step2, SecondMaze.Step2> backTrack = new HashMap<>();
        backTrack.put(start, null);
        toVisit.add(start);
        Visited.add(start);

        while (!toVisit.isEmpty()) {
            SecondMaze.Step2 temp = toVisit.remove(0);

            //if temp is the destination, execute reconstructPath
            if (temp.equals(goal2)) {
                printPath(reconstructPath(backTrack, temp));
            }

            else {
                ArrayList<SecondMaze.Step2> nextSteps = temp.getTransitions();

                for (SecondMaze.Step2 nextStep : nextSteps) {
                    if (!inVisited(nextStep)) {
                        Visited.add(nextStep);
                        backTrack.put(nextStep, temp);
                        toVisit.add(nextStep);
                    }
                }
            }
        }
    }


    public boolean inVisited(SecondMaze.Step2 x) {
        for (SecondMaze.Step2 step2 : Visited) {
            if (step2.equals(x)) return true;
        }
        return false;
    }

    public ArrayList<SecondMaze.Step2> reconstructPath(HashMap<SecondMaze.Step2, SecondMaze.Step2> b, SecondMaze.Step2 goal) {
        path.add(goal);
        while (!b.get(goal).equals(start2)) {
            path.add(b.get(goal));
            goal = b.get(goal);
        }
        path.add(start2);
        return path;
    }

    public void printPath(ArrayList<SecondMaze.Step2> path) {
        for (SecondMaze.Step2 step2 : path) {
            System.out.println(step2.getIi() + " " + step2.getJj());
        }
    }

    public ArrayList<SecondMaze.Step2> getPath(){
        return path;
    }
}


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

class MazeSolver3 {
    ArrayList<ThirdMaze.Step3> path = new ArrayList<>();
    private ThirdMaze.Step3 goal3;
    private ThirdMaze.Step3 start3;
    private final ArrayList<ThirdMaze.Step3> toVisit = new ArrayList<>();
    private final ArrayList<ThirdMaze.Step3> Visited = new ArrayList<>();


    public void go3(ThirdMaze tm) {
        goal3 = tm.getButton(0, 2);
        start3 = tm.getButton(5, 1);
        solve(start3);
    }

    public void solve(ThirdMaze.Step3 start) {
        HashMap<ThirdMaze.Step3, ThirdMaze.Step3> backTrack = new HashMap<>();
        backTrack.put(start, null);
        toVisit.add(start);
        Visited.add(start);

        while (!toVisit.isEmpty()) {
            ThirdMaze.Step3 temp = toVisit.remove(0);

            //if temp is the destination, execute reconstructPath
            if (temp.equals(goal3)) {
                printPath(reconstructPath(backTrack, temp));
            }

            else {
                ArrayList<ThirdMaze.Step3> nextSteps = temp.getTransitions();

                for (ThirdMaze.Step3 nextStep : nextSteps) {
                    if (!inVisited(nextStep)) {
                        Visited.add(nextStep);
                        backTrack.put(nextStep, temp);
                        toVisit.add(nextStep);
                    }
                }
            }
        }
    }


    public boolean inVisited(ThirdMaze.Step3 x) {
        for (ThirdMaze.Step3 step3 : Visited) {
            if (step3.equals(x)) return true;
        }
        return false;
    }

    public ArrayList<ThirdMaze.Step3> reconstructPath(HashMap<ThirdMaze.Step3, ThirdMaze.Step3> b, ThirdMaze.Step3 goal) {
        path.add(goal);
        while (!b.get(goal).equals(start3)) {
            path.add(b.get(goal));
            goal = b.get(goal);
        }
        path.add(start3);
        return path;
    }

    public void printPath(ArrayList<ThirdMaze.Step3> path) {
        for (ThirdMaze.Step3 step3 : path) {
            System.out.println(step3.getIi() + " " + step3.getJj());
        }
    }

    public ArrayList<ThirdMaze.Step3> getPath(){
        return path;
    }

}
