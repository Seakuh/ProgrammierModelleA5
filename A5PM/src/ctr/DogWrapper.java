package ctr;

public class DogWrapper {

	private DogPair dogPair;
	private Dog dog;

	public DogWrapper(Dog dog1, Dog dog2) {
		dogPair = new DogPair(new Dog(dog1.getName(), dog1.getSize()), new Dog(dog2.getName(), dog2.getSize()));
	}

	public DogWrapper(Dog dog1) {
		dog = new Dog(dog1.getName(), dog1.getSize());
	}

	public Dog setDogPair(Dog dog1, Dog dog2) {
		throw new UnsupportedOperationException();
	}

	public int hashCode() {
		return dogPair.hashCode();
	}

	public Dog getSmallDog() {

		return dogPair.getSmallDog();

	}
}
