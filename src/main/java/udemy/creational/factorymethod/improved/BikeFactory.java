package udemy.creational.factorymethod.improved;

public class BikeFactory extends TransportFactory{
	Transport create() {
		return new Bike();
	}
}
