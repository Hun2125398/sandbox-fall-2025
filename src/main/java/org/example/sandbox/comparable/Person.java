package org.example.sandbox.comparable;

public class Person implements Comparable<Person> {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person {");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Person that) {
        // Handle null cases
        if (that == null) {
            return 1;
        }

        // First compare by age
        int ageCmp = Integer.compare(this.age, that.age);
        if (ageCmp != 0) {
            return ageCmp;
        }

        // Then compare by name, handling nulls
        if (this.name == null && that.name == null) {
            return 0;
        }

        // Consider null less than any non-null name
        if (this.name == null) {
            return -1;
        }

        // Now both names are non-null, safe to compare
        if (that.name == null) {
            return 1;
        }
        return this.name.compareTo(that.name);
    }
}
