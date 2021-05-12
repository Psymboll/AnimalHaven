package com.hrmgroup.animalspring.entities;

public class Animal 
{
	

	@Override
	public String toString() {
		return "Animal [id=" + id + ", animalname=" + animalname + ", animalage=" + animalage + ", animaltype="
				+ animaltype + ", owner=" + owner + "]";
	}

	private int id;
	private String animalname;
	private int animalage;
	private String animaltype;
	private Owner owner;
	
	
	public Animal( int id,String animalname, int animalage, String animaltype,Owner owner) 
	{
		this.id = id;
		this.animalname = animalname;
		this.animalage = animalage;
		this.animaltype = animaltype;
		this.owner = owner;
	}

	public Animal()
	{
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnimalname() 
	{
		return animalname;
	}

	
	public void setAnimalname(String animalname) 
	{
		this.animalname = animalname;
	}

	public int getAnimalage() 
	{
		return animalage;
	}

	public void setAnimalage(int animalage) 
	{
		this.animalage = animalage;
	}

	public String getAnimaltype() 
	{
		return animaltype;
	}

	public void setAnimaltype(String animaltype) 
	{
		this.animaltype = animaltype;
	}
	
	public Owner getOwner() 
	{
		return owner;
	}

	public void setOwner(Owner owner) 
	{
		this.owner = owner;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + animalage;
		result = prime * result + ((animalname == null) ? 0 : animalname.hashCode());
		result = prime * result + ((animaltype == null) ? 0 : animaltype.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (animalage != other.animalage)
			return false;
		if (animalname == null) {
			if (other.animalname != null)
				return false;
		} else if (!animalname.equals(other.animalname))
			return false;
		if (animaltype == null) {
			if (other.animaltype != null)
				return false;
		} else if (!animaltype.equals(other.animaltype))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		return true;
	}
	
	//in teoria non ti serve
	public Boolean isEmpty()
	{
		return animalname == null || animaltype == null;
	}
	
	
	
}

