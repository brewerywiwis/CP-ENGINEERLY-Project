package logic;

public class Land implements Buyable, Sellable {

	private House[] houses;
	private Hotel hotel;
	private String name;
	private int price;

	public Land(String name, int price) {
		this.houses = new House[3];
		this.hotel = null;
		this.name = name;
		this.price = price;
	}

	public House[] getHouses() {
		return houses;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

}
