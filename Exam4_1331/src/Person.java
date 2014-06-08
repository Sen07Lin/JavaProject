/*import java.util.Collections;


public class Person implements Comparable<Person>{
	private int age;
	private String name;
	public Person(int age, String name){
		this.age = age;
		this.name = name;
	}
	public boolean equals(Object o){
		if(o == null) return false;
		if(o == this) return true;
		if(!(o instanceof Person)) return false;
		Person that = (Person)o;
		return this.name.equals(that.name) && this.age == that.age;
	}
	public int hasCode(){
		return this.name.hashCode() +age;
	}
	public int compareTo(Person o){
		if(age != o.age){
			return age - o.age;
		} else {
			return name.compareTo(o.name);
		}
	}
	public static void main(String[] args){
		Collections.sort(trooper, new Comparator<Troop>() {
			public int compare(Trooper a, Trooper b){
				if(a.hasM && !b.hasM){
					return 1;
				} else if (!a.hasM && b.hasM){
					return -1;
				} else{
					return a.name.compareTo(b.name);
				}
			}
		});
	}
}
*/