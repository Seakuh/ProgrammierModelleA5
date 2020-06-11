package ctr;

public class DogPair {
	private final Dog small, big;

	DogPair(Dog dog1, Dog dog2) {
		if (dog1.getSize() < dog2.getSize()) {
			this.small = new Dog(dog1.getName(),dog1.getSize());
			this.big = new Dog(dog2.getName(),dog2.getSize());
		} else {
			this.small = new Dog(dog2.getName(),dog2.getSize());
			this.big = new Dog(dog1.getName(),dog1.getSize());
		}
	}

	public Dog getSmallDog() {
		return new Dog(small.getName(),small.getSize());
	}

	@Override
	public String toString() {
		return "Small Dog: " + small + "\n" + "Big Dog: " + big;
	}
}
