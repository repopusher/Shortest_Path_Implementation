//Tobias Lennon
//R00191512
//SDH2-B
package Non_Linear_Assignment_2;

import java.util.ArrayList;
import java.util.List;

public class RobotMoving {

    public static void robotMoving(int n){
        //Move right, down and diagonal-right down respectively.
        double[] COST1 = {1.1, 1.3, 2.5};
        double[] COST2 = {1.5, 1.2, 2.3};
        double[][] m1 = new double[n][n];
        double[][] m2 = new double[n][n];
        m1[0][0] = 0;
        m2[0][0] = 0;
        //If positive integer.
        if(n > 0) {
            for (int j = 1; j < m1.length; j++) {
                //Calculating Jth row.
                m1[0][j] = m1[0][j - 1] + COST1[0];
                m2[0][j] = m2[0][j - 1] + COST2[0];
            }

            for (int i = 1; i < m1.length; i++) {
                //Calculating Ith row.
                m1[i][0] = m1[i - 1][0] + COST1[1];
                m2[i][0] = m2[i - 1][0] + COST2[1];
                for (int j = 1; j < m1.length; j++) {
                    double min = Integer.MAX_VALUE;
                    double min2 = Integer.MAX_VALUE;

                    if (min > m1[i][j - 1] + COST1[0]) {
                        min = m1[i][j - 1] + COST1[0];
                    }

                    if (min > m1[i - 1][j] + COST1[1]) {
                        min = m1[i - 1][j] + COST1[1];
                    }

                    if (min > m1[i - 1][j - 1] + COST1[2]) {
                        min = m1[i - 1][j - 1] + COST1[2];
                    }

                    //Other cost
                    if (min2 > m2[i][j - 1] + COST2[0]) {
                        min2 = m2[i][j - 1] + COST2[0];
                    }

                    if (min2 > m2[i - 1][j] + COST2[1]) {
                        min2 = m2[i - 1][j] + COST2[1];
                    }

                    if (min2 > m2[i - 1][j - 1] + COST2[2]) {
                        min2 = m2[i - 1][j - 1] + COST2[2];
                    }

                    m1[i][j] = min;
                    m2[i][j] = min2;
                }
            }

            double cost = m1[n - 1][n - 1];
            double cost2 = m2[n - 1][n - 1];

            System.out.println("The minimum cost for the robot to reach the finish point [" + n + ", " + n + "] is " + cost + "\nMinimum cost for price list 2 = " + cost2);

            //Printing moves made

            int k = 0, l = 0;
            List roboticMovementsm1 = new ArrayList();
            List roboticMovementsm2 = new ArrayList();
            boolean endRow = false;
            boolean endCol = false;
            boolean option = true;

            while(option){

                if(k == (n-1)){
                    endRow = true;
                }

                if(l == (n-1)){
                    endCol = true;
                }

                //endRow true
                if(endRow){
                    roboticMovementsm1.add("Right");
                    l += 1;
                }

                //endCol true
                if(endCol){
                    roboticMovementsm1.add("Down");
                    k += 1;
                }

                //Exit loop.
                if(endRow && endCol){
                    option = false;
                }

                if(!endCol && !endRow){

                    if (m1[k][l + 1] < m1[k + 1][l + 1] && m1[k][l + 1] < m1[k + 1][l]) {
                        roboticMovementsm1.add("Right");
                        l += 1;
                    }
                    else if (m1[k + 1][l] < m1[k + 1][l + 1]) {
                        roboticMovementsm1.add("Down");
                        k += 1;
                    }
                    else {
                        roboticMovementsm1.add("Right-Down");
                        k += 1;
                        l += 1;
                    }
                }
            }

            while(option){

                if(k == (n-1)){
                    endRow = true;
                }

                if(l == (n-1)){
                    endCol = true;
                }

                //endRow true
                if(endRow){
                    roboticMovementsm2.add("Right");
                    l += 1;
                }

                //endCol true
                if(endCol){
                    roboticMovementsm2.add("Down");
                    k += 1;
                }

                //Exit loop.
                if(endRow && endCol){
                    option = false;
                }

                if(!endCol && !endRow){

                    if (m2[k][l + 1] < m2[k + 1][l + 1] && m2[k][l + 1] < m2[k + 1][l]) {
                        roboticMovementsm2.add("Right");
                        l += 1;
                    }
                    else if (m2[k + 1][l] < m2[k + 1][l + 1]) {
                        roboticMovementsm2.add("Down");
                        k += 1;
                    }
                    else {
                        roboticMovementsm2.add("Right-Down");
                        k += 1;
                        l += 1;
                    }
                }
            }

            System.out.println("Movements for cost list 1\n");
            System.out.println(roboticMovementsm1);
            System.out.println("Movements for cost list 2\n");
            System.out.println(roboticMovementsm2);


        }
        else {
            System.out.println("Error, enter positive integer.");
        }
    }

    public static void main(String[] args) {
        robotMoving(5);
    }
}
