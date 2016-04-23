package TGHM;


import TGHM.RailwayStation;

public class Order {
    
        private int sno;
	private String orderTrain;
	private String orderStation;
	private String orderFoodItems;
	private String orderTimeOfDelivery;
	private String orderPlaceTime;
	private String orderStatus;
        private String Customer;
        public String getOrderPlaceTime()
        {
            return orderPlaceTime;
        }
            
        public String getStatus()
        {
                    return orderStatus;
        }
        
        public String getTime()
        {
            return orderTimeOfDelivery;
        }
        
        public int getSno()
        {
                    return sno;
        }

	public String getTrain() 
        {
		return orderTrain;
	}

	public String getStation()
        {
		return orderStation;
	}

	

	public String getOrderFoodItems() {
		return this.orderFoodItems;
	}

	

	public String getTimeofDelivery() 
        {
		return orderTimeOfDelivery;
	}

	/**
	 * 
	 * @param attribute
	 */
	public void setAttribute(int attribute) {
		// TODO - implement Order.setAttribute
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Train
	 */
	public void setTrain(int Train) {
		// TODO - implement Order.setTrain
		throw new UnsupportedOperationException();
	}

	public void accepOrdert() {
		// TODO - implement Order.accepOrdert
		throw new UnsupportedOperationException();
	}

	public void getOrderplaceTime() {
		// TODO - implement Order.getOrderplaceTime
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param orderplaceTime
	 */
	public void setOrderplaceTime(int orderplaceTime) {
		// TODO - implement Order.setOrderplaceTime
		throw new UnsupportedOperationException();
	}

	public Receipt getGetReceipt() {
		// TODO - implement Order.getGetReceipt
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param getReceipt
	 */
	public void setGetReceipt(Receipt getReceipt) {
		// TODO - implement Order.setGetReceipt
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param details
	 */
	public Order(int Sno,String train,String station,String orderItems,String status,String placetime,String deliverytime,String customer) 
        {
                this.sno = Sno; 
		orderTrain = train;
                orderStation = station;
                orderTimeOfDelivery = deliverytime;
                this.orderFoodItems = orderItems;
                orderStatus = status;
                this.orderPlaceTime = placetime;
                Customer = customer;
	}

	public String getCustomer()
        {
            
            return Customer;
        }

	
}