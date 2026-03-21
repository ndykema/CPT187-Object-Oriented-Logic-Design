package edu.cpt187.dykema.program6;

public class Upgrade {
		private String name;
		private String description;
		private double price;

		public Upgrade(String name, String description, double price) {
			this.name = name;
			this.description = description;
			this.price = price;
		}
		public Upgrade(Upgrade origUpgrade) {
			this.name = origUpgrade.name;
			this.description = origUpgrade.description;
			this.price = origUpgrade.price;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public String getName() {
			return name;
		}

		public String getDescription() {
			return description;
		}
	}

