package freeMarker;

import org.springframework.stereotype.Repository;

public class Animal {
	 private String name;
	    private int price;

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public int getPrice() {
	        return price;
	    }

	    public void setPrice(int price) {
	        this.price = price;
	    }

		@Override
		public String toString() {
			return "Animal [name=" + name + ", price=" + price + "]";
		}

		public Animal(String name, int price) {
			super();
			this.name = name;
			this.price = price;
		}

		public Animal() {
			super();
		}
	    
}
