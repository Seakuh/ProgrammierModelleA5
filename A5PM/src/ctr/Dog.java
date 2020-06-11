package ctr;

class Dog {
	private final String name;
	private final int size;

	Dog(String name, int size) {
		this.size = size;
		this.name = name;
		
	}

	String getName() {
		return name;
	}

	int getSize() {
		return size;
	}



	void setName(String name) {
		if (name == null) {
			throw new IllegalArgumentException();
		}
		new Dog(name, size);

		if (size < 0 || size > 100) {
			throw new IllegalArgumentException();
		}
	}

	
	void setSize(int size) {
		if (size < 0 || size > 100)
			throw new IllegalArgumentException();
		new Dog(name,size);
	}
	
	@Override
	public String toString() {
		return "My name is " + name.toUpperCase() + ", my size is " + size + "cm";
	}

	@Override
	public boolean equals(Object other) {
		if (other == null || getClass() != other.getClass()) {
			return false;
		}
		Dog dog = (Dog) other;
		return name.equals(dog.name) && size == dog.size;

	}

}
