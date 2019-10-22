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
public class ProductContainerRecorder extends ProductContainer {
    private ContainerHistory productContainerHistory;
    
    public ProductContainerRecorder(String productName, 
            double capacity, double initialVolume) {
        super(productName, capacity);
        super.addToTheContainer(initialVolume);
        productContainerHistory = new ContainerHistory();
        productContainerHistory.add(initialVolume);
    }
    
    @Override
    public void addToTheContainer(double amount) {
        super.addToTheContainer(amount);
        productContainerHistory.add(super.getVolume());
    }
    
    @Override
    public double takeFromTheContainer(double amount) {
        double taken = super.takeFromTheContainer(amount);
        productContainerHistory.add(super.getVolume());
        return taken;
    }
    
    public void printAnalysis() {
        System.out.println("Product: " + super.getName());
        System.out.println("History: " + this.history());
        System.out.println("Greatest product amount: " + 
                productContainerHistory.maxValue());
        System.out.println("Smallest product amount:" + 
                productContainerHistory.minValue());
        System.out.println("Average:  " + productContainerHistory.average());
        System.out.println("Greatest change: " + 
                productContainerHistory.greatestFluctuation());
        System.out.println("Variance: " + productContainerHistory.variance());
    }
    
    public String history() {
        return this.productContainerHistory.toString();
    }
    
}
