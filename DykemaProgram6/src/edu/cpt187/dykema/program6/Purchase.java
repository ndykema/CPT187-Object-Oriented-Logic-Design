package edu.cpt187.dykema.program6;
import java.util.*;

public class Purchase {
static ArrayList<Purchase> purchaseList = new ArrayList<>();
private Computer model;
private Upgrade upgrade;

public Purchase(){
	
}

public Purchase(Computer model, Upgrade upgrade){
	this.model = new Computer(model);
	this.upgrade = new Upgrade(upgrade);
}

public String getModelName() {
	String name = model.getName();
	return name;
}
public double getModelPrice() {
	double price = model.getPrice();
	return price;
}

public String getUpgradeName() {
	String name = upgrade.getName();
	return name;
}

public double getUpgradePrice() {
	double price = upgrade.getPrice();
	return price;
}
public double getTotalPrice() {
	double price = getUpgradePrice()+getModelPrice();
	return price;
 }
public void addPurchase(Purchase transaction) {
	purchaseList.add(transaction);

}
public ArrayList<Purchase> copyPurchaseList() {
	return purchaseList;
}
}

