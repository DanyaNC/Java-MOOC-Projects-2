/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

/**
 *
 * @author Danya
 */
import java.util.ArrayList;
import java.util.List;

public class ContainerHistory {

    private List<Double> historyList;

    public ContainerHistory() {
        this.historyList = new ArrayList<Double>();
    }

    public void add(double situation) {
        historyList.add(situation);
    }

    public void reset() {
        historyList.clear();
    }

    @Override
    public String toString() {
        return historyList.toString();
    }

    public double maxValue() {
        double biggest = historyList.get(0);
        for (double number : historyList) {
            if (number > biggest) {
                biggest = number;
            }
        }
        return biggest;
    }

    public double minValue() {
        double smallest = historyList.get(0);
        for (double number : historyList) {
            if (number < smallest) {
                smallest = number;
            }
        }
        return smallest;
    }

    public double average() {
        double sum = 0;
        for (double number : historyList) {
            sum += number;
        }
        if (!historyList.isEmpty()) {
            return sum / historyList.size();
        }
        return 0;
    }

    public double greatestFluctuation() {
        if (historyList.size() > 1) {
            double biggestFluctuation = Math.abs(historyList.get(0)
                    - historyList.get(1));
            for (int i = 0; i < historyList.size(); i++) {
                if (i + 1 < historyList.size()) {
                    double fluctuationCheck = Math.abs(historyList.get(i)
                            - historyList.get(i + 1));
                    if (fluctuationCheck > biggestFluctuation) {
                        biggestFluctuation = fluctuationCheck;
                    }
                }
            }
            return biggestFluctuation;  
        } else {
            return 0;
        }

    }

    public double variance() {
        if (!historyList.isEmpty()) {
            double varianceOutput = 0;
            double average = average();
            for (double number : historyList) {
                varianceOutput += Math.pow((number - average), 2);
            }
            return varianceOutput/(historyList.size() -1);
        }
        return 0;
    }

}
