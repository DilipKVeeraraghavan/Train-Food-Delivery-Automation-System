/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TGHM;

public class Train {

	private String trainName;
	private String trainNumber;
	private TrainRoute trainRoute;

       	public Train(){
            trainName = "SRC";
            trainNumber = "22807";
        }
        public Train(String name,String number,TrainRoute route)
        {
            trainName = name;
            trainNumber = number;
            trainRoute = route;
        }
        
        public String getTrainName() {
		return this.trainName;
	}

	/**
	 * 
	 * @param trainName
	 */
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getTrainNumber() {
		return this.trainNumber;
	}

	/**
	 * 
	 * @param trainNumber
	 */
	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}

	public TrainRoute getTrainRoute() {
		return this.trainRoute;
	}

	/**
	 * 
	 * @param trainRoute
	 */
	public void setTrainRoute(TrainRoute trainRoute) {
		this.trainRoute = trainRoute;
	}

}