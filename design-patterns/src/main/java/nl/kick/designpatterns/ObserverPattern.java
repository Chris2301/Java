package nl.kick.designpatterns;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Observer Pattern
 *
 * Think of it as a weather station (observer) that has thousands of temperature stations (observables) across its region.
 * It wants to listen to updates about temperature rises/drops
 *
 * I personally use it most often in frontend projects with RxJs, but in Java we can use it when:
 * - You have to notify a process of state of another process
 */
public class ObserverPattern {

    public static void main(String[] args) {
        TemperatureMetric observable = new TemperatureMetric();
        WeatherStation observer = new WeatherStation();

        observable.addPropertyChangeListener(observer);
        observable.setCurrentTemperature("15 degrees");

        System.out.println("The temperature is: " + observer.getCurrentTemperature());

        //Remove the observer so it won't get updates
        observable.removePropertyChangeListener(observer);
        observable.setCurrentTemperature("16 degrees");
        System.out.println("The temperature is: " + observer.getCurrentTemperature());


    }

    /**
     * The Observable, which is sending state changes/events
     */
    public static class TemperatureMetric {
        private String currentTemperature;

        private PropertyChangeSupport support;

        public TemperatureMetric() {
            support = new PropertyChangeSupport(this);
        }

        public void addPropertyChangeListener(PropertyChangeListener pcl) {
            support.addPropertyChangeListener(pcl);
        }

        public void removePropertyChangeListener(PropertyChangeListener pcl) {
            support.removePropertyChangeListener(pcl);
        }

        public void setCurrentTemperature(String value) {
            support.firePropertyChange("temp", this.currentTemperature, value);
            this.currentTemperature = value;
        }
    }

    /**
     * The Observer, which is listening to state changes or events
     */
    public static class WeatherStation implements PropertyChangeListener {

        private String currentTemperature;

        public void propertyChange(PropertyChangeEvent evt) {
            this.setCurrentTemperature((String) evt.getNewValue());
        }


        // standard getter and setter
        public void setCurrentTemperature(String currentTemperature) {
            this.currentTemperature = currentTemperature;
        }

        public String getCurrentTemperature() {
            return currentTemperature;
        }
    }
}
